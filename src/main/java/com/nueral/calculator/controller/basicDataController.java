package com.nueral.calculator.controller;

import com.nueral.calculator.service.AuthKey.AuthKeyService;
import com.nueral.calculator.service.CharacterService;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.friendship.GoodsService;
import com.nueral.calculator.service.needExp.NeedExpService;
import com.nueral.calculator.service.needExp.NeedGoodsExpService;
import com.nueral.calculator.service.needExp.NeedSkillExpService;
import com.nueral.calculator.service.needExp.NeedStarExpService;
import com.nueral.calculator.service.skill.SkillSaveService;
import com.nueral.calculator.types.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/admin")
public class basicDataController {
    @Autowired
    AlgorithmService algorithmService;
    @Autowired
    NeedExpService expService;
    @Autowired
    NeedStarExpService needStarExpService;
    @Autowired
    NeedGoodsExpService needGoodsExpService;
    @Autowired
    CharacterService characterService;
    @Autowired
    NeedSkillExpService needSkillExpService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AuthKeyService authKeyService;
    @Autowired
    SkillSaveService skillService;

    @GetMapping(value = "/baseSkills")
    public String createTestSkills(){
        skillService.saveAllSkills("수춘",SkillType.pas,"치유의 녹색","3회 일반공격마다 자신 연산력[1]%만큼 최대체력 상한을 높이며"+
                "그만큼 체력을 회복한다. 최대 10회 발동."+
                        "추가 체력 30마다 수춘의 연산방어력이 1 상승한다.","");
        skillService.saveAllSkills("수춘",SkillType.act,"푸른 매듭","덩굴을 소환해 자신 주위 1칸 안의 적을 휘감아 3초간 무장해제 시킨다."+
                "휘감긴 유닛은 0.6초 마다 연산력 [1]% 연산피해를 받으며,"+
                "동시에 수준은 '연산력 0.5% X 휘감긴 적의 수량'의 체력을 회복한다.","무장해제 - 일반공격과 스킬발동을 도중에 끊고,"+
                "지속 시간동안 일반 공격과 스킬 발동이 불가능하다.");
        skillService.saveAllSkills("수춘",SkillType.ult,"가시덩굴 감옥","지정 범위 안의 적을 띄우고, 치명타가 가능한 연산력 [1]% 연산피해를 준다."+
                "그리고 가시덩굴을 남겨서 지나가는 적을 고정시킨다. 가시덩굴 지속시간 [2]초","");

        return "/home";
    }


