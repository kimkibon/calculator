package com.nueral.calculator.repository.Board;

import com.nueral.calculator.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board , Integer> {
}
