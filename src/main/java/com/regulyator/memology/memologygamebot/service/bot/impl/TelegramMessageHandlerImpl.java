package com.regulyator.memology.memologygamebot.service.bot.impl;

import com.regulyator.memology.memologygamebot.service.bot.TelegramMessageHandler;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class TelegramMessageHandlerImpl implements TelegramMessageHandler<Message> {
    @Override
    public BotApiMethod<Message> handleMessage(Message message) {
        return SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text(message.getText()).build();
    }
}
