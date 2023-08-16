package ru.netology.web;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class CallbackTest {

    @Test
    void shouldTest() {
        open("http://localhost:9999");
        SelenideElement form = $(".form_theme_alfa-on-white");

        form.$("[data-test-id=name] input").setValue("Оксана");
        form.$("[data-test-id=phone] input").setValue("+79880000000");
        form.$("[data-test-id=agreement]").click();
        form.$(".button_theme_alfa-on-white").click();
        $(".order-success").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}
