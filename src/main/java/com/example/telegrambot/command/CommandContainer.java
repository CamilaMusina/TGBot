package com.example.telegrambot.command;

import com.example.telegrambot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import static com.example.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService){
        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = (Command) new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandId){
        return commandMap.getOrDefault(commandId, unknownCommand);
    }
}