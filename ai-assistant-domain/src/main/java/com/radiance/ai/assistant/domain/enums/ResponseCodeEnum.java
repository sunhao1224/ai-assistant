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

    ADD_WKT_ERROR(10101,"wkt信息添加失败"),
    QUERRY_WKT_ERROR(10102,"wkt信息查询失败"),
    UPDATE_WKT_ERROR(10103,"wkt信息更新失败，请检查区块id是否存在"),
    DELETE_WKT_ERROR(10104,"wkt信息删除失败，请检查区块id是否存在"),
    SELECT_WKT_ERROR(10105,"wkt未查到"),
    WKT_SIZES_ERROR(10106,"一次最多允许查询200个自定义区块"),
    WKT_ADDSIZES_ERROR(10107,"一次最多允许添加200个自定义区块"),
    WKT_POINTS_ERROR(10201,"wkt格式错误，不是闭环"),
    WKT_SIZE_ERROR(10202,"wkt坐标点低于4个"),
    WKT_AREA_ERROR(10203,"wkt不符合要求,无法获取有效面积"),
    WKT_GETAREA_ERROR(10204,"wkt格式错误，无法获取面积"),
    WKT_XY_POINT_ERROR(10205,"wkt坐标经纬度校验不合法"),
    WKT_POINT_NOT_IN_CHINA_ERROR(10206,"wkt坐标解析失败"),
    WKT_POINT_FORMAT_ERROR(10207,"wkt坐标格式错误，经纬度之间使用空格分隔"),
    GEO_TYPE_ERROR(10300,"区块类型不存在"),
    GEO_SCALE_ERROR(10400,"区块尺寸不合理，无法展示"),
    MISSING_REQUIRED_PARAMS(10401,"缺少必要参数"),


    /**
     * 点模块
     */
    OBJECT_SIZE_ERROR(11001, "单次请求数据大小超字节限制，请减少数据量"),
    THREAD_SIZE_ERROR(11002, "当前请求数量已达上限，请稍后再试"),
    LAYER_NOT_EXIT(11003, "指定的点图层不存在"),
    CREATE_LAYER_TRANSFINITE(11004, "点图层数量已达上限"),
    TEMPLATE_NOT_EXIT(11005, "指定的模板不存在"),
    LAYER_STATUS_OPERATION_MISMATCH(11006, "请求操作与图层状态不匹配"),
    LAYER_TYPE_NOT_MATCH(11007, "请求操作与图层类型不匹配"),
    UPDATE_LAYER_TRANSFINITE(11008, "批量修改图层数超限"),
    BINDING_LAYER_TEMPLATE_FAILED(11009, "绑定图层模板失败"),
    REQUEST_DATA_SIZE_TRANSFINITE(11010, "已超限，单个图层内支持存储1万个点"),
    DATA_COLUMN_DIFFERENT_TEMPLATE(11011, "上图方式与模板不一致"),
    REPEATED_BINDING_LAYER_TEMPLATE(11012, "模板已绑定，请勿重复调用"),
    REPEATED_UPDATE_STATUS_REQUEST(11013, "已触发状态变更,请勿重复请求"),
    LAYER_TASK_FAILED(11014, "上传点图层数据任务失败"),
    POINT_OP_DB_ERRO(11015, "点数据库操作异常"),
    POINT_UPDATE_FIELD_NOT_EMPTY(11016, "修改字段不能为空"),
    POINT_UPDATE_LAYER_ERROR(11017, "更新区块图层失败"),
    POINT_CREATE_LAYER_ERROR(11019, "创建区块图层失败"),
    POINT_TEMPLATE_ILLE_FIELD(11020, "模板字段错误"),
    POINT_TEMPLATE_ILLE_FIELD_VAL(11021, "模板字段对应值错误"),
    //gis2.0
    POINT_TABLE_CREATE_FIELD_VAL(11022, "创建表失败"),
    POINT_TABLE_ALDREADY_EXISTED(11023, "点详情表已经存在"),
    POINT_UPLOAD_FIELD_REPEATED(11024, "上传字段重复"),
    POINT_UPLOAD_DATA_ERROR(11025, "字段值填写错误："),
    POINT_GET_SYSTEM_TPL_ERROR(11026, "获取系统模板失败"),
    POINT_UPLOAD_FIELD_MISSING(11027, "缺少必填字段fieldDesc或fieldType"),
    TASK_CREATE_FAILED(11028, "任务创建失败"),
    //gis1.3.1
    POINT_EFFECTIVE_FIELD_ERROR(11029, "点详情表有效字段个数超出限制"),
    POINT_TOTAL_FIELD_ERROR(11030, "点详情表总字段个数超出限制"),
    POINT_FIELD_DESC_REPEAT_ERROR(11031, "新增字段描述与已有字段重复"),
    POINT_FIELD_NOT_EXIST_ERROR(11032, "待删除字段不存在"),
    POINT_BATCH_NOT_EXIST_ERROR(11033, "该图层不存在此batchId"),
    POINT_FIELD_DESC_EMPTY_ERROR(11034, "新增字段描述不能为空"),
    //gis single update
    POINT_SINGLE_UPLOAD_SIZE_ERROR(11035, "本接口只支持单条数据上传"),
    //gis1.4.0
    POINT_UPDATE_NOT_EXIST_ERROR(11036, "不支持更新系统字段或不存在字段"),
    POINT_FIELD_NAME_EMPTY_ERROR(11037, "字段名称不能为空"),
    //search
    POINT_SEARCH_MAX_SIZE_ERROR(11101, "字段个数超过上限"),
    POINT_SEARCH_TYPE_ERROR(11102, "字段格式错误"),
    POINT_SEARCH_GEO_ERROR(11103, "city地址解析错误"),
    POINT_SEARCH_FILTER_ERROR(11104, "filter参数解析错误"),
    POINT_SEARCH_SORT_ERROR(11105, "sortrule参数解析错误"),
    POINT_SEARCH_ES_ERROR(11106, "SEARCH服务错误"),
    POINT_SEARCH_POINT_ERROR(11107, "point格式错误"),
    POINT_SEARCH_WKT_ERROR(11108, "polygon参数格式错误"),
    POINT_SEARCH_FILTER_EQ_MAX_ERROR(11109, "filter精准匹配值的个数超限制"),
    POINT_SEARCH_KEYWORDS_MAX_ERROR(11110, "关键字值的个数超限制"),
    POINT_SEARCH_ID_MAX_ERROR(11111, "id值的个数超限制"),
    POINT_SEARCH_BBOX_EQUALS_ERROR(11112, "polygon参数错误,矩形两点经纬度不能相等"),
    POINT_SEARCH_PAGE_ERROR(11113, "请求数据量超限"),
    POINT_SEARCH_TABLE_EXISTS(11114, "表或索引不存在"),

    //es index
    POINT_INDEX_TABLE_EXISTS(11115, "索引不存在"),
    POINT_INDEX_FIlED_NOT_EXISTS(11116, "索引字段不匹配"),
    POINT_INDEX_UPSERT_FIlED(11117,"索引文档创建更新失败"),


    POINT_SEARCH_FILTER_NUM_ERROR(11118, "filter参数条件个数超限制"),
    POINT_SEARCH_POLYGON_EQUALS_ERROR(11119, "polygon参数错误,收尾两点经纬度需要相等"),
    POINT_SEARCH_FILTER_TYPE_ERROR(11120, "filter参数索引类型错误"),
    POINT_SEARCH_POLYGON_AREA_ERROR(11121, "polygon参数面积超过限制"),

    POINT_INDEX_LIMIT(11122 ,"超过最大索引任务数"),
    POINT_INDEX_LAYER_LIMIT(11123 ,"图层索引任务进行中"),

    POINT_INDEX_CUSMTOM_OVER(11124,"自定义索引数量超过限定"),
    POINT_INDEX_MAPPING_FORMAT_ERROR(11125,"索引请求格式错误"),
    /**
     * 面模块
     */
    AREA_LAYER_NOT_EXIT(12003, "指定的区块图层不存在"),
    AREA_CREATE_LAYER_TRANSFINITE(12004, "区块图层数量已达上限"),
    AREA_LAYER_STATUS_OPERATION_MISMATCH(12006, "请求操作与区块图层状态不匹配"),
    AREA_LAYER_TYPE_NOT_MATCH(12007, "请求操作与区块图层类型不匹配"),
    AREA_UPDATE_LAYER_TRANSFINITE(12008, "批量修改区块图层数超限"),
    POLYGON_CREATE_ILLE_ITEM(12009, "请求存在非法项"),
    POLYGON_AREA_TOO_LARGE(12010, "包含创建区块面积过大的项"),
    POLYGON_OP_DB_ERRO(12011, "区块数据库操作异常"),
    POLYGON_LAYER_IS_FULL(12012, "区块图层中可添加数量为"),
    POLYGON_NOT_FOUND_ITEM_TO_UPDATE(12013, "没有可更新的项"),
    POLYGON_UPDATE_ILLE_ITEM(12014, "包含无法更新项"),
    POLYGON_UPDATE_FIELD_NOT_EMPTY(12016, "修改字段不能为空"),
    POLYGON_UPDATE_LAYER_ERROR(12017, "更新区块图层失败"),
    POLYGON_PATTERN_ILLE(12018, "区块wkt格式非法"),
    POLYGON_CREATE_LAYER_ERROR(12019, "创建区块图层失败"),
    POLYGON_GIS_TYPE_ERROR(12020, "空间索引类型有误"),
    /**
     * 缓冲区模块
     */
    POLYGON_COPY_EMPTY_POINT_ERROR(12201, "无法复制空点图层"),
    POLYGON_BUFFER_COPIED_ERROR(12202, "缓冲区图层已有数据只能拷贝一次"),
    /**
     * 行政区划
     */
    POLYGON_AD_INSERT_ERROR(12203, "批量插入行政区划区块失败"),
    ADCODE_WKT_PARAMS_ERROR(12204, "adcode和wkt只能传其中一个"),
    ADCODE_STREET_INFO_ERROR(12205, "该adcode下的街道信息不存在，请检查输入"),
    ADCODE_AD_WKT_NULL_ERROR(12206, "必填参数adcode和wkt不能都为空"),
    ADCODE_VILLAGE_INFO_ERROR(12207, "该adcode下的村/社区信息不存在，请检查输入"),
    ADCODE_STREETID_WKT_NULL_ERROR(12208, "必填参数streetId和wkt不能都为空"),
    ADCODE_STREETID_WKT_PARAMS_ERROR(12209, "streetId和wkt只能传其中一个"),


    /**
     * 点数据分析
     */
    POINT_ANALYZE_OP_DB_ERRO(113011, "数据库操作失败"),
    POINT_ANALYZE_POLYGON_FORMAT_ERROR(113012, "返回围栏基本格式有误，wkt类型头（POLYGON）大写，且点数应该大于三个，且点与点之间应该用逗号相连，且wkt首尾点应该一致."),
    POINT_ANALYZE_ILLE_COLUMN_REGX(113013, "请求字段名称在不符合数据库表字段规范"),
    POINT_ANALYZE_ILLE_COLUMN_IN_TABLE(113014, "数据表中不存在"),
    POINT_ANALYZE_POLYGON_AREA_TOO_LARGE(113015, "区块wkt面积过大的项"),


    /**
     * geo服务
     */
    GEO_PARAM_TRANSFINITE(14001, "参数address，以|分隔后，最多支持10个"),
    GEO_CALL_ONLINE_ERROR(14002, "调用在线GEO服务失败"),
    GEO_CONVERT_RESULT_ERROR(14003, "转换在线GEO服务结果失败"),
    GEO_PARAM_NULL_ERROR(14004, "参数geoParamDTO不能为null"),
    GEO_PARAM_ADDRESS_BLANK_ERROR(14005, "参数address不能为空"),

    /**
     * rgeo服务
     */
    RGEO_PARAM_TRANSFINITE(15001, "参数location，以|分隔后，最多支持20个"),
    RGEO_PARAM_CONTAIN_NO_XY(15002, "参数location中包含不正确的坐标地址"),
    RGEO_CALL_ONLINE_ERROR(15003, "调用在线RGEO服务失败"),
    RGEO_CONVERT_RESULT_ERROR(15004, "转换在线RGEO服务结果失败"),
    RGEO_PARAM_LOCATION_BLANK_ERROR(15005, "参数location不能为空"),
    RGEO_PARAM_NULL_ERROR(15006, "参数rgeoParamDTO不能为null"),
    RGEO_PARAM_EXTENSIONS_ERROR(15007, "参数extensions的可选值为all，base"),
    RGEO_PARAM_ROADLEVEL_ERROR(15008, "参数roadlevel的可选值为0，1"),
    RGEO_PARAM_HOMEORCORP_ERROR(15009, "参数homeorcorp的可选值为0，1，2"),

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

    private Integer code;

    private String msg;

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
