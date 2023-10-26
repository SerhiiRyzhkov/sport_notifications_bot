package com.had0uken.sport_notifications_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
@Table(name = "leagueStages")
public class LeagueStage implements Serializable {
    private static final long serialVersionUID = 5787545020193329483L;

    @Id
    @JsonProperty("Sid")
    private String Sid;

    @JsonProperty("Snm")
    private String Snm;

    @JsonProperty("Scd")
    private String Scd;

    @JsonProperty("badgeUrl")
    private String badgeUrl;

    @JsonProperty("firstColor")
    private String firstColor;

    @JsonProperty("Cid")
    private String Cid;

    @JsonProperty("Cnm")
    private String Cnm;

    @JsonProperty("Csnm")
    private String Csnm;

    @JsonProperty("Ccd")
    private String Ccd;

    @JsonProperty("CompId")
    private String CompId;

    @JsonProperty("CompN")
    private String CompN;

    @JsonProperty("CompD")
    private String CompD;

    @JsonProperty("CompST")
    private String CompST;

    @JsonProperty("Scu")
    private int Scu;

    @JsonProperty("Sds")
    private String Sds;

    @JsonProperty("Chi")
    private int Chi;

    @JsonProperty("Shi")
    private int Shi;

    @JsonProperty("Ccdiso")
    private String Ccdiso;

    @JsonProperty("Sdn")
    private String Sdn;

    @JsonProperty("LeagueTable")
    private LeagueTable LeagueTable;
}