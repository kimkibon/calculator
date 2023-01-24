package com.nueral.calculator.controller.informationController;

import com.nueral.calculator.dto.board.BoardDto;
import com.nueral.calculator.service.Board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @PostMapping(value = "/insert")
    public String saveBoard(@ModelAttribute BoardDto boardDto){
        boardService.saveBoard(boardDto);
        return "home";
    }
}
