package com.radiance.ai.assistant.domain.dto.exam;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考试答题-DO
 *
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/9/26 16:11
 * @since 1.0.0
 */
@Data
public class AsstExamAnswerUploadDTO {
    /**
     * 考试题库表主键 ID
     */
    private Long asstExamBankId;
    /**
     * 考试试卷表主键 ID
     */
    private Long asstExamPaperId;
    /**
     * 老师表主键 ID
     */
    private Long asstInfoStudentId;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 分组
     */
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
