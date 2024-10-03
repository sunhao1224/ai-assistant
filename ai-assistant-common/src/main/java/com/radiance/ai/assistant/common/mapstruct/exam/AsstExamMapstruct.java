package com.radiance.ai.assistant.common.mapstruct.exam;

import com.radiance.ai.assistant.common.mapstruct.CommonMapstructConversion;
import com.radiance.ai.assistant.domain.dos.exam.*;
import com.radiance.ai.assistant.domain.dto.exam.*;
import com.radiance.ai.assistant.domain.query.exam.*;
import com.radiance.ai.assistant.domain.vo.exam.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * AI 助手 Mapstruct
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 19:31
 * @since 1.0.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommonMapstructConversion.class})
public interface AsstExamMapstruct {

    AsstExamDimensionQuery asstExamDimensionListDtoConvertToAsstExamDimensionQuery(AsstExamDimensionListDTO asstExamDimensionListDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamDimensionVO asstExamDimensionDoConvertToAsstExamDimensionVo(AsstExamDimensionDO source);

    List<AsstExamDimensionVO> asstExamDimensionDoListConvertToAsstExamDimensionVoList(List<AsstExamDimensionDO> asstExamDimensionDOList);

    AsstExamDimensionDO asstExamDimensionInsertDtoConvertToAsstExamDimensionDo(AsstExamDimensionInsertDTO asstExamDimensionInsertDTO);

    AsstExamDimensionDO asstExamDimensionUpdateDtoConvertToAsstExamDimensionDo(AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO);

    AsstExamSubjectQuery asstExamSubjectListDtoConvertToAsstExamSubjectQuery(AsstExamSubjectListDTO asstExamSubjectListDTO);

    AsstExamSubjectDO asstExamSubjectInsertDtoConvertToAsstExamSubjectDo(AsstExamSubjectInsertDTO asstExamSubjectInsertDTO);

    AsstExamSubjectDO asstExamSubjectUpdateDtoConvertToAsstExamSubjectDo(AsstExamSubjectUpdateDTO asstExamSubjectUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamSubjectVO asstExamSubjectDoConvertToAsstExamSubjectVo(AsstExamSubjectDO asstExamSubjectDO);

    List<AsstExamSubjectVO> asstExamSubjectDoListConvertToAsstExamSubjectVoList(List<AsstExamSubjectDO> asstExamSubjectDOList);

    AsstExamBankQuery asstExamBankListDtoConvertToAsstExamBankQuery(AsstExamBankListDTO asstExamBankListDTO);

    AsstExamBankDO asstExamBankInsertDtoConvertToAsstExamBankDo(AsstExamBankInsertDTO asstExamBankInsertDTO);

    AsstExamBankDO asstExamBankUpdateDtoConvertToAsstExamBankDo(AsstExamBankUpdateDTO asstExamBankUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamBankVO asstExamBankDoConvertToAsstExamBankVo(AsstExamBankDO asstExamBankDO);

    List<AsstExamBankVO> asstExamBankDoListConvertToAsstExamBankVoList(List<AsstExamBankDO> asstExamBankDOList);

    AsstExamPaperQuery asstExamPaperListDtoConvertToAsstExamPaperQuery(AsstExamPaperListDTO asstExamPaperListDTO);

    AsstExamPaperDO asstExamPaperInsertDtoConvertToAsstExamPaperDo(AsstExamPaperInsertDTO asstExamPaperInsertDTO);

    AsstExamPaperDO asstExamPaperUpdateDtoConvertToAsstExamPaperDo(AsstExamPaperUpdateDTO asstExamPaperUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamPaperVO asstExamPaperDoConvertToAsstExamPaperVo(AsstExamPaperDO asstExamPaperDO);

    List<AsstExamPaperVO> asstExamPaperDoListConvertToAsstExamPaperVoList(List<AsstExamPaperDO> list);

    AsstExamAnswerQuery asstExamAnswerListDtoConvertToAsstExamAnswerQuery(AsstExamAnswerListDTO asstExamAnswerListDTO);

    AsstExamAnswerDO asstExamAnswerInsertDtoConvertToAsstExamAnswerDo(AsstExamAnswerInsertDTO asstExamAnswerInsertDTO);

    AsstExamAnswerDO asstExamAnswerUpdateDtoConvertToAsstExamAnswerDo(AsstExamAnswerUpdateDTO asstExamAnswerUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamAnswerVO asstExamAnswerDoConvertToAsstExamAnswerVo(AsstExamAnswerDO asstExamAnswerDO);

    List<AsstExamAnswerVO> asstExamAnswerDoListConvertToAsstExamAnswerVoList(List<AsstExamAnswerDO> asstExamAnswerDOList);

    AsstExamCommentQuery asstExamCommentListDtoConvertToAsstExamAnswerQuery(AsstExamCommentListDTO asstExamCommentListDTO);

    AsstExamCommentDO asstExamCommentInsertDtoConvertToAsstExamCommentDo(AsstExamCommentInsertDTO asstExamCommentInsertDTO);

    AsstExamCommentDO asstExamCommentUpdateDtoConvertToAsstExamCommentDo(AsstExamCommentUpdateDTO asstExamCommentUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamCommentVO asstExamCommentDoConvertToAsstExamCommentVo(AsstExamCommentDO asstExamCommentDO);

    List<AsstExamCommentVO> asstExamCommentDoListConvertToAsstExamCommentVoList(List<AsstExamCommentDO> asstExamCommentDOList);

    AsstExamAnswerDetailVO asstExamAnswerDoConvertToAsstExamAnswerDetailVo(AsstExamAnswerDO asstExamAnswerDO);

    AsstExamPaperDO asstExamPaperUploadDtoConvertToAsstExamPaperDo(AsstExamPaperUploadDTO asstExamPaperUploadDTO);
}
