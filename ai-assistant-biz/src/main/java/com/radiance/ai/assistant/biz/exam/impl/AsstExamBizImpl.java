package com.radiance.ai.assistant.biz.exam.impl;

import com.radiance.ai.assistant.biz.exam.AsstExamBiz;
import com.radiance.ai.assistant.common.mapstruct.exam.AsstExamMapstruct;
import com.radiance.ai.assistant.dao.exam.*;
import com.radiance.ai.assistant.domain.dos.exam.*;
import com.radiance.ai.assistant.domain.dto.exam.*;
import com.radiance.ai.assistant.domain.query.exam.AsstExamCommentQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
import com.radiance.ai.assistant.domain.vo.exam.AsstExamAnswerDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AI 助手业务接口实现类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:43
 * @since 1.0.0
 */
@Slf4j
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
    public int paperUpload(AsstExamPaperUploadDTO asstExamPaperUploadDTO) {
        // 先删除当前 asst_exam_band_id 下的所有数据
        asstExamPaperDAO.deleteByAsstExamBankId(Collections.singletonList(asstExamPaperUploadDTO.getAsstExamBankId()));

        List<AsstExamPaperDO> list = new ArrayList<>();
        List<String> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();

        try (XWPFDocument document = new XWPFDocument(asstExamPaperUploadDTO.getFile().getInputStream())) {
            // 获取所有段落
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            // 遍历并打印每个段落的文本内容
            for (XWPFParagraph para : paragraphs) {
                if (para.getText().startsWith("题目：")) {
                    questionList.add(para.getText().replaceAll("题目：", ""));
                }
                if (para.getText().startsWith("答案：")) {
                    answerList.add(para.getText().replaceAll("答案：", ""));
                }
            }
        } catch (Exception e) {
            log.info("read word error: {}", e.getMessage(), e);
        }
        for (int i = 0; i < questionList.size(); i++) {
            AsstExamPaperDO asstExamPaperDO = asstExamMapstruct.asstExamPaperUploadDtoConvertToAsstExamPaperDo(asstExamPaperUploadDTO);
            asstExamPaperDO.setType(1);
            asstExamPaperDO.setQuestion(questionList.get(i));
            asstExamPaperDO.setAnswer(answerList.get(i));
            list.add(asstExamPaperDO);
        }
        return asstExamPaperDAO.insertBatch(list);
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
    public int answerUpload(AsstExamAnswerUploadDTO asstExamAnswerUploadDTO) {
        // 先删除当前 asst_exam_band_id 下的所有数据
        asstExamAnswerDAO.deleteByAsstExamBankId(Collections.singletonList(asstExamAnswerUploadDTO.getAsstExamBankId()));

        // 查询试卷表题库所有试题
        List<AsstExamPaperDO> asstExamPaperDOList = asstExamPaperDAO.list(AsstExamPaperQuery.builder().asstExamBankId(asstExamAnswerUploadDTO.getAsstExamBankId()).build());
        // 把 question 放在 Map 里面
        Map<String, AsstExamPaperDO> asstExamPaperDOMap = asstExamPaperDOList.stream().collect(Collectors.toMap(AsstExamPaperDO::getQuestion, e -> e));

        List<AsstExamAnswerDO> list = new ArrayList<>();
        List<String> questionList = new ArrayList<>();
        List<String> answerList = new ArrayList<>();
        try (XWPFDocument document = new XWPFDocument(asstExamAnswerUploadDTO.getFile().getInputStream())) {
            // 获取所有段落
            List<XWPFParagraph> paragraphs = document.getParagraphs();

            // 遍历并打印每个段落的文本内容
            for (XWPFParagraph para : paragraphs) {
                if (para.getText().startsWith("题目：")) {
                    questionList.add(para.getText().replaceAll("题目：", ""));
                }
                if (para.getText().startsWith("答案：")) {
                    answerList.add(para.getText().replaceAll("答案：", ""));
                }
            }
        } catch (Exception e) {
            log.info("read word error: {}", e.getMessage(), e);
        }

        for (int i = 0; i < questionList.size(); i++) {
           if (asstExamPaperDOMap.containsKey(questionList.get(i))) {
               AsstExamAnswerDO asstExamAnswerDO = asstExamMapstruct.asstExamAnswerUploadDtoConvertToAsstExamAnswerDo(asstExamAnswerUploadDTO);
               asstExamAnswerDO.setAsstExamPaperId(asstExamPaperDOMap.get(questionList.get(i)).getId());
               asstExamAnswerDO.setType(1);
               asstExamAnswerDO.setQuestion(questionList.get(i));
               asstExamAnswerDO.setAnswer(answerList.get(i));
               list.add(asstExamAnswerDO);
           }
        }
        return asstExamAnswerDAO.insertBatch(list);
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
