package com.radiance.ai.assistant.biz.task;

import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskInsertDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskListDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskUpdateDTO;

import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:18
 * @since
 */
public interface AsstTaskBiz {

    List<AsstTaskDO> list(AsstTaskListDTO asstTaskListDTO);

    int insert(AsstTaskInsertDTO asstTaskInsertDTO);

    int update(AsstTaskUpdateDTO asstTaskUpdateDTO);

    int remove(List<Long> idList);

    void processPaper(Long asstExamPaperId);
}
