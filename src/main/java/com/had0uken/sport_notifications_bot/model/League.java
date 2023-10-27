package com.had0uken.sport_notifications_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leagues")
public class League implements Serializable {
    private static final long serialVersionUID = 5787545020193329483L;

    @Id
    @JsonProperty("Sid")
    @Column(name = "league_id")
    private Long Sid;

    @Column(name = "league_name")
    @JsonProperty("Snm")
    private String Snm;


    @JsonProperty("Scd")
    private String Scd;

    @Transient
    @JsonProperty("badgeUrl")
    private String badgeUrl;

    @Transient
    @JsonProperty("firstColor")
    private String firstColor;

    @Transient
    @JsonProperty("Cid")
    private String Cid;

    @Transient
    @JsonProperty("Cnm")
    private String Cnm;

    @Transient
    @JsonProperty("Csnm")
    private String Csnm;


    @JsonProperty("Ccd")
    private String Ccd;

    @Transient
    @JsonProperty("CompId")
    private String CompId;

    @Column(name = "league_country")
    @JsonProperty("CompN")
    private String CompN;

    @Transient
    @JsonProperty("CompD")
    private String CompD;

    @Transient
    @JsonProperty("CompST")
    private String CompST;

    @Transient
    @JsonProperty("Scu")
    private int Scu;

    @Transient
    @JsonProperty("Sds")
    private String Sds;

    @Transient
    @JsonProperty("Chi")
    private int Chi;

    @Transient
    @JsonProperty("Shi")
    private int Shi;

    @Transient
    @JsonProperty("Ccdiso")
    private String Ccdiso;

    @Transient
    @JsonProperty("Sdn")
    private String Sdn;

    @Transient
    @JsonProperty("LeagueTable")
    private LeagueTable LeagueTable;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "league")
    private List<Team> teams = new ArrayList<>();

    public League(Long sid, String snm, String compN) {
        Sid = sid;
        Snm = snm;
        CompN = compN;
    }
}