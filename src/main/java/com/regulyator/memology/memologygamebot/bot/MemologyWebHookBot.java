package com.regulyator.memology.memologygamebot.bot;

import com.regulyator.memology.memologygamebot.config.bot.MemologyBotPropertiesHolder;
import com.regulyator.memology.memologygamebot.service.bot.TelegramMessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import java.util.Objects;
@Service("memologyBot")
public class MemologyWebHookBot extends SpringWebhookBot {

    private final MemologyBotPropertiesHolder propertiesHolder;
    private final TelegramMessageHandler telegramMessageHandler;

    public MemologyWebHookBot(SetWebhook setWebhook,
                              MemologyBotPropertiesHolder propertiesHolder,
                              TelegramMessageHandler telegramMessageHandler) {
        super(setWebhook);
        this.propertiesHolder = propertiesHolder;
        this.telegramMessageHandler = telegramMessageHandler;
    }

    @Override
    public String getBotUsername() {
        return propertiesHolder.getName();
    }

    @Override
    public String getBotToken() {
        return propertiesHolder.getToken();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        if(Objects.nonNull(update) && update.hasMessage()) {
            return telegramMessageHandler.handleMessage(update.getMessage());
        }
        return null;
    }

    @Override
    public String getBotPath() {
        return propertiesHolder.getPath();
    }
}
