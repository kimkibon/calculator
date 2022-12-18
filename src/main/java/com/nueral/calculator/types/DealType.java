package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DealType {

    ad("물리"),
    ap("연산"),
    al("복합");

   private final String type;

    public String getType() {
        return type;
    }
}
