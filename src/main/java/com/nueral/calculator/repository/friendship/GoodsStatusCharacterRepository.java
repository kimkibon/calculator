package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import com.nueral.calculator.entity.friendship.id.GoodsStatusCharacterId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsStatusCharacterRepository extends JpaRepository<GoodsStatusCharacter , GoodsStatusCharacterId> {
}
