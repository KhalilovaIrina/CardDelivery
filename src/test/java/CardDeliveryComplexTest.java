
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryComplexTest {
    NeedDay day = new NeedDay();
    String planningDate = day.generateDate(7, "dd.MM.yyyy");

    LocalDate currentDate = LocalDate.now();
    LocalDate planning = LocalDate.now().plusDays(7);



    @Test
    public void shoudRegistred1() {
        open("http://localhost:9999");
        $("[data-test-id='city'] input").setValue("Йо");
        $x("//*[contains(text(),'Йошкар')]").click();
        $("[data-test-id='date'] input").click();

        if (currentDate.getMonthValue() < planning.getMonthValue()) {
            $("[data-step='1'] ").click();
        }
        $x("//td[text()='" + planning.getDayOfMonth() + "']").click();

        $("[data-test-id=name] input").setValue("Гарри-Гаррисон Поттер");
        $("[data-test-id=phone] input").setValue("+79189871057");
        $x("//*[contains(text(),'Я соглашаюсь с условиями')]").click();
        $x("//*[contains(text(),'Забронировать')]").click();
        $("[data-test-id=notification]").should(Condition.appear, Duration.ofSeconds(15));
        $(".notification__content")
                .shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);
    }


}