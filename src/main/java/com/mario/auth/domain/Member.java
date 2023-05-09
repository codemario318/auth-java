package com.mario.auth.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    public Member() {}

    public Member(String name, String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
