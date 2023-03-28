import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import java.time.Duration;


import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
NeedDay day = new NeedDay();
    @Test
    public void shoudRegistred() {
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Йошкар-Ола");
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("[data-test-id=date] input").setValue(day.needDay());
        $("[data-test-id=name] input").setValue("Гарри-Гаррисон Поттер");
        $("[data-test-id=phone] input").setValue("+79189871057");
        $x("//*[contains(text(),'Я соглашаюсь с условиями')]").click();
        $x("//*[contains(text(),'Забронировать')]").click();
        $("[data-test-id=notification]").should(Condition.appear, Duration.ofSeconds(15));

    }




}
