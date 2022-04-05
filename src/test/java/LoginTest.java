import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{
    @Test
    public void loginTestBase() {
        openLoginForm();
        fillLoginForm("anat@gmail.com", "Aa12345$");
        clickOkButtonLogin();
        waitForVisibility("//*[.='Sign Out']");
        Assert.assertTrue(isLogged());

    }
    //=============================================================================

    private boolean isLogged() {
        return isElementPresent(By.xpath("//*[.='Sign Out']"));
    }

    public void waitForVisibility(String locator) {
        new WebDriverWait(wd, 10).until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath(locator))));
    }

    public void clickOkButtonLogin() {
        click(By.xpath("//button[.=' Login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.xpath("//input[@placeholder='Email']"), email);
        type(By.xpath("//input[@placeholder='Password']"), password);
    }

    public void openLoginForm() {
        click(By.xpath("//a[.='LOGIN']"));
    }

}
