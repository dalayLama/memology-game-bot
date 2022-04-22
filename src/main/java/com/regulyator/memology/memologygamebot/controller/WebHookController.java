package com.regulyator.memology.memologygamebot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.WebhookBot;

@RestController
@Slf4j
public class WebHookController {
    private final WebhookBot memologyBot;

    public WebHookController(@Qualifier("memologyBot") WebhookBot memologyBot) {
        this.memologyBot = memologyBot;
    }

    @PostMapping("/bot/update")
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        log.info("receive update {}", update.getUpdateId());
        return memologyBot.onWebhookUpdateReceived(update);
    }
}
