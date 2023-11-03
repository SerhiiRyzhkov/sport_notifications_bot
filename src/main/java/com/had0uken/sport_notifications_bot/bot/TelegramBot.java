package com.had0uken.sport_notifications_bot.bot;

import com.had0uken.sport_notifications_bot.TestJson;
import com.had0uken.sport_notifications_bot.config.BotConfig;
import com.had0uken.sport_notifications_bot.enums.Category;
import com.had0uken.sport_notifications_bot.enums.Country;
import com.had0uken.sport_notifications_bot.model.League;
import com.had0uken.sport_notifications_bot.model.User;
import com.had0uken.sport_notifications_bot.repository.LeagueRepository;
import com.had0uken.sport_notifications_bot.service.UserService;
import com.had0uken.sport_notifications_bot.dataSources.Scorer;
import lombok.SneakyThrows;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    @Autowired
    private UserService userService;

    @Autowired
    private LeagueRepository leagueRepository;


    @Autowired
    private Scorer scorer;

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

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {


        if (update.hasCallbackQuery()){
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setMessageId(update.getCallbackQuery().getMessage().getMessageId());
            editMessageText.setChatId(update.getCallbackQuery().getMessage().getChatId());
          callBackHandler(update, editMessageText);
        }

        else if(update.hasMessage() && update.getMessage().hasText())
        {
            commandsHandler(update);
        }
    }

    private void callBackHandler(Update update, EditMessageText editMessageText) {
        /*if(leagueService.getAllLeagues().stream().
                anyMatch(el->el.getCountry().toString().equals(update.getCallbackQuery().getData())))
        selectTeam(update, editMessageText);*/
    }

    private void selectTeam(Update update, EditMessageText editMessageText) {
        editMessageText.setText("You have selected "+ update.getCallbackQuery().getData());
        executeMessage(editMessageText);
    }

    private void commandsHandler(Update update) throws IOException {
        String answer;
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
                addTeam(chatId);
            }
            case "/test" ->{
            testCase(chatId);
        }
            default -> sendMessage(chatId, "sorry, command does not exists");
        }
    }


    private void addTeam(long chatId) {
       SendMessage sendMessage = new SendMessage();
       sendMessage.setChatId(chatId);
       sendMessage.setText("Select a country: ");

       List<Country> countries = Arrays.stream(Country.values()).toList();

       InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
       List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
       List<InlineKeyboardButton> rowInLine = new ArrayList<>();
       int count = 0;
       for(Country c:countries)
       {
           InlineKeyboardButton button = new InlineKeyboardButton();
           button.setText(c.toString());
           button.setCallbackData(c.toString());
           rowInLine.add(button);
           if(++count==3){
               rowsInLine.add(rowInLine);
               rowInLine=new ArrayList<>();
               count=0;
           }
       }
       rowsInLine.add(rowInLine);
       inlineKeyboardMarkup.setKeyboard(rowsInLine);
       sendMessage.setReplyMarkup(inlineKeyboardMarkup);
       executeMessage(sendMessage);
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


    private void testCase(long chatId) throws IOException {
 /*       TestJson testJson = new TestJson();
        System.out.println("here!!!!!");
        LeagueData leagueData = LeagueData.parseJson(testJson.getJsonUkraine());
        System.out.println("here2!!!");
        System.out.println(leagueData);
        System.out.println(leagueData.getStages().get(0).getCnm());
        leagueData.getStages().get(0).getLeagueTable().getL().get(0).getTables().get(0).getTeam().forEach(el-> System.out.println(el.getTnm()));
*/

      /*  League league = new League();
        league.setLeague_id(111L);
        league.setLeague_name("test_league");
        System.out.println("here!!");
        System.out.println(league);
        leagueRepository.save(league);
        System.out.println("saved!");*/
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