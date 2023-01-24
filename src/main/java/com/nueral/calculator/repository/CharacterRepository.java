package com.nueral.calculator.repository;

import com.nueral.calculator.entity.character.Characters;
import com.nueral.calculator.mapping.CharacterName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Characters, String> {
    Optional<Characters> findByName(String name);
    List<CharacterName> findAllBy();
}
