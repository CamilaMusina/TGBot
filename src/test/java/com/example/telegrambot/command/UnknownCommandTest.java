package com.example.telegrambot.command;

import org.junit.jupiter.api.DisplayName;
import static com.example.telegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-tests for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest{
    @Override
    String getCommandName(){
        return "/unknown_command";
    }

    @Override
    String getCommandMessage(){
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand(){
        return new UnknownCommand(sendBotMessageService);
    }
}
