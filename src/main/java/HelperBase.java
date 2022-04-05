import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void waitForVisibility(String locator, int timeOutInSeconds) {
        new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locator))));
    }

    public void logout() {
        click(By.xpath("//*[.='Sign Out']"));
    }
}
