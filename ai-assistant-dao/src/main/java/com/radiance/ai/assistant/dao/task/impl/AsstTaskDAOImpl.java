package com.radiance.ai.assistant.dao.task.impl;

import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.dao.task.AsstTaskDAO;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.TaskStatusEnum;
import com.radiance.ai.assistant.domain.enums.exam.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
import com.radiance.ai.assistant.domain.query.task.AsstTaskQuery;
import com.radiance.ai.assistant.mapper.task.AsstTaskMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考试维度数据层接口实现类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:32
 * @since 1.0.0
 */
@Repository
public class AsstTaskDAOImpl implements AsstTaskDAO {

    @Resource
    private AsstTaskMapper asstTaskMapper;

    @Override
    public List<AsstTaskDO> list(AsstTaskQuery data) {
        if (data.getDataStatus() == null) {
            data.setDataStatus(DataStatusEnum.NORMAL.getValue());
        }
        return asstTaskMapper.list(data);
    }

    @Override
    public int insertBatch(List<AsstTaskDO> list) {
        list.forEach(e -> {
            if (e.getStatus() == null) {
                e.setStatus(TaskStatusEnum.UN_EXECUTED.getValue());
            }
            if (e.getType() == null) {
                e.setType(AsstExamDimensionTypeEnum.COMMON.getValue());
            }
            if (e.getDataStatus() == null) {
                e.setDataStatus(DataStatusEnum.NORMAL.getValue());
            }
            if (e.getCreateTime() == null) {
                e.setCreateTime(DateUtil.getNow());
            }
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstTaskMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<AsstTaskDO> list) {
        list.forEach(e -> {
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstTaskMapper.updateBatch(list);
    }

    @Override
    public int removeBatch(List<Long> list) {
        return asstTaskMapper.removeBatch(list);
    }

    @Override
    public int deleteBatch(List<Long> list) {
        return asstTaskMapper.deleteBatch(list);
    }

    @Override
    public AsstTaskDO getTaskAndLock() {
        return asstTaskMapper.getTaskAndLock();
    }

}
