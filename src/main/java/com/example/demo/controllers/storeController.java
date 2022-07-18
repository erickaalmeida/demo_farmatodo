package com.example.demo.controllers;

import com.example.demo.repositories.RickAndMortyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodio")
public class storeController {
    @GetMapping()
    public void getEpisode(){
        try {
            Integer episode = 1;
            RickAndMortyApi rickAndMortyApi = new RickAndMortyApi();
            rickAndMortyApi.getData(episode);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
