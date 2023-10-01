package com.had0uken.sport_notifications_bot.dataSources;

import java.io.IOException;
import java.net.MalformedURLException;

public interface Scorer {
    String getList() throws IOException;
}
