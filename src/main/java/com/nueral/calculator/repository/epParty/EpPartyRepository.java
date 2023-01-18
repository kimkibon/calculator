package com.nueral.calculator.repository.epParty;

import com.nueral.calculator.entity.epParty.EpParty;
import com.nueral.calculator.entity.epParty.id.EpPartyId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpPartyRepository extends JpaRepository<EpParty, EpPartyId> {
    List<EpParty> findAllByEpPool(int epPool);
}
