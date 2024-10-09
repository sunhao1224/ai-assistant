package com.radiance.ai.assistant.dao.exam.impl;

import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.dao.exam.AsstExamKeywordDAO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamCommentDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamKeywordDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.exam.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.query.exam.AsstExamCommentQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamKeywordQuery;
import com.radiance.ai.assistant.mapper.exam.AsstExamKeywordMapper;
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
public class AsstExamKeywordDAOImpl implements AsstExamKeywordDAO {

    @Resource
    private AsstExamKeywordMapper asstExamKeywordMapper;

    @Override
    public List<AsstExamKeywordDO> list(AsstExamKeywordQuery data) {
        if (data.getDataStatus() == null) {
            data.setDataStatus(DataStatusEnum.NORMAL.getValue());
        }
        return asstExamKeywordMapper.list(data);
    }

    @Override
    public int insertBatch(List<AsstExamKeywordDO> list) {
        list.forEach(e -> {
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
        return asstExamKeywordMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<AsstExamKeywordDO> list) {
        list.forEach(e -> {
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstExamKeywordMapper.updateBatch(list);
    }

    @Override
    public int removeBatch(List<Long> list) {
        return asstExamKeywordMapper.removeBatch(list);
    }

    @Override
    public int deleteBatch(List<Long> list) {
        return asstExamKeywordMapper.deleteBatch(list);
    }

}
