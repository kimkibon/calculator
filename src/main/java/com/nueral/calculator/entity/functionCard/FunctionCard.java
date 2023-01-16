package com.nueral.calculator.entity.functionCard;

import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class FunctionCard {
    @Id
    private String FunctionName;
    private RoleType roleType;
    private DealType dealType;
    private String FunctionEffect;

}
