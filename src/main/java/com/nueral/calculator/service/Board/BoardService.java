package com.nueral.calculator.service.Board;

import com.nueral.calculator.dto.board.BoardDto;
import com.nueral.calculator.entity.board.Board;
import com.nueral.calculator.repository.Board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void saveBoard(BoardDto boardDto){
        boardRepository.save(new Board(boardDto));
    }
}
