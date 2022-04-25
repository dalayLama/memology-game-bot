package com.regulyator.memology.memologygamebot.bot.command;

import com.regulyator.memology.memologygamebot.bot.button.KeyboardMaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
@Slf4j
public class StartCommand implements Command<Message> {
    private static final String TOKEN = "start";
    private static final String DESCRIPTION = "Start command";
    private final KeyboardMaker<ReplyKeyboardMarkup> mainKeyboardMaker;

    public StartCommand(@Qualifier("mainKeyboardMaker") KeyboardMaker<ReplyKeyboardMarkup> mainKeyboardMaker) {
        this.mainKeyboardMaker = mainKeyboardMaker;
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
    public BotApiMethod<Message> handle(Message message) {
        var user = message.getFrom();
        var chatId = String.valueOf(message.getChatId());
        log.info("get {} command, user id {}", TOKEN, user.getId());
        return SendMessage.builder()
                .chatId(chatId)
                .text("")
                .replyMarkup(mainKeyboardMaker.getKeyboard())
                .build();
    }
}
