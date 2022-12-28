package com.nueral.calculator.service.friendship;

import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.friendship.*;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.friendship.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    private AllGoodsRepository allGoodsRepository;
    @Autowired
    private GoodsCharacterRepository goodsCharacterRepository;
    @Autowired
    private GoodsStatusRepository goodsStatusRepository;
    @Autowired
    private GoodsStatusLevelRepository goodsStatusLevelRepository;
    @Autowired
    private GoodsStatusCharacterRepository goodsStatusCharacterRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public void saveAllGoods(String name , int goodsLevel , int likeExp , int hateExp , int normalExp){

        AllGoods allGoods = AllGoods.builder()
                .name(name)
                .goodsLevel(goodsLevel)
                .likeExp(likeExp)
                .hateExp(hateExp)
                .normalExp(normalExp)
                .build();
        allGoodsRepository.save(allGoods);

    }


    public void saveGoodsStatus(String name , String status){

        GoodsStatus goodsStatus = GoodsStatus.builder()
                .name(name)
                .status(status)
                .build();

        goodsStatusRepository.save(goodsStatus);

    }

    public void saveGoodsStatusLevel(String goodsStatusName , int statusLevel , double status){

        GoodsStatus goodsStatus = goodsStatusRepository.findByName(goodsStatusName);

        GoodsStatusLevel goodsStatusLevel = GoodsStatusLevel.builder()
                .goodsStatus(goodsStatus)
                .statusLevel(statusLevel)
                .status(status)
                .build();

        goodsStatusLevelRepository.save(goodsStatusLevel);
    }

    public void saveGoodsCharacter(String characterName, String GoodsName, int goodsLike){
        Characters characters = characterRepository.findByName(characterName).get();
        AllGoods allGoods = allGoodsRepository.name(GoodsName);
        boolean like;
        if(goodsLike == 1){
            like = true;
        } else {
            like = false;
        }

        GoodsCharacter.builder()
                .goodsLike(like)
                .allGoods(allGoods)
                .characters(characters)
                .build();
    }

    public void GoodsStatusCharacter(String characterName, String goodsStatusName , int statusLevel){

        Characters characters = characterRepository.findByName(characterName).get();
        GoodsStatus goodsStatus = goodsStatusRepository.findByName(goodsStatusName);

        GoodsStatusCharacter goodsStatusCharacter = GoodsStatusCharacter.builder()
                .characters(characters)
                .goodsStatus(goodsStatus)
                .statusLevel(statusLevel)
                .build();

        goodsStatusCharacterRepository.save(goodsStatusCharacter);
    }
}
