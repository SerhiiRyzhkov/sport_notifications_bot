package com.had0uken.sport_notifications_bot.dataSources;
import com.had0uken.sport_notifications_bot.enums.Category;
import com.had0uken.sport_notifications_bot.enums.Country;
import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.model.LeagueData;
import com.had0uken.sport_notifications_bot.model.Team;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class LiveScore implements Scorer {

    @Value("${account.key}")
    String key;

    @Value("${account.host}")
    String host;

    @Override
    public List<Team> getTeamsByCategoryAndLeague(Category category, League league) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "https://livescore6.p.rapidapi.com/matches/v2/get-table?Category="+
                category.toString().toLowerCase()+
                "&Eid="+
                league.getSid();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("X-RapidAPI-Key", key)
                .addHeader("X-RapidAPI-Host", host)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {


                    System.out.println();
                    return new ArrayList<>(LeagueData.parseJson(responseBody.string()).getStages().get(0).getLeagueTable().
                            getL().get(0).getTables().get(0).getTeam());
                }
            } else {
                System.out.println("HTTP request failed with status code: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
