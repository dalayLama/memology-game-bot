package com.regulyator.memology.memologygamebot.service.bot;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface TelegramMessageHandler {

    BotApiMethod<?> handleMessage(Message message);
}
