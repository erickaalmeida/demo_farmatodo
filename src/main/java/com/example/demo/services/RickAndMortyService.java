package com.example.demo.services;

import com.example.demo.repositories.RickAndMortyApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class RickAndMortyService {
    @Autowired
    RickAndMortyApi rickAndMortyApi;

    public void setRickAndMortyApi(RickAndMortyApi rickAndMortyApi) {
        this.rickAndMortyApi = rickAndMortyApi;
    }
    public String getEpisode(@PathVariable("id") Long id){
        String response = new String();
        try {
            response = this.rickAndMortyApi.getData(id).toString();
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
