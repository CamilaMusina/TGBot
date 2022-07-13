package com.example.telegrambot.command;

import org.junit.jupiter.api.DisplayName;
import static com.example.telegrambot.command.CommandName.START;
import static com.example.telegrambot.command.StartCommand.START_MESSAGE;

@DisplayName("Unit-tests for StartCommand")
public class StartCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName(){
        return START.getCommandName();
    }

    @Override
    String getCommandMessage(){
        return START_MESSAGE;
    }

    @Override
    Command getCommand(){
        return new StartCommand(sendBotMessageService);
    }
}
