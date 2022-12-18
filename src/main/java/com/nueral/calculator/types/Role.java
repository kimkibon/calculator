package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
@Getter
public enum Role implements GrantedAuthority {
    ADMIN("ADMIN" , "관리자"),
    USER("USER" , "유저");

    private final String Authority;
    private final String description;
    @Override
    public String getAuthority() {
        return Authority;
    }

    public String getDescription() {
        return description;
    }
}
