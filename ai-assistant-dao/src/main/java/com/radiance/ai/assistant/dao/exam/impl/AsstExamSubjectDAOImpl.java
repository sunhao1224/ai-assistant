package com.radiance.ai.assistant.dao.exam.impl;

import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.dao.exam.AsstExamDimensionDAO;
import com.radiance.ai.assistant.dao.exam.AsstExamSubjectDAO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamSubjectDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.exam.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamSubjectQuery;
import com.radiance.ai.assistant.mapper.exam.AsstExamDimensionMapper;
import com.radiance.ai.assistant.mapper.exam.AsstExamSubjectMapper;
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
public class AsstExamSubjectDAOImpl implements AsstExamSubjectDAO {

    @Resource
    private AsstExamSubjectMapper asstExamSubjectMapper;

    @Override
    public List<AsstExamSubjectDO> list(AsstExamSubjectQuery data) {
        if (data.getDataStatus() == null) {
            data.setDataStatus(DataStatusEnum.NORMAL.getValue());
        }
        return asstExamSubjectMapper.list(data);
    }

    @Override
    public int insertBatch(List<AsstExamSubjectDO> list) {
        list.forEach(e -> {
            if(e.getType() == null) {
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
        return asstExamSubjectMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<AsstExamSubjectDO> list) {
        list.forEach(e -> {
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstExamSubjectMapper.updateBatch(list);
    }

    @Override
    public int removeBatch(List<Long> list) {
        return asstExamSubjectMapper.removeBatch(list);
    }

    @Override
    public int deleteBatch(List<Long> list) {
        return asstExamSubjectMapper.deleteBatch(list);
    }

}
