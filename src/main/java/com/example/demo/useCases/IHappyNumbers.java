package com.example.demo.useCases;

import com.example.demo.models.NumbersModel;

import java.util.ArrayList;

public interface IHappyNumbers {
    public ArrayList<NumbersModel> getHappyNumbers(Integer[] numbers);
}
