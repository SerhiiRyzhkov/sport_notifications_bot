package com.had0uken.sport_notifications_bot.model;

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
public class LeagueTableEntry implements Serializable {
    @Serial
    private static final long serialVersionUID = 2410988760948619974L;
    @JsonProperty("Tables")
    private List<TableData> Tables;
    @JsonProperty("phrX")
    private List<TableData> phrX;

}
