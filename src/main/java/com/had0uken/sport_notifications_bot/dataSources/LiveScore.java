package com.had0uken.sport_notifications_bot.dataSources;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@Component
public class LiveScore implements Scorer {


    @Value("${account.key}")
    String key;

    @Value("${account.host}")
    String host;
    @Override
    public String getList() throws IOException {
        URL apiUrl = new URL("https://livescore6.p.rapidapi.com/matches/v2/list-live?Category=soccer&Timezone=-7");

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Set the request headers
        connection.setRequestProperty("X-RapidAPI-Key", key);
        connection.setRequestProperty("X-RapidAPI-Host", host);

        // Set the timeout for the connection (optional)
        connection.setConnectTimeout(5000); // 5 seconds
        connection.setReadTimeout(5000);    // 5 seconds

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Check if the response code is OK (200)
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Create a BufferedReader to read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Return the response as a string
            return response.toString();
        } else {
            // Handle the error, e.g., by throwing an exception or returning an error message
            throw new IOException("HTTP GET request failed with response code: " + responseCode);
        }
    }
}
