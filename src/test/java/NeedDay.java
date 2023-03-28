import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NeedDay {

    public String needDay() {
        LocalDate date = LocalDate.now().plusDays(3);
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
    }
    public String needDay7() {
        LocalDate date = LocalDate.now().plusDays(7);
        return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
    }

}
