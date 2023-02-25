package com.nueral.calculator.service.friendship;

import com.nueral.calculator.dto.goodsDto.*;
import com.nueral.calculator.entity.friendship.AllGoods;
import com.nueral.calculator.entity.friendship.GoodsCharacter;
import com.nueral.calculator.entity.friendship.GoodsStatusCharacter;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.friendship.AllGoodsRepository;
import com.nueral.calculator.repository.friendship.GoodsCharacterRepository;
import com.nueral.calculator.repository.friendship.GoodsStatusCharacterRepository;
import com.nueral.calculator.repository.friendship.GoodsStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Autowired
    private AllGoodsRepository allGoodsRepository;
    @Autowired
    private GoodsCharacterRepository goodsCharacterRepository;
    @Autowired
    private GoodsStatusRepository goodsStatusRepository;
    @Autowired
    private GoodsStatusCharacterRepository goodsStatusCharacterRepository;
    @Autowired
    private CharacterRepository characterRepository;

    public GoodsCharacterSaveDtoList saveGoodsCharacterPro(String name){
        List<GoodsCharacter> goodsCharacterList = goodsCharacterRepository.findAllByCharacterName(name);
        GoodsCharacterSaveDtoList goodsCharacterSaveDtoList;
        if(goodsCharacterList.isEmpty()){

            List<GoodsCharacterSaveDto> saveDtoList = new ArrayList<>();

            saveDtoList.add(new GoodsCharacterSaveDto(name));
            goodsCharacterSaveDtoList = new GoodsCharacterSaveDtoList(saveDtoList);
        } else {

            goodsCharacterSaveDtoList =
                    new GoodsCharacterSaveDtoList(goodsCharacterList.stream()
                            .sorted((c1 , c2) -> c2.getAllGoods().getGoodsLevel() - c1.getAllGoods().getGoodsLevel())
                            .map(GoodsCharacterSaveDto::new)
                            .collect(Collectors.toList()));
        }
        return goodsCharacterSaveDtoList;
    }
    @Transactional
    public void saveGoodsCharacter(GoodsCharacterSaveDtoList goodsCharacterSaveDtoList , String name){
        try{
            goodsCharacterRepository.deleteByCharacterName(name);
            goodsCharacterRepository.flush();
            List<GoodsCharacter> goodsCharacterList = new ArrayList<>();
            for(GoodsCharacterSaveDto dto : goodsCharacterSaveDtoList.getGoodsCharacterSaveDto()){
                GoodsCharacter goodsCharacter = GoodsCharacter.builder()
                        .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                        .allGoods(allGoodsRepository.getReferenceById(dto.getGoodsName()))
                        .build();
                goodsCharacterList.add(goodsCharacterRepository.save(goodsCharacter));
            }
            goodsCharacterRepository.saveAll(goodsCharacterList);
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
        }
    }

    public GoodsStatusCharacterSaveDtoList saveGoodsStatusCharacterPro(String name){
        List<GoodsStatusCharacter> goodsStatusCharacters = goodsStatusCharacterRepository.findAllByCharacterName(name);
        GoodsStatusCharacterSaveDtoList goodsStatusCharacterDtoList;
        if(goodsStatusCharacters.isEmpty()){
            List<GoodsStatusCharacterSaveDto> saveDtoList = new ArrayList<>();
            saveDtoList.add(new GoodsStatusCharacterSaveDto(name,"",1));
            saveDtoList.add(new GoodsStatusCharacterSaveDto(name,"",2));
            saveDtoList.add(new GoodsStatusCharacterSaveDto(name,"",3));
            goodsStatusCharacterDtoList = new GoodsStatusCharacterSaveDtoList(saveDtoList);
        } else {
            goodsStatusCharacterDtoList =
                    new GoodsStatusCharacterSaveDtoList(goodsStatusCharacters.stream()
                            .sorted(Comparator.comparingInt(GoodsStatusCharacter::getStatusLevel)).map(GoodsStatusCharacterSaveDto::new).collect(Collectors.toList()));
        }
        return goodsStatusCharacterDtoList;
    }

    public void saveGoodsStatusCharacter(GoodsStatusCharacterSaveDtoList goodsStatusCharacterSaveDtoList){
        try{
            for(GoodsStatusCharacterSaveDto dto : goodsStatusCharacterSaveDtoList.getGoodsStatusCharacterDto()){
                GoodsStatusCharacter goodsStatusCharacter = GoodsStatusCharacter.builder()
                        .goodsStatus(goodsStatusRepository.getReferenceById(dto.getStatusName()))
                        .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                        .statusLevel(dto.getStatusLevel())
                        .build();
                goodsStatusCharacterRepository.save(goodsStatusCharacter);
            }
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
        }
    }

    public List<AllGoodsDto> allGoodsList(){
        return allGoodsRepository
                .findAll().stream()
                .sorted(Comparator.comparingInt(AllGoods::getGoodsLevel).reversed())
                .map(AllGoodsDto::new).collect(Collectors.toList());
    }

    public List<AllGoodsStatusDto> allGoodsStatusDtoList(){
        return goodsStatusRepository
                .findAll().stream()
                .map(AllGoodsStatusDto::new).collect(Collectors.toList());
    }

}
