package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public enum AreaType {

    area("범위"),
    target("단일");

    private final String type;

    public String getType() {
        return type;
    }


}
