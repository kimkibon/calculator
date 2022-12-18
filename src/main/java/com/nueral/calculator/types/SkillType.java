package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum SkillType {
    pas("패시브 스킬"),
    act("액티브 스킬"),
    ult("궁극기");

    private final String type;

    public String getType() {
        return type;
    }


}
