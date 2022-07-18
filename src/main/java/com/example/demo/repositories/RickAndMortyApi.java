package com.example.demo.repositories;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RickAndMortyApi implements ApiThirdParty {
    public void getData(Integer id) {
        try {
            URL urlRickMorty = new URL("https://rickandmortyapi.com/api");
            HttpURLConnection conn = (HttpURLConnection) urlRickMorty.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("ocurrió un error: " + responseCode + "id: "+ id);
            } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(urlRickMorty.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();

                System.out.println(informationString);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
