package com.radiance.ai.assistant.domain.dto.info;

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
public class AsstInfoStudentInsertDTO {
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
}
