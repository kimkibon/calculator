package com.nueral.calculator.dto.character;

import com.nueral.calculator.entity.images.Skins;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SkinSaveDto {
    String characterName;
    String type;
    MultipartFile file;
    String stdName;
    int releaseDate;

    public SkinSaveDto(Skins skins){
        this.characterName = skins.getCharacters().getName();
        this.type = skins.getType();
        this.stdName = skins.getStdName();
        this.releaseDate = skins.getReleaseDate();
    }

    public SkinSaveDto(String characterName){
        this.characterName = characterName;
    }

}
