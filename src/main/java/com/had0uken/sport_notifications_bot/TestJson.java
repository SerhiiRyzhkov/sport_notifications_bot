package com.had0uken.sport_notifications_bot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TestJson {
    public static String getJson() {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("src/text.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
