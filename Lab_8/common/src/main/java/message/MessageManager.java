package message;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MessageManager {
    private static MessageManager messageManager = null;

    private final Map<Locale, Messages> messagesMap;

    private MessageManager() {
        messagesMap = new HashMap<>();
        messagesMap.put(new Locale("ru", "RU"), new MessagesRU());
        messagesMap.put(new Locale("by", "BY"), new MessagesBY());
        messagesMap.put(new Locale("bg", "BG"), new MessagesBG());
        messagesMap.put(new Locale("es","CR"), new MessagesCR());
    }

    public static synchronized MessageManager getInstance() {
        if(messageManager == null) {
            messageManager = new MessageManager();
        }
        return messageManager;
    }
//для сервера
    public Messages getLocalMessages(Locale locale) {
        Messages localMessages = messagesMap.get(locale);
        if(localMessages == null)
            return new MessagesRU();
        else
            return localMessages;
    }
//для клиента
    public Messages getLocalMessages() {
        Messages localMessages = messagesMap.get(Locale.getDefault());
        if(localMessages == null)
            return new MessagesRU();
        else
            return localMessages;
    }
}
