package com.nueral.calculator.service.algorithm;

import com.nueral.calculator.dto.save.AlgorithmSaveDto;
import com.nueral.calculator.entity.Characters;
import com.nueral.calculator.entity.algorithm.Algorithm;
import com.nueral.calculator.entity.algorithm.MainAlgorithm;
import com.nueral.calculator.entity.algorithm.SetAlgorithm;
import com.nueral.calculator.entity.algorithm.SubAlgorithm;
import com.nueral.calculator.repository.CharacterRepository;
import com.nueral.calculator.repository.algorithm.AlgorithmRepository;
import com.nueral.calculator.repository.algorithm.MainAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SetAlgorithmRepository;
import com.nueral.calculator.repository.algorithm.SubAlgorithmRepository;
import com.nueral.calculator.types.AlgorithmType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    public void saveAlgorithm(
            String charactersName, AlgorithmType algorithmType,
            String setAlgorithmName , String mainOpt,
            String subOpt , String subOpt2){

        SetAlgorithm setAlgorithm = setAlgorithmRepository.findAllByAlgorithmTypeAndSetAlgorithmName(algorithmType , setAlgorithmName).get();
        MainAlgorithm mainAlgorithm = mainAlgorithmRepository.findAllByAlgorithmTypeAndMainOpt(algorithmType , mainOpt).orElseGet(()->mainAlgorithmRepository.findAllByAlgorithmTypeAndMainOpt(AlgorithmType.all,mainOpt).get());
        SubAlgorithm subAlgorithm = subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(algorithmType,subOpt).orElseGet(()->subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(AlgorithmType.all,subOpt).get());
        SubAlgorithm subAlgorithm2 = subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(algorithmType,subOpt2).orElseGet(()->subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(AlgorithmType.all,subOpt2).get());
        Characters characters = characterRepository.findByName(charactersName).get();

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

    public String saveAlgorithmByDto(List<AlgorithmSaveDto> algorithmSaveDto){
        try{
        for(AlgorithmSaveDto dto :algorithmSaveDto) {
            AlgorithmType algorithmType = AlgorithmType.valueOf(dto.getAlgorithmType());
            String setAlgorithmName = dto.getSetAlgorithm();
            String mainOpt = dto.getMainAlgorithm();
            String subOpt = dto.getSubAlgorithm();
            String subOpt2 = dto.getSubAlgorithm2();
            String charactersName = dto.getCharacterName();

            SetAlgorithm setAlgorithm = setAlgorithmRepository.findAllByAlgorithmTypeAndSetAlgorithmName(algorithmType, setAlgorithmName).get();
            MainAlgorithm mainAlgorithm = mainAlgorithmRepository.findAllByAlgorithmTypeAndMainOpt(algorithmType, mainOpt).orElseGet(() -> mainAlgorithmRepository.findAllByAlgorithmTypeAndMainOpt(AlgorithmType.all, mainOpt).get());
            SubAlgorithm subAlgorithm = subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(algorithmType, subOpt).orElseGet(() -> subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(AlgorithmType.all, subOpt).get());
            SubAlgorithm subAlgorithm2 = subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(algorithmType, subOpt2).orElseGet(() -> subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(AlgorithmType.all, subOpt2).get());
            Characters characters = characterRepository.findByName(charactersName).get();

            Algorithm algorithm = Algorithm.builder()
                    .algorithmType(algorithmType)
                    .setAlgorithm(setAlgorithm)
                    .subAlgorithm(subAlgorithm)
                    .characters(characters)
                    .mainAlgorithm(mainAlgorithm)
                    .subAlgorithm2(subAlgorithm2)
                    .build();
            algorithmRepository.save(algorithm);
        } return "/home";
        } catch (Exception e){
            return "/saveError";
        }
//To do;
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
                                 AlgorithmType algorithmType , String twoSetOpt,
                                 String threeSetOpt){

        SetAlgorithm setAlgorithm = SetAlgorithm.builder()
                .algorithmType(algorithmType)
                .setAlgorithmName(setAlgorithmName)
                .threeSetOpt(threeSetOpt)
                .twoSetOpt(twoSetOpt)
                .build();

        setAlgorithmRepository.save(setAlgorithm);

    }

    public Map<String,Object> saveAlgorithmPro(){
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("set",setAlgorithmRepository.findAll());
        objectMap.put("main",mainAlgorithmRepository.findAll());
        objectMap.put("sub",subAlgorithmRepository.findAll());
        return objectMap;
    }

}
