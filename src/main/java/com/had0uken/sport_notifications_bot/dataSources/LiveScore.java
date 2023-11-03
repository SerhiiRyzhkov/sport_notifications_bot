package com.had0uken.sport_notifications_bot.dataSources;
import com.had0uken.sport_notifications_bot.enums.Category;
import com.had0uken.sport_notifications_bot.enums.Country;
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


}
