package com.nueral.calculator.service.needExp;

import com.nueral.calculator.entity.needExp.NeedSkillExp;
import com.nueral.calculator.repository.needExp.NeedSkillExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NeedSkillExpService {
    @Autowired
    private NeedSkillExpRepository needSkillExpRepository;

    public void saveSkillExp(int skillLevel , int exp , int core){

        NeedSkillExp needSkillExp = NeedSkillExp.builder()
                .skillLevel(skillLevel)
                .exp(exp)
                .core(core)
                .build();

        needSkillExpRepository.save(needSkillExp);
    }

    public List<NeedSkillExp> findAll(){

        return needSkillExpRepository.findAll(Sort.by(Sort.Direction.DESC, "level"));

    }
}
