package com.nueral.calculator.controller;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.dto.character.CharacterService;
import com.nueral.calculator.service.UserService;
import com.nueral.calculator.service.algorithm.AlgorithmService;
import com.nueral.calculator.service.friendship.GoodsService;
import com.nueral.calculator.service.needExp.NeedExpService;
import com.nueral.calculator.service.needExp.NeedGoodsExpService;
import com.nueral.calculator.service.needExp.NeedSkillExpService;
import com.nueral.calculator.service.needExp.NeedStarExpService;
import com.nueral.calculator.service.skill.SkillSaveService;
import com.nueral.calculator.types.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
class TestController {

    @BeforeEach
    void init() {
        openMocks(this);
    }
    @Autowired
    private CharacterService characterService;
    @Autowired
    private SkillSaveService skillSaveService;
    @Autowired
    private AlgorithmService algorithmService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private NeedExpService expService;
    @Autowired
    private NeedStarExpService needStarExpService;
    @Autowired
    private NeedSkillExpService needSkillExpService;
    @Autowired
    private NeedGoodsExpService needGoodsExpService;
    @Autowired
    private UserService userService;

    @Test
    public void saveTest(){
        characterService.save("수춘",DealType.ap,RoleType.depender,AreaType.target,CompanyType.lab,1);
        characterService.save("수춘",DealType.ap,RoleType.depender,AreaType.target,CompanyType.lab,5);
    }

