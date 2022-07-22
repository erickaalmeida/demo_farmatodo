package com.example.demo.useCases;

import com.example.demo.models.NumbersModel;
import com.example.demo.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HappyNumbers implements IHappyNumbers{
    @Autowired
    private SumService sumService;

    @Override
    public ArrayList<NumbersModel> getHappyNumbers(Integer[] numbers) {
        ArrayList<NumbersModel> responseNumbers = new ArrayList<NumbersModel>();
        for (int i=0; i < numbers.length; i++) {
            Integer number = numbers[i];
            boolean isHappy = sumService.isHappy(number);
            NumbersModel NumberObj = new NumbersModel();
            NumberObj.setNumber(number);
            NumberObj.setIsHappy(isHappy);
            responseNumbers.add(NumberObj);
        }
        return responseNumbers;
    }
}
