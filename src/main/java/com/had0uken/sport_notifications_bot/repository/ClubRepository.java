package com.had0uken.sport_notifications_bot.repository;

import com.had0uken.sport_notifications_bot.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,Long> {
}
