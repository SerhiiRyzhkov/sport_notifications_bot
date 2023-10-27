package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class TableData implements Serializable {
    @Serial
    private static final long serialVersionUID = 2176421776094841531L;
    @JsonProperty("LTT")
    private int LTT;
    @JsonProperty("team")
    private List<Team> team;

    @JsonIgnore
    private List<PhrX> phrX; // You should replace "SomeOtherType" with the actual data type of "phrX"
}
