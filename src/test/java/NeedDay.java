import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NeedDay {
    public String generateDate(long addDays, String pattern) {
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern(pattern));
    }

}
