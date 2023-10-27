package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LeagueData implements Serializable {
    @Serial
    private static final long serialVersionUID = -2070729524542282799L;
    @JsonProperty("Stages")
    private List<League> Stages;


    public static LeagueData parseJson(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, LeagueData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
