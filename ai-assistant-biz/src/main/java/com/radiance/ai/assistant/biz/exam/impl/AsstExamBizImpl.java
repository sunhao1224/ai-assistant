package com.radiance.ai.assistant.biz.exam.impl;

import com.radiance.ai.assistant.biz.exam.AsstExamBiz;
import com.radiance.ai.assistant.common.mapstruct.exam.AsstExamMapstruct;
import com.radiance.ai.assistant.dao.exam.*;
import com.radiance.ai.assistant.domain.dos.exam.*;
import com.radiance.ai.assistant.domain.dto.exam.*;
import com.radiance.ai.assistant.domain.query.exam.AsstExamCommentQuery;
import com.radiance.ai.assistant.domain.vo.exam.AsstExamAnswerDetailVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * AI 助手业务接口实现类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:43
 * @since 1.0.0
 */
@Service
public class AsstExamBizImpl implements AsstExamBiz {

    @Resource
    private AsstExamMapstruct asstExamMapstruct;

    @Resource
    private AsstExamDimensionDAO asstExamDimensionDAO;

    @Resource
    private AsstExamSubjectDAO asstExamSubjectDAO;

    @Resource
    private AsstExamBankDAO asstExamBankDAO;

    @Resource
    private AsstExamPaperDAO asstExamPaperDAO;

    @Resource
    private AsstExamAnswerDAO asstExamAnswerDAO;

    @Resource
    private AsstExamCommentDAO asstExamCommentDAO;


