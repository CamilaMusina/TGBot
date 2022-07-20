package com.example.telegrambot.command;

public enum CommandName {
    START("/start", "Старт"),
    STOP("/stop", "Завершить"),
    HELP("/help", "Помощь"),
    NO("nocommand", "-"),
    ENTER_ID("/enter_id", "Ввести ID компании"),
    CREATE_ACC("/create_acc", "Создать счёт"),
    LAST_OP("/last_op", "Последние операции"),
    PAY_AMOUNT("/pay_amount", "Сумма платежа");


    private final String commandName;
    private final String buttonName;

    CommandName(String commandName, String buttonName) {
        this.commandName = commandName;
        this.buttonName = buttonName;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getButtonName() { return buttonName; }
}
