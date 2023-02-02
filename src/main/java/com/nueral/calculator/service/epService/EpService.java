package com.nueral.calculator.service.epService;

import com.nueral.calculator.dto.EpDto.EpPoolDto;
import com.nueral.calculator.entity.epParty.EpParty;
import com.nueral.calculator.entity.epParty.EpPool;
import com.nueral.calculator.repository.epParty.EpPartyRepository;
import com.nueral.calculator.repository.epParty.EpPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpService {
    @Autowired
    private EpPartyRepository epPartyRepository;
    @Autowired
    private EpPoolRepository epPoolRepository;


    public EpPoolDto saveEpPoolPro(int index) {
        EpPoolDto epPoolDto;
        if(index == 0) {
            List<EpParty> epPartyList = new ArrayList<>();
            epPartyList.add(EpParty.builder().epPartyIndex((int) epPoolRepository.count()).epMemberList(new ArrayList<>()).build());
            EpPool epPool = EpPool.builder().epPartyList(epPartyList).build();
            epPoolDto = new EpPoolDto(epPool);
        } else {
            epPoolDto = new EpPoolDto(epPoolRepository.findById(index).get());
        }
        return epPoolDto;
    }

    public List<EpPoolDto> EpPoolDtoList() {
        return epPoolRepository.findAll().stream().map(EpPoolDto::new).collect(Collectors.toList());
    }
}
