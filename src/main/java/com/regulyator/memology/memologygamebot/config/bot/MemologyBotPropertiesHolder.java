package com.regulyator.memology.memologygamebot.config.bot;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "memology.bot")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemologyBotPropertiesHolder {
    String name;
    String token;
    String path;
}
