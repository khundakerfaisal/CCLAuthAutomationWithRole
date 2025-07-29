package Uttils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GetScreenShot {
    WebDriver driver;
    public void getScreenCapture(WebDriver driver, ExtentTest node, String message) throws IOException {
        Random randNumber = new Random();
        int generateAutoNumber = randNumber.nextInt(9999) + 1111;
        File srcFilePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotDir = "reports/screenshots/";
        new File(screenshotDir).mkdirs(); // Ensure directory exists
        String filename = "screenshot_" + generateAutoNumber + ".png";
        String fullScreenshotPath = screenshotDir + filename;
        File destFile = new File(fullScreenshotPath);
        FileUtils.copyFile(srcFilePath, destFile);

        // Use RELATIVE path from HTML file (ExtentReport.html is in /reports/)
        String relativePath = "screenshots/" + filename;
        node.pass(message,
                MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
    }
}
