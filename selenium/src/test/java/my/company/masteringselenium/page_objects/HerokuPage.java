package my.company.masteringselenium.page_objects;

import io.qameta.allure.Step;
import my.company.masteringselenium.listeners.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HerokuPage extends BasePage {

    private final WebDriver webdriver;

    public HerokuPage() {
        this.webdriver = driver;
    }

    @Step
    public HerokuPage open(String url) {
        driver.get(url);
        return this;
    }

    @Step
    public HerokuPage clickOnLinkWithText(String value) {
        webdriver.findElement(By.linkText(value)).click();
        return this;
    }
}