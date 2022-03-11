package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ModalWindow {
    public static void checkTableRow(String label, String value) {
        $(".table")
                .shouldHave(Condition.text(label), Condition.text(value));
    }
}
