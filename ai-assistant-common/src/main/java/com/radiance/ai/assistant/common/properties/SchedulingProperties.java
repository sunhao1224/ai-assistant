package com.radiance.ai.assistant.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/28 00:04
 * @since
 */
@Data
@Component
public class SchedulingProperties {

    @Value("${scheduling.consumer.task.paper.cron}")
    private String taskPaperCron;

}
