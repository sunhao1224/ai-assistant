package com.radiance.ai.assistant.domain.dto.info;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author juncong.sh@alibaba-inc.com
 * @date 2024/10/9 17:37
 * @since
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsstInfoTeacherLoginDTO {
    /**
     * 主键 ID
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;
}
