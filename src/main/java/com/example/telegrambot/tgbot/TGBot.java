package com.example.telegrambot.tgbot;

import com.example.telegrambot.command.CommandContainer;
import com.example.telegrambot.service.SendBotMessageService;
import com.example.telegrambot.service.SendBotMessageServiceImpl;
import com.example.telegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Locale;

import static com.example.telegrambot.command.CommandName.NO;

@Component
public class TGBot extends TelegramLongPollingBot{
    public static String COMMAND_PREFIX = "/";
    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    private CommandContainer commandContainer;

    @Autowired
    public TGBot(TelegramUserService telegramUserService){
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)){
                String commandId = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandId).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
