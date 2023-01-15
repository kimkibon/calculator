package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsCharacter;
import com.nueral.calculator.entity.friendship.id.GoodsCharacterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsCharacterRepository extends JpaRepository<GoodsCharacter , GoodsCharacterId> {
    @Query(value = "select * from goods_character s where s.character_name = :name" , nativeQuery = true)
    List<GoodsCharacter> findAllByCharacterName(@Param("name") String name);
}
