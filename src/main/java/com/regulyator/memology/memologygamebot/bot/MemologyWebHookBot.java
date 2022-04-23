package com.regulyator.memology.memologygamebot.bot;

import com.regulyator.memology.memologygamebot.config.bot.MemologyBotPropertiesHolder;
import com.regulyator.memology.memologygamebot.service.bot.CommandHandler;
import com.regulyator.memology.memologygamebot.service.bot.TelegramMessageHandler;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;

import java.util.Objects;
@Service("memologyBot")
public class MemologyWebHookBot extends SpringWebhookBot {

    private static final String COMMAND_PREFIX = "/";
    private final MemologyBotPropertiesHolder propertiesHolder;
    private final TelegramMessageHandler telegramMessageHandler;
    private final CommandHandler commandHandler;

    public MemologyWebHookBot(SetWebhook setWebhook,
                              MemologyBotPropertiesHolder propertiesHolder,
                              TelegramMessageHandler telegramMessageHandler,
                              CommandHandler commandHandler) {
        super(setWebhook);
        this.propertiesHolder = propertiesHolder;
        this.telegramMessageHandler = telegramMessageHandler;
        this.commandHandler = commandHandler;
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
            var message = update.getMessage();
            if(isCommand(message)){
                commandHandler.handleCommand(message.getText(), message);
                return null;
            }

            return telegramMessageHandler.handleMessage(update.getMessage());


        }
        return null;
    }

    @Override
    public String getBotPath() {
        return propertiesHolder.getPath();
    }

    private boolean isCommand(Message message) {
        return message.hasText()
                && message.getText().startsWith(COMMAND_PREFIX);
    }
}
