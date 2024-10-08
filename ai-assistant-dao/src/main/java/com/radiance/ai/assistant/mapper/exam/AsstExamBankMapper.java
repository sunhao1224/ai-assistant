package com.radiance.ai.assistant.mapper.exam;

import com.radiance.ai.assistant.domain.dos.exam.AsstExamBankDO;
import com.radiance.ai.assistant.domain.query.exam.AsstExamBankQuery;
import com.radiance.ai.assistant.domain.query.exam.AsstExamDimensionQuery;
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
public interface AsstExamBankMapper {

    /**
     * 查询列表数据
     *
     * @param
     * @return
     * @author juncong.sh@alibaba-inc.com
     * @date 2024/9/25 17:12
     * @since 1.0.0.
     */
    List<AsstExamBankDO> list(@Param("data") AsstExamBankQuery data);

    int insertBatch(@Param("list") List<AsstExamBankDO> list);

    int updateBatch(@Param("list") List<AsstExamBankDO> list);

    int removeBatch(@Param("list") List<Long> list);

    int deleteBatch(@Param("list") List<Long> list);

}
