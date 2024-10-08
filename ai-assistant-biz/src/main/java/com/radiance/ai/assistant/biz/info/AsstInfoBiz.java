package com.radiance.ai.assistant.biz.info;

import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.dto.info.*;

import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:15
 * @since
 */
public interface AsstInfoBiz {

    List<AsstInfoClassDO> classList(AsstInfoClassListDTO asstInfoClassListDTO);

    int classInsert(AsstInfoClassInsertDTO asstInfoClassInsertDTO);

    int classUpdate(AsstInfoClassUpdateDTO asstInfoClassUpdateDTO);

    int classRemove(List<Long> idList);

    List<AsstInfoTeacherDO> teacherList(AsstInfoTeacherListDTO asstInfoTeacherListDTO);

    long teacherInsert(AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO);

    int teacherUpdate(AsstInfoTeacherUpdateDTO asstInfoTeacherUpdateDTO);

    int teacherRemove(List<Long> idList);

    List<AsstInfoStudentDO> studentList(AsstInfoStudentListDTO asstInfoStudentListDTO);

    long studentInsert(AsstInfoStudentInsertDTO asstInfoStudentInsertDTO);

    int studentUpdate(AsstInfoStudentUpdateDTO asstInfoStudentUpdateDTO);

    int studentRemove(List<Long> idList);

}
