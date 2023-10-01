package com.had0uken.sport_notifications_bot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Stage")
public class Stage implements Serializable {
    @Id
    @JsonProperty("Sid")
    private String sid;

    @JsonProperty("Snm")
    private String snm;

    @JsonProperty("Scd")
    private String scd;

    @JsonProperty("badgeUrl")
    private String badgeUrl;

    @JsonProperty("firstColor")
    private String firstColor;

    @JsonProperty("Cid")
    private String cid;

    @JsonProperty("Cnm")
    private String cnm;

    @JsonProperty("Csnm")
    private String csnm;

    @JsonProperty("Ccd")
    private String ccd;

    @JsonProperty("CompId")
    private String compId;

    @JsonProperty("CompN")
    private String compN;

    @JsonProperty("CompD")
    private String compD;

    @JsonProperty("CompST")
    private String compST;

    @JsonProperty("Scu")
    private int scu;

    @JsonProperty("Sds")
    private String sds;

    @JsonProperty("Chi")
    private int chi;

    @JsonProperty("Shi")
    private int shi;

    @JsonProperty("Ccdiso")
    private String ccdiso;

    @JsonProperty("Sdn")
    private String sdn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stage")
    @JsonProperty("Events")
    private List<Event> events;
}
