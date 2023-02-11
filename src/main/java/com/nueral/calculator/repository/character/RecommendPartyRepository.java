package com.nueral.calculator.repository.character;

import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.entity.character.RecommendParty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendPartyRepository extends JpaRepository<RecommendParty, Characters> {
    long deleteByCharacters(Characters characters);
    List<RecommendParty> findByCharacters_Name(String name);
}