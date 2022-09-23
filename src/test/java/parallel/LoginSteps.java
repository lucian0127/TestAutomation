package parallel;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static java.lang.System.out;

public class LoginSteps {

    private static String title;
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    @Given("User is on home page")
    public void user_is_on_home_page() {
        out.println("User navigated to GitHub Home page.");
        DriverFactory.getDriver().get("https://github.com");
    }

    @Given("Home Page title should be {string}")
    public void home_page_title_should_be(String expectedTitleName) {
        title = loginPage.getHomePageTitle();
        out.println("Home page title is: \"" + title + "\"");
        Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("User clicks the Sign in Link")
    public void user_clicks_the_sign_in_button() {
        out.println("User clicks the Sign In button in GitHub Home page.");
        loginPage.clickSigninLink();
    }

    @Then("Sign in Page title should be {string}")
    public void sign_in_page_title_should_be(String expectedTitleName) {
        title = loginPage.getSigninPageTitle();
        out.println("Sign In page title is: \"" + title + "\"");
        //Assert.assertTrue(title.contains(expectedTitleName));
    }

    @Then("Forgot password link should be displayed")
    public void forgot_password_link_should_be_displayed() {
        out.println("User checks if Forgot Password link is exist.");
        Assert.assertTrue(loginPage.isForgotPasswordExist());
    }

    @Then("Create an account link should be displayed")
    public void create_an_account_link_should_be_displayed() {
        out.println("User checks if Create new Account link is exist.");
        Assert.assertTrue(loginPage.isCreateNewAccountExist());
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        out.println("User enters username");
        loginPage.enterUsername(username);
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        out.println("User enters password");
        loginPage.enterPassword(password);
    }

    @Then("User clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        out.println("User redirects to Home page");
        loginPage.clickSignInButton();
    }

    @Then("Account Dashboard Page will be displayed")
    public void account_dashboard_page_will_be_displayed() {
        out.println("User checks if avatar icon is exist.");
        Assert.assertTrue(loginPage.isAvatarIconExist());
    }

    @Then("User close the browser")
    public void user_close_the_browser() {

    }
}
