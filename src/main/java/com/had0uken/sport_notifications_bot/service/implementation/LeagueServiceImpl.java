package com.had0uken.sport_notifications_bot.service.implementation;


import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.repository.LeagueRepository;
import com.had0uken.sport_notifications_bot.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueService {
    @Autowired
    private LeagueRepository leagueRepository;
    @Override
    public void saveLeagues(List<League> leagues) {
        leagueRepository.saveAll(leagues);
    }

    @Override
    public void saveLeague(League league) {
        leagueRepository.save(league);
    }
}
