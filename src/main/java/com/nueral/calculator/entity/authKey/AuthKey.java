package com.nueral.calculator.entity.authKey;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class AuthKey extends DefaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int KeyId;
    private int exp;
    private int gray;
    private int green;
    private int blue;
    private int purple;
    private int orange;
    private int skillCore;
    private int skillExp;
    private int starExp;

    @Builder
    public AuthKey(int exp , int gray , int green , int blue,
                   int purple , int orange , int skillCore,
                   int skillExp , int starExp){
        this.gray = gray;
        this.blue = blue;
        this.green = green;
        this.purple = purple;
        this.orange = orange;
        this.starExp = starExp;
        this.skillCore = skillCore;
        this.skillExp = skillExp;
        this.exp = exp;
    }
}
