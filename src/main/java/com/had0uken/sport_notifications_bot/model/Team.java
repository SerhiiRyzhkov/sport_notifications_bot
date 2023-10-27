package com.had0uken.sport_notifications_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team implements Serializable {
    private static final long serialVersionUID = -4824171355003629367L;
    @Transient
    @JsonProperty("rnk")
    private int rnk;

    @Id
    @JsonProperty("Tid")
    @Column(name = "team_id")
    private Long Tid;

    @Transient
    @JsonProperty("win")
    private int win;

    @Transient
    @JsonProperty("winn")
    private String winn;

    @Transient
    @JsonProperty("wreg")
    private int wreg;

    @Transient
    @JsonProperty("wap")
    private int wap;

    @Transient
    @JsonProperty("pf")
    private int pf;

    @Transient
    @JsonProperty("pa")
    private int pa;

    @Transient
    @JsonProperty("wot")
    private int wot;

    @Column(name = "team_name")
    @JsonProperty("Tnm")
    private String Tnm;

    @Transient
    @JsonProperty("lst")
    private int lst;

    @Transient
    @JsonProperty("lstn")
    private String lstn;

    @Transient
    @JsonProperty("lreg")
    private int lreg;

    @Transient
    @JsonProperty("lot")
    private int lot;

    @Transient
    @JsonProperty("lap")
    private int lap;

    @Transient
    @JsonProperty("drw")
    private int drw;

    @Transient
    @JsonProperty("drwn")
    private String drwn;

    @Transient
    @JsonProperty("gf")
    private int gf;

    @Transient
    @JsonProperty("ga")
    private int ga;

    @Transient
    @JsonProperty("gd")
    private int gd;

    @Transient
    @JsonProperty("ptsn")
    private String ptsn;

    @JsonProperty("phr")
    @Transient
    private List<Integer> phr;

    @Transient
    @JsonProperty("Ipr")
    private int Ipr;

    @Transient
    @JsonProperty("Img")
    private String Img;

    @Transient
    @JsonProperty("pts")
    private int pts;

    @Transient
    @JsonProperty("pld")
    private int pld;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    @JsonIgnore
    @ToString.Exclude
    private League league;

}