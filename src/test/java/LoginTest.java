import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginTestBase() {
        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("anat@gmail.com", "Aa12345$");
        app.getUser().clickOkButtonLogin();
        app.getUser().waitForVisibility("//*[.='Sign Out']", 10);
        Assert.assertTrue(app.getUser().isLogged());

    }

}
