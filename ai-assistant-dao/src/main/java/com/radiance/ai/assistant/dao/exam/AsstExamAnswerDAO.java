package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamAnswerDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamAnswerStatisticsLevelDO;
import com.radiance.ai.assistant.domain.dto.exam.AsstExamAnswerStatisticsLevelDTO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamAnswerQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamAnswerDAO {

    List<AsstExamAnswerDO> list(AsstExamAnswerQuery data);

    int insertBatch(List<AsstExamAnswerDO> list);

    int updateBatch(List<AsstExamAnswerDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

    int deleteByAsstExamBankId(List<Long> list);

    List<AsstExamAnswerStatisticsLevelDO> answerStatisticsLevel(Long asstExamBankId);
}
