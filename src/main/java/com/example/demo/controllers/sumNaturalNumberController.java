package com.example.demo.controllers;

import com.example.demo.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sum")
public class sumNaturalNumberController {
    @Autowired
    private SumService sumService;

    @GetMapping(path = "/{number}")
    public String getSum(@PathVariable("number") Long number) {
        return sumService.getSum(number);
    }
}
