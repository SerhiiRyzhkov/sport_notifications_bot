package com.had0uken.sport_notifications_bot.model;

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
@Table(name = "Sid")
public class Sid implements Serializable {
    @Serial
    private static final long serialVersionUID = -4528184670792413077L;
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
