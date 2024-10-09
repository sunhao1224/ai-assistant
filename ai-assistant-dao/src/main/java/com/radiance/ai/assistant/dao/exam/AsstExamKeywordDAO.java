package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamCommentDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamKeywordDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamCommentQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamKeywordQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamKeywordDAO {

    List<AsstExamKeywordDO> list(AsstExamKeywordQuery data);

    int insertBatch(List<AsstExamKeywordDO> list);

    int updateBatch(List<AsstExamKeywordDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
