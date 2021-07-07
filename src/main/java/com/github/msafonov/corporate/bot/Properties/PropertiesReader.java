package com.github.msafonov.corporate.bot.Properties;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReader {


    private final String token;
    private final String botName;
    private final String chatId;

    public PropertiesReader() throws IOException {
        String path = "src/main/resources/config.properties";
        File file = new File(path);


        Properties properties = new Properties();
        try (var reader = new FileReader(file)) {
            properties.load(reader);
        }
        token = properties.getProperty("token");
        botName = properties.getProperty("botName");
        path = "src/main/resources/admins.properties";
        file = new File(path);
        try (var reader = new FileReader(file)) {
            properties.load(reader);
        }
        chatId = properties.getProperty("chatId");
    }


    public BotProperties getBotProperties() {
        return new BotProperties(token, botName);
    }
    public AdminsProperties getAdminsProperties(){return new AdminsProperties(chatId);}
}
