package com.regulyator.memology.memologygamebot.config.bot;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;

@Configuration
@RequiredArgsConstructor
public class BotConfiguration {
    private final MemologyBotPropertiesHolder propertiesHolder;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(propertiesHolder.getPath()).build();
    }

}
