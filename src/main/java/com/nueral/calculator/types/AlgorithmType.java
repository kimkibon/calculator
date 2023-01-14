package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlgorithmType {

    atk("공격성"),
    def("안정성"),
    spc("특이성"),
    all("올타입");

    private final String type;

    public String getType() {
        return type;
    }

}
