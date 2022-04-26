package com.regulyator.memology.memologygamebot.service.bot.impl;

import com.regulyator.memology.memologygamebot.service.bot.CommandHandler;
import com.regulyator.memology.memologygamebot.service.bot.TelegramMessageHandler;
import com.regulyator.memology.memologygamebot.service.bot.TelegramUpdateHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.Serializable;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class TelegramUpdateHandlerImpl implements TelegramUpdateHandler {
    private final TelegramMessageHandler<Message> defaultTelegramMessageHandler;
    private final CommandHandler<? extends Serializable> commandHandler;

    @Override
    public BotApiMethod<?> handleUpdate(Update update) {
        if(Objects.nonNull(update)) {
            if(update.hasCallbackQuery()) {
                return handleCallbackQuery(update.getCallbackQuery());
            } else if (update.hasMessage()){
                return handleMessage(update.getMessage());
            }
        }
        return null;
    }

    private BotApiMethod<?> handleCallbackQuery(CallbackQuery callbackQuery) {
        log.info("receive callback query, callback data: {}", callbackQuery.getData());
        return null;
    }

    private BotApiMethod<?> handleMessage(Message message) {
        var msgText = message.getText();
        if (StringUtils.hasText(msgText)) {
            var handleResult = commandHandler.handleCommand(msgText, message);
            if (Objects.isNull(handleResult)) {
                return defaultTelegramMessageHandler.handleMessage(message);
            }
        }
        return null;
    }

}
