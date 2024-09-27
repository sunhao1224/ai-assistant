package com.radiance.ai.assistant.mapper.info;

import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.query.info.AsstInfoTeacherQuery;
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
public interface AsstInfoTeacherMapper {

    /**
     * 查询列表数据
     *
     * @param
     * @return
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/25 17:12
     * @since 1.0.0.
     */
    List<AsstInfoTeacherDO> list(@Param("data") AsstInfoTeacherQuery data);

    int insertBatch(@Param("list") List<AsstInfoTeacherDO> list);

    int updateBatch(@Param("list") List<AsstInfoTeacherDO> list);

    int removeBatch(@Param("list") List<Long> list);

    int deleteBatch(@Param("list") List<Long> list);

}
