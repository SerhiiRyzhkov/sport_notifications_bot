package com.had0uken.sport_notifications_bot.bot;

import com.had0uken.sport_notifications_bot.config.BotConfig;
import com.had0uken.sport_notifications_bot.model.User;
import com.had0uken.sport_notifications_bot.service.UserService;
import com.had0uken.sport_notifications_bot.dataSources.Scorer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    UserService userService;

    @Autowired
    Scorer scorer;

    private final BotConfig botConfig;
    private static final String ERROR_TEXT = "Error occurred: ";

    private static final String HELP_TEXT = """
           
            Type /start to see a welcome message

            Type /help to see this message again
                        
            Type /deletedata to delete all your personal data that we keep
                        
            Type /mydata to view the information that we keep about you
            
            Type /settings to configure your preferences

            """;

    public TelegramBot(BotConfig botConfig)
    {
        this.botConfig=botConfig;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "get a welcome message"));
        listOfCommands.add(new BotCommand("/mydata", "get your data stored"));
        listOfCommands.add(new BotCommand("/deletedata", "delete my data"));
        listOfCommands.add(new BotCommand("/help", "info how to use this bot"));
        listOfCommands.add(new BotCommand("/settings", "set my preferences"));
        listOfCommands.add(new BotCommand("/test", "test"));
        listOfCommands.add(new BotCommand("/addTeam","add team to favourite"));
        try {
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error(ERROR_TEXT + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken(){
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        String answer;
        if (update.hasMessage() && update.getMessage().hasText())
        {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start" -> {
                    registerUser(update.getMessage());
                    answer = "Hello, " + update.getMessage().getChat().getFirstName() + "!";
                    sendMessage(chatId, answer);
                }
                case "/mydata" -> {
                    sendMessage(chatId, getData(chatId));
                }
                case "/help" -> {
                    sendMessage(chatId, HELP_TEXT);
                }
                case "/deletedata" -> {
                    userService.delete(chatId);
                    answer = update.getMessage().getChat().getFirstName() + ", your data was deleted";
                    sendMessage(chatId, answer);
                }

                case "/addTeam" ->{
                    sendMessage(chatId,addTeam(chatId));
                }
                case "/test" ->{
                    try {
                        sendMessage(chatId, scorer.getList());
                       // scorer.getList();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                default -> sendMessage(chatId, "sorry, command does not exists");
            }

        }
    }



    private String addTeam(long chatId) {
        InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();

        List<String> teams = new ArrayList<>(List.of("Milan,MU,Chelsea"));

        for(String t:teams)
        {
            List<InlineKeyboardButton> rowInLine = new ArrayList<>();
            InlineKeyboardButton button = new InlineKeyboardButton();
            button.setCallbackData(t);
            rowInLine.add(button);
            rowsInline.add(rowInLine);
        }
        markupInline.setKeyboard(rowsInline);


        markupInline.setKeyboard(rowsInline);
        return "Team was added";
    }






    private String getData(long chatId) {
        return userService.getData(chatId);
    }


    private void registerUser(Message message){
        if(!userService.isExist(message.getChatId())) {
            Chat chat = message.getChat();
            User user = new User(message.getChatId(), chat.getFirstName(), chat.getLastName(),
                    chat.getUserName(), new java.sql.Timestamp(System.currentTimeMillis()));
            userService.save(user);
            log.info("user saved: " + user);
        }
    }





    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }



    @Override
    public void onRegister() {
        super.onRegister();
    }


    private void sendMessage(long chatId, String textToSend)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(textToSend);
        executeMessage(sendMessage);
    }






    private void executeMessage(EditMessageText message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error(ERROR_TEXT + e.getMessage());
        }
    }

    private void executeMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            log.error(ERROR_TEXT + e.getMessage());
        }
    }
}