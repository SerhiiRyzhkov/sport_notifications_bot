package com.had0uken.sport_notifications_bot.service;

import com.had0uken.sport_notifications_bot.model.League;

import java.util.List;

public interface LeagueService {
    void saveLeagues(List<League> leagues);
    void saveLeague(League league);
}
