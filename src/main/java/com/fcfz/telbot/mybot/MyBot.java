package com.fcfz.telbot.mybot;

import com.fcfz.telbot.common.util;
import com.fcfz.telbot.dto.buttomDTO;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;


public class MyBot extends TelegramLongPollingBot {

    private String token = "7351865879:AAGQxLZB9WuRSgHiILRxlQYXsznh6pFDRDI";

    private String username = "flqzds";


    public MyBot() {
        super();
    }

    public MyBot(DefaultBotOptions options) {
        super(options);
    }

    private SendMessage hasMessage(Update update) {
        SendMessage message = new SendMessage();
//        && update.getMessage().hasText()
        if (update.hasMessage()) { // 判断是否有消息即可，不局限于文本
            // Set variables
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();


            message.setChatId(chat_id);
            message.enableHtml(true);

            message.setText("You said: " + message_text);

            // 接收到消息后判断是否为命令
            if (message_text.equals("/start")) {

                InlineKeyboardMarkup markupInline = util.newButton(
                        new buttomDTO("按钮·1", "数据1"),
                        new buttomDTO("按钮·2", "数据2"),
                        new buttomDTO("按钮·3", "数据3"));

                message.setReplyMarkup(markupInline);


//                String call_data = update.getCallbackQuery().getData();
//                long message_id = update.getCallbackQuery().getMessage().getMessageId();
//                long callback_chat_id = update.getCallbackQuery().getMessage().getChatId();
//
//                if (call_data.equals("backData 1")) {
//                    String answer = "回复你的更新消息";
//                    EditMessageText new_message = new EditMessageText();
//                    new_message.setChatId(callback_chat_id);
//                    new_message.setMessageId(Math.toIntExact(message_id));
//                    new_message.setText(answer);
//
//
//                    try {
//                        this.execute(new_message);
//                    } catch (TelegramApiException e) {
//                        e.printStackTrace();
//                    }
            }
        }
        return message;
    }


    @Override
    public void onUpdateReceived(Update update) {

        SendMessage message = hasMessage(update);

        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
    }

    @Override
    public String getBotUsername() {
        return this.username;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    @Override
    public void onRegister() {
        super.onRegister();
    }
}
