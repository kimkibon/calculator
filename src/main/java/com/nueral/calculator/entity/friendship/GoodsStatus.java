package com.nueral.calculator.entity.friendship;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class GoodsStatus extends DefaultEntity {
    @Id
    @Column(name = "GOODS_STATUS_NAME")
    private String name;
    private String status;


    @Builder
    public GoodsStatus(String name , String status){
        this.name = name;
        this.status = status;

    }
}
