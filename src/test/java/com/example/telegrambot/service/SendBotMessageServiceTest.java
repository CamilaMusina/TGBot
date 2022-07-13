package com.example.telegrambot.service;

import com.example.telegrambot.tgbot.TGBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-test for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageService sendBotMessageService;
    private TGBot tgBot;

    @BeforeEach
    public void init(){
        tgBot = Mockito.mock(TGBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(tgBot);
    }

    @Test
    public void test() throws TelegramApiException{
        String chatId = "chat_id";
        String message = "message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);
        Mockito.verify(tgBot).execute(sendMessage);
    }
}
