package com.study.design.pattern.templatemethod.service;

public abstract class AbstractLogin {

    protected abstract boolean checkUserExist(String email);

    protected abstract boolean authentication(String email, String password);

    public boolean login(String email, String password) {
        if (!checkUserExist(email)) {
            return false;
        }

        return authentication(email, password);
    }
}
