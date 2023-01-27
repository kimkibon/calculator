package com.nueral.calculator.dto.EpDto;

import com.nueral.calculator.entity.epParty.EpPool;
import lombok.*;

import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EpPoolDto {
    private int epIndex;
    private int startDate;
    private int endDate;
    private String fstStage;
    private String sndStage;
    private String thdStage;
    private String bossName;

    public EpPoolDto(EpPool epPool){
        this.epIndex = epPool.getEpIndex();
        this.startDate = epPool.getStartDate();
        this.endDate = epPool.getEndDate();
        this.fstStage = epPool.getFstStage();
        this.sndStage = epPool.getSndStage();
        this.thdStage = epPool.getThdStage();
        this.bossName = epPool.getBossName();

    }
}
