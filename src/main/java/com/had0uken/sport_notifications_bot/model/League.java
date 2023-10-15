package com.had0uken.sport_notifications_bot.model;

import com.had0uken.sport_notifications_bot.enums.Country;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leagues")
public class League {
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String name;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Club> clubs = new ArrayList<>();
}
