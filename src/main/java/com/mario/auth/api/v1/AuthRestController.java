package com.mario.auth.api.v1;

import com.mario.auth.dto.ExceptionResponse;
import com.mario.auth.dto.SignupRequest;
import com.mario.auth.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthRestController {

    private final MemberService memberService;

    public AuthRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody @Valid SignupRequest signupRequest) {
        try {
            memberService.signup(signupRequest);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (IllegalArgumentException exception) {
            ExceptionResponse response = new ExceptionResponse(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
