package com.nueral.calculator.entity.images.id;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class SkinsId implements Serializable {
    private String characters;
    private String type;
}
