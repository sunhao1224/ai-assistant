package com.radiance.ai.assistant.dao.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstExamDimensionDAO {

    List<AsstExamDimensionDO> list(AsstExamDimensionQuery data);

    int insertBatch(List<AsstExamDimensionDO> list);

    int updateBatch(List<AsstExamDimensionDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
