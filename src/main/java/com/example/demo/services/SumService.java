package com.example.demo.services;

import com.example.demo.models.NaturalNumberModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SumService {

    public String getSum(Long number)
    {
        String response = new String();
        try {
            Long count = Long.valueOf(0);
            Long sum = Long.valueOf(0);
            do {
                sum = sum + count;
                count++;
            } while (count <= number);
            NaturalNumberModel naturalNumberModel = new NaturalNumberModel();
            naturalNumberModel.setResult(sum);
            ObjectMapper obj = new ObjectMapper();
            response = obj.writeValueAsString(naturalNumberModel);
            return response;
        } catch (Exception e) {
            response = "No se pudo realizar la sumatoria";
            return response;
        }
    }
}
