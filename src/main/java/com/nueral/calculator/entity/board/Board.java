package com.nueral.calculator.entity.board;

import com.nueral.calculator.dto.board.BoardDto;
import com.nueral.calculator.entity.DefaultEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor
@DynamicUpdate
@DynamicInsert
public class Board extends DefaultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idx;
    private String tag;
    private String title;
    private String text;

    public Board(BoardDto boardDto){
        this.title = boardDto.getTitle();
        this.text = boardDto.getText();
        this.tag = boardDto.getTag();
        this.idx = boardDto.getIdx();
    }
}
