package com.regulyator.memology.memologygamebot.bot.command.impl;

import com.regulyator.memology.memologygamebot.bot.command.Command;
import com.regulyator.memology.memologygamebot.enums.Buttons;
import com.regulyator.memology.memologygamebot.service.bot.TelegramApiExecutor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartGameCommand implements Command<Message> {

    private static final String TOKEN = Buttons.START_GAME.getButtonName();
    private static final String DESCRIPTION = "Start game command";
    private final TelegramApiExecutor<Message> telegramApiExecutor;

    public StartGameCommand(TelegramApiExecutor<Message> telegramApiExecutor) {
        this.telegramApiExecutor = telegramApiExecutor;
    }


    @Override
    public String getCommandToken() {
        return TOKEN;
    }

    @Override
    public String getCommandDescription() {
        return DESCRIPTION;
    }

    @SneakyThrows
    @Override
    public Message handle(Message message) {
        List<InlineKeyboardButton> l = new ArrayList<>(5);
        l.add(new InlineKeyboardButton("1"));
        l.add(new InlineKeyboardButton("2"));
        l.add(new InlineKeyboardButton("3"));
        l.add(new InlineKeyboardButton("4"));
        l.add(new InlineKeyboardButton("5"));


        l.forEach(inlineKeyboardButton -> {
            List<List<InlineKeyboardButton>> rows = new ArrayList<>();
            inlineKeyboardButton.setCallbackData(inlineKeyboardButton.getText());
            List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
            keyboardButtonsRow.add(inlineKeyboardButton);
            rows.add(keyboardButtonsRow);

            telegramApiExecutor.execute(SendPhoto.builder()
                    .chatId(String.valueOf(message.getChatId()))
                    .replyMarkup(InlineKeyboardMarkup.builder()
                            .keyboard(rows)
                            .build())
                    .photo(new InputFile(getClass().getClassLoader().getResourceAsStream("test_img.png"), "bird"))
                    .build());

        });
        return telegramApiExecutor.execute(SendMessage.builder()
                .chatId(String.valueOf(message.getChatId()))
                .text("Choose")
                .build());
    }
}