    @Test
    public void saveAlgorithm(){
        algorithmService.saveAlgorithm("전지" , AlgorithmType.atk , "이질 회귀" , "공격력 퍼센트" , "피해량 증가 " , "공격력 퍼센트");
    }
    @Test
    public void saveSubAlgorithm(){
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"공격력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"연산력");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk,"공격력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk,"연산력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"연산 관통");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"공격 관통");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"치명타 확률");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"치명타 피해");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"체력");
        algorithmService.saveSubAlgorithm(AlgorithmType.def,"체력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"방어력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"방어력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"연산방어력");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"연산방어력 퍼센트");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"전투 후 체력회복");
        algorithmService.saveSubAlgorithm(AlgorithmType.all,"효과 저항");
        algorithmService.saveSubAlgorithm(AlgorithmType.atk,"피해량 증가");
        algorithmService.saveSubAlgorithm(AlgorithmType.def,"피해량 감소");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc,"충전속도");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc,"치료 효과");
        algorithmService.saveSubAlgorithm(AlgorithmType.spc,"회피");
    }

    @Test
    public void saveMainAlgorithm(){
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"공격력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"공격력");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"연산력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"연산력 ");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"물리관통");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"물리관통 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"연산관통 ");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"연산관통 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.atk,"효과 저항");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"체력");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"체력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"방어력");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"방어력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"연산저항");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"연산저항 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"전투 후 회복");
        algorithmService.saveMainAlgorithm(AlgorithmType.def,"효과 저항");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"치명타 확률");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"치명타 피해");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"재사용 대기시간 감소");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"치료 효과");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"방어력");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"방어력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"연산방어력");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"연산방어력 퍼센트");
        algorithmService.saveMainAlgorithm(AlgorithmType.spc,"효과저항");
    }
    @Test
    public void saveSetAlgorithm(){
        algorithmService.saveSetAlgorithm("추적 연산",AlgorithmType.atk,"미실장","미실장");
        algorithmService.saveSetAlgorithm("예측",AlgorithmType.atk,"기초 공격력 +15%","");
        algorithmService.saveSetAlgorithm("최소 역치",AlgorithmType.atk,"체력 흡수 +10%","체력 15% 미만시 10초간 공격속도 +50, 공격력 +10%, 피해 차감 +30%");
        algorithmService.saveSetAlgorithm("초과반응",AlgorithmType.atk,"미실장","미실장");
        algorithmService.saveSetAlgorithm("점진",AlgorithmType.atk,"기초 연산력 +15%","");
        algorithmService.saveSetAlgorithm("추론",AlgorithmType.atk,"공격속도 +30","");
        algorithmService.saveSetAlgorithm("데이터 복원",AlgorithmType.atk,"효과 저항 +50","적에게 입힌 피해량의 10% 흡수 회복");
        algorithmService.saveSetAlgorithm("이질 회귀",AlgorithmType.atk,"주는 피해량 +5%","적 퇴치시 해당 맵에서 상대의 공격력, 연산력, 체력 상한 12%를 빼앗아 회복");
        algorithmService.saveSetAlgorithm("감지",AlgorithmType.def,"기초 체력 +15%","");
        algorithmService.saveSetAlgorithm("머신 러닝",AlgorithmType.def,"피해 반사 +5%","전투 종료 시 살아있으면 체력 15% 회복");
        algorithmService.saveSetAlgorithm("코드압축",AlgorithmType.def,"피해 차감 +5%","체력 이 가장 낮은 아군 피해량의 30%를 대신 받는다.");
        algorithmService.saveSetAlgorithm("이성",AlgorithmType.def,"기초 방어력 +15%","");
        algorithmService.saveSetAlgorithm("오버플로우",AlgorithmType.def,"5초당 체력 회복 +2%","전투 시작 시 물리 방어력의 500% 보호막을 자신에게 생성");
        algorithmService.saveSetAlgorithm("연결",AlgorithmType.def,"효과 저항 +50","");
        algorithmService.saveSetAlgorithm("열적반사",AlgorithmType.def,"미실장","미실장");
        algorithmService.saveSetAlgorithm("빈사저항",AlgorithmType.def,"미실장","미실장");
        algorithmService.saveSetAlgorithm("계몽",AlgorithmType.spc,"5초당 체력 회복 +2%","");
        algorithmService.saveSetAlgorithm("서포트 벡터",AlgorithmType.spc,"치료 효과 +7.5%","치료 효과 +10%, 치료 대상의 체력이 45% 미만일 경우 치료효과 + 30%");
        algorithmService.saveSetAlgorithm("순방향 피드백",AlgorithmType.spc,"치료 효과 +7.5%","아군 치료시 4초간 대상의 치료량 +20%");
        algorithmService.saveSetAlgorithm("합성곱",AlgorithmType.spc,"치명타 피해 +20%","");
        algorithmService.saveSetAlgorithm("무중력 가속",AlgorithmType.spc,"충전 속도 +10%","평타 3회마다 스킬 충전략 +1초");
        algorithmService.saveSetAlgorithm("행렬 구조",AlgorithmType.spc,"공격 속도 +30","치명타 4회마다 적에게 현재 체력 8%만큼의 고정 피해를 준다. 단 연산력의 2배를 넘지 않음");
        algorithmService.saveSetAlgorithm("취약점 확산",AlgorithmType.spc,"미실장","미실장");
        algorithmService.saveSetAlgorithm("게임론",AlgorithmType.spc,"회피 +8%","");
        algorithmService.saveSetAlgorithm("집속",AlgorithmType.spc,"치명률 +10%","");
    }


    @Test
    public void saveAllSkills(){
        skillSaveService.saveAllSkills("수춘",SkillType.pas,"치유의 녹색","","");
        skillSaveService.saveAllSkills("수춘",SkillType.act,"푸른 매듭","","");
        skillSaveService.saveAllSkills("수춘",SkillType.ult,"가시덩굴 감옥","","");
        skillSaveService.saveAllSkills("이블린",SkillType.pas,"추진 전술","","밀어냄 - 대상의 행동을 중단하고 지정 방향으로 일정 거리 이동시킨다.");
        skillSaveService.saveAllSkills("이블린",SkillType.act,"진압대책","","기절 - 행동할 수 없다, 스킬 발동을 도중에 끊고 자동 스킬 충전이 멈춘다.");
        skillSaveService.saveAllSkills("이블린",SkillType.ult,"철통진형","","");
        skillSaveService.saveAllSkills("크로크",SkillType.pas,"강인불굴","","도발 - 대상이 도발 시전자를 강제로 공격하게 만든다, 도발된 기간 스킬을 발동할 수 없다, 제어 효과, 디버프");
        skillSaveService.saveAllSkills("크로크",SkillType.act,"이지스의 방패","","");
        skillSaveService.saveAllSkills("크로크",SkillType.ult,"기신포효","","중상 - 이동할 수 없다, 공격력과 연산력 -10%");
        skillSaveService.saveAllSkills("보니",SkillType.pas,"창백한 뼈방패","","");
        skillSaveService.saveAllSkills("보니",SkillType.act,"강식골갑","","");
        skillSaveService.saveAllSkills("보니",SkillType.ult,"골수 전송","","");
        skillSaveService.saveAllSkills("야니",SkillType.pas,"파도 휘감기","","");
        skillSaveService.saveAllSkills("야니",SkillType.act,"인스머스의 닻","","공격집중 - 모든 유닛이 이 상태의 유닛을 강제로 공격한다, 근거리 유닛은 자동으로 길을 찾아 공격하고, 상태 해제 시 모두 표적을 재설정한다.");
        skillSaveService.saveAllSkills("야니",SkillType.ult,"물거품 감옥","","");
        skillSaveService.saveAllSkills("시온",SkillType.pas,"카본 용해","","");
        skillSaveService.saveAllSkills("시온",SkillType.act,"동위원소 흡수","","");
        skillSaveService.saveAllSkills("시온",SkillType.ult,"피해 전담","","");
        skillSaveService.saveAllSkills("쿠로",SkillType.pas,"천성 어그로","","");
        skillSaveService.saveAllSkills("쿠로",SkillType.act,"댓글창 도배","","");
        skillSaveService.saveAllSkills("쿠로",SkillType.ult,"장작 투척","","");
        skillSaveService.saveAllSkills("허블",SkillType.pas,"행성정렬","","");
        skillSaveService.saveAllSkills("허블",SkillType.act,"천체추락","","");
        skillSaveService.saveAllSkills("허블",SkillType.ult,"초신성 붕괴","","기절 -  행동할 수 없다, 스킬 발동을 도중에 끊고 자동 충전 스킬이 멈춘다");
        skillSaveService.saveAllSkills("람",SkillType.pas,"풀러 버니어","","");
        skillSaveService.saveAllSkills("람",SkillType.act,"차징 버스타","","");
        skillSaveService.saveAllSkills("람",SkillType.ult,"백터드 블래스트","","");
        skillSaveService.saveAllSkills("옥토겐",SkillType.pas,"유황맛 전주","","");
        skillSaveService.saveAllSkills("옥토겐",SkillType.act,"블록버스터","","");
        skillSaveService.saveAllSkills("옥토겐",SkillType.ult,"성대한 피날레","","");
        skillSaveService.saveAllSkills("에어하트",SkillType.pas,"어벤저 로어","","");
        skillSaveService.saveAllSkills("에어하트",SkillType.act,"헬다이브","","");
        skillSaveService.saveAllSkills("에어하트",SkillType.ult,"넵툰 스트라이크","","");
        skillSaveService.saveAllSkills("맥스",SkillType.pas,"파지직 공격","","");
        skillSaveService.saveAllSkills("맥스",SkillType.act,"찌릿찌릿 볼","","");
        skillSaveService.saveAllSkills("맥스",SkillType.ult,"번쩍번쩍 필드","","");
        skillSaveService.saveAllSkills("전지",SkillType.pas,"금상첨화","","");
        skillSaveService.saveAllSkills("전지",SkillType.act,"화룡첨봉","","");
        skillSaveService.saveAllSkills("전지",SkillType.ult,"건곤일침","","");
        skillSaveService.saveAllSkills("시모",SkillType.pas,"유령의 발걸음","","은신 - 적의 공격 대상이 되지 않는다.");
        skillSaveService.saveAllSkills("시모",SkillType.act,"쇠뇌 연사","","");
        skillSaveService.saveAllSkills("시모",SkillType.ult,"침묵의 겨울","","");
        skillSaveService.saveAllSkills("프레넬",SkillType.pas,"미러 워프","","");
        skillSaveService.saveAllSkills("프레넬",SkillType.act,"펄스 레이저","","");
        skillSaveService.saveAllSkills("프레넬",SkillType.ult,"초임계 플레어","","");
        skillSaveService.saveAllSkills("아키",SkillType.pas,"비월일섬","","");
        skillSaveService.saveAllSkills("아키",SkillType.act,"무라사메 베기","","");
        skillSaveService.saveAllSkills("아키",SkillType.ult,"치도리가에시","","");
        skillSaveService.saveAllSkills("베티",SkillType.pas,"베티 돌돌 펀치","","");
        skillSaveService.saveAllSkills("베티",SkillType.act,"막나간다냥","","");
        skillSaveService.saveAllSkills("베티",SkillType.ult,"궁지 몰린 고양이","","");
        skillSaveService.saveAllSkills("센타우레이시",SkillType.pas,"메이드 특훈","","기절 - 행동할 수 없다, 스킬 발동을 도중에 끊고 자동 스킬 충전이 멈춘다.");
        skillSaveService.saveAllSkills("센타우레이시",SkillType.act,"최종징계","","밀어냄 - 대상의 행동을 중단하고 지정 방향으로 일정 거리 이동시킨다.");
        skillSaveService.saveAllSkills("센타우레이시",SkillType.ult,"메이드의 소양","","");
        skillSaveService.saveAllSkills("브이",SkillType.pas,"영혼 먹는 가면","","탈취 - 대상의 특정 능력치를 감소시키고, 같은 수치만큼 자신 능력치가 상승한다. 중첩 불가능");
        skillSaveService.saveAllSkills("브이",SkillType.act,"아픔의 미학","","");
        skillSaveService.saveAllSkills("브이",SkillType.ult,"가면 프릭쇼","","");
        skillSaveService.saveAllSkills("첼시",SkillType.pas,"고압 절단","","");
        skillSaveService.saveAllSkills("첼시",SkillType.act,"초고압 펌프","","");
        skillSaveService.saveAllSkills("첼시",SkillType.ult,"질소 냉동","","");
        skillSaveService.saveAllSkills("솔",SkillType.pas,"패링","","");
        skillSaveService.saveAllSkills("솔",SkillType.act,"신염참","","작열 - 4스택 누적 시 폭발하여 스택당 연산력 40%의 고정피해를 준다. 폭발 후 화상 표식을 최대 5중첩까지 남긴다.");
        skillSaveService.saveAllSkills("솔",SkillType.ult,"사자열화참","","");
        skillSaveService.saveAllSkills("펜",SkillType.pas,"깨어난 용뼈","","");
        skillSaveService.saveAllSkills("펜",SkillType.act,"졸른호펜 헌팅","","");
        skillSaveService.saveAllSkills("펜",SkillType.ult,"시조의 포효","","");
        skillSaveService.saveAllSkills("뱅크시",SkillType.pas,"뒷골목의 법칙","","");
        skillSaveService.saveAllSkills("뱅크시",SkillType.act,"프리 슬라이딩","","");
        skillSaveService.saveAllSkills("뱅크시",SkillType.ult,"스크럼블 아트","","");
        skillSaveService.saveAllSkills("사쿠야",SkillType.pas,"꽃 꺾기","","");
        skillSaveService.saveAllSkills("사쿠야",SkillType.act,"가지치기","","");
        skillSaveService.saveAllSkills("사쿠야",SkillType.ult,"잎사귀 폭풍","","");
        skillSaveService.saveAllSkills("리세",SkillType.pas,"에일리언 협약","","");
        skillSaveService.saveAllSkills("리세",SkillType.act,"호킨스 파일","","");
        skillSaveService.saveAllSkills("리세",SkillType.ult,"미스트 트레이서","","");
        skillSaveService.saveAllSkills("윌로우",SkillType.pas,"긴급 속보","","");
        skillSaveService.saveAllSkills("윌로우",SkillType.act,"현장 돌격","","실명 - 평타가 80% 확률로 빗나간다.");
        skillSaveService.saveAllSkills("윌로우",SkillType.ult,"대서 특필","","");
        skillSaveService.saveAllSkills("안젤라",SkillType.pas,"빛의 우화","","");
        skillSaveService.saveAllSkills("안젤라",SkillType.act,"마녀의 밤","","");
        skillSaveService.saveAllSkills("안젤라",SkillType.ult,"드래곤 판타지아","","");
        skillSaveService.saveAllSkills("마이",SkillType.pas,"광란기류","","");
        skillSaveService.saveAllSkills("마이",SkillType.act,"회오리 폭풍","","");
        skillSaveService.saveAllSkills("마이",SkillType.ult,"태풍경보","","");
        skillSaveService.saveAllSkills("그루브",SkillType.pas,"워밍업","","");
        skillSaveService.saveAllSkills("그루브",SkillType.act,"댄싱 나이트 피버","","");
        skillSaveService.saveAllSkills("그루브",SkillType.ult,"난장판 피날레","","");
        skillSaveService.saveAllSkills("안토니나",SkillType.pas,"데이터 침식","","트로이 - 공격속도 10 감소, 6스택시 기절");
        skillSaveService.saveAllSkills("안토니나",SkillType.act,"연쇄감염","","");
        skillSaveService.saveAllSkills("안토니나",SkillType.ult,"글로벌 해킹","","");
        skillSaveService.saveAllSkills("아비게일",SkillType.pas,"강조 또 반복","","");
        skillSaveService.saveAllSkills("아비게일",SkillType.act,"개는 대단하다","","");
        skillSaveService.saveAllSkills("아비게일",SkillType.ult,"애비야 물어!","","");
        skillSaveService.saveAllSkills("드셰브니",SkillType.pas,"순수한 선율","","");
        skillSaveService.saveAllSkills("드셰브니",SkillType.act,"내맘대로 순회공연","","");
        skillSaveService.saveAllSkills("드셰브니",SkillType.ult,"천진난만한 선물","","");
        skillSaveService.saveAllSkills("크세니아",SkillType.pas,"전속 서비스","","");
        skillSaveService.saveAllSkills("크세니아",SkillType.act,"한정 세트","","");
        skillSaveService.saveAllSkills("크세니아",SkillType.ult,"VIP 타임","","");
        skillSaveService.saveAllSkills("나나카",SkillType.pas,"스타더스트 리듬","","");
        skillSaveService.saveAllSkills("나나카",SkillType.act,"걸즈 스테이지","","");
        skillSaveService.saveAllSkills("나나카",SkillType.ult,"댄싱 스타라이트","","");
        skillSaveService.saveAllSkills("플로렌스",SkillType.pas,"천사의 유혹","","매료 - 공격 대상이 아군 유닛으로 변한다, 스킬 발동을 도중에 끊고 자동 스킬 충전이 멈춘다.");
        skillSaveService.saveAllSkills("플로렌스",SkillType.act,"VIP 간호","","");
        skillSaveService.saveAllSkills("플로렌스",SkillType.ult,"금단의 비약","","");
        skillSaveService.saveAllSkills("진",SkillType.pas,"마그라세아 믹스","","");
        skillSaveService.saveAllSkills("진",SkillType.act,"젓지 말고 흔들어서","","");
        skillSaveService.saveAllSkills("진",SkillType.ult,"엠버 드림","","");
        skillSaveService.saveAllSkills("제시",SkillType.pas,"청결 서비스","","");
        skillSaveService.saveAllSkills("제시",SkillType.act,"전면소독","","");
        skillSaveService.saveAllSkills("제시",SkillType.ult,"주말 대청소","","");
        skillSaveService.saveAllSkills("페르시카",SkillType.pas,"생명게임","","");
        skillSaveService.saveAllSkills("페르시카",SkillType.act,"재귀연산","","");
        skillSaveService.saveAllSkills("페르시카",SkillType.ult,"에테르 필드","","");
        skillSaveService.saveAllSkills("파나케이아",SkillType.pas,"폭발성 알약","","");
        skillSaveService.saveAllSkills("파나케이아",SkillType.act,"미검증 처방","","");
        skillSaveService.saveAllSkills("파나케이아",SkillType.ult,"약학 매니아","","");
        skillSaveService.saveAllSkills("초코",SkillType.pas,"초코 파워","","");
        skillSaveService.saveAllSkills("초코",SkillType.act,"행운의 진저맨","","");
        skillSaveService.saveAllSkills("초코",SkillType.ult,"가슴따뜻 쿠키","","");
        skillSaveService.saveAllSkills("임호텝",SkillType.pas,"호루스의 부리","","");
        skillSaveService.saveAllSkills("임호텝",SkillType.act,"사냥의 날개","","");
        skillSaveService.saveAllSkills("임호텝",SkillType.ult,"숙면의 깃털","","");
    }
    @Test
    public void saveGoodsStatusCharacter(){
        goodsService.GoodsStatusCharacter("이블린","코드안정",1);
        goodsService.GoodsStatusCharacter("이블린","우정방패",2);
        goodsService.GoodsStatusCharacter("이블린","어깨동무",3);
        goodsService.GoodsStatusCharacter("크로크","코드안정",1);
        goodsService.GoodsStatusCharacter("크로크","우정방패",2);
        goodsService.GoodsStatusCharacter("크로크","어깨동무",3);
        goodsService.GoodsStatusCharacter("보니","코드안정",1);
        goodsService.GoodsStatusCharacter("보니","멘탈활성",2);
        goodsService.GoodsStatusCharacter("보니","어깨동무",3);
        goodsService.GoodsStatusCharacter("야니","우정방패",1);
        goodsService.GoodsStatusCharacter("야니","멘탈활성",2);
        goodsService.GoodsStatusCharacter("야니","상호엄호",3);
        goodsService.GoodsStatusCharacter("시온","우정방패",1);
        goodsService.GoodsStatusCharacter("시온","멘탈활성",2);
        goodsService.GoodsStatusCharacter("시온","상호엄호",3);
        goodsService.GoodsStatusCharacter("쿠로","멘탈활성",1);
        goodsService.GoodsStatusCharacter("쿠로","코드안정",2);
        goodsService.GoodsStatusCharacter("쿠로","진형강화",3);
        goodsService.GoodsStatusCharacter("허블","출력강화",1);
        goodsService.GoodsStatusCharacter("허블","멘탈활성",2);
        goodsService.GoodsStatusCharacter("허블","협력강타",3);
        goodsService.GoodsStatusCharacter("람","출력강화",1);
        goodsService.GoodsStatusCharacter("람","협력강타",2);
        goodsService.GoodsStatusCharacter("람","필승격려",3);
        goodsService.GoodsStatusCharacter("옥토겐","출력강화",1);
        goodsService.GoodsStatusCharacter("옥토겐","멘탈활성",2);
        goodsService.GoodsStatusCharacter("옥토겐","협력강타",3);
        goodsService.GoodsStatusCharacter("에어하트","출력강화",1);
        goodsService.GoodsStatusCharacter("에어하트","멘탈활성",2);
        goodsService.GoodsStatusCharacter("에어하트","협력강타",3);
        goodsService.GoodsStatusCharacter("맥스","출력강화",1);
        goodsService.GoodsStatusCharacter("맥스","멘탈활성",2);
        goodsService.GoodsStatusCharacter("맥스","진형강화",3);
        goodsService.GoodsStatusCharacter("전지","출력강화",1);
        goodsService.GoodsStatusCharacter("전지","코어가속",2);
        goodsService.GoodsStatusCharacter("전지","진형강화",3);
        goodsService.GoodsStatusCharacter("시모","출력강화",1);
        goodsService.GoodsStatusCharacter("시모","상호엄호",2);
        goodsService.GoodsStatusCharacter("시모","협력강타",3);
        goodsService.GoodsStatusCharacter("프레넬","출력강화",1);
        goodsService.GoodsStatusCharacter("프레넬","멘탈활성",2);
        goodsService.GoodsStatusCharacter("프레넬","진형강화",3);
        goodsService.GoodsStatusCharacter("아키","출력강화",1);
        goodsService.GoodsStatusCharacter("아키","코드안정",2);
        goodsService.GoodsStatusCharacter("아키","협력강타",3);
        goodsService.GoodsStatusCharacter("베티","출력강화",1);
        goodsService.GoodsStatusCharacter("베티","코드안정",2);
        goodsService.GoodsStatusCharacter("베티","진형강화",3);
        goodsService.GoodsStatusCharacter("센타우레이시","출력강화",1);
        goodsService.GoodsStatusCharacter("센타우레이시","코드안정",2);
        goodsService.GoodsStatusCharacter("센타우레이시","코어가속",3);
        goodsService.GoodsStatusCharacter("브이","출력강화",1);
        goodsService.GoodsStatusCharacter("브이","멘탈활성",2);
        goodsService.GoodsStatusCharacter("브이","진형강화",3);
        goodsService.GoodsStatusCharacter("첼시","출력강화",1);
        goodsService.GoodsStatusCharacter("첼시","코드안정",2);
        goodsService.GoodsStatusCharacter("첼시","코어가속",3);
        goodsService.GoodsStatusCharacter("솔","멘탈활성",1);
        goodsService.GoodsStatusCharacter("솔","코드안정",2);
        goodsService.GoodsStatusCharacter("솔","코어가속",3);
        goodsService.GoodsStatusCharacter("펜","멘탈활성",1);
        goodsService.GoodsStatusCharacter("펜","코드안정",2);
        goodsService.GoodsStatusCharacter("펜","코어가속",3);
        goodsService.GoodsStatusCharacter("뱅크시","출력강화",1);
        goodsService.GoodsStatusCharacter("뱅크시","코드안정",2);
        goodsService.GoodsStatusCharacter("뱅크시","코어가속",3);
        goodsService.GoodsStatusCharacter("사쿠야","출력강화",1);
        goodsService.GoodsStatusCharacter("사쿠야","코드안정",2);
        goodsService.GoodsStatusCharacter("사쿠야","코어가속",3);
        goodsService.GoodsStatusCharacter("리세","멘탈활성",1);
        goodsService.GoodsStatusCharacter("리세","코드안정",2);
        goodsService.GoodsStatusCharacter("리세","코어가속",3);
        goodsService.GoodsStatusCharacter("윌로우","멘탈활성",1);
        goodsService.GoodsStatusCharacter("윌로우","코드안정",2);
        goodsService.GoodsStatusCharacter("윌로우","코어가속",3);
        goodsService.GoodsStatusCharacter("안젤라","멘탈활성",1);
        goodsService.GoodsStatusCharacter("안젤라","코드안정",2);
        goodsService.GoodsStatusCharacter("안젤라","코어가속",3);
        goodsService.GoodsStatusCharacter("마이","멘탈활성",1);
        goodsService.GoodsStatusCharacter("마이","코드안정",2);
        goodsService.GoodsStatusCharacter("마이","상호엄호",3);
        goodsService.GoodsStatusCharacter("그루브","멘탈활성",1);
        goodsService.GoodsStatusCharacter("그루브","코드안정",2);
        goodsService.GoodsStatusCharacter("그루브","상호엄호",3);
        goodsService.GoodsStatusCharacter("안토니나","멘탈활성",1);
        goodsService.GoodsStatusCharacter("안토니나","코드안정",2);
        goodsService.GoodsStatusCharacter("안토니나","코어가속",3);
        goodsService.GoodsStatusCharacter("아비게일","멘탈활성",1);
        goodsService.GoodsStatusCharacter("아비게일","코드안정",2);
        goodsService.GoodsStatusCharacter("아비게일","코어가속",3);
        goodsService.GoodsStatusCharacter("드셰브니","멘탈활성",1);
        goodsService.GoodsStatusCharacter("드셰브니","코드안정",2);
        goodsService.GoodsStatusCharacter("드셰브니","코어가속",3);
        goodsService.GoodsStatusCharacter("크세니아","멘탈활성",1);
        goodsService.GoodsStatusCharacter("크세니아","코드안정",2);
        goodsService.GoodsStatusCharacter("크세니아","코어가속",3);
        goodsService.GoodsStatusCharacter("나나카","멘탈활성",1);
        goodsService.GoodsStatusCharacter("나나카","코드안정",2);
        goodsService.GoodsStatusCharacter("나나카","코어가속",3);
        goodsService.GoodsStatusCharacter("플로렌스","멘탈활성",1);
        goodsService.GoodsStatusCharacter("플로렌스","코드안정",2);
        goodsService.GoodsStatusCharacter("플로렌스","치유연대",3);
        goodsService.GoodsStatusCharacter("진","멘탈활성",1);
        goodsService.GoodsStatusCharacter("진","코드안정",2);
        goodsService.GoodsStatusCharacter("진","코어가속",3);
        goodsService.GoodsStatusCharacter("제시","멘탈활성",1);
        goodsService.GoodsStatusCharacter("제시","코드안정",2);
        goodsService.GoodsStatusCharacter("제시","상호엄호",3);
        goodsService.GoodsStatusCharacter("페르시카","멘탈활성",1);
        goodsService.GoodsStatusCharacter("페르시카","코드안정",2);
        goodsService.GoodsStatusCharacter("페르시카","코어가속",3);
        goodsService.GoodsStatusCharacter("파나케이아","멘탈활성",1);
        goodsService.GoodsStatusCharacter("파나케이아","코드안정",2);
        goodsService.GoodsStatusCharacter("파나케이아","치유연대",3);
        goodsService.GoodsStatusCharacter("초코","멘탈활성",1);
        goodsService.GoodsStatusCharacter("초코","코드안정",2);
        goodsService.GoodsStatusCharacter("초코","코어가속",3);
        goodsService.GoodsStatusCharacter("임호텝","멘탈활성",1);
        goodsService.GoodsStatusCharacter("임호텝","코드안정",2);
        goodsService.GoodsStatusCharacter("임호텝","코어가속",3);
        goodsService.GoodsStatusCharacter("수춘","우정방패",1);
        goodsService.GoodsStatusCharacter("수춘","멘탈활성",2);
        goodsService.GoodsStatusCharacter("수춘","상호엄호",3);
    }
    @Test
    public void saveCharacter(){
        characterService.save("수춘",DealType.ap,RoleType.depender,AreaType.target,CompanyType.lab,1);
        characterService.save("이블린",DealType.ap,RoleType.depender,AreaType.target,CompanyType.sva,5);
        characterService.save("크로크",DealType.ap,RoleType.depender,AreaType.target,CompanyType.sva,5);
        characterService.save("보니",DealType.ap,RoleType.depender,AreaType.target,CompanyType.ucl,1);
        characterService.save("야니",DealType.ap,RoleType.depender,AreaType.target,CompanyType.lab,1);
        characterService.save("시온",DealType.ap,RoleType.depender,AreaType.target,CompanyType.sva,3);
        characterService.save("쿠로",DealType.ap,RoleType.gunner,AreaType.target,CompanyType.cma,5);
        characterService.save("허블",DealType.ap,RoleType.gunner,AreaType.area,CompanyType.lab,5);
        characterService.save("람",DealType.ad,RoleType.gunner,AreaType.target,CompanyType.uas,1);
        characterService.save("옥토겐",DealType.ap,RoleType.gunner,AreaType.target,CompanyType.sva,3);
        characterService.save("에어하트",DealType.ap,RoleType.gunner,AreaType.target,CompanyType.sva,3);
        characterService.save("맥스",DealType.ap,RoleType.gunner,AreaType.area,CompanyType.lab,1);
        characterService.save("전지",DealType.ad,RoleType.gunner,AreaType.area,CompanyType.cma,5);
        characterService.save("시모",DealType.ad,RoleType.gunner,AreaType.target,CompanyType.sva,1);
        characterService.save("프레넬",DealType.al,RoleType.gunner,AreaType.target,CompanyType.lab,3);
        characterService.save("아키",DealType.ad,RoleType.soldier,AreaType.target,CompanyType.uas,5);
        characterService.save("베티",DealType.ad,RoleType.soldier,AreaType.target,CompanyType.uas,3);
        characterService.save("센타우레이시",DealType.ad,RoleType.soldier,AreaType.target,CompanyType.uas,5);
        characterService.save("브이",DealType.al,RoleType.soldier,AreaType.target,CompanyType.ucl,5);
        characterService.save("첼시",DealType.ad,RoleType.soldier,AreaType.target,CompanyType.sva,1);
        characterService.save("솔",DealType.ap,RoleType.soldier,AreaType.target,CompanyType.lab,3);
        characterService.save("펜",DealType.ap,RoleType.soldier,AreaType.target,CompanyType.lab,3);
        characterService.save("뱅크시",DealType.ad,RoleType.specialist,AreaType.target,CompanyType.cma,5);
        characterService.save("사쿠야",DealType.ad,RoleType.specialist,AreaType.target,CompanyType.uas,3);
        characterService.save("리세",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.ucl,3);
        characterService.save("윌로우",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.cma,5);
        characterService.save("안젤라",DealType.al,RoleType.specialist,AreaType.target,CompanyType.uas,3);
        characterService.save("마이",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.lab,1);
        characterService.save("그루브",DealType.al,RoleType.specialist,AreaType.target,CompanyType.cma,1);
        characterService.save("안토니나",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.lab,3);
        characterService.save("아비게일",DealType.al,RoleType.specialist,AreaType.target,CompanyType.sva,1);
        characterService.save("드셰브니",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.uas,3);
        characterService.save("크세니아",DealType.ap,RoleType.specialist,AreaType.target,CompanyType.uas,3);
        characterService.save("나나카",DealType.ap,RoleType.healer,AreaType.area,CompanyType.cma,5);
        characterService.save("플로렌스",DealType.ap,RoleType.healer,AreaType.target,CompanyType.ucl,5);
        characterService.save("진",DealType.ap,RoleType.healer,AreaType.target,CompanyType.uas,5);
        characterService.save("제시",DealType.ap,RoleType.healer,AreaType.target,CompanyType.uas,1);
        characterService.save("페르시카",DealType.ap,RoleType.healer,AreaType.target,CompanyType.lab,3);
        characterService.save("파나케이아",DealType.ap,RoleType.healer,AreaType.target,CompanyType.ucl,3);
        characterService.save("초코",DealType.ap,RoleType.healer,AreaType.target,CompanyType.uas,1);
        characterService.save("임호텝", DealType.ap, RoleType.healer, AreaType.target, CompanyType.ucl,3);

    }

    @Test
    public void saveGoodsStatus(){
        goodsService.saveGoodsStatus("출력강화","공격력 [] 상승");
        goodsService.saveGoodsStatus("코어가속","충전속도 []% 상승");
        goodsService.saveGoodsStatus("진형강화","모든 피해량[]% 상승");
        goodsService.saveGoodsStatus("멘탈활성","연상력 [] 상승");
        goodsService.saveGoodsStatus("코드안정","체력 [] 상승");
        goodsService.saveGoodsStatus("협력강타","치명률 []% 상승");
        goodsService.saveGoodsStatus("필승격려","치명타 피해 []% 상승");
        goodsService.saveGoodsStatus("우정방패","방어력 [] 상승");
        goodsService.saveGoodsStatus("어깨동무","피해차감 []% 상승");
        goodsService.saveGoodsStatus("치유연대","치유량 []% 상승");
        goodsService.saveGoodsStatus("상호엄호","회피율 []% 상승");
    }

    @Test
    public void saveAllGoods(){
        goodsService.saveAllGoods("찐빵",1,20,12,16);
        goodsService.saveAllGoods("패스트푸드",1,20,12,16);
        goodsService.saveAllGoods("케익 조각",1,20,12,16);
        goodsService.saveAllGoods("벌꿀",1,20,12,16);
        goodsService.saveAllGoods("오뎅",1,20,12,16);
        goodsService.saveAllGoods("봉제 열쇠고리",1,20,12,16);
        goodsService.saveAllGoods("디지털 블럭",1,20,12,16);
        goodsService.saveAllGoods("연습용 죽도",1,20,12,16);
        goodsService.saveAllGoods("찐빵 찜통",2,50,30,40);
        goodsService.saveAllGoods("직장인 세트",2,50,30,40);
        goodsService.saveAllGoods("신호등 케익",2,50,30,40);
        goodsService.saveAllGoods("초콜릿 선디",2,50,30,40);
        goodsService.saveAllGoods("딸기 케익",2,50,30,40);
        goodsService.saveAllGoods("카툰 인형",2,50,30,40);
        goodsService.saveAllGoods("보틀셔틀",2,50,30,40);
        goodsService.saveAllGoods("컴뱃 나이프",2,50,30,40);
        goodsService.saveAllGoods("찐빵 한박스",3,125,100,75);
        goodsService.saveAllGoods("커플 세트",3,125,100,75);
        goodsService.saveAllGoods("디럭스 케익",3,125,100,75);
        goodsService.saveAllGoods("커피",3,125,100,75);
        goodsService.saveAllGoods("티타임 세트",3,125,100,75);
        goodsService.saveAllGoods("곰돌이 인형",3,125,100,75);
        goodsService.saveAllGoods("프라모델",3,125,100,75);
        goodsService.saveAllGoods("소장용 명검",3,125,100,75);
    }

    @Test
    public void saveStarExp(){
        needStarExpService.saveStarExp(1,0);
        needStarExpService.saveStarExp(2,5);
        needStarExpService.saveStarExp(3,10);
        needStarExpService.saveStarExp(4,25);
        needStarExpService.saveStarExp(5,40);
        needStarExpService.saveStarExp(6,60);
        needStarExpService.saveStarExp(7,70);
        needStarExpService.saveStarExp(8,90);
        needStarExpService.saveStarExp(9,100);
    }

    @Test
    public void saveGoodsExp(){
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
    }

    @Test
    public void saveSkillExp(){
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
    }

    @Test
    public void saveExp(){

        expService.saveExp(0,1,0,0,0,0,0,0);
        expService.saveExp(90,2,0,0,0,0,0,0);
        expService.saveExp(140,3,0,0,0,0,0,0);
        expService.saveExp(190,4,0,0,0,0,0,0);
        expService.saveExp(240,5,0,0,0,0,0,0);
        expService.saveExp(290,6,0,0,0,0,0,0);
        expService.saveExp(430,7,0,0,0,0,0,0);
        expService.saveExp(390,8,0,0,0,0,0,0);
        expService.saveExp(440,9,0,0,0,0,0,0);
        expService.saveExp(490,10,10,0,0,0,0,0);
        expService.saveExp(540,11,0,0,0,0,0,0);
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
    }

}
