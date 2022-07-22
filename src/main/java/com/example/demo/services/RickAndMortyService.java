package com.example.demo.services;

import com.example.demo.models.PersonModel;
import com.example.demo.models.EpisodeModel;
import com.example.demo.models.LocationModel;
import com.example.demo.repositories.IEpisodeRepository;
import com.example.demo.repositories.ILocationRepository;
import com.example.demo.repositories.IPersonRepository;
import com.example.demo.repositories.RickAndMortyApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class RickAndMortyService {
    @Autowired
    RickAndMortyApi rickAndMortyApi;

    @Autowired
    private IEpisodeRepository episodeRepository;

    @Autowired
    private ILocationRepository locationRepository;

    @Autowired
    private IPersonRepository personRepository;

    public void setRickAndMortyApi(RickAndMortyApi rickAndMortyApi) {
        this.rickAndMortyApi = rickAndMortyApi;
    }
    public String getEpisode(@PathVariable("id") Long id){
        String response = new String();
        try {
            String urlEpisode = "https://rickandmortyapi.com/api/episode/" + id;
            JSONObject episode = this.rickAndMortyApi.getData(urlEpisode);
            JSONArray characters = episode.getJSONArray("characters");
            List<PersonModel> listCharacters = findCharacters(characters);
            EpisodeModel episodeData = new EpisodeModel();
            episodeData.setId(episode.getLong("id"));
            episodeData.setEpisode(episode.getLong("id"));
            episodeData.setEpisodeName(episode.getString("name"));
            episodeData.setPersonList(listCharacters);
            episodeRepository.save(episodeData);
            ObjectMapper obj = new ObjectMapper();
            response = obj.writeValueAsString(episodeData);
            return response;
        } catch (Exception e) {
            return "El episodio no existe";
        }
    }

    private List<PersonModel> findCharacters(JSONArray characters) {
        List<PersonModel> charactersInfo = new ArrayList<>();
        try {
            for (int i = 0; i < characters.length(); i++) {
                PersonModel characterInfo = getCharacter(characters.get(i).toString());
                charactersInfo.add(characterInfo);
            }
            return charactersInfo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private PersonModel getCharacter(String urlCharacter) {
        PersonModel characterData = new PersonModel();
        try {
            JSONObject character = this.rickAndMortyApi.getData(urlCharacter);
            JSONObject locationObj = character.getJSONObject("location");
            LocationModel locationData = getLocation(locationObj);
            characterData.setId(character.getLong("id"));
            characterData.setName(character.getString("name"));
            characterData.setGender(character.getString ("gender"));
            characterData.setSpecies(character.getString("species"));
            characterData.setImage(character.getString("image"));
            characterData.setLocation(locationData);
            personRepository.save(characterData);

            return characterData;
        } catch (Exception e) {
            return characterData;
        }

    }

    private LocationModel getLocation(JSONObject locationObj) {
        String urlLocation = locationObj.getString("url");
        JSONObject location = this.rickAndMortyApi.getData(urlLocation);
        LocationModel locationModel = new LocationModel();
        locationModel.setId(location.getLong("id"));
        locationModel.setName(locationObj.getString("name"));
        locationModel.setType(location.getString("type"));
        locationModel.setDimension(location.getString("dimension"));
        locationRepository.save(locationModel);
        return locationModel;
    }
}
