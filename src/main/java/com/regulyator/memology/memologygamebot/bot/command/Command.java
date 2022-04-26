package com.regulyator.memology.memologygamebot.bot.command;

import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command<E extends BotApiObject> {

    String COMMAND_START_TOKEN = "/";

    String getCommandToken();

    String getCommandDescription();

    E handle(Message message);
}
