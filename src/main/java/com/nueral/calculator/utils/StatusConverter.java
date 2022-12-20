package com.nueral.calculator.utils;

import com.nueral.calculator.dto.skillsDto.SkillLevelDto;
import com.nueral.calculator.entity.friendship.GoodsStatusLevel;

import java.util.ArrayList;
import java.util.List;

public class StatusConverter {

    public List<String> convertSkillString(String explain , List<SkillLevelDto> statusList){

        List<String> result = new ArrayList<>();

        for (SkillLevelDto skillLevelDto : statusList) {
            String convert = String.copyValueOf(explain.toCharArray());
            String replace = convert
                    .replace("[1]", String.valueOf(skillLevelDto.getStatus1()))
                    .replace("[2]", String.valueOf(skillLevelDto.getStatus2()))
                    .replace("[3]", String.valueOf(skillLevelDto.getStatus3()))
                    .replace("[4]", String.valueOf(skillLevelDto.getStatus4()));
            result.add(replace);
        }

        return result;
    }

    public List<String> convertGoodsString(String explain , List<GoodsStatusLevel> statusList){
        List<String> result = new ArrayList<>();

        for (GoodsStatusLevel goodsStatusLevel : statusList) {
            String convert = String.copyValueOf(explain.toCharArray());
            String replace = convert
                    .replace("[]", String.valueOf(goodsStatusLevel.getStatus()));
            result.add(replace);
        }

        return result;
    }
}
