package com.regulyator.memology.memologygamebot.bot.button;

import com.regulyator.memology.memologygamebot.enums.Buttons;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component("mainKeyboardMaker")
public class MainKeyboardMaker implements KeyboardMaker<ReplyKeyboardMarkup> {

    @Override
    public ReplyKeyboardMarkup getKeyboard() {
        KeyboardRow gameActionsRow = new KeyboardRow();

        gameActionsRow.add(new KeyboardButton(Buttons.START_GAME.getButtonName()));
        gameActionsRow.add(new KeyboardButton(Buttons.STATISTIC.getButtonName()));

        KeyboardRow serviceActionsRow = new KeyboardRow();

        serviceActionsRow.add(new KeyboardButton(Buttons.REGISTER.getButtonName()));


        List<KeyboardRow> keyboard = new ArrayList<>();
        keyboard.add(gameActionsRow);
        keyboard.add(serviceActionsRow);

        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(keyboard);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        return replyKeyboardMarkup;
    }
}
