package com.radiance.ai.assistant.common.mapstruct;

import com.radiance.ai.assistant.domain.dos.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionInsertDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionListDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionUpdateDTO;
import com.radiance.ai.assistant.domain.query.AsstExamDimensionQuery;
import com.radiance.ai.assistant.domain.vo.AsstExamDimensionVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * AI 助手 Mapstruct
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 19:31
 * @since 1.0.0
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommonMapstructConversion.class})
public interface AsstMapstruct {

    AsstExamDimensionQuery asstExamDimensionListDtoConvertToAsstExamDimensionQuery(AsstExamDimensionListDTO source);

    AsstExamDimensionQuery asstExamDimensionDtoConvertToAsstExamDimensionQuery(AsstExamDimensionListDTO source);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstExamDimensionVO asstExamDimensionDoConvertToAsstExamDimensionVo(AsstExamDimensionDO source);

    List<AsstExamDimensionVO> asstExamDimensionDoListConvertToAsstExamDimensionVoList(List<AsstExamDimensionDO> list);

    @Mappings({
            @Mapping(source = "type", target = "type", defaultValue = "1")
    })
    AsstExamDimensionDO asstExamDimensionDtoConvertToAsstExamDimensionDo(AsstExamDimensionListDTO source);

    AsstExamDimensionDO asstExamDimensionInsertDtoConvertToAsstExamDimensionDo(AsstExamDimensionInsertDTO source);

    AsstExamDimensionDO asstExamDimensionUpdateDtoConvertToAsstExamDimensionDo(AsstExamDimensionUpdateDTO source);

}
