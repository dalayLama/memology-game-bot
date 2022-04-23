package com.regulyator.memology.memologygamebot.service.bot;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface CommandHandler {

    boolean handleCommand(String command, Message message);

    boolean isCommandExist(Command command);
}
