package com.radiance.ai.assistant.dao.task;

import com.radiance.ai.assistant.domain.query.task.AsstTaskQuery;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstTaskDAO {

    List<AsstTaskDO> list(AsstTaskQuery data);

    int insertBatch(List<AsstTaskDO> list);

    int updateBatch(List<AsstTaskDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

    AsstTaskDO getTaskAndLock();

}
