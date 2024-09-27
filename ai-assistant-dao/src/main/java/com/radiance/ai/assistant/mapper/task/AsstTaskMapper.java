package com.radiance.ai.assistant.mapper.task;

import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.query.task.AsstTaskQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 考试维度 Mapper 层
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:30
 * @since 1.0.0
 */
@Mapper
public interface AsstTaskMapper {

    /**
     * 查询列表数据
     *
     * @param
     * @return
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/25 17:12
     * @since 1.0.0.
     */
    List<AsstTaskDO> list(@Param("data") AsstTaskQuery data);

    int insertBatch(@Param("list") List<AsstTaskDO> list);

    int updateBatch(@Param("list") List<AsstTaskDO> list);

    int removeBatch(@Param("list") List<Long> list);

    int deleteBatch(@Param("list") List<Long> list);

    AsstTaskDO getTaskAndLock();
}
