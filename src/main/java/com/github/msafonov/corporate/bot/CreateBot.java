package com.github.msafonov.corporate.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class CreateBot {
    CreateBot(){
        try {
            PropertiesReader propertiesReader = new PropertiesReader();
            BotProperties botProperties = propertiesReader.getBotProperties();
            if (botProperties.getBotName() == null || botProperties.getToken() == null) {
                throw new Exception("botName or botToken not found");
            }
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Bot(botProperties));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}