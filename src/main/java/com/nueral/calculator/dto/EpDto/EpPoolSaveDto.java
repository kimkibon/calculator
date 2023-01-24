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
public class EpPoolSaveDto {
    private int epIndex;
    private int startDate;
    private int endDate;
    private String fsrStage;
    private String sndStage;
    private String thdStage;
    private String bossName;
    private List<EpPartySaveDto> epPartySaveDtoList;

    public EpPoolSaveDto(EpPool epPool){
        this.epIndex = epPool.getEpIndex();
        this.startDate = epPool.getStartDate();
        this.endDate = epPool.getEndDate();
        this.fsrStage = epPool.getFstStage();
        this.sndStage = epPool.getSndStage();
        this.thdStage = epPool.getThdStage();
        this.bossName = epPool.getBossName();
        this.epPartySaveDtoList = epPool.getEpParty().stream().map(EpPartySaveDto::new).collect(Collectors.toList());

    }
}
