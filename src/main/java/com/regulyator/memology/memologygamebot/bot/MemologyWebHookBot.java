package com.regulyator.memology.memologygamebot.bot;

import com.regulyator.memology.memologygamebot.config.bot.MemologyBotPropertiesHolder;
import com.regulyator.memology.memologygamebot.service.bot.TelegramUpdateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

@Service("memologyBot")
@Slf4j
public class MemologyWebHookBot extends SpringWebhookBot {
    private final MemologyBotPropertiesHolder propertiesHolder;
    private final TelegramUpdateHandler telegramUpdateHandler;

    public MemologyWebHookBot(SetWebhook setWebhook,
                              MemologyBotPropertiesHolder propertiesHolder,
                              TelegramUpdateHandler telegramUpdateHandler) {
        super(setWebhook);
        this.propertiesHolder = propertiesHolder;
        this.telegramUpdateHandler = telegramUpdateHandler;
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
        return telegramUpdateHandler.handleUpdate(update);
    }

    @Override
    public String getBotPath() {
        return propertiesHolder.getPath();
    }
}
