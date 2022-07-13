package com.example.telegrambot.command;

import org.junit.jupiter.api.DisplayName;
import static com.example.telegrambot.command.CommandName.NO;
import static com.example.telegrambot.command.NoCommand.NO_MESSAGE;

@DisplayName("Unit-tests for NoCommand")
public class NoCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName(){
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage(){
        return NO_MESSAGE;
    }

    @Override
    Command getCommand(){
        return new NoCommand(sendBotMessageService);
    }
}
