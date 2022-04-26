package com.regulyator.memology.memologygamebot.service.bot;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler<E extends BotApiObject> {

    E handleCommand(String command, Message message);

    boolean isCommandExist(String command);
}
