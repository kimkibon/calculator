package com.nueral.calculator.service.epService;

import com.nueral.calculator.dto.EpDto.EpPoolSaveDto;
import com.nueral.calculator.entity.epParty.EpPool;
import com.nueral.calculator.repository.epParty.EpPartyRepository;
import com.nueral.calculator.repository.epParty.EpPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpService {
    @Autowired
    private EpPartyRepository epPartyRepository;
    @Autowired
    private EpPoolRepository epPoolRepository;

    public EpPoolSaveDto saveEpPoolPro(int epIndex){
        return new EpPoolSaveDto(epPoolRepository.findById(epIndex)
                .orElse(EpPool.builder().epIndex(epIndex).build()));
    }

    public int EpPoolCount(){
        return (int)epPoolRepository.count();
    }

}
