package com.radiance.ai.assistant.mapper.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamPaperDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamPaperQuery;
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
public interface AsstExamPaperMapper {

    /**
     * 查询列表数据
     *
     * @param
     * @return
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/25 17:12
     * @since 1.0.0.
     */
    List<AsstExamPaperDO> list(@Param("data") AsstExamPaperQuery data);

    int insertBatch(@Param("list") List<AsstExamPaperDO> list);

    int updateBatch(@Param("list") List<AsstExamPaperDO> list);

    int removeBatch(@Param("list") List<Long> list);

    int deleteBatch(@Param("list") List<Long> list);

    int deleteByGroup(@Param("list") List<String> list);

    int deleteByAsstExamBankId(@Param("list") List<Long> list);
}
