package com.study.design.pattern.common.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username;
    private String phoneNumber;
    private String grade;

    @Builder
    public User(Long id, String username, String phoneNumber, String grade) {
        this.id = id;
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.grade = grade;
    }
}
