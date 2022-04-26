package ru.dobro.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER;

    @Override
    public String getAuthority() {
        return name();   // это будет строковое представление наименование роли
    }
}
