package com.regulyator.memology.bot;

import com.regulyator.memology.config.MemologyBotPropertiesHolder;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

public class MemologyWebHookBot extends SpringWebhookBot {
    private final MemologyBotPropertiesHolder propertiesHolder;


    public MemologyWebHookBot(DefaultBotOptions options,
                              SetWebhook setWebhook,
                              MemologyBotPropertiesHolder propertiesHolder) {
        super(options, setWebhook);
        this.propertiesHolder = propertiesHolder;
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
        return null;
    }

    @Override
    public String getBotPath() {
        return propertiesHolder.getPath();
    }
}
