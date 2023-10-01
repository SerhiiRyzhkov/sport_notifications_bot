package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Team")
public class Team implements Serializable {
    @Id
    @JsonProperty("ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @JsonProperty("Nm")
    private String nm;

    @JsonProperty("Img")
    private String img;

    @JsonProperty("NewsTag")
    private String newsTag;

    @JsonProperty("Abr")
    private String abr;

    @JsonProperty("tbd")
    private int tbd;

    @JsonProperty("Gd")
    private int gd;

    @JsonProperty("CoNm")
    private String coNm;

    @JsonProperty("CoId")
    private String coId;

    @JsonProperty("HasVideo")
    private boolean hasVideo;
}