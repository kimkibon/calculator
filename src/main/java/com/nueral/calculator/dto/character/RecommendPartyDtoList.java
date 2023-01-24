package com.nueral.calculator.dto.character;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendPartyDtoList {
    private List<RecommendPartyDto> recommendPartyDtoList;
}
