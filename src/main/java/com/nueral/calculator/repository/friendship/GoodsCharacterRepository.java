package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsCharacter;
import com.nueral.calculator.entity.friendship.id.GoodsCharacterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCharacterRepository extends JpaRepository<GoodsCharacter , GoodsCharacterId> {
}
