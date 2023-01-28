package com.nueral.calculator.service.epService;

import com.nueral.calculator.dto.EpDto.EpPoolDto;
import com.nueral.calculator.entity.epParty.EpPool;
import com.nueral.calculator.repository.epParty.EpPartyRepository;
import com.nueral.calculator.repository.epParty.EpPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpService {
    @Autowired
    private EpPartyRepository epPartyRepository;
    @Autowired
    private EpPoolRepository epPoolRepository;


    public EpPoolDto saveEpPoolPro(int index) {
        return new EpPoolDto(epPoolRepository.findById(index).orElse(new EpPool()));
    }

    public List<EpPoolDto> EpPoolDtoList() {
        return epPoolRepository.findAll().stream().map(EpPoolDto::new).collect(Collectors.toList());
    }
}
