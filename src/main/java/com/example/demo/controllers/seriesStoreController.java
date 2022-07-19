package com.example.demo.controllers;

import com.example.demo.repositories.ApiThirdParty;
import com.example.demo.repositories.RickAndMortyApi;
import com.example.demo.services.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episode")
public class seriesStoreController {

    @Autowired
    private RickAndMortyService rickAndMortyService;

    public void setRickAndMortyService(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping(path = "/{id}")
    public String getEpisode(@PathVariable("id") Long id){
        String response = new String();
        try {
            response = this.rickAndMortyService.getEpisode(id);
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
