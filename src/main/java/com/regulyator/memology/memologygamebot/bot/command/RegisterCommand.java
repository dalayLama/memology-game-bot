package com.regulyator.memology.memologygamebot.bot.command;

import org.springframework.stereotype.Component;

@Component
public class RegisterCommand implements Command {
    private final static String TOKEN = "/register";
    private final static String DESCRIPTION = "Registration command";

    @Override
    public String getCommandToken() {
        return TOKEN;
    }

    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }
}
