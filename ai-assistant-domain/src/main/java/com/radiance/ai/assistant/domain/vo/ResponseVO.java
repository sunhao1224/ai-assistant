package com.radiance.ai.assistant.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.radiance.ai.assistant.domain.enums.ResponseCodeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 返回响应实体类
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/25 16:41
 * @since 1.0.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO implements Serializable {

    private static final long serialVersionUID = 1325102754270862143L;

    private Integer code;

    private String message;

    private Object data;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DataVO<T> {
        private Object info;
        private List<T> list;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class TplVO<T1, T2> {
        private Object info;
        private List<T1> systemTpls;
        private List<T2> customFields;
    }

    public ResponseVO() {
        super();
    }

    public ResponseVO(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public <T> ResponseVO(Integer code, String message, List<T> list, Object info) {
        this.code = code;
        this.message = message;
        DataVO dataVO = new DataVO();
        dataVO.setInfo(info);
        dataVO.setList(list);
        this.data = dataVO;
    }

    public <T1, T2> ResponseVO(Integer code, String message, List<T1> list1, List<T2> list2, Object info) {
        this.code = code;
        this.message = message;
        TplVO tplVO = new TplVO();
        tplVO.setInfo(info);
        tplVO.setSystemTpls(list1);
        tplVO.setCustomFields(list2);
        this.data = tplVO;
    }

    public static <T> ResponseVO successList(List<T> list) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), list, null);
    }

    public static ResponseVO successInfo(Object info) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), null, info);
    }

    public static <T> ResponseVO successInfoAndList(List<T> list, Object info) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), list, info);
    }

    public static <T> ResponseVO successInfoAndList(Object info, List<T> list) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), list, info);
    }

    public static ResponseVO success(Object data) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), data);
    }

    public static ResponseVO err() {
        return new ResponseVO(ResponseCodeEnum.SYSTEM_ERROR.getCode(), ResponseCodeEnum.SYSTEM_ERROR.getMsg(),
            null);
    }

    public static ResponseVO err(Integer code, String message) {
        return new ResponseVO(code, message, null);
    }

    public static <T1, T2> ResponseVO successTwoList(List<T1> list1, List<T2> list2) {
        return new ResponseVO(ResponseCodeEnum.SUCCESS.getCode(), ResponseCodeEnum.SUCCESS.getMsg(), list1, list2,
            null);
    }

}
