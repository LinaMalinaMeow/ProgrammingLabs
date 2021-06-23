package message;

import java.time.LocalDate;

public interface Messages {
    String getString(String key);
    String getDate(LocalDate date);
}
