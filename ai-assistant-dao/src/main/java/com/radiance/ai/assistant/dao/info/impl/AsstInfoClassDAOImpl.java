package com.radiance.ai.assistant.dao.info.impl;

import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.dao.info.AsstInfoClassDAO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.exam.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
import com.radiance.ai.assistant.mapper.info.AsstInfoClassMapper;
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
public class AsstInfoClassDAOImpl implements AsstInfoClassDAO {

    @Resource
    private AsstInfoClassMapper asstInfoClassMapper;

    @Override
    public List<AsstInfoClassDO> list(AsstInfoClassQuery data) {
        if (data.getDataStatus() == null) {
            data.setDataStatus(DataStatusEnum.NORMAL.getValue());
        }
        return asstInfoClassMapper.list(data);
    }

    @Override
    public int insertBatch(List<AsstInfoClassDO> list) {
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
        return asstInfoClassMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<AsstInfoClassDO> list) {
        list.forEach(e -> {
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstInfoClassMapper.updateBatch(list);
    }

    @Override
    public int removeBatch(List<Long> list) {
        return asstInfoClassMapper.removeBatch(list);
    }

    @Override
    public int deleteBatch(List<Long> list) {
        return asstInfoClassMapper.deleteBatch(list);
    }

}
