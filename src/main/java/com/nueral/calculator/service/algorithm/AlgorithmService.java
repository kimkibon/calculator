package com.nueral.calculator.service.algorithm;

import com.nueral.calculator.dto.AlgorithmDto.*;
import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.algorithm.SetAlgorithm;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.algorithm.AlgorithmRepository;
import com.nueral.calculator.repository.algorithm.MainAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SetAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SubAlgorithmRepository;
import com.nueral.calculator.types.AlgorithmType;
import com.nueral.calculator.utils.FindTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlgorithmService {
    @Autowired
    private AlgorithmRepository algorithmRepository;
    @Autowired
    private MainAlgorithmRepository mainAlgorithmRepository;
    @Autowired
    private SubAlgorithmRepository subAlgorithmRepository;
    @Autowired
    private SetAlgorithmRepository setAlgorithmRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private FindTypes findTypes;

    @Transactional
    public void saveAlgorithmByDto(AlgorithmSaveDtoList algorithmSaveDtoList){
        try{
        for(AlgorithmSaveDto dto :algorithmSaveDtoList.getAlgorithmSaveDto()) {
            Algorithm algorithm = Algorithm.builder()
                    .algorithmType(findTypes.findAlgorithmTypeByName(dto.getAlgorithmType()))
                    .setAlgorithm(setAlgorithmRepository.getReferenceById(dto.getSetAlgorithm()))
                    .subAlgorithm(subAlgorithmRepository.getReferenceById(dto.getSubAlgorithm()))
                    .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                    .mainAlgorithm(mainAlgorithmRepository.getReferenceById(dto.getMainAlgorithm()))
                    .subAlgorithm2(subAlgorithmRepository.getReferenceById(dto.getSubAlgorithm2()))
                    .build();
            algorithmRepository.save(algorithm);
        }
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
        }
    }

    public AlgorithmSaveDtoList saveAlgorithmPro(String name){
        List<Algorithm> algorithmList = algorithmRepository.findByCharacterName(name);
        AlgorithmSaveDtoList algorithmSaveDtolist;
        if(algorithmList.isEmpty()){
            List<AlgorithmSaveDto> algorithmSaveDtoList = new ArrayList<>();

            algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.atk.getType()));
            algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.def.getType()));
            algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.spc.getType()));

            algorithmSaveDtolist = new AlgorithmSaveDtoList(algorithmSaveDtoList);
        } else {
            algorithmSaveDtolist = new AlgorithmSaveDtoList(algorithmList.stream().map(AlgorithmSaveDto::new).collect(Collectors.toList()));
        }

        return algorithmSaveDtolist;
    }

    @Transactional
    public String saveSetAlgorithmList(SetAlgorithmDtoList setAlgorithmDtoList){
        try {
            for(SetAlgorithmDto dto : setAlgorithmDtoList.getSetAlgorithmList()){
                SetAlgorithm setAlgorithm = SetAlgorithm.builder()
                        .setAlgorithmName(dto.getSetAlgorithmName())
                        .algorithmType(findTypes.findAlgorithmTypeByName(dto.getType()))
                        .puckUpDay(dto.getPickUpDay())
                        .twoSetOpt(dto.getTwoSetOpt())
                        .threeSetOpt(dto.getThreeSetOpt())
                        .build();
                setAlgorithmRepository.save(setAlgorithm);
            } return "redirect:/home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다. : " + e.getMessage());
            return "redirect:/saveError";
        }
    }

    public List<MainAlgorithmDto> mainAlgorithmDtoList(){
        return mainAlgorithmRepository.findAll().stream().map(MainAlgorithmDto::new).collect(Collectors.toList());
    }

    public List<SetAlgorithmDto> setAlgorithmDtoList(){
        return setAlgorithmRepository.findAll().stream().map(SetAlgorithmDto::new).collect(Collectors.toList());
    }

    public List<SubAlgorithmDto> subAlgorithmDtoList(){
        return subAlgorithmRepository.findAll().stream().map(SubAlgorithmDto::new).collect(Collectors.toList());
    }

}
