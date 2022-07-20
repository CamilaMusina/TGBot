package com.example.telegrambot.service;

public interface SendBotMessageService {
    void sendMessage(String chatId, String message);
    void sendMessage(String chatId, String message, Boolean flag);
    void sendMessage(String chatId, String companyId, String message);
}
