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
public class NeedGoods extends DefaultEntity {

    @Id
    private int friendlyLevel;
    private int exp;

    @Builder
    public NeedGoods(int friendlyLevel , int exp){
        this.friendlyLevel = friendlyLevel;
        this.exp = exp;
    }
}
