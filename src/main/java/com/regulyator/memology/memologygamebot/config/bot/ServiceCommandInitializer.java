package com.regulyator.memology.memologygamebot.config.bot;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.bot.command.ServiceCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.interfaces.BotApiObject;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@Slf4j
public class ServiceCommandInitializer {
    private final AbsSender absSender;
    private final List<Command<? extends BotApiObject>> serviceCommands;

    public ServiceCommandInitializer(@Qualifier("memologyBot") AbsSender absSender,
                                     @ServiceCommand List<Command<? extends BotApiObject>> serviceCommands) {
        this.absSender = absSender;
        this.serviceCommands = serviceCommands;
    }

    @PostConstruct
    public void initializeServiceCommands() {
        try {
            var commands = new SetMyCommands();
            commands.setCommands(mapToStandardCommands());
            absSender.execute(commands);
        } catch (TelegramApiException e) {
            log.error("error init commands");
        }

    }

    private List<BotCommand> mapToStandardCommands() {
        return serviceCommands.stream()
                .map(command -> new BotCommand(command.getCommandToken(), command.getCommandDescription()))
                .collect(Collectors.toList());
    }
}
