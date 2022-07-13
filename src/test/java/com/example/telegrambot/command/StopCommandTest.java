package com.example.telegrambot.command;

import org.junit.jupiter.api.DisplayName;
import static com.example.telegrambot.command.CommandName.STOP;
import static com.example.telegrambot.command.StopCommand.STOP_MESSAGE;

@DisplayName("Unit-tests for StopCommand")
public class StopCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName(){
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage(){
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand(){
        return new StopCommand(sendBotMessageService);
    }
}
