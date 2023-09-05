package com.had0uken.sport_notifications_bot.repository;

import com.had0uken.sport_notifications_bot.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    void delete(User entity);
}