package my.company.masteringselenium.config;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public interface DriverSetup {
    RemoteWebDriver getWebDriverObject(DesiredCapabilities capabilities);
}