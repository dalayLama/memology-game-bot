package com.regulyator.memology.memologygamebot.bot.command;

import com.regulyator.memology.memologygamebot.dto.UserInfo;
import com.regulyator.memology.memologygamebot.service.external.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegisterCommand implements Command {

    private final UserService userService;

    private static final String TOKEN = "/register";
    private static final String DESCRIPTION = "Registration command";

    @Override
    public String getCommandToken() {
        return TOKEN;
    }

    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }

    @Override
    public boolean handle(@NonNull Message message) {
        var user = message.getFrom();
        log.info("get register command, user id {}", user.getId());
        return userService.registerUser(UserInfo.builder()
                        .id(user.getId())
                        .userName(user.getUserName())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                .build());
    }
}
