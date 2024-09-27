package com.radiance.ai.assistant.dao.info;

import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.query.info.AsstInfoClassQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoTeacherQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstInfoTeacherDAO {

    List<AsstInfoTeacherDO> list(AsstInfoTeacherQuery data);

    int insertBatch(List<AsstInfoTeacherDO> list);

    int updateBatch(List<AsstInfoTeacherDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
