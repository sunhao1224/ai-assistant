package com.radiance.ai.assistant.dao.info.impl;

import com.radiance.ai.assistant.common.constant.EncryptConstant;
import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.common.utils.EncryptUtils;
import com.radiance.ai.assistant.dao.info.AsstInfoStudentDAO;
import com.radiance.ai.assistant.dao.info.AsstInfoTeacherDAO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import com.radiance.ai.assistant.domain.enums.exam.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoStudentQuery;
import com.radiance.ai.assistant.mapper.info.AsstInfoStudentMapper;
import com.radiance.ai.assistant.mapper.info.AsstInfoTeacherMapper;
import org.apache.commons.lang3.StringUtils;
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
public class AsstInfoStudentDAOImpl implements AsstInfoStudentDAO {

    @Resource
    private AsstInfoStudentMapper asstInfoStudentMapper;

    @Override
    public List<AsstInfoStudentDO> list(AsstInfoStudentQuery data) {
        if (data.getDataStatus() == null) {
            data.setDataStatus(DataStatusEnum.NORMAL.getValue());
        }
        return asstInfoStudentMapper.list(data);
    }

    @Override
    public int insertBatch(List<AsstInfoStudentDO> list) {
        list.forEach(e -> {
            if (StringUtils.isNotBlank(e.getPassword())) {
                e.setPassword(EncryptUtils.aesEncrypt(e.getPassword(), EncryptConstant.TSINGHUA_MEM_KEY));
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
        return asstInfoStudentMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<AsstInfoStudentDO> list) {
        list.forEach(e -> {
            if (StringUtils.isNotBlank(e.getPassword())) {
                e.setPassword(EncryptUtils.aesEncrypt(e.getPassword(), EncryptConstant.TSINGHUA_MEM_KEY));
            }
            if (e.getUpdateTime() == null) {
                e.setUpdateTime(DateUtil.getNow());
            }
            if (e.getFinishTime() == null) {
                e.setFinishTime(DateUtil.getNow());
            }
        });
        return asstInfoStudentMapper.updateBatch(list);
    }

    @Override
    public int removeBatch(List<Long> list) {
        return asstInfoStudentMapper.removeBatch(list);
    }

    @Override
    public int deleteBatch(List<Long> list) {
        return asstInfoStudentMapper.deleteBatch(list);
    }

}
