package com.nueral.calculator.entity.needExp;


import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class NeedStarExp extends DefaultEntity {

    @Id
    private int starLevel;
    private String showLevel;
    private int exp;

    @Builder
    public NeedStarExp(int starLevel , int exp , String showLevel){
        this.starLevel = starLevel;
        this.showLevel = showLevel;
        this.exp = exp;
    }
}
