package com.nueral.calculator.utils;

import com.nueral.calculator.types.*;

import java.util.ArrayList;
import java.util.List;

public class GetTypes {
    public List<String> getAlgorithmType(){
        List<String> types = new ArrayList<>();
        types.add(AlgorithmType.all.getType());
        types.add(AlgorithmType.atk.getType());
        types.add(AlgorithmType.def.getType());
        types.add(AlgorithmType.spc.getType());
        return types;
    }
    public List<String> getAreaTypes(){
        List<String> types = new ArrayList<>();
        types.add(AreaType.area.getType());
        types.add(AreaType.target.getType());
        return types;
    }
    public List<String> getCompanyTypes(){
        List<String> types = new ArrayList<>();
        types.add(CompanyType.cma.getEnglish());
        types.add(CompanyType.sva.getEnglish());
        types.add(CompanyType.lab.getEnglish());
        types.add(CompanyType.uas.getEnglish());
        types.add(CompanyType.ucl.getEnglish());
        return types;
    }
    public List<String> getDealTypes(){
        List<String> types = new ArrayList<>();
        types.add(DealType.ad.getType());
        types.add(DealType.ap.getType());
        types.add(DealType.al.getType());
        return types;
    }
    public List<String> getRoleTypes(){
        List<String> types = new ArrayList<>();
        types.add(RoleType.depender.getType());
        types.add(RoleType.healer.getType());
        types.add(RoleType.soldier.getType());
        types.add(RoleType.healer.getType());
        types.add(RoleType.specialist.getType());
        return types;
    }
    public List<String> getSkillTypes(){
        List<String> types = new ArrayList<>();
        types.add(SkillType.pas.getType());
        types.add(SkillType.act.getType());
        types.add(SkillType.ult.getType());
        return types;
    }
}
