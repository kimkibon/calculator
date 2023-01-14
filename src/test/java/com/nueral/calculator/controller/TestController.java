package com.nueral.calculator.controller;

import com.nueral.calculator.types.AlgorithmType;
import com.nueral.calculator.types.AreaType;
import com.nueral.calculator.types.DealType;
import org.junit.jupiter.api.Test;

class TestController {

    @Test
    public void algorithmTypeTest(){
        System.out.println(AlgorithmType.atk.getType());
        System.out.println(DealType.ap.getType());
        System.out.println(AreaType.target.getType());
        System.out.println(AreaType.valueOf("target"));

    }

}
