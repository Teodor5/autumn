package my.company.masteringselenium.page_objects;

import io.qameta.allure.Step;
import my.company.masteringselenium.DriverBase;
import my.company.masteringselenium.listeners.ScreenshotListener;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public abstract class BasePage {

    protected RemoteWebDriver driver;

    public BasePage() {
        try {
            driver = DriverBase.getDriver();
            PageFactory.initElements(driver, this);

        } catch (MalformedURLException ignored) {
            //This will be be thrown when the test starts if it cannot connect to a RemoteWebDriver Instance
        }
    }

    @Step
    public void captureScrenshot() {
        ScreenshotListener shot = new ScreenshotListener();
        shot.captureScreenshot();
    }
}