package com.nueral.calculator.service.algorithm;

import com.nueral.calculator.dto.AlgorithmDto.*;
import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.algorithm.AlgorithmRepository;
import com.nueral.calculator.repository.algorithm.MainAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SetAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SubAlgorithmRepository;
import com.nueral.calculator.types.AlgorithmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


/**
    public void saveAlgorithm(
            String charactersName, AlgorithmType,
            String setAlgorithmName , String mainOpt,
            String subOpt , String subOpt2){

        SetAlgorithm setAlgorithm = setAlgorithmRepository.getReferenceById(setAlgorithmName);
        MainAlgorithm mainAlgorithm = mainAlgorithmRepository.getReferenceById(mainOpt);
        SubAlgorithm subAlgorithm = subAlgorithmRepository.getReferenceById(subOpt);
        SubAlgorithm subAlgorithm2 = subAlgorithmRepository.getReferenceById(subOpt2);
        Characters characters = characterRepository.getReferenceById(charactersName);

        Algorithm algorithm = Algorithm.builder()
                .algorithmType(algorithmType)
                .setAlgorithm(setAlgorithm)
                .subAlgorithm(subAlgorithm)
                .characters(characters)
                .mainAlgorithm(mainAlgorithm)
                .subAlgorithm2(subAlgorithm2)
                .build();

        algorithmRepository.save(algorithm);

    }

    public void saveMainAlgorithm(AlgorithmType algorithmType , String mainOpt){
        MainAlgorithm mainAlgorithm = MainAlgorithm.builder()
                .algorithmType(algorithmType)
                .mainOpt(mainOpt)
                .build();

        mainAlgorithmRepository.save(mainAlgorithm);

    }

    public void saveSubAlgorithm(AlgorithmType algorithmType , String subOpt){

        SubAlgorithm subAlgorithm = SubAlgorithm.builder()
                .algorithmType(algorithmType)
                .subOpt(subOpt)
                .build();

        subAlgorithmRepository.save(subAlgorithm);
    }

    public void saveSetAlgorithm(String setAlgorithmName,
                                 AlgorithmType , String twoSetOpt,
                                 String threeSetOpt){

        SetAlgorithm setAlgorithm = SetAlgorithm.builder()
                .algorithmType(algorithmType)
                .setAlgorithmName(setAlgorithmName)
                .threeSetOpt(threeSetOpt)
                .twoSetOpt(twoSetOpt)
                .build();

        setAlgorithmRepository.save(setAlgorithm);

    }
*/

    public String saveAlgorithmByDto(AlgorithmSaveDtoList algorithmSaveDtoList){
        try{
        for(AlgorithmSaveDto dto :algorithmSaveDtoList.getAlgorithmSaveDto()) {

            AlgorithmType algorithmType;
            switch (dto.getAlgorithmType()){
                case "공격성" : algorithmType = AlgorithmType.atk;
                    break;
                case "안정성" : algorithmType = AlgorithmType.def;
                    break;
                case "특이성" : algorithmType = AlgorithmType.spc;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + dto.getAlgorithmType());
            }
            Algorithm algorithm = Algorithm.builder()
                    .algorithmType(algorithmType)
                    .setAlgorithm(setAlgorithmRepository.getReferenceById(dto.getSetAlgorithm()))
                    .subAlgorithm(subAlgorithmRepository.getReferenceById(dto.getSubAlgorithm()))
                    .characters(characterRepository.getReferenceById(dto.getCharacterName()))
                    .mainAlgorithm(mainAlgorithmRepository.getReferenceById(dto.getMainAlgorithm()))
                    .subAlgorithm2(subAlgorithmRepository.getReferenceById(dto.getSubAlgorithm2()))
                    .build();
            algorithmRepository.save(algorithm);
        } return "home";
        } catch (Exception e){
            System.out.println("오류가 발생했습니다 : "+e.getMessage());
            return "saveError";
        }
    }

    public AlgorithmSaveDtoList saveAlgorithmPro(String name){
        List<Algorithm> algorithmList = algorithmRepository.findByCharacterName(name);
        AlgorithmSaveDtoList algorithmSaveDtolist;
        if(algorithmList.isEmpty()){
            List<AlgorithmSaveDto> algorithmSaveDtoList = new ArrayList<>();
            for(int i = 0; i <3; i++){
                switch (i) {
                    case 0 :algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.atk.getType()));
                    break;
                    case 1 : algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.def.getType()));
                    break;
                    case 2 : algorithmSaveDtoList.add(new AlgorithmSaveDto(name, AlgorithmType.spc.getType()));
                    break;
                }
            }
            algorithmSaveDtolist = new AlgorithmSaveDtoList(algorithmSaveDtoList);
        } else {
            algorithmSaveDtolist = new AlgorithmSaveDtoList(algorithmList.stream().map(AlgorithmSaveDto::new).collect(Collectors.toList()));
        }

        return algorithmSaveDtolist;
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
