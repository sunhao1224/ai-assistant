package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamPaperDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamBankQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamPaperDAO {

    List<AsstExamPaperDO> list(AsstExamPaperQuery data);

    int insertBatch(List<AsstExamPaperDO> list);

    int updateBatch(List<AsstExamPaperDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
