import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    UserHelper user;


    public void init() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        openSite("https://contacts-app.tobbymarshall815.vercel.app/home");
        user = new UserHelper(wd);
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

    public UserHelper getUser() {
        return user;
    }

    public void stop() {
        wd.quit();
    }

}
