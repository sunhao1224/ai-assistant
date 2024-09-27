package com.radiance.ai.assistant.biz.scheduling.consumer;

import com.radiance.ai.assistant.biz.task.AsstTaskBiz;
import com.radiance.ai.assistant.common.constant.DateConstant;
import com.radiance.ai.assistant.common.properties.SchedulingProperties;
import com.radiance.ai.assistant.dao.task.AsstTaskDAO;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.TaskStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/28 00:02
 * @since
 */
@Slf4j
@Component
@ConditionalOnProperty(name = "scheduling.consumer.task.paper.enabled", havingValue = "true", matchIfMissing = true)
public class AsstExamPaperTaskConsumer implements SchedulingConfigurer {

    @Resource
    private SchedulingProperties schedulingProperties;

    @Resource
    private AsstTaskDAO asstTaskDAO;

    @Resource
    private AsstTaskBiz asstTaskBiz;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() -> {
            log.info("di task consumer start time: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateConstant.YYYY_MM_DD_HH_MM_SS_FORMAT)));
            try {
                processTask();
            } catch (Exception e) {
                log.error("di task consumer error: {}", e.getMessage(), e);
            }
            log.info("di task consumer end time: {}", LocalDateTime.now().format(DateTimeFormatter.ofPattern(DateConstant.YYYY_MM_DD_HH_MM_SS_FORMAT)));
        }, triggerContext -> {
            // 使用 CronTrigger 触发器，可动态修改 cron 表达式来操作循环规则
            CronTrigger cronTrigger = new CronTrigger(schedulingProperties.getTaskPaperCron());
            return cronTrigger.nextExecutionTime(triggerContext);
        });
    }

    private void processTask() {
        log.info("paper task consumer start");
        // 查询任务
        AsstTaskDO asstTaskDO = asstTaskDAO.getTaskAndLock();
        if (ObjectUtils.isEmpty(asstTaskDO)) {
            return;
        }
        asstTaskDO.setStatus(TaskStatusEnum.EXECUTING.getValue());
        asstTaskDAO.updateBatch(Collections.singletonList(asstTaskDO));
        // 执行任务
        asstTaskBiz.processPaper(asstTaskDO.getAsstExamPaperId());

        // 更新任务状态
        asstTaskDO.setStatus(TaskStatusEnum.EXECUTED.getValue());
        asstTaskDAO.updateBatch(Collections.singletonList(asstTaskDO));
        log.info("paper task consumer end");
    }

}
