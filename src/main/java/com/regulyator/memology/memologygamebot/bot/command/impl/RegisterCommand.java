package com.regulyator.memology.memologygamebot.bot.command.impl;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.dto.UserInfo;
import com.regulyator.memology.memologygamebot.service.bot.TelegramApiExecutor;
import com.regulyator.memology.memologygamebot.service.external.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegisterCommand implements Command<Message> {

    private static final String TOKEN = "register";
    private static final String DESCRIPTION = "Registration command";
    private static final String SUCCESS_REGISTRATION_MSG = "Это успех, Вы успешно зарегистрированы!";
    private static final String ERROR_REGISTRATION_MSG = "Упс, что-то пошло не так:(";
    private final UserService userService;
    private final TelegramApiExecutor<Message> telegramApiExecutor;

    @Override
    public String getCommandToken() {
        return COMMAND_START_TOKEN + TOKEN;
    }

    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }

    @Override
    public Message handle(@NonNull Message message) {
        var user = message.getFrom();
        var chatId = String.valueOf(message.getChatId());
        log.info("get {} command, user id {}", TOKEN, user.getId());
        var result = userService.registerUser(UserInfo.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build());
        return telegramApiExecutor.execute(SendMessage.builder()
                .chatId(chatId)
                .text(result ? SUCCESS_REGISTRATION_MSG :
                        ERROR_REGISTRATION_MSG)
                .build());
    }
}
