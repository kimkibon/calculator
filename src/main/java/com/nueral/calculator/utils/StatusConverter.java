package com.nueral.calculator.utils;

import com.nueral.calculator.entity.friendship.GoodsStatusLevel;
import com.nueral.calculator.entity.skill.SkillLevels;

import java.util.ArrayList;
import java.util.List;

public class StatusConverter {

    public List<String> convertSkillString(String explain , List<SkillLevels> statusList){

        List<String> result = new ArrayList<>();

        for (SkillLevels skillLevels : statusList) {
            String convert = String.copyValueOf(explain.toCharArray());
            String replace = convert
                    .replace("[1]", String.valueOf(skillLevels.getStatus()))
                    .replace("[2]", String.valueOf(skillLevels.getStatus2()))
                    .replace("[3]", String.valueOf(skillLevels.getStatus3()))
                    .replace("[4]", String.valueOf(skillLevels.getStatus4()));
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
