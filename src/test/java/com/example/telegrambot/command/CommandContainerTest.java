package com.example.telegrambot.command;

import com.example.telegrambot.service.CompanyInfoService;
import com.example.telegrambot.service.SendBotMessageService;
import com.example.telegrambot.service.TelegramUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;

@DisplayName("Unit-tests for CommandContainer")
public class CommandContainerTest {
    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        CompanyInfoService companyInfoService = Mockito.mock(CompanyInfoService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService, companyInfoService);
    }

    @Test
    public void test_getCommands(){
        Arrays.stream(CommandName.values()).forEach(commandName -> {
            Command command = commandContainer.retrieveCommand(commandName.getCommandName());
            Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
        });
    }

    @Test
    public void test_returnUnknown(){
        String unknownCommand = "/hello";
        Command command = commandContainer.retrieveCommand(unknownCommand);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
