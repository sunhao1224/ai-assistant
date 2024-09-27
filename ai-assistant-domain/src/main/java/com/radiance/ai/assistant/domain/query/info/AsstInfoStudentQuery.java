package com.radiance.ai.assistant.domain.query.info;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 信息-学生-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstInfoStudentQuery {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 班级表主键 ID
     */
    private Long asstInfoClassId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 性别：0-未知，1-男，2-女
     */
    private Integer sex;
    /**
     * 分组
     */
    private String group;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 政治面貌
     */
    private String politicalOutlook;
    /**
     * 数据状态：0-未删除，1-已删除
     */
    private Integer dataStatus;
}
