package com.nueral.calculator.entity.functionCard;

import com.nueral.calculator.entity.DefaultEntity;
import com.nueral.calculator.types.DealType;
import com.nueral.calculator.types.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
@SequenceGenerator(name = "FUNCTION_SET_IDX_GENERATOR" , sequenceName = "FUNCTION_SET_SEQ", allocationSize = 1) // 시퀀스 생성
public class FunctionSet extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FUNCTION_SET_IDX_GENERATOR")
    @Column(name = "FUNCTION_SET_INDEX")
    private int functionSetIndex;
    private String functionSetName;
    private RoleType roleType;
    private DealType dealType;
    private String functionSetEffect;
    @OneToMany(mappedBy = "functionSet" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<FunctionCard> functionCardList;
}
