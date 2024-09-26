package com.radiance.ai.assistant.web;

import com.alibaba.fastjson.JSONObject;
import com.radiance.ai.assistant.biz.AsstBiz;
import com.radiance.ai.assistant.common.mapstruct.AsstMapstruct;
import com.radiance.ai.assistant.domain.dos.AsstExamDimensionDO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionInsertDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionListDTO;
import com.radiance.ai.assistant.domain.dto.AsstExamDimensionUpdateDTO;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 17:40
 * @since
 */
@RestController
@RequestMapping("/asst")
public class AsstController {

    @Resource
    private AsstBiz asstBiz;

    @Resource
    private AsstMapstruct asstMapstruct;

    @GetMapping("/exam/dimension/list")
    public ResponseVO examDimensionList(AsstExamDimensionListDTO asstExamDimensionListDTO) {
        JSONObject info = new JSONObject();
        List<AsstExamDimensionDO> list = asstBiz.examDimensionList(asstExamDimensionListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstMapstruct.asstExamDimensionDoListConvertToAsstExamDimensionVoList(list));
    }

    @PostMapping("/exam/dimension/insert")
    public ResponseVO examDimensionInsert(@RequestBody @Validated AsstExamDimensionInsertDTO asstExamDimensionInsertDTO) {
        int result = asstBiz.examDimensionInsert(asstExamDimensionInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/exam/dimension/update")
    public ResponseVO examDimensionUpdate(@RequestBody @Validated AsstExamDimensionUpdateDTO asstExamDimensionUpdateDTO) {
        int result = asstBiz.examDimensionUpdate(asstExamDimensionUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/exam/dimension/remove")
    public ResponseVO examDimensionDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstBiz.examDimensionRemove(idList);
        return ResponseVO.success(result);
    }

}
