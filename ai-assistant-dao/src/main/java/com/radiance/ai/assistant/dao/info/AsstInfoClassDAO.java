package com.radiance.ai.assistant.dao.info;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamPaperDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstInfoClassDAO {

    List<AsstInfoClassDO> list(AsstInfoClassQuery data);

    int insertBatch(List<AsstInfoClassDO> list);

    int updateBatch(List<AsstInfoClassDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
