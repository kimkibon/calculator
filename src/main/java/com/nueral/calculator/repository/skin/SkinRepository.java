package com.nueral.calculator.repository.skin;

import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.entity.images.id.SkinsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SkinRepository extends JpaRepository<Skins, SkinsId> {
    Optional<Skins> findByCharacters(String name);

    @Query(value = "select distinct s.type from skins s" ,nativeQuery = true)
    Optional<String> findType();
}
