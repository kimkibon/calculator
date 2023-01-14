package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {

    gunner("사수"),
    healer("치료사"),
    soldier("전사"),
    depender("수위"),
    specialist("해결사");

    private final String type;

    public String getType() {
        return type;
    }

}
