package com.radiance.ai.assistant.biz.exam;

import com.radiance.ai.assistant.domain.dos.exam.*;
import com.radiance.ai.assistant.domain.dto.exam.*;
import com.radiance.ai.assistant.domain.vo.exam.AsstExamAnswerDetailVO;

import java.util.List;

/**
 * AI 助手业务接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:42
 * @since 1.0.0
 */
public interface AsstExamBiz {

    List<AsstExamDimensionDO> dimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO);

    int dimensionInsert(AsstExamDimensionInsertDTO asstExamDimensionInsertDTO);

    int dimensionUpdate(AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO);

    int dimensionRemove(List<Long> idList);

    List<AsstExamSubjectDO> subjectList(AsstExamSubjectListDTO asstExamSubjectListDTO);

    int subjectInsert(AsstExamSubjectInsertDTO asstExamSubjectInsertDTO);

    int subjectUpdate(AsstExamSubjectUpdateDTO asstExamSubjectUpdateDTO);

    int subjectRemove(List<Long> idList);

    List<AsstExamBankDO> bankList(AsstExamBankListDTO asstExamBankListDTO);

    int bankInsert(AsstExamBankInsertDTO asstExamBankInsertDTO);

    int bankUpdate(AsstExamBankUpdateDTO asstExamBankUpdateDTO);

    int bankRemove(List<Long> idList);

    List<AsstExamPaperDO> paperList(AsstExamPaperListDTO asstExamPaperListDTO);

    int paperInsert(AsstExamPaperInsertDTO asstExamPaperInsertDTO);

    int paperUpdate(AsstExamPaperUpdateDTO asstExamPaperUpdateDTO);

    int paperRemove(List<Long> idList);

    int paperUpload(AsstExamPaperUploadDTO asstExamPaperUploadDTO);

    List<AsstExamAnswerDO> answerList(AsstExamAnswerListDTO asstExamAnswerListDTO);

    AsstExamAnswerDetailVO answerDetail(AsstExamAnswerDetailDTO asstExamAnswerDetailDTO);

    int answerInsert(AsstExamAnswerInsertDTO asstExamAnswerInsertDTO);

    int answerUpdate(AsstExamAnswerUpdateDTO asstExamAnswerUpdateDTO);

    int answerRemove(List<Long> idList);

    List<AsstExamCommentDO> commentList(AsstExamCommentListDTO asstExamCommentListDTO);

    int commentInsert(AsstExamCommentInsertDTO asstExamCommentInsertDTO);

    int commentUpdate(AsstExamCommentUpdateDTO asstExamCommentUpdateDTO);

    int commentRemove(List<Long> idList);

}
