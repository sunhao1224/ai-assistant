package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamBankDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamBankQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamSubjectQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamBankDAO {

    List<AsstExamBankDO> list(AsstExamBankQuery data);

    int insertBatch(List<AsstExamBankDO> list);

    int updateBatch(List<AsstExamBankDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
