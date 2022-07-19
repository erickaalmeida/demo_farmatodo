package com.example.demo.repositories;

import org.json.JSONObject;

import java.net.MalformedURLException;

public interface ApiThirdParty {
    public JSONObject getData(Long id) throws MalformedURLException;
}
