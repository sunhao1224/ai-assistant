package com.radiance.ai.assistant.web.info;

import com.alibaba.fastjson.JSONObject;
import com.radiance.ai.assistant.biz.info.AsstInfoBiz;
import com.radiance.ai.assistant.common.mapstruct.info.AsstInfoMapstruct;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoClassDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoStudentDO;
import com.radiance.ai.assistant.domain.dos.info.AsstInfoTeacherDO;
import com.radiance.ai.assistant.domain.dto.info.*;
import com.radiance.ai.assistant.domain.vo.ResponseVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 21:32
 * @since
 */
@RestController
@RequestMapping("/asst/info")
public class AsstInfoController {

    @Resource
    private AsstInfoBiz asstInfoBiz;

    @Resource
    private AsstInfoMapstruct asstInfoMapstruct;

    @GetMapping("/class/list")
    public ResponseVO classList(AsstInfoClassListDTO asstInfoClassListDTO) {
        JSONObject info = new JSONObject();
        List<AsstInfoClassDO> list = asstInfoBiz.classList(asstInfoClassListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstInfoMapstruct.asstInfoClassDoListConvertToAsstInfoClassVoList(list));
    }

    @PostMapping("/class/insert")
    public ResponseVO classInsert(@RequestBody @Validated AsstInfoClassInsertDTO asstInfoClassInsertDTO) {
        int result = asstInfoBiz.classInsert(asstInfoClassInsertDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/class/update")
    public ResponseVO classUpdate(@RequestBody @Validated AsstInfoClassUpdateDTO asstInfoClassUpdateDTO) {
        int result = asstInfoBiz.classUpdate(asstInfoClassUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/class/remove")
    public ResponseVO classDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstInfoBiz.classRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/teacher/list")
    public ResponseVO teacherList(AsstInfoTeacherListDTO asstInfoTeacherListDTO) {
        JSONObject info = new JSONObject();
        List<AsstInfoTeacherDO> list = asstInfoBiz.teacherList(asstInfoTeacherListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstInfoMapstruct.asstInfoTeacherDoListConvertToAsstInfoTeacherVoList(list));
    }

    @PostMapping("/teacher/insert")
    public ResponseVO teacherInsert(@RequestBody @Validated AsstInfoTeacherInsertDTO asstInfoTeacherInsertDTO) {
        return ResponseVO.success(asstInfoBiz.teacherInsert(asstInfoTeacherInsertDTO));
    }

    @PostMapping("/teacher/update")
    public ResponseVO teacherUpdate(@RequestBody @Validated AsstInfoTeacherUpdateDTO asstInfoTeacherUpdateDTO) {
        int result = asstInfoBiz.teacherUpdate(asstInfoTeacherUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/teacher/remove")
    public ResponseVO teacherDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstInfoBiz.teacherRemove(idList);
        return ResponseVO.success(result);
    }

    @GetMapping("/student/list")
    public ResponseVO studentList(AsstInfoStudentListDTO asstInfoStudentListDTO) {
        JSONObject info = new JSONObject();
        List<AsstInfoStudentDO> list = asstInfoBiz.studentList(asstInfoStudentListDTO);
        info.put("count", list.size());
        return ResponseVO.successInfoAndList(info,
                asstInfoMapstruct.asstInfoStudentDoListConvertToAsstInfoStudentVoList(list));
    }

    @PostMapping("/student/insert")
    public ResponseVO studentInsert(@RequestBody @Validated AsstInfoStudentInsertDTO asstInfoStudentInsertDTO) {
        return ResponseVO.success(asstInfoBiz.studentInsert(asstInfoStudentInsertDTO));
    }

    @PostMapping("/student/update")
    public ResponseVO studentUpdate(@RequestBody @Validated AsstInfoStudentUpdateDTO asstInfoStudentUpdateDTO) {
        int result = asstInfoBiz.studentUpdate(asstInfoStudentUpdateDTO);
        return ResponseVO.success(result == 1 ? "success" : "fail");
    }

    @PostMapping("/student/remove")
    public ResponseVO studentDelete(@RequestBody @Validated List<Long> idList) {
        int result = asstInfoBiz.studentRemove(idList);
        return ResponseVO.success(result);
    }


}
