package com.regulyator.memology.memologygamebot.service.bot.impl;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.service.bot.CommandHandler;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Message;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MessageCommandHandlerImpl implements CommandHandler<Message> {
    private final Map<String, Command<Message>> commandMap;

    public MessageCommandHandlerImpl(List<Command<Message>> commands) {
        this.commandMap = new HashMap<>(commands.size(), 1.0f);
        commands.forEach(command -> commandMap.put(command.getCommandToken(), command));
    }

    @Override
    public BotApiMethod<Message> handleCommand(String command, @NonNull Message message) {
        return this.isCommandExist(command) ?
                commandMap.get(command).handle(message):null;
    }

    @Override
    public boolean isCommandExist(String command) {
        return commandMap.containsKey(command);
    }
}
