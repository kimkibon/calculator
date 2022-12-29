package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsStatusRepository extends JpaRepository<GoodsStatus, String> {
    GoodsStatus findByName(String goodsStatus);
}
