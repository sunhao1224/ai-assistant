package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamSubjectDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamSubjectQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamSubjectDAO {

    List<AsstExamSubjectDO> list(AsstExamSubjectQuery data);

    int insertBatch(List<AsstExamSubjectDO> list);

    int updateBatch(List<AsstExamSubjectDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
