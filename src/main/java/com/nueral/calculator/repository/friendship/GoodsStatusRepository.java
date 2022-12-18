package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsStatus;
import com.nueral.calculator.entity.friendship.id.GoodsStatusLevelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsStatusRepository extends JpaRepository<GoodsStatus, GoodsStatusLevelId> {
    GoodsStatus findByName(String goodsStatus);
}
