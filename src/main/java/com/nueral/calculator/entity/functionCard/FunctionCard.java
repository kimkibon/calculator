package com.nueral.calculator.entity.functionCard;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@SequenceGenerator(name = "FUNCTION_CARD_IDX_GENERATOR" , sequenceName = "FUNCTION_CARD_SEQ", allocationSize = 1) // 시퀀스 생성
public class FunctionCard extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FUNCTION_CARD_IDX_GENERATOR")
    private int functionIndex;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FUNCTION_SET_INDEX", nullable = false , referencedColumnName ="FUNCTION_SET_INDEX")
    @ToString.Exclude
    private FunctionSet functionSet;
    private String functionName;
    private String functionEffect;

    public void setFunctionSet(FunctionSet functionSet) {
        this.functionSet = functionSet;
    }

}
