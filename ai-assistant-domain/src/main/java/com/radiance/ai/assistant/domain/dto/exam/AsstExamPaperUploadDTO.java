package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 考试试卷-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamPaperUploadDTO {
    /**
     * 考试题库表主键 ID
     */
    @NotNull(message = "asstExamBankId 不能为空")
    private Long asstExamBankId;
    /**
     * 老师表主键 ID
     */
    @NotNull(message = "asstInfoTeacherId 不能为空")
    private Long asstInfoTeacherId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分组
     */
    @NotBlank(message = "group 不能为空")
    private String group;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 文件
     */
    private MultipartFile file;
}
