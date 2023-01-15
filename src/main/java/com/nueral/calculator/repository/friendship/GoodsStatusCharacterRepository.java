package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import com.nueral.calculator.entity.friendship.id.GoodsStatusCharacterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsStatusCharacterRepository extends JpaRepository<GoodsStatusCharacter , GoodsStatusCharacterId> {
    @Query(value = "select * from goods_status_character s where s.character_name = :name" , nativeQuery = true)

    List<GoodsStatusCharacter> findAllByCharacterName(@Param("name") String name);
}
