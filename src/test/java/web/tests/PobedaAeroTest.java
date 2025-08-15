package web.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PobedaAeroTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://www.google.com";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\79213\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testPobedaAeroWebsite() {
        try {
            // 1. Открыть Google и выполнить поиск
            navigateToGoogleAndSearch();

            // 2. Кликнуть на первую ссылку в результатах
            clickFirstSearchResult();

            // 3. Проверить текст на картинке
            waitForKaliningradText();

            // 4. Переключить язык и проверить английские тексты
            switchToEnglishAndVerifyTexts();

        } catch (Exception e) {
            Assert.fail("Тест упал с ошибкой: " + e.getMessage());
        }
    }

    private void navigateToGoogleAndSearch() {
        int attempts = 0;
        while (attempts < 3) {
            try {
                driver.get(BASE_URL);
                acceptGoogleCookiesIfPresent();

                WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("textarea[name='q'], input[name='q']")));
                searchInput.clear();
                searchInput.sendKeys("Сайт компании Победа авиакомпания");
                searchInput.sendKeys(Keys.RETURN);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
                return;
            } catch (TimeoutException e) {
                attempts++;
                if (attempts == 3) {
                    throw new AssertionError("Не удалось выполнить поиск в Google после 3 попыток");
                }
                System.out.println("Попытка " + attempts + " не удалась, пробуем снова...");
            }
        }
    }

    private void acceptGoogleCookiesIfPresent() {
        try {
            WebElement acceptButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[contains(., 'Принять все') or contains(., 'Accept all')]")));
            acceptButton.click();
        } catch (TimeoutException e) {
            System.out.println("Окно с кукисами не найдено, продолжаем...");
        }
    }

    private void clickFirstSearchResult() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search")));

        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("div#search a h3")));

        Assert.assertFalse("Не найдено результатов поиска", results.isEmpty());

        results.get(0).click();
    }

    private void waitForKaliningradText() {
        try {
            // Используем конкретный XPath для поиска текста про Калининград
            WebElement kaliningradElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("/html/body/div/div/main/div/div/div[1]/div/div[1]/button[10]/div[2]")));

            // Проверяем, что элемент содержит текст про Калининград
            String elementText = kaliningradElement.getText();
            Assert.assertTrue("Текст не содержит упоминания Калининграда",
                    elementText.contains("Полетели в Калининград") || elementText.contains("Let's fly to Kaliningrad!"));

            System.out.println("Найден текст: " + kaliningradElement.getText());
        } catch (TimeoutException e) {
            // Делаем скриншот для отладки
            takeScreenshot();
            throw new AssertionError("Не удалось найти текст про Калининград по указанному XPath. Текущий URL: " + driver.getCurrentUrl());
        }
    }

    private void switchToEnglishAndVerifyTexts() {
        try {
            // Кликаем на переключатель языка
            WebElement langSwitch = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label*='anguage'], button[aria-label*='зык']")));
            langSwitch.click();

            // Выбираем английский
            WebElement englishOption = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(., 'ENG') or contains(., 'English')]")));
            englishOption.click();

            // Даем время для применения изменений
            Thread.sleep(2000);

            // Проверяем английские тексты
            verifyEnglishText("Ticket search", "Find flight");
            verifyEnglishText("Online check-in", "Check-in");
            verifyEnglishText("Manage my booking", "My bookings");

        } catch (TimeoutException e) {
            throw new AssertionError("Не удалось переключить язык: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError("Тест был прерван: " + e.getMessage());
        }
    }

    private void verifyEnglishText(String... possibleTexts) {
        boolean found = false;
        for (String text : possibleTexts) {
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" +
                                text.toLowerCase() + "')]")));
                found = true;
                break;
            } catch (TimeoutException e) {
                continue;
            }
        }
        Assert.assertTrue("Не найден ни один из ожидаемых текстов: " + String.join(", ", possibleTexts), found);
    }

    private void takeScreenshot() {
        try {
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            // Здесь можно сохранить скриншот или добавить его в отчет
            System.out.println("Сделан скриншот для отладки");
        } catch (Exception e) {
            System.out.println("Не удалось сделать скриншот: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}