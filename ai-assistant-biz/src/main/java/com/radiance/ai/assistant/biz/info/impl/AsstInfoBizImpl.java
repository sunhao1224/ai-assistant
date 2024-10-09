package com.radiance.ai.assistant.biz.info.impl;

import com.radiance.ai.assistant.biz.info.AsstInfoBiz;
import com.radiance.ai.assistant.common.constant.EncryptConstant;
import com.radiance.ai.assistant.common.exception.runtime.CommonException;
import com.radiance.ai.assistant.common.mapstruct.info.AsstInfoMapstruct;
import com.radiance.ai.assistant.common.utils.EncryptUtils;
import com.radiance.ai.assistant.dao.info.AsstInfoClassDAO;
import com.radiance.ai.assistant.dao.info.AsstInfoStudentDAO;
import com.radiance.ai.assistant.dao.info.AsstInfoTeacherDAO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.dto.info.*;
import com.radiance.ai.assistant.domain.enums.ResponseCodeEnum;
import com.radiance.ai.assistant.domain.query.info.AsstInfoTeacherQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:15
 * @since
 */
@Service
public class AsstInfoBizImpl implements AsstInfoBiz {

    @Resource
    private AsstInfoMapstruct asstInfoMapstruct;

    @Resource
    private AsstInfoClassDAO asstInfoClassDAO;

    @Resource
    private AsstInfoTeacherDAO asstInfoTeacherDAO;

    @Resource
    private AsstInfoStudentDAO asstInfoStudentDAO;

    @Override
    public List<AsstInfoClassDO> classList(AsstInfoClassListDTO asstInfoClassListDTO) {
        return asstInfoClassDAO.list(asstInfoMapstruct.asstInfoClassListDtoConvertToAsstInfoClassQuery(asstInfoClassListDTO));
    }

    @Override
    public int classInsert(AsstInfoClassInsertDTO asstInfoClassInsertDTO) {
        AsstInfoClassDO asstInfoClassDO = asstInfoMapstruct.asstInfoClassInsertDtoConvertToAsstInfoClassDo(asstInfoClassInsertDTO);
        return asstInfoClassDAO.insertBatch(Collections.singletonList(asstInfoClassDO));
    }

    @Override
    public int classUpdate(AsstInfoClassUpdateDTO asstInfoClassUpdateDTO) {
        AsstInfoClassDO asstInfoClassDO = asstInfoMapstruct.asstInfoClassUpdateDtoConvertToAsstInfoClassDo(asstInfoClassUpdateDTO);
        return asstInfoClassDAO.updateBatch(Collections.singletonList(asstInfoClassDO));
    }

    @Override
    public int classRemove(List<Long> idList) {
        return asstInfoClassDAO.removeBatch(idList);
    }

    @Override
    public List<AsstInfoTeacherDO> teacherList(AsstInfoTeacherListDTO asstInfoTeacherListDTO) {
        return asstInfoTeacherDAO.list(asstInfoMapstruct.asstInfoTeacherListDtoConvertToAsstInfoTeacherQuery(asstInfoTeacherListDTO));
    }

    @Override
    public long teacherInsert(AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO) {
        AsstInfoTeacherDO asstInfoTeacherDO = asstInfoMapstruct.asstInfoTeacherInsertDtoConvertToAsstInfoTeacherDo(asstInfoTeacherInsertDTO);
        int result = asstInfoTeacherDAO.insertBatch(Collections.singletonList(asstInfoTeacherDO));
        if (result < 1) {
            throw new CommonException(ResponseCodeEnum.DATA_INSERT_ERROR);
        }
        return asstInfoTeacherDO.getId();
    }

    @Override
    public int teacherUpdate(AsstInfoTeacherUpdateDTO asstInfoTeacherUpdateDTO) {
        AsstInfoTeacherDO asstInfoTeacherDO = asstInfoMapstruct.asstInfoTeacherUpdateDtoConvertToAsstInfoTeacherDo(asstInfoTeacherUpdateDTO);
        return asstInfoTeacherDAO.updateBatch(Collections.singletonList(asstInfoTeacherDO));
    }

