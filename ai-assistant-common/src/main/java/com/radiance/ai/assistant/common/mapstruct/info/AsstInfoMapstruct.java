package com.radiance.ai.assistant.common.mapstruct.info;

import com.radiance.ai.assistant.common.mapstruct.CommonMapstructConversion;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.dto.info.*;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoStudentQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoTeacherQuery;
import com.radiance.ai.assistant.domain.vo.info.AsstInfoClassVO;
import com.radiance.ai.assistant.domain.vo.info.AsstInfoStudentVO;
import com.radiance.ai.assistant.domain.vo.info.AsstInfoTeacherVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 20:54
 * @since
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommonMapstructConversion.class})
public interface AsstInfoMapstruct {

    AsstInfoClassQuery asstInfoClassListDtoConvertToAsstInfoClassQuery(AsstInfoClassListDTO asstInfoClassListDTO);

    AsstInfoClassDO asstInfoClassInsertDtoConvertToAsstInfoClassDo(AsstInfoClassInsertDTO asstInfoClassInsertDTO);

    AsstInfoClassDO asstInfoClassUpdateDtoConvertToAsstInfoClassDo(AsstInfoClassUpdateDTO asstInfoClassUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstInfoClassVO asstInfoClassDoConvertToAsstInfoClassVo(AsstInfoClassDO asstInfoClassDO);

    List<AsstInfoClassVO> asstInfoClassDoListConvertToAsstInfoClassVoList(List<AsstInfoClassDO> asstInfoClassDOList);

    AsstInfoTeacherQuery asstInfoTeacherListDtoConvertToAsstInfoTeacherQuery(AsstInfoTeacherListDTO asstInfoTeacherListDTO);

    AsstInfoTeacherDO asstInfoTeacherInsertDtoConvertToAsstInfoTeacherDo(AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO);

    AsstInfoTeacherDO asstInfoTeacherUpdateDtoConvertToAsstInfoTeacherDo(AsstInfoTeacherUpdateDTO asstInfoTeacherUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstInfoTeacherVO asstInfoTeacherDoConvertToAsstInfoTeacherVo(AsstInfoTeacherDO asstInfoTeacherDO);

    List<AsstInfoTeacherVO> asstInfoTeacherDoListConvertToAsstInfoTeacherVoList(List<AsstInfoTeacherDO> asstInfoTeacherDOList);

    AsstInfoStudentQuery asstInfoStudentListDtoConvertToAsstInfoStudentQuery(AsstInfoStudentListDTO asstInfoStudentListDTO);

    AsstInfoStudentDO asstInfoStudentInsertDtoConvertToAsstInfoStudentDo(AsstInfoStudentInsertDTO asstInfoStudentInsertDTO);

    AsstInfoStudentDO asstInfoStudentUpdateDtoConvertToAsstInfoStudentDo(AsstInfoStudentUpdateDTO asstInfoStudentUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstInfoStudentVO asstInfoStudentDoConvertToAsstInfoStudentVo(AsstInfoStudentDO asstInfoStudentDO);

    List<AsstInfoStudentVO> asstInfoStudentDoListConvertToAsstInfoStudentVoList(List<AsstInfoStudentDO> asstInfoStudentDOList);

}
