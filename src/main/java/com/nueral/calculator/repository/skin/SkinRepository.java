package com.nueral.calculator.repository.skin;

import com.nueral.calculator.entity.images.Skins;
import com.nueral.calculator.entity.images.id.SkinsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkinRepository extends JpaRepository<Skins, SkinsId> {
    @Query(value = "select * from Skins s where s.character_name = :name" ,nativeQuery = true)
    List<Skins> findByCharacters(@Param("name") String name);

    @Query(value = "select distinct s.type from Skins s" ,nativeQuery = true)
    List<String> findType();
}
