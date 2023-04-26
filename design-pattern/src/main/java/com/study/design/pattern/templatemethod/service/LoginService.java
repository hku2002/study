package com.study.design.pattern.templatemethod.service;

import com.study.design.pattern.common.domain.User;
import com.study.design.pattern.common.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService extends AbstractLogin {

    private final UserRepository userRepository;
    @Override
    protected boolean checkUserExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    protected boolean authentication(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) return false;
        return user.get().getPassword().equals(password);
    }

}
