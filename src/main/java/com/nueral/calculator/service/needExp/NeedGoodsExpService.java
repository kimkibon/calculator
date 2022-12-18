package com.nueral.calculator.service.needExp;

import com.nueral.calculator.entity.needExp.NeedGoods;
import com.nueral.calculator.repository.needExp.NeedGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NeedGoodsExpService {
    @Autowired
    private NeedGoodsRepository goodsRepository;

    public void saveGoodsExp(int friendlyLevel , int exp){
        NeedGoods needGoods = NeedGoods.builder()
                .exp(exp)
                .friendlyLevel(friendlyLevel)
                .build();

        goodsRepository.save(needGoods);

    }
}
