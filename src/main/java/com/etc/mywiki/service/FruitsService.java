package com.etc.mywiki.service;

import com.etc.mywiki.domain.Fruits;
import com.etc.mywiki.mapper.FruitsMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitsService {

    @Resource
    private FruitsMapper fruitsMapper;
    public List<Fruits> AllFruits(){
        return fruitsMapper.getFruits();
    }

    public List<Fruits> FruitsByName(String f_name){
        return fruitsMapper.getFruitsByName(f_name);
    }
}
