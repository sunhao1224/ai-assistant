package com.radiance.ai.assistant.domain.enums;

/**
 * 返回编码
 *
 * @Author hyp
 * @Date 17:13 2019-07-16
 **/
public enum ResponseCodeEnum implements ResponseCode {
    /**
     * 系统+通用模块
     */
    SUCCESS(0, "OK"),
    SYSTEM_ERROR(1, "系统错误"),
    UNAUTHORIZED_OPERATION(10001, "您无此图层数据权限"),
    REQUIRED_PARAM_IS_NULL(10002, "必填参数不能为空"),
    PARAM_IS_ERROR(10003, "参数填写错误"),
    PATH_ERROR(10004, "路径错误"),
    HTTP_REQUEST_ERROR(10005, "不支持的请求方式"),
    REQUEST_JSON_PARSE_ERROR(10006, "参数解析异常"),
    HTTP_REQUEST_HEADER_ERROR(10007, "不支持的请求头格式"),
    HTTP_REQUEST_TIMEOUT_ERROR(10008, "请求超时"),
    HTTP_RESPONSE_HAND_ERROR(10009, "http响应处理失败"),
    PARAM_TYPE_IS_ERROR(10010, "参数类型错误"),
    FILE_UPLOAD_ERROR(10011, "文件上传错误"),

    DATA_ERROR(10100, "数据错误"),
    DATA_INSERT_ERROR(10101, "数据新增错误"),

    /**
     * 日志
     */
    LOG_FILE_NOT_EXIST_ERROR(16001, "指定的日志文件不存在"),
    LOG_PARAM_FILENAME_BLANK_ERROR(16002, "参数fileName不能为空"),
    LOG_PARAM_LOGLEVEL_ERROR(16003, "参数logLevel的可选值为debug，info，warn，error，all"),

    /**
     * 授权
     */
    LICENSE_NOT_EXISTS_ERROR(17001, "授权信息不存在"),
    LICENSE_EXPIRED_ERROR(17002, "授权信息过期"),
    LICENSE_PARSE_NOTAFTERTIME_ERROR(17003, "授权信息中的终止日期解析失败"),
    LICENSE_MODIFIED_SYS_TIME_ERROR(17004, "修改了系统时间"),
    LICENSE_NOT_EXISTS_LASTUSETIME_ERROR(17005, "与授权相关的lastUseTime配置项不存在"),
    LICENSE_PARSE_LASTUSETIME_ERROR(17006, "与授权相关的lastUseTime配置项解析失败"),
    LICENSE_PARSE_ERROR(17007, "授权信息解析失败"),

    /**
     * 流控
     */
    RATELIMIT_NOT_EXISTS_API_ERROR(18001, "apiPath = %s 未注册"),
    RATELIMIT_NOT_EXISTS_QUOTA_API_ERROR(18002, "apiId = %s, apiPath = %s 的流控配置不存在"),
    RATELIMIT_PARSE_QUOTA_API_ERROR(18003, "apiId = %s, apiPath = %s 的流控配置 confValue = %s 错误"),
    RATELIMIT_QUOTA_DAY_TRANSFINITE(18004, "apiId = %s, apiPath = %s 的流控配置（天级） %s 已达上限"),
    RATELIMIT_QUOTA_MINUTE_TRANSFINITE(18005, "apiId = %s, apiPath = %s 的流控配置（分钟级） %s 已达上限"),
    RATELIMIT_QUOTA_SECOND_TRANSFINITE(18006, "apiId = %s, apiPath = %s 的流控配置（秒级） %s 已达上限"),
    RATELIMIT_NOT_EXISTS_ACTUAL_DAY_ERROR(18007, "apiId = %s, apiPath = %s 的实际流量统计配置（天级） %s 不存在"),
    RATELIMIT_PARSE_ACTUAL_DAY_ERROR(18008, "apiId = %s, apiPath = %s 的实际流量统计配置（天级）解析失败"),
    RATELIMIT_PARSE_QUOTA_ERROR(18009, "流控配置解析失败"),

    /**
     * me-core禁用段!
     * saaas接入层：19000-19999
     * saas文件系统：29000-29999
     */

    /**
     * 计量
     */
    CALCFLOW_CONFIG_NOT_EXISTS_ERROR(21001, "计量配置不存在"),
    CALCFLOW_CONFIG_PARSE_ERROR(21002, "计量配置解析失败"),

    /**
     * 数据分析
     */
    DATA_ANALYZE_REQUIRED_PARAM_EMPTY(22001, "必要参数为空"),
    DATA_ANALYZE_ITEM_CAL_SIZE_ERROR(22002, "待计算项与计算原语个数不匹配"),
    DATA_ANALYZE_POINT_ENUM_ERROR(22003, "point参数中存在错误的枚举值"),
    DATA_ANALYZE_FIELD_ERROR(22004, "field 字段错误"),
    DATA_ANALYZE_CAL_TYPE_ERROR(22005, "cal 计算类型错误"),
    DATA_ANALYZE_DISTINCT_TYPE_ERROR(22006, "该计算类型不支持去重"),
    DATA_ANALYZE_POLYGON_TYPE_ERROR(22007, "polygon 类型错误"),
    DATA_ANALYZE_BUFFER_META_ERROR(22008, "buffer图层库中缺少meta信息"),
    DATA_ANALYZE_TASK_EMPTY(22009, "计算任务为空"),
    DATA_ANALYZE_TASK_STATUS_ILL(22010, "计算任务状态异常"),
    DATA_ANALYZE_TASK_RESULT_ILL(22011, "计算结果有误"),
    DATA_ANALYZE_TASK_SQL_ILL(22012, "计算任务sql拼写有误"),
    DATA_ANALYZE_TASK_ILL(22013, "无法查找到任务"),
    DATA_ANALYZE_VAL_ILL(22014, "field对应的val输入有误"),
    DATA_ANALYZE_NEED_GAODE_FIELD(22015, "缺少高德条件字段"),
    DATA_ANALYZE_GAODE_FIELD_VAL_ERROR(22016, "高德数据字段错误"),
    DATA_ANALYZE_GAODE_FIELDS_SIZE_ERROR(22017, "高德数据集合大小错误"),
    DATA_ANALYZE_ITEM_ARRANGE_ERROR(22018,"计算项顺序排列有误"),
    DATA_ANALYZE_DA_RESULT_PARAM_ERROR(22019,"获取计算结果参数错误"),
    DATA_ANALYZE_DA_NUM_LIMIT(22020,"任务数超过限制，请自行删减"),
    DATA_ANALYZE_DA_RESULT_PARAM_WKT_ERROR(22021,"wkt参数无法切分出有效的单元"),
    DATA_ANALYZE_DA_RESULT_NOT_FOUND(22022,"找不到计算结果"),

    /**
     * 安全
     */
    SECURITY_REFER_ERROR(20001, "referer信息错误");

    private final Integer code;

    private final String msg;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
