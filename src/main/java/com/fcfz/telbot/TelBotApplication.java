package com.fcfz.telbot;

import com.fcfz.telbot.mybot.MyBot;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class TelBotApplication {



    public static void main(String[] args) {
        TelegramBotsApi botsApi = null;
        try {
            botsApi = new TelegramBotsApi(DefaultBotSession.class);

            DefaultBotOptions defaultBotOptions = new DefaultBotOptions();
            defaultBotOptions.setProxyType(DefaultBotOptions.ProxyType.HTTP);
            defaultBotOptions.setProxyHost("127.0.0.1");
            defaultBotOptions.setProxyPort(33210);

            botsApi.registerBot(new MyBot(defaultBotOptions));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

}
