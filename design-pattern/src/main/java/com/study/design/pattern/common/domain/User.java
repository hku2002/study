package com.study.design.pattern.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "USERS", uniqueConstraints =
@UniqueConstraint(name = "uni_email", columnNames = { "email" }))
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String email;

    private String password;
    private String username;
    private String phoneNumber;
    private String grade;

    @Builder
    public User(Long id, String email, String password, String username, String phoneNumber, String grade) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
    }
}
