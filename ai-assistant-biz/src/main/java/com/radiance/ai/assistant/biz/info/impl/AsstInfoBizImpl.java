package com.radiance.ai.assistant.biz.info.impl;

import com.radiance.ai.assistant.biz.info.AsstInfoBiz;
import com.radiance.ai.assistant.common.mapstruct.info.AsstInfoMapstruct;
import com.radiance.ai.assistant.dao.info.AsstInfoClassDAO;
import com.radiance.ai.assistant.dao.info.AsstInfoStudentDAO;
import com.radiance.ai.assistant.dao.info.AsstInfoTeacherDAO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.dto.info.*;
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
    public int teacherInsert(AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO) {
        AsstInfoTeacherDO asstInfoTeacherDO = asstInfoMapstruct.asstInfoTeacherInsertDtoConvertToAsstInfoTeacherDo(asstInfoTeacherInsertDTO);
        return asstInfoTeacherDAO.insertBatch(Collections.singletonList(asstInfoTeacherDO));
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
    public List<AsstInfoStudentDO> studentList(AsstInfoStudentListDTO asstInfoStudentListDTO) {
        return asstInfoStudentDAO.list(asstInfoMapstruct.asstInfoStudentListDtoConvertToAsstInfoStudentQuery(asstInfoStudentListDTO));
    }

    @Override
    public int studentInsert(AsstInfoStudentInsertDTO asstInfoStudentInsertDTO) {
        AsstInfoStudentDO asstInfoStudentDO = asstInfoMapstruct.asstInfoStudentInsertDtoConvertToAsstInfoStudentDo(asstInfoStudentInsertDTO);
        return asstInfoStudentDAO.insertBatch(Collections.singletonList(asstInfoStudentDO));
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
