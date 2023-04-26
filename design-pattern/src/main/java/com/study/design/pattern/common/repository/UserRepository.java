package com.study.design.pattern.common.repository;

import com.study.design.pattern.common.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
