package com.radiance.ai.assistant.biz.task.impl;

import com.alibaba.fastjson.JSONObject;
import com.radiance.ai.assistant.biz.llm.doubao.DouBaoLlmBiz;
import com.radiance.ai.assistant.biz.task.AsstTaskBiz;
import com.radiance.ai.assistant.common.mapstruct.task.AsstTaskMapstruct;
import com.radiance.ai.assistant.dao.exam.AsstExamAnswerDAO;
import com.radiance.ai.assistant.dao.exam.AsstExamPaperDAO;
import com.radiance.ai.assistant.dao.task.AsstTaskDAO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamAnswerDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamPaperDO;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskInsertDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskListDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskUpdateDTO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamAnswerQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:27
 * @since
 */
@Service
public class AsstTaskBizImpl implements AsstTaskBiz {

    @Resource
    private AsstTaskMapstruct asstTaskMapstruct;

    @Resource
    private AsstTaskDAO asstTaskDAO;

    @Resource
    private AsstExamPaperDAO asstExamPaperDAO;

    @Resource
    private DouBaoLlmBiz douBaoLlmBiz;

    @Resource
    private AsstExamAnswerDAO asstExamAnswerDAO;

    @Override
    public List<AsstTaskDO> list(AsstTaskListDTO asstTaskListDTO) {
        return asstTaskDAO.list(asstTaskMapstruct.asstTaskListDtoConvertToAsstTaskQuery(asstTaskListDTO));
    }

    @Override
    public int insert(AsstTaskInsertDTO asstTaskInsertDTO) {
        AsstTaskDO asstTaskDO = asstTaskMapstruct.asstTaskInsertDtoConvertToAsstTaskDo(asstTaskInsertDTO);
        return asstTaskDAO.insertBatch(Collections.singletonList(asstTaskDO));
    }

    @Override
    public int update(AsstTaskUpdateDTO asstTaskUpdateDTO) {
        AsstTaskDO asstTaskDO = asstTaskMapstruct.asstTaskUpdateDtoConvertToAsstTaskDo(asstTaskUpdateDTO);
        return asstTaskDAO.updateBatch(Collections.singletonList(asstTaskDO));
    }

    @Override
    public int remove(List<Long> idList) {
        return asstTaskDAO.removeBatch(idList);
    }

    @Override
    public void processPaper(Long asstExamPaperId) {
        // 查询 asst_exam_paper 表，拿到考试试卷信息
        List<AsstExamPaperDO> asstExamPaperDOList = asstExamPaperDAO.list(AsstExamPaperQuery.builder().id(asstExamPaperId).build());
        AsstExamPaperDO asstExamPaperDO = asstExamPaperDOList.get(0);

        // 试卷题目调用大模型，拿到结果，并更新数据回表中
        String result = douBaoLlmBiz.promptGenerate(asstExamPaperDO.getQuestion());
        asstExamPaperDO.setAiAnswer(result);

        // 根据 asst_exam_paper 表主键 ID 查询学生答题表数据
        List<AsstExamAnswerDO> asstExamAnswerDOList = asstExamAnswerDAO.list(AsstExamAnswerQuery.builder().asstExamPaperId(asstExamPaperDO.getId()).build());

        for (AsstExamAnswerDO asstExamAnswerDO : asstExamAnswerDOList) {
            String aiResult = douBaoLlmBiz.aiAssist(asstExamAnswerDO.getAnswer());
            JSONObject json = JSONObject.parseObject(aiResult);
            asstExamAnswerDO.setAiScore(json.getInteger("总得分"));
            asstExamAnswerDO.setAiResult(aiResult);
        }
        asstExamAnswerDAO.updateBatch(asstExamAnswerDOList);

    }

}
