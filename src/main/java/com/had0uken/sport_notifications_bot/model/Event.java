package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
@Table(name = "Event")
public class Event implements Serializable {

    @Serial
    private static final long serialVersionUID = 5597729867287774584L;
    @Id
    @JsonProperty("Eid")
    private String eid;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Stage stage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    @JsonProperty("Pids")
    private List<Pid> pids;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    @JsonProperty("Sids")
    private List<Sid> sids;

    @JsonProperty("Tr1")
    private String tr1;

    @JsonProperty("Tr2")
    private String tr2;

    @JsonProperty("Tr1OR")
    private String tr1OR;

    @JsonProperty("Tr2OR")
    private String tr2OR;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("T1")
    private List<Team> t1;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("T2")
    private List<Team> t2;

    @JsonProperty("Eps")
    private String eps;

    @JsonProperty("Esid")
    private int esid;

    @JsonProperty("Epr")
    private int epr;

    @JsonProperty("Ecov")
    private int ecov;

    @JsonProperty("Ern")
    private int ern;

    @JsonProperty("ErnInf")
    private String ernInf;

    @JsonProperty("Et")
    private int et;

    @JsonProperty("Esd")
    private long esd;

    @JsonProperty("LuUT")
    private long luUT;

    @JsonProperty("Eact")
    private int eact;

    @JsonProperty("EO")
    private long eo;

    @JsonProperty("EOX")
    private long eox;

    @JsonProperty("IncsX")
    private int incsX;

    @JsonProperty("ComX")
    private int comX;

    @JsonProperty("LuX")
    private int luX;

    @JsonProperty("StatX")
    private int statX;

    @JsonProperty("SubsX")
    private int subsX;

    @JsonProperty("SDFowX")
    private int sdfowX;

    @JsonProperty("SDInnX")
    private int sdInnX;

    @JsonProperty("LuC")
    private int luC;

    @JsonProperty("Ehid")
    private int ehid;

    @JsonProperty("Spid")
    private int spid;

}