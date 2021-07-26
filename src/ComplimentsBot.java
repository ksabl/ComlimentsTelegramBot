import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.TimeUnit;

public class ComplimentsBot extends TelegramLongPollingBot {

    private static final String TOKEN = "1921330470:AAEhyWepAtnz2E417sxyd9El6n8ELroavbo";
    private static final String USERNAME = "ComlimentsForGirlBot";

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            String chat_id = Long.toString(update.getMessage().getChatId());

            try {
                ParserComplements pars = new ParserComplements();
                while(true) {
                    String complement = pars.init();
                    execute(new SendMessage(chat_id, complement));
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
