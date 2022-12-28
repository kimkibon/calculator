package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.AllGoods;
import com.nueral.calculator.entity.friendship.GoodsStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllGoodsRepository extends JpaRepository<AllGoods , String> {

    AllGoods name(String goodsName);
}

