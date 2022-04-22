package com.regulyator.memology.memologygamebot.service.bot;

import com.regulyator.memology.memologygamebot.bot.command.Command;

public interface CommandHandler {

    boolean handleCommand(Command command);
}
