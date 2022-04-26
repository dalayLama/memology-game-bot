package com.regulyator.memology.memologygamebot.service.bot.impl;

import com.regulyator.memology.memologygamebot.service.bot.TelegramApiExecutor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramApiExecutorImpl implements TelegramApiExecutor<Message> {
    private final AbsSender sender;

    public TelegramApiExecutorImpl(@Lazy @Qualifier("memologyBot") AbsSender sender) {

        this.sender = sender;
    }

    @SneakyThrows(TelegramApiException.class)
    @Override
    public Message execute(BotApiMethod<Message> apiMethod) {

        return sender.execute(apiMethod);
    }

    @SneakyThrows(TelegramApiException.class)
    @Override
    public Message execute(SendPhoto sendPhoto) {
        return sender.execute(sendPhoto);
    }

    @SneakyThrows(TelegramApiException.class)
    @Override
    public Message execute(SendSticker sendSticker) {
        return sender.execute(sendSticker);
    }
}
