package com.regulyator.memology.memologygamebot.bot.command;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command {

    String getCommandToken();

    String getCommandDescription();

    boolean handle(Message message);
}
