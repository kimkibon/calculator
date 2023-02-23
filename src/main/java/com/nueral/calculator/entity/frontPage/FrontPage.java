package com.nueral.calculator.entity.frontPage;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@SequenceGenerator(name = "FRONT_IDX_GENERATOR" , sequenceName = "FRONT_SEQ", allocationSize = 1) // 시퀀스 생성
public class FrontPage extends DefaultEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "FRONT_IDX_GENERATOR")
    private int frontIdx;
    private String main;
    private String calculator;
    private String tier;
    private String ep;
    private String character;
}
