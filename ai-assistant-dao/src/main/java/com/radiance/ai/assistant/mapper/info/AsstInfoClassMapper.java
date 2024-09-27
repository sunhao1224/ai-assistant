package com.radiance.ai.assistant.mapper.info;

import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
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
public interface AsstInfoClassMapper {

    /**
     * 查询列表数据
     *
     * @param
     * @return
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/25 17:12
     * @since 1.0.0.
     */
    List<AsstInfoClassDO> list(@Param("data") AsstInfoClassQuery data);

    int insertBatch(@Param("list") List<AsstInfoClassDO> list);

    int updateBatch(@Param("list") List<AsstInfoClassDO> list);

    int removeBatch(@Param("list") List<Long> list);

    int deleteBatch(@Param("list") List<Long> list);

}
