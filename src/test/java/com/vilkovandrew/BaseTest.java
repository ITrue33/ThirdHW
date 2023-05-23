package com.vilkovandrew;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

/**
 * Базовый класс для тестов.
 *
 * @author Вилков Андрей
 */
public class BaseTest {
    /**
     * Конфигурирование драйвера перед тестами.
     *
     * <p>
     * Автор: Вилков Андрей
     * </p>
     */
    @BeforeEach
    void beforeTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--remote-allow-origins=*",
                "--incognito",
                "--disable-blink-features=AutomationControlled",
                "--no-sandbox",
                "--disable-dev-shm-usage",
                "--disable-infobars"
        );

        options.addArguments("user-agent=\"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36\"");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setPageLoadTimeout(Duration.ofSeconds(120));
        Configuration.browserCapabilities = options;
        open();
        webdriver().object().manage().window().maximize();
    }

    /**
     * Закрытие драйвера после тестов.
     *
     * <p>
     * Автор: Вилков Андрей
     * </p>
     */
    @AfterEach
    void afterTest() {
    }
}
