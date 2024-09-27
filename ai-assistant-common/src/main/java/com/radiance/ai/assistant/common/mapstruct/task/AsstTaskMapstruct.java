package com.radiance.ai.assistant.common.mapstruct.task;

import com.radiance.ai.assistant.common.mapstruct.CommonMapstructConversion;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskInsertDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskListDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskUpdateDTO;
import com.radiance.ai.assistant.domain.query.task.AsstTaskQuery;
import com.radiance.ai.assistant.domain.vo.task.AsstTaskVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 20:54
 * @since
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CommonMapstructConversion.class})
public interface AsstTaskMapstruct {

    AsstTaskQuery asstTaskListDtoConvertToAsstTaskQuery(AsstTaskListDTO asstTaskListDTO);

    AsstTaskDO asstTaskInsertDtoConvertToAsstTaskDo(AsstTaskInsertDTO asstTaskInsertDTO);

    AsstTaskDO asstTaskUpdateDtoConvertToAsstTaskDo(AsstTaskUpdateDTO asstTaskUpdateDTO);

    @Mappings({
            @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "finishTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AsstTaskVO asstTaskDoConvertToAsstTaskVo(AsstTaskDO asstTaskDO);

    List<AsstTaskVO> asstTaskDoListConvertToAsstTaskVoList(List<AsstTaskDO> asstTaskDOList);

}
