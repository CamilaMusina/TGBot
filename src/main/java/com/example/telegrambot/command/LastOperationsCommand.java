package com.example.telegrambot.command;

import com.example.telegrambot.service.CompanyInfoService;
import com.example.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class LastOperationsCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final CompanyInfoService companyInfoService;
    private final String companyId;

    public final static String NO_DESC_MESSAGE = "Платежей по счёту не осуществлялось";

    public LastOperationsCommand(SendBotMessageService sendBotMessageService, CompanyInfoService companyInfoService, String companyId) {
        this.sendBotMessageService = sendBotMessageService;
        this.companyInfoService = companyInfoService;
        this.companyId = companyId;
    }

    @Override
    public void execute(Update update){
        String chatId = update.getMessage().getChatId().toString();

        companyInfoService.findByCompanyId(companyId).ifPresent(
                bill -> {
                    if (bill.getDescription() == null){
                        sendBotMessageService.sendMessage(chatId, NO_DESC_MESSAGE, false);
                    } else {
                        sendBotMessageService.sendMessage(chatId, bill.getDescription(), false);
                    }
                }
        );
    }
}
