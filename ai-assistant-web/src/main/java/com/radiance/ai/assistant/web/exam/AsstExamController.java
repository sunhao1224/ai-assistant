package com.radiance.ai.assistant.web.exam;

import com.alibaba.fastjson.JSONObject;
import com.radiance.ai.assistant.biz.exam.AsstExamBiz;
import com.radiance.ai.assistant.common.mapstruct.exam.AsstExamMapstruct;
import com.radiance.ai.assistant.domain.dos.exam.*;
import com.radiance.ai.assistant.domain.dto.exam.*;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import com.radiance.ai.assistant.domain.vo.exam.AsstExamAnswerDetailVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:40
 * @since
 */
@RestController
@RequestMapping("/asst/exam")
public class AsstExamController {

    @Resource
    private AsstExamBiz asstExamBiz;

    @Resource
    private AsstExamMapstruct asstExamMapstruct;

    @GetMapping("/dimension/list")
    public ResponseVO dimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamDimensionDO> list = asstExamBiz.dimensionList(asstExamDimensionListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamDimensionDoListConvertToAsstExamDimensionVoList(list));
    }

    @PostMapping("/dimension/insert")
    public ResponseVO dimensionInsert(@RequestBody @Validated AsstExamDimensionInsertDTO asstExamDimensionInsertDTO) {
        int result = asstExamBiz.dimensionInsert(asstExamDimensionInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/dimension/update")
    public ResponseVO dimensionUpdate(@RequestBody @Validated AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO) {
        int result = asstExamBiz.dimensionUpdate(asstExamDimensionUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/dimension/remove")
    public ResponseVO dimensionDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.dimensionRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/subject/list")
    public ResponseVO subjectList(AsstExamSubjectListDTO asstExamSubjectListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamSubjectDO> list = asstExamBiz.subjectList(asstExamSubjectListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamSubjectDoListConvertToAsstExamSubjectVoList(list));
    }

    @PostMapping("/subject/insert")
    public ResponseVO subjectInsert(@RequestBody @Validated AsstExamSubjectInsertDTO asstExamSubjectInsertDTO) {
        int result = asstExamBiz.subjectInsert(asstExamSubjectInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/subject/update")
    public ResponseVO subjectUpdate(@RequestBody @Validated AsstExamSubjectUpdateDTO asstExamSubjectUpdateDTO) {
        int result = asstExamBiz.subjectUpdate(asstExamSubjectUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/subject/remove")
    public ResponseVO subjectDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.subjectRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/bank/list")
    public ResponseVO bankList(AsstExamBankListDTO asstExamBankListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamBankDO> list = asstExamBiz.bankList(asstExamBankListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamBankDoListConvertToAsstExamBankVoList(list));
    }

    @PostMapping("/bank/insert")
    public ResponseVO bankInsert(@RequestBody @Validated AsstExamBankInsertDTO asstExamBankInsertDTO) {
        int result = asstExamBiz.bankInsert(asstExamBankInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/bank/update")
    public ResponseVO bankUpdate(@RequestBody @Validated AsstExamBankUpdateDTO asstExamBankUpdateDTO) {
        int result = asstExamBiz.bankUpdate(asstExamBankUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/bank/remove")
    public ResponseVO bankDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.bankRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/paper/list")
    public ResponseVO paperList(AsstExamPaperListDTO asstExamPaperListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamPaperDO> list = asstExamBiz.paperList(asstExamPaperListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamPaperDoListConvertToAsstExamPaperVoList(list));
    }

    @PostMapping("/paper/insert")
    public ResponseVO paperInsert(@RequestBody @Validated AsstExamPaperInsertDTO asstExamPaperInsertDTO) {
        int result = asstExamBiz.paperInsert(asstExamPaperInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/paper/update")
    public ResponseVO paperUpdate(@RequestBody @Validated AsstExamPaperUpdateDTO asstExamPaperUpdateDTO) {
        int result = asstExamBiz.paperUpdate(asstExamPaperUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/paper/remove")
    public ResponseVO paperDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.paperRemove(idList);
        return ResponseVO.success(result);
    }

    @PostMapping("/paper/upload")
    public ResponseVO paperUpload(@Validated AsstExamPaperUploadDTO asstExamPaperUploadDTO) {
        int result = asstExamBiz.paperUpload(asstExamPaperUploadDTO);
        return ResponseVO.success(result > 0 ? "success" : "fail");
    }

    @GetMapping("/answer/list")
    public ResponseVO answerList(AsstExamAnswerListDTO asstExamAnswerListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamAnswerDO> list = asstExamBiz.answerList(asstExamAnswerListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamAnswerDoListConvertToAsstExamAnswerVoList(list));
    }

    @GetMapping("/answer/detail")
    public ResponseVO answerDetail(@Validated AsstExamAnswerDetailDTO asstExamAnswerDetailDTO) {
        AsstExamAnswerDetailVO asstExamAnswerDetailVO = asstExamBiz.answerDetail(asstExamAnswerDetailDTO);
        return ResponseVO.success(asstExamAnswerDetailVO);
    }

    @PostMapping("/answer/insert")
    public ResponseVO answerInsert(@RequestBody @Validated AsstExamAnswerInsertDTO asstExamAnswerInsertDTO) {
        int result = asstExamBiz.answerInsert(asstExamAnswerInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/answer/update")
    public ResponseVO answerUpdate(@RequestBody @Validated AsstExamAnswerUpdateDTO asstExamAnswerUpdateDTO) {
        int result = asstExamBiz.answerUpdate(asstExamAnswerUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/answer/remove")
    public ResponseVO answerDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.answerRemove(idList);
        return ResponseVO.success(result);
    }

    @PostMapping("/answer/upload")
    public ResponseVO answerUpload(@Validated AsstExamAnswerUploadDTO asstExamAnswerUploadDTO) {
        int result = asstExamBiz.answerUpload(asstExamAnswerUploadDTO);
        return ResponseVO.success(result > 0 ? "success" : "fail");
    }

    @GetMapping("/answer/statistics/level")
    public ResponseVO answerStatisticsLevel(AsstExamAnswerStatisticsLevelDTO asstExamAnswerStatisticsLevelDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamAnswerStatisticsLevelDO> list = asstExamBiz.answerStatisticsLevel(asstExamAnswerStatisticsLevelDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info, list);
    }

    @GetMapping("/comment/list")
    public ResponseVO commentList(AsstExamCommentListDTO asstExamCommentListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamCommentDO> list = asstExamBiz.commentList(asstExamCommentListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamCommentDoListConvertToAsstExamCommentVoList(list));
    }

    @PostMapping("/comment/insert")
    public ResponseVO commentInsert(@RequestBody @Validated AsstExamCommentInsertDTO asstExamCommentInsertDTO) {
        int result = asstExamBiz.commentInsert(asstExamCommentInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/comment/update")
    public ResponseVO commentUpdate(@RequestBody @Validated AsstExamCommentUpdateDTO asstExamCommentUpdateDTO) {
        int result = asstExamBiz.commentUpdate(asstExamCommentUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/comment/remove")
    public ResponseVO commentDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.commentRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/keyword/list")
    public ResponseVO keywordList(AsstExamKeywordListDTO asstExamKeywordListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamKeywordDO> list = asstExamBiz.keywordList(asstExamKeywordListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstExamMapstruct.asstExamKeywordDoListConvertToAsstExamKeywordVoList(list));
    }

    @PostMapping("/keyword/insert")
    public ResponseVO keywordInsert(@RequestBody @Validated AsstExamKeywordInsertDTO asstExamKeywordInsertDTO) {
        int result = asstExamBiz.keywordInsert(asstExamKeywordInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/keyword/update")
    public ResponseVO keywordUpdate(@RequestBody @Validated AsstExamKeywordUpdateDTO asstExamKeywordUpdateDTO) {
        int result = asstExamBiz.keywordUpdate(asstExamKeywordUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/keyword/remove")
    public ResponseVO keywordDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstExamBiz.keywordRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/keyword/statistics")
    public ResponseVO keywordStatistics(AsstExamKeywordStatisticsDTO asstExamKeywordStatisticsDTO) {
        List<AsstExamKeywordStatisticsDO> result =  asstExamBiz.keywordStatistics(asstExamKeywordStatisticsDTO);
        JSONObject info = new JSONObject();
        info.put("count", result.size());
        return ResponseVO.successInfoAndList(info, result);
    }

//    @GetMapping("/statistics/list")
//    public ResponseVO statisticsList(AsstExamStatisticsListDTO asstExamStatisticsListDTO) {
//
//        return ResponseVO.success("success");
//    }

}
