package com.had0uken.sport_notifications_bot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.had0uken.sport_notifications_bot.enums.Country;
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

    @JsonProperty("Tid")
    @Column(name = "TEAM_ID")
    @Id
    private String TEAM_ID;

    @JsonProperty("Tnm")
    @Column(name = "TEAM_NAME")
    private String TEAM_NAME;

    @Column
    private Country country;

}
