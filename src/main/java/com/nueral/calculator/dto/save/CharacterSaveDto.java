package com.nueral.calculator.dto.save;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CharacterSaveDto {
    private String characterName;
    private String dealType;
    private String roleType;
    private String areaType;
    private String companyType;
    private int defaultStar;
    private String profile;
}
