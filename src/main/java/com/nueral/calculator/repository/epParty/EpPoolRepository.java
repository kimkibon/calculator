package com.nueral.calculator.repository.epParty;

import com.nueral.calculator.entity.epParty.EpPool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpPoolRepository extends JpaRepository<EpPool , Integer> {
    long countByEpIndex(int epIndex);
}
