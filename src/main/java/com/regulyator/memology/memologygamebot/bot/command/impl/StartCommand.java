package com.regulyator.memology.memologygamebot.bot.command.impl;

import com.regulyator.memology.memologygamebot.bot.button.KeyboardMaker;
import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.bot.command.ServiceCommand;
import com.regulyator.memology.memologygamebot.service.bot.TelegramApiExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
@ServiceCommand
public class StartCommand implements Command<Message> {
    private static final String TOKEN = "start";
    private static final String DESCRIPTION = "Start command";
    private static final String WELCOME_MESSAGE = "Привет!";
    private final KeyboardMaker<ReplyKeyboardMarkup> mainKeyboardMaker;
    private final TelegramApiExecutor<Message> telegramApiExecutor;

    public StartCommand(@Qualifier("mainKeyboardMaker") KeyboardMaker<ReplyKeyboardMarkup> mainKeyboardMaker,
                        TelegramApiExecutor<Message> telegramApiExecutor) {
        this.mainKeyboardMaker = mainKeyboardMaker;
        this.telegramApiExecutor = telegramApiExecutor;
    }

    @Override
    public String getCommandToken() {
        return COMMAND_START_TOKEN + TOKEN;
    }

    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }

    @Override
    public Message handle(Message message) {
        var user = message.getFrom();
        var chatId = String.valueOf(message.getChatId());
        log.info("get {} command, user id {}", TOKEN, user.getId());
        return telegramApiExecutor.execute(SendMessage.builder()
                .chatId(chatId)
                .text(WELCOME_MESSAGE)
                .replyMarkup(mainKeyboardMaker.getKeyboard())
                .build());
    }
}
