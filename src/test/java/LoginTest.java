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

    @Test
    public void loginTestWithInvalidPassword() {
        /*User user = new User()
                .withEmail("anat@gmail.com")
                .withPassword("Aa12345");*/

        app.getUser().openLoginForm();
        app.getUser().fillLoginForm("anat@gmail.com", "Aa12345");
        //logger.info("Login with --> email: \"" + user.getEmail() + "\", password: \"" + user.getPassword() + "\"");
        app.getUser().clickOkButtonLogin();
        app.getUser().acceptAlert();
        Assert.assertFalse(app.getUser().isLogged());
    }

}
