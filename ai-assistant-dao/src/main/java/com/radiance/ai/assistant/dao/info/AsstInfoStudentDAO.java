package com.radiance.ai.assistant.dao.info;

import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.query.info.AsstInfoStudentQuery;
import com.radiance.ai.assistant.domain.query.info.AsstInfoTeacherQuery;

import java.util.List;

/**
 * 考试维度数据层接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 14:31
 * @since 1.0.0
 */
public interface AsstInfoStudentDAO {

    List<AsstInfoStudentDO> list(AsstInfoStudentQuery data);

    int insertBatch(List<AsstInfoStudentDO> list);

    int updateBatch(List<AsstInfoStudentDO> list);

    int removeBatch(List<Long> list);

    int deleteBatch(List<Long> list);

}
