package com.nueral.calculator.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CompanyType {

    cma("사이버 미디어" , "CYBER MEDIA"),
    sva("스바로그", "SVAROG"),
    lab("42랩", "42LAB"),
    uas("유니버셜 애니띵 서비스","UNIVERSAL ANYTHING SERVICE"),
    ucl("얼티라이프 컴퍼니 리미티드","ULTIMATE COMPANY LIMITED");

    private final String korean;
    private final String english;

    public String getKorean() {
        return korean;
    }
    public String getEnglish() {
        return english;
    }



}
