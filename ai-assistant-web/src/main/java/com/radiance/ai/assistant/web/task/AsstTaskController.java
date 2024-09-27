package com.radiance.ai.assistant.web.task;

import com.alibaba.fastjson.JSONObject;
import com.radiance.ai.assistant.biz.task.AsstTaskBiz;
import com.radiance.ai.assistant.common.mapstruct.task.AsstTaskMapstruct;
import com.radiance.ai.assistant.domain.dos.task.AsstTaskDO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskInsertDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskListDTO;
import com.radiance.ai.assistant.domain.dto.task.AsstTaskUpdateDTO;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:33
 * @since
 */
@RestController
@RequestMapping("/asst/task")
public class AsstTaskController {

    @Resource
    private AsstTaskBiz asstTaskBiz;

    @Resource
    private AsstTaskMapstruct asstTaskMapstruct;

    @GetMapping("/list")
    public ResponseVO list(AsstTaskListDTO asstTaskListDTO) {
        JSONObject info = new JSONObject();
        List<AsstTaskDO> list = asstTaskBiz.list(asstTaskListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstTaskMapstruct.asstTaskDoListConvertToAsstTaskVoList(list));
    }

    @PostMapping("/insert")
    public ResponseVO insert(@RequestBody @Validated AsstTaskInsertDTO asstTaskInsertDTO) {
        int result = asstTaskBiz.insert(asstTaskInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/update")
    public ResponseVO update(@RequestBody @Validated AsstTaskUpdateDTO asstTaskUpdateDTO) {
        int result = asstTaskBiz.update(asstTaskUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/remove")
    public ResponseVO delete(@RequestBody @Validated List<Long> idList) {
        int result = asstTaskBiz.remove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/process")
    public ResponseVO process(@RequestParam("asstExamPaperId") Long asstExamPaperId) {
        asstTaskBiz.processPaper(asstExamPaperId);
        return ResponseVO.success("success");
    }

}
