package com.nueral.calculator.entity.images;

import com.nueral.calculator.entity.DefaultEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@SequenceGenerator(name = "IMAGES_GENERATOR" , sequenceName = "IMAGES_SEQ" , allocationSize = 1)
public class Images extends DefaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "IMAGES_GENERATOR")
    private long imageId;
    private String orgName;
    private String stdName;
    private String type;

    @Builder
    public Images(String orgName , String stdName, String type){
        this.orgName = orgName;
        this.stdName = stdName;
        this.type = type;
    }
}
