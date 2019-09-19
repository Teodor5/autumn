package my.company.masteringselenium.page_objects;

import io.qameta.allure.Step;
import my.company.masteringselenium.listeners.ScreenshotListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditorPage extends BasePage {

    private final WebDriver webdriver;

    @FindBy(css = "#mce_0_ifr")
    private WebElement editorFrame;

    @FindBy(css = "body")
    private WebElement editorBody;

    @FindBy(css = "body > p:nth-child(1)")
    private WebElement editorFirstRow;

    public EditorPage() {
        this.webdriver = driver;
        PageFactory.initElements(webdriver, this);
        webdriver.switchTo().frame(editorFrame);
    }

    @Step
    public EditorPage clear() {
        editorBody.clear();
        return this;
    }

    @Step
    public EditorPage type(String text) {
        editorBody.sendKeys(text);
        return this;
    }

    @Step
    public EditorPage makeFirstRowBold() {
        Actions builder = new Actions(webdriver);
        builder.moveToElement(editorFirstRow).doubleClick().perform();
        editorBody.sendKeys(Keys.CONTROL + "b");
        return this;
    }
}