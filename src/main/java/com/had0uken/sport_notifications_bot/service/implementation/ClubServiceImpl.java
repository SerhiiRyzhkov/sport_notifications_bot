package com.had0uken.sport_notifications_bot.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.had0uken.sport_notifications_bot.model.Club;
import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.repository.ClubRepository;
import com.had0uken.sport_notifications_bot.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ClubServiceImpl implements ClubService {
    @Autowired
    private ClubRepository clubRepository;


  /*  public void parseAndSaveClubsFromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        League league = new League(); // You may set the league properties accordingly

        // Deserialize the JSON into an array of Club objects
        Club[] clubs = objectMapper.readValue(json, Club[].class);

        // Set the league for each club
        for (Club club : clubs) {
            club.setLeague(league);
        }

        // Save the clubs to the database
        clubRepository.saveAll(Arrays.asList(clubs));
    }*/
}
