package com.regulyator.memology.memologygamebot.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Buttons {
    REGISTER("Регистрация"),
    PIDOR("Артур пидор");

    private final String buttonName;


}
