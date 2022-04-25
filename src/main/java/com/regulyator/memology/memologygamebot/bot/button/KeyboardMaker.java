package com.regulyator.memology.memologygamebot.bot.button;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface KeyboardMaker<E extends ReplyKeyboard> {

    E getKeyboard();
}
