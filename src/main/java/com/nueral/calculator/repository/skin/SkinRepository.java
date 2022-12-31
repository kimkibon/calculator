package com.nueral.calculator.repository.skin;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.entity.images.id.SkinsId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SkinRepository extends JpaRepository<Skins, SkinsId> {
    List<Skins> findByCharacters(String name);
    Optional<Skins> findByCharactersAndType(Characters characters, String type);
}
