package com.had0uken.sport_notifications_bot.dataloaders;

import com.had0uken.sport_notifications_bot.enums.Country;
import com.had0uken.sport_notifications_bot.model.League;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LeaguesLoader
        //implements CommandLineRunner
{

  /*  private final LeagueRepository leagueRepository;



    @Override
    public void run(String... args) {
    List<League> leagues = new ArrayList<>();
    *//*leagues.add(new League(14414L, Country.ENGLAND, "Premier League", new ArrayList<>()));
    leagues.add(new League(14500L, Country.SPAIN, "LaLiga", new ArrayList<>()));
    leagues.add(new League(14689L, Country.ITALY, "Serie A", new ArrayList<>()));
    leagues.add(new League(14579L, Country.NETHERLANDS, "Eredivisie", new ArrayList<>()));
    leagues.add(new League(14596L, Country.GERMANY, "Bundesliga", new ArrayList<>()));
    leagues.add(new League(14706L, Country.PORTUGAL, "Primeira Liga", new ArrayList<>()));
    leagues.add(new League(14712L, Country.UKRAINE, "Premier League", new ArrayList<>()));
    leagues.add(new League(14589L, Country.FRANCE, "Ligue 1", new ArrayList<>()));
*//*
        leagues.add(new League(65L, Country.ENGLAND, "Premier League", new ArrayList<>()));
        leagues.add(new League(75L, Country.SPAIN, "LaLiga", new ArrayList<>()));
        leagues.add(new League(77L, Country.ITALY, "Serie A", new ArrayList<>()));
        leagues.add(new League(64L, Country.NETHERLANDS, "Eredivisie", new ArrayList<>()));
        leagues.add(new League(67L, Country.GERMANY, "Bundesliga", new ArrayList<>()));
        leagues.add(new League(79L, Country.PORTUGAL, "Primeira Liga", new ArrayList<>()));
        leagues.add(new League(164L, Country.UKRAINE, "Premier League", new ArrayList<>()));
        leagues.add(new League(68L, Country.FRANCE, "Ligue 1", new ArrayList<>()));

        leagueRepository.saveAll(leagues);

    }*/
}
