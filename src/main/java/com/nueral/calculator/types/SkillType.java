package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SkillType {
    pas("패시브"),
    act("액티브"),
    ult("궁극기");

    private final String type;

    public String getType() {
        return type;
    }


}
