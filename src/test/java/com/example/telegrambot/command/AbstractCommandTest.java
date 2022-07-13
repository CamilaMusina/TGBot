package com.example.telegrambot.command;

import com.example.telegrambot.tgbot.TGBot;
import com.example.telegrambot.service.SendBotMessageService;
import com.example.telegrambot.service.SendBotMessageServiceImpl;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

abstract class AbstractCommandTest {
    protected TGBot tgBot = Mockito.mock(TGBot.class);
    protected SendBotMessageService sendBotMessageService = new SendBotMessageServiceImpl(tgBot);

    abstract String getCommandName();
    abstract String getCommandMessage();
    abstract Command getCommand();

    @Test
    public void test_Execute() throws TelegramApiException{
        Long chatId = 1234567898765L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        getCommand().execute(update);
        Mockito.verify(tgBot).execute(sendMessage);
    }
}
