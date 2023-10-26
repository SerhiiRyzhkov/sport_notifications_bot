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
public class TeamData implements Serializable {
    private static final long serialVersionUID = -4824171355003629367L;

    @JsonProperty("rnk")
    private int rnk;

    @JsonProperty("Tid")
    private String Tid;

    @JsonProperty("win")
    private int win;

    @JsonProperty("winn")
    private String winn;

    @JsonProperty("wreg")
    private int wreg;

    @JsonProperty("wap")
    private int wap;

    @JsonProperty("pf")
    private int pf;

    @JsonProperty("pa")
    private int pa;

    @JsonProperty("wot")
    private int wot;

    @JsonProperty("Tnm")
    private String Tnm;

    @JsonProperty("lst")
    private int lst;

    @JsonProperty("lstn")
    private String lstn;

    @JsonProperty("lreg")
    private int lreg;

    @JsonProperty("lot")
    private int lot;

    @JsonProperty("lap")
    private int lap;

    @JsonProperty("drw")
    private int drw;

    @JsonProperty("drwn")
    private String drwn;

    @JsonProperty("gf")
    private int gf;

    @JsonProperty("ga")
    private int ga;

    @JsonProperty("gd")
    private int gd;

    @JsonProperty("ptsn")
    private String ptsn;

    @JsonProperty("phr")
    private List<Integer> phr;

    @JsonProperty("Ipr")
    private int Ipr;

    @JsonProperty("Img")
    private String Img;

    @JsonProperty("pts")
    private int pts;

    @JsonProperty("pld")
    private int pld;
}