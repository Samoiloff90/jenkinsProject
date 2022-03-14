package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.FileDownloadMode.FOLDER;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        String user = System.getProperty("user");
        String password = System.getProperty("password");
        String browserSize = System.getProperty("browserSize");

        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = browserSize;  //"1920x1080"
        Configuration.remote = "https://" + user + ":" + password + "@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;

//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.fileDownload = FOLDER;
//
//        //password and user for remote browser
//        String user = System.getProperty("user");
//        String password = System.getProperty("password");
//
//        // конфигурация удаленного запуска
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        // чтобы было видно, что происходит
//        capabilities.setCapability("enableVNC", true);
//        // для записи видео
//        capabilities.setCapability("enableVideo", true);
//        Configuration.browserCapabilities = capabilities;
//
//        // для запуска на удаленном селеноиде
//        Configuration.remote = "https://" + user + ":" + password + "@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachment() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWebDriver();
    }
}
