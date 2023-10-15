package com.had0uken.sport_notifications_bot.dataloaders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.had0uken.sport_notifications_bot.TestJson;
import com.had0uken.sport_notifications_bot.model.Club;
import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.repository.ClubRepository;
import com.had0uken.sport_notifications_bot.repository.LeagueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClubsLoader implements CommandLineRunner {

    private final ClubRepository clubRepository;
    private final LeagueRepository leagueRepository;
    private final TestJson testJson;

    @Override
    public void run(String... args) throws Exception {
        String json = testJson.getJsonUkraine();
        ObjectMapper objectMapper = new ObjectMapper();

        // Parse the JSON into a JsonNode
        JsonNode rootNode = objectMapper.readTree(json);

        // Extract the "L" array containing club data
        JsonNode clubDataNode = rootNode.path("Stages").get(0).path("LeagueTable").path("L").get(0);

        // Extract club objects from the array
        List<Club> clubs = new ArrayList<>();
        for (JsonNode clubNode : clubDataNode.path("Tables").get(0).path("team")) {
            Club club = new Club();
            club.setId(clubNode.path("Tid").asLong());
            club.setName(clubNode.path("Tnm").asText());

            // You may need to set the league ID separately here

            clubs.add(club);
        }

        // Save the clubs to the database
        clubRepository.saveAll(clubs);
        }
    }

