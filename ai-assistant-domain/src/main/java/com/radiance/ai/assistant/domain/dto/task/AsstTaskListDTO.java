package com.radiance.ai.assistant.domain.dto.task;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 任务-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstTaskListDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 开始试卷表主键 ID
     */
    private Long asstExamPaperId;
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
     * 执行状态：0-未执行，1-执行中，2-完成，3-出错
     */
    private Integer status;
}
