package com.had0uken.sport_notifications_bot.dataSources;

import com.had0uken.sport_notifications_bot.enums.Category;
import com.had0uken.sport_notifications_bot.enums.Country;
import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.model.Team;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface Scorer {
    List<Team> getTeamsByCategoryAndLeague(Category category, League league) throws IOException;
}
