package com.example.telegrambot.command;

import com.example.telegrambot.repository.entity.CompanyInfo;
import com.example.telegrambot.service.SendBotMessageService;
import com.example.telegrambot.service.CompanyInfoService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class EnterIdCommand implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final CompanyInfoService companyInfoService;

    public final static String ENTER_ID_MESSAGE = "ID введено успешно. Доступные действия:";

    public EnterIdCommand(SendBotMessageService sendBotMessageService, CompanyInfoService companyInfoService) {
        this.sendBotMessageService = sendBotMessageService;
        this.companyInfoService = companyInfoService;
    }

    @Override
    public void execute(Update update) {
        String companyId = update.getMessage().getText();

        companyInfoService.findByCompanyId(companyId).ifPresentOrElse(
                company -> {
                    companyInfoService.save(company);
                },
                () -> {
                    CompanyInfo companyInfo = new CompanyInfo();
                    companyInfo.setCompany_id(companyId);
                    companyInfoService.save(companyInfo);
                }
        );

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), companyId, ENTER_ID_MESSAGE);
    }
}
