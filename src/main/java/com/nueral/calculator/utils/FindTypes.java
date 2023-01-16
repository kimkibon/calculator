package com.nueral.calculator.utils;

import com.nueral.calculator.types.*;
import org.springframework.stereotype.Component;

@Component
public class FindTypes {
    public AlgorithmType findAlgorithmTypeByName(String name){
        switch (name){
            case "공격성": return AlgorithmType.atk;
            case "안정성": return AlgorithmType.def;
            case "특이성": return AlgorithmType.spc;
            case "올타입": return AlgorithmType.all;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }


    public AreaType findAreaTypeByName(String name){
        switch (name){
            case "범위": return AreaType.area;
            case "단일": return AreaType.target;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }

    public CompanyType findCompanyTypeByName(String name){
        switch (name){
            case "CYBER MEDIA": return CompanyType.cma;
            case "SVAROG": return CompanyType.sva;
            case "42LAB": return CompanyType.lab;
            case "UNIVERSAL ANYTHING SERVICE": return CompanyType.uas;
            case "ULTIMATE COMPANY LIMITED": return CompanyType.ucl;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }

    public DealType findDealTypeByName(String name){
        switch (name){
            case "연산": return DealType.ap;
            case "물리": return DealType.ad;
            case "복합": return DealType.al;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }

    public RoleType findRoleTypeByName(String name){
        switch (name){
            case "사수": return RoleType.gunner;
            case "치료사": return RoleType.healer;
            case "전사": return RoleType.soldier;
            case "수위": return RoleType.depender;
            case "해결사": return RoleType.specialist;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }

    public SkillType findSkillTypeByName(String name){
        switch (name){
            case "패시브": return SkillType.pas;
            case "액티브": return SkillType.act;
            case "궁극기": return SkillType.ult;
            default: throw new IllegalStateException("Unexpected value: "+name);
        }
    }
}
