package ru.dobro.beans;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, ADMIN;

    @Override
    public String getAuthority() {
        return name();   // это будет строковое представление наименование роли
    }
}
