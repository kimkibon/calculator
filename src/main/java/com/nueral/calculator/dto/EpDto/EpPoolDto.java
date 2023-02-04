package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpPool;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPoolDto {
    private int epPoolIndex;
    private String startDate;
    private String endDate;
    private String fstStage;
    private String sndStage;
    private String thdStage;
    private String bossName;
    private List<EpPartyDto> epPartyDtoList;

    public EpPoolDto(EpPool epPool){
        this.epPoolIndex = epPool.getEpIndex();
        this.startDate = epPool.getStartDate().toString();
        this.endDate = epPool.getEndDate().toString();
        this.fstStage = epPool.getFstStage();
        this.sndStage = epPool.getSndStage();
        this.thdStage = epPool.getThdStage();
        this.bossName = epPool.getBossName();
        this.epPartyDtoList = epPool.getEpPartyList().stream().map(EpPartyDto::new).collect(Collectors.toList());
    }
}
