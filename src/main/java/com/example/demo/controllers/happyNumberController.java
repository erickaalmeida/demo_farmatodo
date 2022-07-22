package com.example.demo.controllers;

import com.example.demo.models.ListNumberModel;
import com.example.demo.models.NumbersModel;
import com.example.demo.models.RequestNumber;
import com.example.demo.useCases.IHappyNumbers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/happy-numbers")
public class happyNumberController {
    @Autowired
    private IHappyNumbers happyNumbers;

    @PostMapping()
    public String getHappyNumbers(@RequestBody RequestNumber requestNumber)
    {
        try {
            ArrayList<NumbersModel> numbers = happyNumbers.getHappyNumbers(requestNumber.getNumbers());
            ListNumberModel listNumber = new ListNumberModel();
            listNumber.setNumbers(numbers);
            ObjectMapper obj = new ObjectMapper();
            String response = obj.writeValueAsString(listNumber);
            return response;
        } catch (Exception e) {
            return "No es posible calcular si el número es feliz o no";
        }
    }
}
