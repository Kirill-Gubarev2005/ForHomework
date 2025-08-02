package web.tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private final String BASE_URL = "https://pikabu.ru/";
    private final String LOGIN = "Qwerty";
    private final String PASSWORD = "Qwerty";
    private final String EXPECTED_TITLE = "Горячее – самые интересные и обсуждаемые посты | Пикабу";
    private final String EXPECTED_ERROR = "Ошибка. Вы ввели неверные данные авторизации";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\79213\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        String actualTitle = driver.getTitle();
        assertEquals("Заголовок страницы не соответствует ожидаемому",
                EXPECTED_TITLE, actualTitle);


        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".header-right-menu__login-button")));
        loginButton.click();
        WebElement authForm = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".tabs__tab.tabs__tab_visible.auth")));


        WebElement usernameField = authForm.findElement(By.xpath("//*[@id=\"signin-form\"]/div[1]/div/div/input"));
        WebElement passwordField = authForm.findElement(By.xpath("//*[@id=\"signin-form\"]/div[2]/div/div/input"));
        WebElement submitButton = authForm.findElement(By.xpath("//*[@id=\"signin-form\"]/div[6]/button"));
        usernameField.sendKeys(LOGIN);
        passwordField.sendKeys(PASSWORD);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);


        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"signin-form\"]/div[5]/span")));
        assertEquals("Текст ошибки не соответствует ожидаемому",
                EXPECTED_ERROR, errorMessage.getText());
    }

    @After
    public void tearDown() {
            driver.quit();
    }
}