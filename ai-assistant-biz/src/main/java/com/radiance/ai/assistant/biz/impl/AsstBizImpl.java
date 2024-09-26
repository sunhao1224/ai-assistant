package com.radiance.ai.assistant.biz.impl;

import com.radiance.ai.assistant.biz.AsstBiz;
import com.radiance.ai.assistant.common.mapstruct.AsstMapstruct;
import com.radiance.ai.assistant.common.utils.DateUtil;
import com.radiance.ai.assistant.dao.AsstExamDimensionDAO;
import com.radiance.ai.assistant.domain.dos.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionInsertDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionListDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionUpdateDTO;
import com.radiance.ai.assistant.domain.enums.AsstExamDimensionTypeEnum;
import com.radiance.ai.assistant.domain.enums.DataStatusEnum;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * AI 助手业务接口实现类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:43
 * @since 1.0.0
 */
@Service
public class AsstBizImpl implements AsstBiz {

    @Resource
    private AsstExamDimensionDAO asstExamDimensionDAO;

    @Resource
    private AsstMapstruct asstMapstruct;

    @Override
    public List<AsstExamDimensionDO> examDimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO) {
        return asstExamDimensionDAO.list(asstMapstruct.asstExamDimensionListDtoConvertToAsstExamDimensionQuery(asstExamDimensionListDTO));
    }

    @Override
    public int examDimensionInsert(AsstExamDimensionInsertDTO asstExamDimensionInsertDTO) {
        AsstExamDimensionDO asstExamDimensionDO = asstMapstruct.asstExamDimensionInsertDtoConvertToAsstExamDimensionDo(asstExamDimensionInsertDTO);
        return asstExamDimensionDAO.insertBatch(Collections.singletonList(asstExamDimensionDO));
    }

    @Override
    public int examDimensionUpdate(AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO) {
        AsstExamDimensionDO asstExamDimensionDO = asstMapstruct.asstExamDimensionUpdateDtoConvertToAsstExamDimensionDo(asstExamDimensionUpdateDTO);
        return asstExamDimensionDAO.updateBatch(Collections.singletonList(asstExamDimensionDO));
    }

    @Override
    public int examDimensionRemove(List<Long> idList) {
        return asstExamDimensionDAO.removeBatch(idList);
    }
}
