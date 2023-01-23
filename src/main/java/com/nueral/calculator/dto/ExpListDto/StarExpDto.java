package com.nueral.calculator.dto.ExpListDto;

import com.nueral.calculator.entity.needExp.NeedStarExp;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StarExpDto {
    private int starLevel;
    private String showLevel;
    private int exp;

    public StarExpDto(NeedStarExp needStarExp){
        this.exp = needStarExp.getExp();
        this.showLevel = needStarExp.getShowLevel();
        this.starLevel = needStarExp.getStarLevel();
    }
}
