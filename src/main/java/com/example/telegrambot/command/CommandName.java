package com.example.telegrambot.command;

public enum CommandName {
    START("/start"),
    STOP("/stop"),
    HELP("/help"),
    NO("nocommand");
    /*
    ENTER_ID("/enter_id");
    CREATE_ACC("/create_acc");
    LAST_OP("/last_op");
    PAY_AMOUNT("/pay_amount");
    */

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
