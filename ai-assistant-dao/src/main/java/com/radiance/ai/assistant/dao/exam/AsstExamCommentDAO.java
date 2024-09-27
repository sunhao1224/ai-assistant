package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamCommentDO;
import com.radiance.ai.assistant.domain.dos.exam.AsstExamPaperDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamCommentQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamCommentDAO {

    List<AsstExamCommentDO> list(AsstExamCommentQuery data);

    int insertBatch(List<AsstExamCommentDO> list);

    int updateBatch(List<AsstExamCommentDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
