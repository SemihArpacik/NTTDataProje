package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {

        public static void waitFor(int sec) {
                {
                        try {
                                Thread.sleep(sec * 1000);
                        } catch (InterruptedException e) {
                                e.printStackTrace();

                        }
                }
        }

        public static void jseClick(WebElement element) {
                ReusableMethods.waitFor(3);
                JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
                jse.executeScript("arguments[0].click();", element);

        }

        public static WebElement waitForVisibility(WebElement element, int timeout) {
                WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
                return wait.until(ExpectedConditions.visibilityOf(element));
        }

        public static String getScreenshot(String name) throws IOException {
                String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
                TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
                File source = ts.getScreenshotAs(OutputType.FILE);
                String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
                File finalDestination = new File(target);
                FileUtils.copyFile(source, finalDestination);
                return target;
        }

        public static void JSEScrollBy() {
                JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
                js.executeScript("window.scrollBy(0,1250)");
                waitFor(2);

        }

}
