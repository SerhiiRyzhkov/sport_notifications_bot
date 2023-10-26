package com.had0uken.sport_notifications_bot.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PhrX implements Serializable{
    @Serial
    private static final long serialVersionUID = 1560340345408503915L;
    @JsonProperty("V")
    private int V;
    @JsonProperty("D")
    private int D;
}
