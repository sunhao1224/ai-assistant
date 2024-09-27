package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 20:26
 * @since
 */
@Data
public class AsstExamSubjectInsertDTO {
    /**
     * 类型
     */
    private Integer type;
    /**
     * 名称
     */
    private String name;
    /**
     * 分组
     */
    private String group;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 创建人
     */
    private String creator;
}
