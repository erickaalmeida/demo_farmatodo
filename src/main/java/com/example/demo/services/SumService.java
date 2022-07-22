package com.example.demo.services;

import com.example.demo.models.NaturalNumberModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.hibernate.collection.internal.PersistentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public int sumSquares(int number)
    {
        int sum = 0;
        int num = number;
        while (num > 9) {
            int unit = num % 10;
            sum = sum + (unit * unit);
            num = num / 10;
        }
        sum = sum + num * num;
        return sum;
    }

    public boolean isHappy(int number)
    {
        System.out.println(number);
        Integer n = number;
        List<Integer> previous = new ArrayList<Integer>();
        boolean stop = false;

        while (!stop) {
            if (n == 1)
                stop = true;
            else if (previous.contains(n))
                stop = true;
            else {
                previous.add(n);
                n = sumSquares(n);
            }
        }

        boolean happy = n == 1;
        return happy;
    }
}