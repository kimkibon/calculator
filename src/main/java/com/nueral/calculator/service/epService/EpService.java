package com.nueral.calculator.service.epService;

import com.nueral.calculator.dto.EpDto.EpPoolDto;
import com.nueral.calculator.dto.EpDto.EpPoolSaveDto;
import com.nueral.calculator.entity.epParty.EpPool;
import com.nueral.calculator.repository.epParty.EpPartyRepository;
import com.nueral.calculator.repository.epParty.EpPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpService {
    @Autowired
    private EpPartyRepository epPartyRepository;
    @Autowired
    private EpPoolRepository epPoolRepository;

    public EpPoolSaveDto saveEpPoolPro(int epIndex){
        return new EpPoolSaveDto(epPoolRepository.findById(epIndex)
                .orElse(EpPool.builder().epIndex(epIndex).epParty(new ArrayList<>()).build()));
    }

    public int EpPoolCount(){
        return (int)epPoolRepository.count();
    }

    public List<EpPoolDto> EpPoolDtoList(){
       return epPoolRepository.findAll().stream().sorted(Comparator.comparingInt(EpPool::getEpIndex).reversed()).map(EpPoolDto::new).collect(Collectors.toList());
    }

}
