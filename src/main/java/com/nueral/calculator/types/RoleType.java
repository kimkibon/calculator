package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    depender("수위"),
    gunner("사수"),
    soldier("전사"),
    healer("치료사"),
    specialist("해결사");
    private final String type;
    public String getType() {
        return type;
    }

}
