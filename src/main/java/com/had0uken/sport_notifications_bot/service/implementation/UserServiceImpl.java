package com.had0uken.sport_notifications_bot.service.implementation;


import com.had0uken.sport_notifications_bot.model.User;
import com.had0uken.sport_notifications_bot.repository.UserRepository;
import com.had0uken.sport_notifications_bot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean isExist(Long chatId) {
        return userRepository.existsById(chatId);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long chatId) {
        Optional<User> userOptional = userRepository.findById(chatId);
        userOptional.ifPresent(user -> userRepository.delete(user));
    }

    @Override
    public String getData(long chatId) {
        Optional<User> userOptional = userRepository.findById(chatId);
        if(userOptional.isPresent())return userOptional.get().toString();
        else return "Your data is clear";
    }


}
