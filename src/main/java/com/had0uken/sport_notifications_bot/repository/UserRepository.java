package com.had0uken.sport_notifications_bot.repository;

import com.had0uken.sport_notifications_bot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}