    @GetMapping(value = "/baseCharacter")
    public void createBaseCharacter() {
        characterService.save("수춘", DealType.ap, RoleType.depender, AreaType.target, CompanyType.lab, 1);
        characterService.save("이블린", DealType.ap, RoleType.depender, AreaType.target, CompanyType.sva, 5);
        characterService.save("크로크", DealType.ap, RoleType.depender, AreaType.target, CompanyType.sva, 5);
        characterService.save("보니", DealType.ap, RoleType.depender, AreaType.target, CompanyType.ucl, 1);
        characterService.save("야니", DealType.ap, RoleType.depender, AreaType.target, CompanyType.lab, 1);
        characterService.save("시온", DealType.ap, RoleType.depender, AreaType.target, CompanyType.sva, 3);
        characterService.save("쿠로", DealType.ap, RoleType.gunner, AreaType.target, CompanyType.cma, 5);
        characterService.save("허블", DealType.ap, RoleType.gunner, AreaType.area, CompanyType.lab, 5);
        characterService.save("람", DealType.ad, RoleType.gunner, AreaType.target, CompanyType.uas, 1);
        characterService.save("옥토겐", DealType.ap, RoleType.gunner, AreaType.target, CompanyType.sva, 3);
        characterService.save("에어하트", DealType.ap, RoleType.gunner, AreaType.target, CompanyType.sva, 3);
        characterService.save("맥스", DealType.ap, RoleType.gunner, AreaType.area, CompanyType.lab, 1);
        characterService.save("전지", DealType.ad, RoleType.gunner, AreaType.area, CompanyType.cma, 5);
        characterService.save("시모", DealType.ad, RoleType.gunner, AreaType.target, CompanyType.sva, 1);
        characterService.save("프레넬", DealType.al, RoleType.gunner, AreaType.target, CompanyType.lab, 3);
        characterService.save("아키", DealType.ad, RoleType.soldier, AreaType.target, CompanyType.uas, 5);
        characterService.save("베티", DealType.ad, RoleType.soldier, AreaType.target, CompanyType.uas, 3);
        characterService.save("센타우레이시", DealType.ad, RoleType.soldier, AreaType.target, CompanyType.uas, 5);
        characterService.save("브이", DealType.al, RoleType.soldier, AreaType.target, CompanyType.ucl, 5);
        characterService.save("첼시", DealType.ad, RoleType.soldier, AreaType.target, CompanyType.sva, 1);
        characterService.save("솔", DealType.ap, RoleType.soldier, AreaType.target, CompanyType.lab, 3);
        characterService.save("펜", DealType.ap, RoleType.soldier, AreaType.target, CompanyType.lab, 3);
        characterService.save("뱅크시", DealType.ad, RoleType.specialist, AreaType.target, CompanyType.cma, 5);
        characterService.save("사쿠야", DealType.ad, RoleType.specialist, AreaType.target, CompanyType.uas, 3);
        characterService.save("리세", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.ucl, 3);
        characterService.save("윌로우", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.cma, 5);
        characterService.save("안젤라", DealType.al, RoleType.specialist, AreaType.target, CompanyType.uas, 3);
        characterService.save("마이", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.lab, 1);
        characterService.save("그루브", DealType.al, RoleType.specialist, AreaType.target, CompanyType.cma, 1);
        characterService.save("안토니나", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.lab, 3);
        characterService.save("아비게일", DealType.al, RoleType.specialist, AreaType.target, CompanyType.sva, 1);
        characterService.save("드셰브니", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.uas, 3);
        characterService.save("크세니아", DealType.ap, RoleType.specialist, AreaType.target, CompanyType.uas, 3);
        characterService.save("나나카", DealType.ap, RoleType.healer, AreaType.area, CompanyType.cma, 5);
        characterService.save("플로렌스", DealType.ap, RoleType.healer, AreaType.target, CompanyType.ucl, 5);
        characterService.save("진", DealType.ap, RoleType.healer, AreaType.target, CompanyType.uas, 5);
        characterService.save("제시", DealType.ap, RoleType.healer, AreaType.target, CompanyType.uas, 1);
        characterService.save("페르시카", DealType.ap, RoleType.healer, AreaType.target, CompanyType.lab, 3);
        characterService.save("파나케이아", DealType.ap, RoleType.healer, AreaType.target, CompanyType.ucl, 3);
        characterService.save("초코", DealType.ap, RoleType.healer, AreaType.target, CompanyType.uas, 1);
        characterService.save("임호텝", DealType.ap, RoleType.healer, AreaType.target, CompanyType.ucl, 3);
    }
    @GetMapping(value = "/baseTest")
    public String createBaseTest(){
        characterService.save("전지", DealType.ad, RoleType.gunner, AreaType.area, CompanyType.cma, 5);

        goodsService.GoodsStatusCharacter("전지","출력강화",1);
        goodsService.GoodsStatusCharacter("전지","코어가속",2);
        goodsService.GoodsStatusCharacter("전지","진형강화",3);

        goodsService.saveGoodsCharacter("전지","곰돌이 인형",1);
        goodsService.saveGoodsCharacter("전지","카툰 인형",1);
        goodsService.saveGoodsCharacter("전지","찐빵",1);

        skillService.saveAllSkills("전지",SkillType.pas,"금상첨화","'일반공격이 대상에게 '꽃자수'를 부여한다."+
                "'꽃자수': 표식이 터질 때 공격력의 [1]% X 스택 수 의 물리피해를 준다.","");
        skillService.saveAllSkills("전지",SkillType.act,"화룡첨봉","'꽃무리' 상태가 된다. 지속 6초"+
                "이 상태에서 일반공격은 3갈래 관통 공격이 되어, 경로상의 적에게"+
                        "공격력 [1]% 물리피해를 준다. 스킬 종료 시 모든 '꽃자수' 표식을 터트린다.","");
        skillService.saveAllSkills("전지",SkillType.ult,"건곤일침","'지정 방향으로 바늘을 던져, 범위 안에 적에게 총합 공격력 [1]% 물리피해를 준다."+
                "'꽃무리' 상태에서 사용한 경우, '꽃무리' 지속시간이 4초 연장된다.","");

        skillService.saveSkillLevels(1,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(2,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(3,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(4,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(5,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(6,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(7,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(8,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(9,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(10,"전지","금상첨화",0,0,0,0);
        skillService.saveSkillLevels(1,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(2,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(3,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(4,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(5,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(6,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(7,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(8,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(9,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(10,"전지","화룡첨봉",0,0,0,0);
        skillService.saveSkillLevels(1,"전지","건곤일침",0,0,0,0);
        skillService.saveSkillLevels(2,"전지","건곤일침",0,0,0,0);
        skillService.saveSkillLevels(3,"전지","건곤일침",0,0,0,0);
        skillService.saveSkillLevels(4,"전지","건곤일침",0,0,0,0);
        skillService.saveSkillLevels(5,"전지","건곤일침",0,0,0,0);

        algorithmService.saveAlgorithm("전지",AlgorithmType.atk,"이질 회귀","공격력 퍼센트","피해량 증가","공격력 퍼센트");
        algorithmService.saveAlgorithm("전지",AlgorithmType.def,"코드압축","체력 퍼센트","공격력","치명타 확률");
        algorithmService.saveAlgorithm("전지",AlgorithmType.spc,"무중력 가속","치명타 확률","치명타 확률","치명타 피해");
        return "/home";
    }
    @GetMapping(value = "/baseData")
    public String createBaseExp(){

        needStarExpService.saveStarExp(1,0);
        needStarExpService.saveStarExp(2,5);
        needStarExpService.saveStarExp(3,10);
        needStarExpService.saveStarExp(4,25);
        needStarExpService.saveStarExp(5,40);
        needStarExpService.saveStarExp(6,60);
        needStarExpService.saveStarExp(7,70);
        needStarExpService.saveStarExp(8,90);
        needStarExpService.saveStarExp(9,100);

        needGoodsExpService.saveGoodsExp(1,0);
        needGoodsExpService.saveGoodsExp(2,30);
        needGoodsExpService.saveGoodsExp(3,100);
        needGoodsExpService.saveGoodsExp(4,180);
        needGoodsExpService.saveGoodsExp(5,290);
        needGoodsExpService.saveGoodsExp(6,350);
        needGoodsExpService.saveGoodsExp(7,470);
        needGoodsExpService.saveGoodsExp(8,590);
        needGoodsExpService.saveGoodsExp(9,700);
        needGoodsExpService.saveGoodsExp(10,1060);
        needGoodsExpService.saveGoodsExp(11,1250);
        needGoodsExpService.saveGoodsExp(12,1650);
        needGoodsExpService.saveGoodsExp(13,2000);
        needGoodsExpService.saveGoodsExp(14,2300);
        needGoodsExpService.saveGoodsExp(15,2600);

        needSkillExpService.saveSkillExp(1,0,0);
        needSkillExpService.saveSkillExp(2,100,0);
        needSkillExpService.saveSkillExp(3,200,0);
        needSkillExpService.saveSkillExp(4,360,0);
        needSkillExpService.saveSkillExp(5,560,0);
        needSkillExpService.saveSkillExp(6,880,0);
        needSkillExpService.saveSkillExp(7,1320,0);
        needSkillExpService.saveSkillExp(8,1920,4);
        needSkillExpService.saveSkillExp(9,2680,8);
        needSkillExpService.saveSkillExp(10,3600,12);

        expService.saveExp(0,1,0,0,0,0,0,0);
        expService.saveExp(90,2,0,0,0,0,0,0);
        expService.saveExp(140,3,0,0,0,0,0,0);
        expService.saveExp(190,4,0,0,0,0,0,0);
        expService.saveExp(240,5,0,0,0,0,0,0);
        expService.saveExp(290,6,0,0,0,0,0,0);
        expService.saveExp(430,7,0,0,0,0,0,0);
        expService.saveExp(390,8,0,0,0,0,0,0);
        expService.saveExp(440,9,0,0,0,0,0,0);
        expService.saveExp(490,10,0,0,0,0,0,0);
        expService.saveExp(540,11,10,0,0,0,0,0);
        expService.saveExp(580,12,0,0,0,0,0,0);
        expService.saveExp(620,13,0,0,0,0,0,0);
        expService.saveExp(660,14,0,0,0,0,0,0);
        expService.saveExp(700,15,0,0,0,0,0,0);
        expService.saveExp(740,16,0,0,0,0,0,0);
        expService.saveExp(780,17,0,0,0,0,0,0);
        expService.saveExp(820,18,0,0,0,0,0,0);
        expService.saveExp(860,19,0,0,0,0,0,0);
        expService.saveExp(900,20,0,0,0,0,0,0);
        expService.saveExp(940,21,10,15,0,0,0,0);
        expService.saveExp(980,22,0,0,0,0,0,0);
        expService.saveExp(1000,23,0,0,0,0,0,0);
        expService.saveExp(1050,24,0,0,0,0,0,0);
        expService.saveExp(1100,25,0,0,0,0,0,0);
        expService.saveExp(1300,26,0,0,0,0,0,0);
        expService.saveExp(1410,27,0,0,0,0,0,0);
        expService.saveExp(1540,28,0,0,0,0,0,0);
        expService.saveExp(1930,29,0,0,0,0,0,0);
        expService.saveExp(2190,30,0,0,0,0,0,0);
        expService.saveExp(2450,31,0,15,20,0,0,0);
        expService.saveExp(2450,32,0,0,0,0,0,0);
        expService.saveExp(2580,33,0,0,0,0,0,0);
        expService.saveExp(2830,34,0,0,0,0,0,0);
        expService.saveExp(2960,35,0,0,0,0,0,0);
        expService.saveExp(3090,36,0,0,0,0,0,0);
        expService.saveExp(3220,37,0,0,0,0,0,0);
        expService.saveExp(3480,38,0,0,0,0,0,0);
        expService.saveExp(3610,39,0,0,0,0,0,0);
        expService.saveExp(3740,40,0,0,0,0,0,0);
        expService.saveExp(3990,41,0,0,15,25,0,0);
        expService.saveExp(4250,42,0,0,0,0,0,0);
        expService.saveExp(4510,43,0,0,0,0,0,0);
        expService.saveExp(4770,44,0,0,0,0,0,0);
        expService.saveExp(4900,45,0,0,0,0,0,0);
        expService.saveExp(5800,46,0,0,0,0,0,0);
        expService.saveExp(6190,47,0,0,0,0,0,0);
        expService.saveExp(6320,48,0,0,0,0,0,0);
        expService.saveExp(6700,49,0,0,0,0,0,0);
        expService.saveExp(6960,50,0,0,0,0,0,0);
        expService.saveExp(7090,51,0,0,0,20,30,0);
        expService.saveExp(7700,52,0,0,0,0,0,0);
        expService.saveExp(8500,53,0,0,0,0,0,0);
        expService.saveExp(9100,54,0,0,0,0,0,0);
        expService.saveExp(10400,55,0,0,0,0,0,0);
        expService.saveExp(11000,56,0,0,0,0,0,0);
        expService.saveExp(11800,57,0,0,0,0,0,0);
        expService.saveExp(12500,58,0,0,0,0,0,0);
        expService.saveExp(13400,59,0,0,0,0,0,0);
        expService.saveExp(14000,60,0,0,0,0,0,0);

        algorithmService.saveSubAlgorithm(AlgorithmType.all, "공격력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "연산력");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk, "공격력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk, "연산력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "연산 관통");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "공격 관통");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "치명타 확률");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "치명타 피해");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "체력");
        algorithmService.saveSubAlgorithm(AlgorithmType.def, "체력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "방어력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "방어력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "연산방어력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "연산방어력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "전투 후 체력회복");
        algorithmService.saveSubAlgorithm(AlgorithmType.all, "효과 저항");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk, "피해량 증가");
        algorithmService.saveSubAlgorithm(AlgorithmType.def, "피해량 감소");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc, "충전속도");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc, "치료 효과");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc, "회피");

        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "공격력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "공격력");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "연산력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "연산력");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "물리관통");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "물리관통 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "연산관통");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk, "연산관통 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.all, "효과 저항");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "체력");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "체력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "방어력");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "방어력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "연산저항");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "연산저항 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def, "전투 후 회복");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "치명타 확률");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "치명타 피해");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "재사용 대기시간 감소");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "치료 효과");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "연산방어력");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc, "연산방어력 퍼센트");

        algorithmService.saveSetAlgorithm("추적 연산", AlgorithmType.atk, "미실장", "미실장");
        algorithmService.saveSetAlgorithm("예측", AlgorithmType.atk, "기초 공격력 +15%", "");
        algorithmService.saveSetAlgorithm("최소 역치", AlgorithmType.atk, "체력 흡수 +10%", "체력 15% 미만시 10초간 공격속도 +50, 공격력 +10%, 피해 차감 +30%");
        algorithmService.saveSetAlgorithm("초과반응", AlgorithmType.atk, "미실장", "미실장");
        algorithmService.saveSetAlgorithm("점진", AlgorithmType.atk, "기초 연산력 +15%", "");
        algorithmService.saveSetAlgorithm("추론", AlgorithmType.atk, "공격속도 +30", "");
        algorithmService.saveSetAlgorithm("데이터 복원", AlgorithmType.atk, "효과 저항 +50", "적에게 입힌 피해량의 10% 흡수 회복");
        algorithmService.saveSetAlgorithm("이질 회귀", AlgorithmType.atk, "주는 피해량 +5%", "적 퇴치시 해당 맵에서 상대의 공격력, 연산력, 체력 상한 12%를 빼앗아 회복");
        algorithmService.saveSetAlgorithm("감지", AlgorithmType.def, "기초 체력 +15%", "");
        algorithmService.saveSetAlgorithm("머신 러닝", AlgorithmType.def, "피해 반사 +5%", "전투 종료 시 살아있으면 체력 15% 회복");
        algorithmService.saveSetAlgorithm("코드압축", AlgorithmType.def, "피해 차감 +5%", "체력 이 가장 낮은 아군 피해량의 30%를 대신 받는다.");
        algorithmService.saveSetAlgorithm("이성", AlgorithmType.def, "기초 방어력 +15%", "");
        algorithmService.saveSetAlgorithm("오버플로우", AlgorithmType.def, "5초당 체력 회복 +2%", "전투 시작 시 물리 방어력의 500% 보호막을 자신에게 생성");
        algorithmService.saveSetAlgorithm("연결", AlgorithmType.def, "효과 저항 +50", "");
        algorithmService.saveSetAlgorithm("열적반사", AlgorithmType.def, "미실장", "미실장");
        algorithmService.saveSetAlgorithm("빈사저항", AlgorithmType.def, "미실장", "미실장");
        algorithmService.saveSetAlgorithm("계몽", AlgorithmType.spc, "5초당 체력 회복 +2%", "");
        algorithmService.saveSetAlgorithm("서포트 벡터", AlgorithmType.spc, "치료 효과 +7.5%", "치료 효과 +10%, 치료 대상의 체력이 45% 미만일 경우 치료효과 + 30%");
        algorithmService.saveSetAlgorithm("순방향 피드백", AlgorithmType.spc, "치료 효과 +7.5%", "아군 치료시 4초간 대상의 치료량 +20%");
        algorithmService.saveSetAlgorithm("합성곱", AlgorithmType.spc, "치명타 피해 +20%", "");
        algorithmService.saveSetAlgorithm("무중력 가속", AlgorithmType.spc, "충전 속도 +10%", "평타 3회마다 스킬 충전략 +1초");
        algorithmService.saveSetAlgorithm("행렬 구조", AlgorithmType.spc, "공격 속도 +30", "치명타 4회마다 적에게 현재 체력 8%만큼의 고정 피해를 준다. 단 연산력의 2배를 넘지 않음");
        algorithmService.saveSetAlgorithm("취약점 확산", AlgorithmType.spc, "미실장", "미실장");
        algorithmService.saveSetAlgorithm("게임론", AlgorithmType.spc, "회피 +8%", "");
        algorithmService.saveSetAlgorithm("집속", AlgorithmType.spc, "치명률 +10%", "");

        goodsService.saveGoodsStatus("출력강화", "공격력 [] 상승");
        goodsService.saveGoodsStatus("코어가속", "충전속도 []% 상승");
        goodsService.saveGoodsStatus("진형강화", "모든 피해량[]% 상승");
        goodsService.saveGoodsStatus("멘탈활성", "연상력 [] 상승");
        goodsService.saveGoodsStatus("코드안정", "체력 [] 상승");
        goodsService.saveGoodsStatus("협력강타", "치명률 []% 상승");
        goodsService.saveGoodsStatus("필승격려", "치명타 피해 []% 상승");
        goodsService.saveGoodsStatus("우정방패", "방어력 [] 상승");
        goodsService.saveGoodsStatus("어깨동무", "피해차감 []% 상승");
        goodsService.saveGoodsStatus("치유연대", "치유량 []% 상승");
        goodsService.saveGoodsStatus("상호엄호", "회피율 []% 상승");

        goodsService.saveGoodsStatusLevel("출력강화", 1, 7);
        goodsService.saveGoodsStatusLevel("출력강화", 2, 16);
        goodsService.saveGoodsStatusLevel("출력강화", 3, 27);
        goodsService.saveGoodsStatusLevel("출력강화", 4, 40);
        goodsService.saveGoodsStatusLevel("출력강화", 5, 55);
        goodsService.saveGoodsStatusLevel("코어가속", 1, 1);
        goodsService.saveGoodsStatusLevel("코어가속", 2, 2.5);
        goodsService.saveGoodsStatusLevel("코어가속", 3, 4);
        goodsService.saveGoodsStatusLevel("코어가속", 4, 6);
        goodsService.saveGoodsStatusLevel("코어가속", 5, 8);
        goodsService.saveGoodsStatusLevel("진형강화", 1, 0.5);
        goodsService.saveGoodsStatusLevel("진형강화", 2, 1);
        goodsService.saveGoodsStatusLevel("진형강화", 3, 2);
        goodsService.saveGoodsStatusLevel("진형강화", 4, 3.5);
        goodsService.saveGoodsStatusLevel("진형강화", 5, 5);
        goodsService.saveGoodsStatusLevel("멘탈활성", 1, 7);
        goodsService.saveGoodsStatusLevel("멘탈활성", 2, 16);
        goodsService.saveGoodsStatusLevel("멘탈활성", 3, 27);
        goodsService.saveGoodsStatusLevel("멘탈활성", 4, 40);
        goodsService.saveGoodsStatusLevel("멘탈활성", 5, 55);
        goodsService.saveGoodsStatusLevel("코드안정", 1, 170);
        goodsService.saveGoodsStatusLevel("코드안정", 2, 380);
        goodsService.saveGoodsStatusLevel("코드안정", 3, 650);
        goodsService.saveGoodsStatusLevel("코드안정", 4, 960);
        goodsService.saveGoodsStatusLevel("코드안정", 5, 1320);
        goodsService.saveGoodsStatusLevel("협력강타", 1, 1);
        goodsService.saveGoodsStatusLevel("협력강타", 2, 2.5);
        goodsService.saveGoodsStatusLevel("협력강타", 3, 4);
        goodsService.saveGoodsStatusLevel("협력강타", 4, 6);
        goodsService.saveGoodsStatusLevel("협력강타", 5, 8);
        goodsService.saveGoodsStatusLevel("필승격려", 1, 1.5);
        goodsService.saveGoodsStatusLevel("필승격려", 2, 3.5);
        goodsService.saveGoodsStatusLevel("필승격려", 3, 6);
        goodsService.saveGoodsStatusLevel("필승격려", 4, 8.5);
        goodsService.saveGoodsStatusLevel("필승격려", 5, 12);
        goodsService.saveGoodsStatusLevel("우정방패", 1, 7);
        goodsService.saveGoodsStatusLevel("우정방패", 2, 16);
        goodsService.saveGoodsStatusLevel("우정방패", 3, 27);
        goodsService.saveGoodsStatusLevel("우정방패", 4, 40);
        goodsService.saveGoodsStatusLevel("우정방패", 5, 55);
        goodsService.saveGoodsStatusLevel("어깨동무", 1, 0.5);
        goodsService.saveGoodsStatusLevel("어깨동무", 2, 1);
        goodsService.saveGoodsStatusLevel("어깨동무", 3, 2);
        goodsService.saveGoodsStatusLevel("어깨동무", 4, 3.5);
        goodsService.saveGoodsStatusLevel("어깨동무", 5, 5);
        goodsService.saveGoodsStatusLevel("치유연대", 1, 0.5);
        goodsService.saveGoodsStatusLevel("치유연대", 2, 1);
        goodsService.saveGoodsStatusLevel("치유연대", 3, 2);
        goodsService.saveGoodsStatusLevel("치유연대", 4, 3.5);
        goodsService.saveGoodsStatusLevel("치유연대", 5, 5);
        goodsService.saveGoodsStatusLevel("상호엄호", 1, 1);
        goodsService.saveGoodsStatusLevel("상호엄호", 2, 2.5);
        goodsService.saveGoodsStatusLevel("상호엄호", 3, 4);
        goodsService.saveGoodsStatusLevel("상호엄호", 4, 6);
        goodsService.saveGoodsStatusLevel("상호엄호", 5, 8);

        goodsService.saveAllGoods("찐빵", 1, 20, 12, 16);
        goodsService.saveAllGoods("패스트푸드", 1, 20, 12, 16);
        goodsService.saveAllGoods("케익 조각", 1, 20, 12, 16);
        goodsService.saveAllGoods("벌꿀", 1, 20, 12, 16);
        goodsService.saveAllGoods("오뎅", 1, 20, 12, 16);
        goodsService.saveAllGoods("봉제 열쇠고리", 1, 20, 12, 16);
        goodsService.saveAllGoods("디지털 블럭", 1, 20, 12, 16);
        goodsService.saveAllGoods("연습용 죽도", 1, 20, 12, 16);
        goodsService.saveAllGoods("찐빵 찜통", 2, 50, 30, 40);
        goodsService.saveAllGoods("직장인 세트", 2, 50, 30, 40);
        goodsService.saveAllGoods("신호등 케익", 2, 50, 30, 40);
        goodsService.saveAllGoods("초콜릿 선디", 2, 50, 30, 40);
        goodsService.saveAllGoods("딸기 케익", 2, 50, 30, 40);
        goodsService.saveAllGoods("카툰 인형", 2, 50, 30, 40);
        goodsService.saveAllGoods("보틀셔틀", 2, 50, 30, 40);
        goodsService.saveAllGoods("컴뱃 나이프", 2, 50, 30, 40);
        goodsService.saveAllGoods("찐빵 한박스", 3, 125, 100, 75);
        goodsService.saveAllGoods("커플 세트", 3, 125, 100, 75);
        goodsService.saveAllGoods("디럭스 케익", 3, 125, 100, 75);
        goodsService.saveAllGoods("커피", 3, 125, 100, 75);
        goodsService.saveAllGoods("티타임 세트", 3, 125, 100, 75);
        goodsService.saveAllGoods("곰돌이 인형", 3, 125, 100, 75);
        goodsService.saveAllGoods("프라모델", 3, 125, 100, 75);
        goodsService.saveAllGoods("소장용 명검", 3, 125, 100, 75);

        return "/home";
    }

}
