import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
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

    public void acceptAlert() {
        new WebDriverWait(wd,10).until(ExpectedConditions.alertIsPresent());
        wd.switchTo().alert().accept();
    }
}
