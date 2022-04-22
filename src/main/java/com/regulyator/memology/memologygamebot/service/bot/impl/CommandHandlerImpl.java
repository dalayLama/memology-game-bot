package com.regulyator.memology.memologygamebot.service.bot.impl;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.service.bot.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommandHandlerImpl implements CommandHandler {
    private final Map<String, Command> commandMap;

    public CommandHandlerImpl(List<Command> commands) {
        this.commandMap = new HashMap<>(commands.size(), 1.0f);
        commands.forEach(command -> commandMap.put(command.getCommandToken(), command));
    }

    @Override
    public boolean handleCommand(Command command) {
        return false;
    }
}
