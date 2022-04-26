package com.regulyator.memology.memologygamebot.service.bot;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramUpdateHandler {

    BotApiMethod<?> handleUpdate(Update update);
}
