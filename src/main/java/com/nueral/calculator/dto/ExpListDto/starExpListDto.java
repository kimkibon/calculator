package com.nueral.calculator.dto.ExpListDto;

import com.nueral.calculator.entity.needExp.NeedStarExp;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class starExpListDto {
    private List<NeedStarExp> needStarExpList;
}
