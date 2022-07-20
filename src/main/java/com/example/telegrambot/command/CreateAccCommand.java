package com.example.telegrambot.command;

import com.example.telegrambot.repository.entity.CompanyInfo;
import com.example.telegrambot.service.CompanyInfoService;
import com.example.telegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CreateAccCommand implements Command{
    private final SendBotMessageService sendBotMessageService;
    private final CompanyInfoService companyInfoService;
    private final String companyId;

    public final static String ENTER_PAY_MESSAGE = "Введите сумму поступившего платежа";
    public final static String DESC_BILL_MESSAGE = "Дайте описание счёта";
    public final static String ENTER_EMAIL_MESSAGE = "Введите email для отправки информации";
    public final static String BILL_SAVED_MESSAGE = "Счёт обновлен. Доступные действия:";

    public CreateAccCommand(SendBotMessageService sendBotMessageService, CompanyInfoService companyInfoService, String companyId) {
        this.sendBotMessageService = sendBotMessageService;
        this.companyInfoService = companyInfoService;
        this.companyId = companyId;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, ENTER_PAY_MESSAGE);
        String pay_amount = update.getMessage().getText();
        Integer amount = Integer.parseInt(pay_amount);

        sendBotMessageService.sendMessage(chatId, DESC_BILL_MESSAGE);
        String desc = update.getMessage().getText();

        sendBotMessageService.sendMessage(chatId, ENTER_EMAIL_MESSAGE);
        String email = update.getMessage().getText();

        companyInfoService.findByCompanyId(companyId).ifPresentOrElse(
                bill -> {
                    bill.setAmount(amount);
                    bill.setDescription(bill.getDescription() + desc);
                    bill.setEmail(email);
                    companyInfoService.save(bill);
                },
                () -> {
                    CompanyInfo companyInfo = new CompanyInfo();
                    companyInfo.setAmount(amount);
                    companyInfo.setDescription(desc);
                    companyInfo.setEmail(email);
                    companyInfoService.save(companyInfo);
                }
        );

        sendBotMessageService.sendMessage(chatId, BILL_SAVED_MESSAGE, false);
    }
}
