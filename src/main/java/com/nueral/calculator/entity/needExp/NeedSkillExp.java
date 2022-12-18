package com.nueral.calculator.entity.needExp;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class NeedSkillExp extends DefaultEntity {

    @Id
    private int skillLevel;
    @NonNull
    private int exp;
    private int core;

    @Builder
    public NeedSkillExp(
            int skillLevel , int exp , int core
    ){
        this.skillLevel = skillLevel;
        this.exp = exp;
        this.core = core;
    }
}
