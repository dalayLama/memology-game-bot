package com.regulyator.memology.memologygamebot.config;

import com.regulyator.memology.memologygamebot.config.bot.MemologyBotPropertiesHolder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MemologyBotPropertiesHolder.class)
public class MainAppConfiguration {
}
