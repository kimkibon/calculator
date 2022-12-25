package com.nueral.calculator.service.needExp;

import com.nueral.calculator.entity.needExp.NeedExp;
import com.nueral.calculator.entity.needExp.NeedGoods;
import com.nueral.calculator.entity.needExp.NeedSkillExp;
import com.nueral.calculator.entity.needExp.NeedStarExp;
import com.nueral.calculator.repository.needExp.NeedExpRepository;
import com.nueral.calculator.repository.needExp.NeedGoodsRepository;
import com.nueral.calculator.repository.needExp.NeedSkillExpRepository;
import com.nueral.calculator.repository.needExp.NeedStarExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class CalculatorService {
    @Autowired
    private NeedExpRepository needExpRepository;
    @Autowired
    private NeedStarExpRepository starExpRepository;
    @Autowired
    private NeedSkillExpRepository needSkillExpRepository;
    @Autowired
    private NeedGoodsRepository goodsRepository;

    public List<NeedSkillExp> skillExpList(){
        return needSkillExpRepository.findAll(Sort.by(Sort.Direction.DESC, "skillLevel"));
    }
    public List<NeedExp> expList(){
        return needExpRepository.findAll(Sort.by(Sort.Direction.DESC, "characterLevel"));
    }
    public List<NeedGoods> goodsExpList(){
        return goodsRepository.findAll(Sort.by(Sort.Direction.DESC, "friendlyLevel"));
    }
    public List<NeedStarExp> starExpList(){
        return starExpRepository.findAll(Sort.by(Sort.Direction.DESC, "starLevel"));
    }

}
