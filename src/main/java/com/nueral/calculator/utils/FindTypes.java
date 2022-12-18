package com.nueral.calculator.utils;

import com.nueral.calculator.types.*;

public class FindTypes {
    public AlgorithmType findAlgorithmType(String Type){
        AlgorithmType algorithmType = null;
        switch (Type) {
            case "atk": algorithmType = AlgorithmType.atk;
            break;
            case "def": algorithmType = AlgorithmType.def;
            break;
            case "spc": algorithmType = AlgorithmType.spc;
            break;
            case "all": algorithmType = AlgorithmType.all;
        }
        return algorithmType;
    }

    public AreaType findAreaType(String Type){
        AreaType areaType = null;
        switch (Type){
            case "area": areaType = AreaType.area;
            break;
            case "target": areaType = AreaType.target;
        }
        return areaType;
    }
    public CompanyType findCompanyType(String Type){
        CompanyType companyType = null;

        switch(Type) {
            case "cma": companyType = CompanyType.cma;
                break;
            case "sva": companyType = CompanyType.sva;
                break;
            case "lab": companyType = CompanyType.lab;
                break;
            case "uas": companyType = CompanyType.uas;
                break;
            case "ucl": companyType = CompanyType.ucl;
                break;
        }
        return companyType;
    }
    public DealType findDealType(String Type){
        DealType dealType = null;
        switch (Type){
            case "al": dealType = DealType.al;
            break;
            case "ad": dealType = DealType.ad;
            break;
            case "ap": dealType = DealType.ap;
        }
        return dealType;
    }

    public RoleType findRoleType(String Type){
        RoleType roleType = null;
        switch (Type){
            case "gunner": roleType = RoleType.gunner;
                break;
            case "soldier": roleType = RoleType.soldier;
                break;
            case "healer": roleType = RoleType.healer;
                break;
            case "specialist": roleType = RoleType.specialist;
                break;
            case "defender": roleType = RoleType.depender;
                break;
        }
        return roleType;
    }

    public SkillType findSkillType(String Type){
        SkillType skillType = null;
        switch (Type){
            case "pas": skillType = SkillType.pas;
                break;
            case "act": skillType = SkillType.act;
                break;
            case "ult": skillType = SkillType.ult;
        }
        return skillType;
    }



}
