package com.mario.auth.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SignupRequest {
    @NotBlank(message = "이메일 주소는 필수 입력입니다.")
    @Email(message = "이메일 주소 형식을 확인해주세요.")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min = 8, max = 20, message = "비밀번호는 8 ~ 20자 까지 입력 가능합니다.")
    @Pattern(
        regexp = "(?=.*\\d)(?=.*[~`!@#$%^&*()-+=])(?=.*[a-zA-Z])$",
        message = "비밀번호 입력 형식을 확인해주세요. (영문, 숫자, 특수문자 1개 이상)"
    )
    private String password;

    @NotBlank(message = "이름은 필수 입력입니다.")
    @Size(min = 2, max = 20, message = "이름은 2 ~ 10자 까지 입력 가능합니다.")
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]+$", message = "이름 입력 형식을 확인해주세요. (한글, 영문, 숫자)")
    private String name;
}
