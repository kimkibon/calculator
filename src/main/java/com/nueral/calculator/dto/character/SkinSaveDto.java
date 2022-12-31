package com.nueral.calculator.dto.character;

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
    MultipartFile multipartFile;
}
