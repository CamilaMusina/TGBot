package com.example.telegrambot.command;

import com.example.telegrambot.service.CompanyInfoService;
import com.example.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PayAmountCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final CompanyInfoService companyInfoService;
    private final String companyId;

    public final static String NO_PAY_MESSAGE = "Платежей по счёту не осуществлялось";

    public PayAmountCommand(SendBotMessageService sendBotMessageService, CompanyInfoService companyInfoService, String companyId) {
        this.sendBotMessageService = sendBotMessageService;
        this.companyInfoService = companyInfoService;
        this.companyId = companyId;
    }

    @Override
    public void execute(Update update){
        String chatId = update.getMessage().getChatId().toString();

        companyInfoService.findByCompanyId(companyId).ifPresent(
                bill -> {
                    if (bill.getAmount() == null){
                        sendBotMessageService.sendMessage(chatId, NO_PAY_MESSAGE);
                    } else {
                        sendBotMessageService.sendMessage(chatId, bill.getAmount().toString(), false);
                    }
                }
        );
    }
}