    @Override
    public int teacherRemove(List<Long> idList) {
        return asstInfoTeacherDAO.removeBatch(idList);
    }

    @Override
    public AsstInfoTeacherDO teacherLogin(AsstInfoTeacherLoginDTO asstInfoTeacherLoginDTO) {
        AsstInfoTeacherDO asstInfoTeacherDO = null;
        if (asstInfoTeacherLoginDTO.getId() == null && StringUtils.isBlank(asstInfoTeacherLoginDTO.getName())) {
            throw new CommonException(ResponseCodeEnum.PARAM_IS_ERROR, "教师 id 和 name 不能同时为空");

        }
        AsstInfoTeacherQuery asstInfoTeacherQuery = AsstInfoTeacherQuery.builder().build();
        if (asstInfoTeacherLoginDTO.getId() != null && StringUtils.isBlank(asstInfoTeacherLoginDTO.getName())) {
            asstInfoTeacherQuery.setId(asstInfoTeacherLoginDTO.getId());
        }
        if (asstInfoTeacherLoginDTO.getId() == null && StringUtils.isNotBlank(asstInfoTeacherLoginDTO.getName())) {
            asstInfoTeacherQuery.setName(asstInfoTeacherLoginDTO.getName());
        }
        if (asstInfoTeacherLoginDTO.getId() != null && StringUtils.isNotBlank(asstInfoTeacherLoginDTO.getName())) {
            asstInfoTeacherQuery.setId(asstInfoTeacherLoginDTO.getId());
        }
        List<AsstInfoTeacherDO> list = asstInfoTeacherDAO.list(asstInfoTeacherQuery);
        if (list.isEmpty()) {
            AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO = new AsstInfoTeacherInsertDTO();
            asstInfoTeacherInsertDTO.setName(asstInfoTeacherLoginDTO.getName());
            asstInfoTeacherInsertDTO.setPassword("123456");
            long id = teacherInsert(asstInfoTeacherInsertDTO);
            asstInfoTeacherDO = asstInfoTeacherDAO.list(AsstInfoTeacherQuery.builder().id(id).build()).get(0);
        } else {
            asstInfoTeacherDO = list.get(0);
            if (!EncryptUtils.aesEncrypt(asstInfoTeacherLoginDTO.getPassword(), EncryptConstant.TSINGHUA_MEM_KEY)
                    .equals(asstInfoTeacherDO.getPassword())) {
                throw new CommonException(ResponseCodeEnum.PARAM_IS_ERROR, "密码错误");
            }
        }
        return asstInfoTeacherDO;
    }

    @Override
    public List<AsstInfoStudentDO> studentList(AsstInfoStudentListDTO asstInfoStudentListDTO) {
        return asstInfoStudentDAO.list(asstInfoMapstruct.asstInfoStudentListDtoConvertToAsstInfoStudentQuery(asstInfoStudentListDTO));
    }

    @Override
    public long studentInsert(AsstInfoStudentInsertDTO asstInfoStudentInsertDTO) {
        AsstInfoStudentDO asstInfoStudentDO = asstInfoMapstruct.asstInfoStudentInsertDtoConvertToAsstInfoStudentDo(asstInfoStudentInsertDTO);
        int result = asstInfoStudentDAO.insertBatch(Collections.singletonList(asstInfoStudentDO));
        if (result < 1) {
            throw new CommonException(ResponseCodeEnum.DATA_INSERT_ERROR);
        }
        return asstInfoStudentDO.getId();
    }

    @Override
    public int studentUpdate(AsstInfoStudentUpdateDTO asstInfoStudentUpdateDTO) {
        AsstInfoStudentDO asstInfoStudentDO = asstInfoMapstruct.asstInfoStudentUpdateDtoConvertToAsstInfoStudentDo(asstInfoStudentUpdateDTO);
        return asstInfoStudentDAO.updateBatch(Collections.singletonList(asstInfoStudentDO));
    }

    @Override
    public int studentRemove(List<Long> idList) {
        return asstInfoStudentDAO.removeBatch(idList);
    }
}
