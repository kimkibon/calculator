package com.nueral.calculator.service.algorithm;

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
        SubAlgorithm subAlgorithm2 = subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(algorithmType,subOpt2).orElseGet(()->subAlgorithmRepository.findAllByAlgorithmTypeAndSubOpt(AlgorithmType.all,subOpt).get());
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

}
