package com.nueral.calculator.repository.friendship;

import com.nueral.calculator.entity.friendship.GoodsStatusLevel;
import com.nueral.calculator.entity.friendship.id.GoodsStatusLevelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsStatusLevelRepository extends JpaRepository<GoodsStatusLevel , GoodsStatusLevelId> {
}
