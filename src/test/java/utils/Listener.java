package utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Listener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ITestContext iTestContext = result.getTestContext();
            WebDriver driver = (WebDriver) iTestContext.getAttribute("WebDriver");

            Allure.addAttachment(UUID.randomUUID().toString(),
                    new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

            byte[] scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(scrFile);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    private String saveTextLog(String message) {
        return message;
    }
}
