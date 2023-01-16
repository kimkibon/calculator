package com.nueral.calculator.entity.epParty;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class EpPool extends DefaultEntity {
    @Id
    private int epIndex;
    private int startDate;
    private int endDate;
    private String fstStage;
    private String sndStage;
    private String thdStage;
    private String bossName;

    @OneToMany(mappedBy = "epPool" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<EpParty> epParty;

    @Builder EpPool(
            int epIndex , int startDate , int endDate ,
            String fstStage , String sndStage , String thdStage, String bossName
    ){
        this.epIndex = epIndex;
        this.startDate = startDate;
        this.endDate = endDate;
        this.fstStage = fstStage;
        this.sndStage = sndStage;
        this.thdStage = thdStage;
        this.bossName = bossName;
    }
}
