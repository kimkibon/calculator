package com.nueral.calculator.dto.character;

import com.nueral.calculator.entity.images.Skins;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SkinDto {
    String name;
    String type;

    public SkinDto(Skins skins){
       this.name = skins.getStdName();
       this.type = skins.getType();
    }
}
