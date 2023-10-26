package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

public class LeagueTable implements Serializable {
    @Serial
    private static final long serialVersionUID = -9027580964511144711L;
    @JsonProperty("L")
    private List<LeagueTableEntry> L;
}
