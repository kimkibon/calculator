package com.nueral.calculator.dto.board;

import com.nueral.calculator.entity.board.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    int idx;
    String title;
    String text;
    String tag;

    public BoardDto(Board board){
        this.title = board.getTitle();
        this.text = board.getText();
        this.tag = board.getTag();
        this.idx = board.getIdx();
    }
}
