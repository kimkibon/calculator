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
public class NeedExp extends DefaultEntity {

    @Id
    private int characterLevel;

    @NonNull
    private int exp;
    private int gray;
    private int green;
    private int blue;
    private int purple;
    private int orange;
    private int rainbow;

    @Builder
    public NeedExp(int characterLevel, int exp , int gray ,int green ,
                   int blue, int purple , int orange , int rainbow ){

        this.characterLevel = characterLevel;
        this.exp = exp;
        this.gray = gray;
        this.green = green;
        this.blue = blue;
        this.purple = purple;
        this.orange = orange;
        this.rainbow = rainbow;

    }

}
