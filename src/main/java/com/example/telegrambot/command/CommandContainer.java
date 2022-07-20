package com.example.telegrambot.command;

import com.example.telegrambot.service.CompanyInfoService;
import com.example.telegrambot.service.TelegramUserService;
import com.example.telegrambot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import static com.example.telegrambot.command.CommandName.*;

public class CommandContainer {
    private final ImmutableMap<String, Command> commandMap;
    private final ImmutableMap<String, Command> buttonMap;
    private final Command unknownCommand;
    private String companyId;

    public CommandContainer(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService,
                            CompanyInfoService companyInfoService){

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        buttonMap = ImmutableMap.<String, Command>builder()
                .put(START.getButtonName(), new StartCommand(sendBotMessageService, telegramUserService))
                .put(STOP.getButtonName(), new StopCommand(sendBotMessageService, telegramUserService))
                .put(ENTER_ID.getButtonName(), new EnterIdCommand(sendBotMessageService, companyInfoService))
                .put(CREATE_ACC.getButtonName(), new CreateAccCommand(sendBotMessageService, companyInfoService, companyId))
                .put(LAST_OP.getButtonName(), new LastOperationsCommand(sendBotMessageService, companyInfoService, companyId))
                .put(PAY_AMOUNT.getButtonName(), new PayAmountCommand(sendBotMessageService, companyInfoService, companyId))
                .build();

        unknownCommand = (Command) new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandId){
        return commandMap.getOrDefault(commandId, unknownCommand);
    }
    public Command retrieveButton(String buttonId) { return buttonMap.getOrDefault(buttonId, unknownCommand); }
    public Boolean findButton(String buttonId) { return buttonMap.equals(buttonId); }

    public void setCompanyId(String companyId) { this.companyId = companyId; }
}