    @Override
    public List<AsstExamDimensionDO> dimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO) {
        return asstExamDimensionDAO.list(asstExamMapstruct.asstExamDimensionListDtoConvertToAsstExamDimensionQuery(asstExamDimensionListDTO));
    }

    @Override
    public int dimensionInsert(AsstExamDimensionInsertDTO asstExamDimensionInsertDTO) {
        AsstExamDimensionDO asstExamDimensionDO = asstExamMapstruct.asstExamDimensionInsertDtoConvertToAsstExamDimensionDo(asstExamDimensionInsertDTO);
        return asstExamDimensionDAO.insertBatch(Collections.singletonList(asstExamDimensionDO));
    }

    @Override
    public int dimensionUpdate(AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO) {
        AsstExamDimensionDO asstExamDimensionDO = asstExamMapstruct.asstExamDimensionUpdateDtoConvertToAsstExamDimensionDo(asstExamDimensionUpdateDTO);
        return asstExamDimensionDAO.updateBatch(Collections.singletonList(asstExamDimensionDO));
    }

    @Override
    public int dimensionRemove(List<Long> idList) {
        return asstExamDimensionDAO.removeBatch(idList);
    }

    @Override
    public List<AsstExamSubjectDO> subjectList(AsstExamSubjectListDTO asstExamSubjectListDTO) {
        return asstExamSubjectDAO.list(asstExamMapstruct.asstExamSubjectListDtoConvertToAsstExamSubjectQuery(asstExamSubjectListDTO));
    }

    @Override
    public int subjectInsert(AsstExamSubjectInsertDTO asstExamSubjectInsertDTO) {
        AsstExamSubjectDO asstExamSubjectDO = asstExamMapstruct.asstExamSubjectInsertDtoConvertToAsstExamSubjectDo(asstExamSubjectInsertDTO);
        return asstExamSubjectDAO.insertBatch(Collections.singletonList(asstExamSubjectDO));
    }

    @Override
    public int subjectUpdate(AsstExamSubjectUpdateDTO asstExamSubjectUpdateDTO) {
        AsstExamSubjectDO asstExamSubjectDO = asstExamMapstruct.asstExamSubjectUpdateDtoConvertToAsstExamSubjectDo(asstExamSubjectUpdateDTO);
        return asstExamSubjectDAO.updateBatch(Collections.singletonList(asstExamSubjectDO));
    }

    @Override
    public int subjectRemove(List<Long> idList) {
        return asstExamSubjectDAO.removeBatch(idList);
    }

    @Override
    public List<AsstExamBankDO> bankList(AsstExamBankListDTO asstExamBankListDTO) {
        return asstExamBankDAO.list(asstExamMapstruct.asstExamBankListDtoConvertToAsstExamBankQuery(asstExamBankListDTO));
    }

    @Override
    public int bankInsert(AsstExamBankInsertDTO asstExamBankInsertDTO) {
        AsstExamBankDO asstExamBankDO = asstExamMapstruct.asstExamBankInsertDtoConvertToAsstExamBankDo(asstExamBankInsertDTO);
        return asstExamBankDAO.insertBatch(Collections.singletonList(asstExamBankDO));
    }

    @Override
    public int bankUpdate(AsstExamBankUpdateDTO asstExamBankUpdateDTO) {
        AsstExamBankDO asstExamBankDO = asstExamMapstruct.asstExamBankUpdateDtoConvertToAsstExamBankDo(asstExamBankUpdateDTO);
        return asstExamBankDAO.updateBatch(Collections.singletonList(asstExamBankDO));
    }

    @Override
    public int bankRemove(List<Long> idList) {
        return asstExamBankDAO.removeBatch(idList);
    }

    @Override
    public List<AsstExamPaperDO> paperList(AsstExamPaperListDTO asstExamPaperListDTO) {
        return asstExamPaperDAO.list(asstExamMapstruct.asstExamPaperListDtoConvertToAsstExamPaperQuery(asstExamPaperListDTO));
    }

    @Override
    public int paperInsert(AsstExamPaperInsertDTO asstExamPaperInsertDTO) {
        AsstExamPaperDO asstExamPaperDO = asstExamMapstruct.asstExamPaperInsertDtoConvertToAsstExamPaperDo(asstExamPaperInsertDTO);
        return asstExamPaperDAO.insertBatch(Collections.singletonList(asstExamPaperDO));
    }

    @Override
    public int paperUpdate(AsstExamPaperUpdateDTO asstExamPaperUpdateDTO) {
        AsstExamPaperDO asstExamPaperDO = asstExamMapstruct.asstExamPaperUpdateDtoConvertToAsstExamPaperDo(asstExamPaperUpdateDTO);
        return asstExamPaperDAO.updateBatch(Collections.singletonList(asstExamPaperDO));
    }

    @Override
    public int paperRemove(List<Long> idList) {
        return asstExamPaperDAO.removeBatch(idList);
    }

    @Override
    public List<AsstExamAnswerDO> answerList(AsstExamAnswerListDTO asstExamAnswerListDTO) {
        return asstExamAnswerDAO.list(asstExamMapstruct.asstExamAnswerListDtoConvertToAsstExamAnswerQuery(asstExamAnswerListDTO));
    }

    @Override
    public AsstExamAnswerDetailVO answerDetail(AsstExamAnswerDetailDTO asstExamAnswerDetailDTO) {
        List<AsstExamAnswerDO> asstExamAnswerDOList = this.answerList(new AsstExamAnswerListDTO(asstExamAnswerDetailDTO.getId()));
        AsstExamAnswerDetailVO asstExamAnswerDetailVO = asstExamMapstruct.asstExamAnswerDoConvertToAsstExamAnswerDetailVo(asstExamAnswerDOList.get(0));
        List<AsstExamCommentDO> asstExamCommentDOList = asstExamCommentDAO.list(AsstExamCommentQuery.builder().asstExamAnswerId(asstExamAnswerDetailDTO.getId()).build());
        asstExamAnswerDetailVO.setCommentList(asstExamMapstruct.asstExamCommentDoListConvertToAsstExamCommentVoList(asstExamCommentDOList));
        return asstExamAnswerDetailVO;
    }

    @Override
    public int answerInsert(AsstExamAnswerInsertDTO asstExamAnswerInsertDTO) {
        AsstExamAnswerDO asstExamAnswerDO = asstExamMapstruct.asstExamAnswerInsertDtoConvertToAsstExamAnswerDo(asstExamAnswerInsertDTO);
        return asstExamAnswerDAO.insertBatch(Collections.singletonList(asstExamAnswerDO));
    }

    @Override
    public int answerUpdate(AsstExamAnswerUpdateDTO asstExamAnswerUpdateDTO) {
        AsstExamAnswerDO asstExamAnswerDO = asstExamMapstruct.asstExamAnswerUpdateDtoConvertToAsstExamAnswerDo(asstExamAnswerUpdateDTO);
        return asstExamAnswerDAO.updateBatch(Collections.singletonList(asstExamAnswerDO));
    }

    @Override
    public int answerRemove(List<Long> idList) {
        return asstExamAnswerDAO.removeBatch(idList);
    }

    @Override
    public List<AsstExamCommentDO> commentList(AsstExamCommentListDTO asstExamCommentListDTO) {
        return asstExamCommentDAO.list(asstExamMapstruct.asstExamCommentListDtoConvertToAsstExamAnswerQuery(asstExamCommentListDTO));
    }

    @Override
    public int commentInsert(AsstExamCommentInsertDTO asstExamCommentInsertDTO) {
        AsstExamCommentDO asstExamCommentDO = asstExamMapstruct.asstExamCommentInsertDtoConvertToAsstExamCommentDo(asstExamCommentInsertDTO);
        return asstExamCommentDAO.insertBatch(Collections.singletonList(asstExamCommentDO));
    }

    @Override
    public int commentUpdate(AsstExamCommentUpdateDTO asstExamCommentUpdateDTO) {
        AsstExamCommentDO asstExamCommentDO = asstExamMapstruct.asstExamCommentUpdateDtoConvertToAsstExamCommentDo(asstExamCommentUpdateDTO);
        return asstExamCommentDAO.updateBatch(Collections.singletonList(asstExamCommentDO));
    }

    @Override
    public int commentRemove(List<Long> idList) {
        return asstExamCommentDAO.removeBatch(idList);
    }

}
