package com.had0uken.sport_notifications_bot.service;

import com.had0uken.sport_notifications_bot.model.User;

import java.util.List;

public interface UserService {
    boolean isExist(Long chatId);
    void save(User user);

    void delete(Long chatId);

    String getData(long chatId);
}
