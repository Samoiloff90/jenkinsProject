package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        // для запуска на удаленном селеноиде
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        // конфигурация удаленного запуска
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // чтобы было видно, что происходит
        capabilities.setCapability("enableVNC", true);
        // для записи видео
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

    }
}
