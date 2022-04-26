package com.regulyator.memology.memologygamebot.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Buttons {
    REGISTER("Регистрация"),
    START_GAME("Начать игру"),
    STATISTIC("Статистика");

    private final String buttonName;


}
