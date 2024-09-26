package com.radiance.ai.assistant.biz;

import com.radiance.ai.assistant.domain.dos.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionInsertDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionListDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionUpdateDTO;

import java.util.List;

/**
 * AI 助手业务接口
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:42
 * @since 1.0.0
 */
public interface AsstBiz {

    List<AsstExamDimensionDO> examDimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO);

    int examDimensionInsert(AsstExamDimensionInsertDTO asstExamDimensionInsertDTO);

    int examDimensionUpdate(AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO);

    int examDimensionRemove(List<Long> idList);
}
