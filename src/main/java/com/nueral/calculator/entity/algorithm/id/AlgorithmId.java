package com.nueral.calculator.entity.algorithm.id;

import com.nueral.calculator.types.AlgorithmType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class AlgorithmId implements Serializable {
    private String characters;
    @Enumerated(EnumType.STRING)
    private AlgorithmType algorithmType;
}
