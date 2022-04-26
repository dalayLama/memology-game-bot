package com.regulyator.memology.memologygamebot.service.bot;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;

public interface TelegramApiExecutor<E extends BotApiObject> {

    E execute(BotApiMethod<E> apiMethod);

    E execute(SendPhoto sendPhoto);

    E execute(SendSticker sendSticker);
}
