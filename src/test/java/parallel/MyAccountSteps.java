package parallel;

import com.pages.LoginPage;
import com.pages.MyAccountPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class MyAccountSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private MyAccountPage myAccountPage;
    private String username;
    private String password;

    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map<String, String>> credList = dataTable.asMaps();
        username = credList.get(0).get("username");
        password = credList.get(0).get("password");

        DriverFactory.getDriver().get("https://github.com/login");

        myAccountPage = loginPage.doLogin(username, password);
    }

    @Given("User navigates the MyAccount popup")
    public void user_navigates_the_my_account_popup() {
        if (myAccountPage.getMyAccountPopupTitle() == "Signed in as " + username)
        {
            out.println("User is now logged in.");
        }
    }

    @When("User gets the title of the MyAccount popup")
    public void user_gets_the_title_of_the_my_account_popup() {
        out.println("Users validates the title of My Account popup box.");

    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String title = myAccountPage.getMyAccountPopupTitle();

        out.println("user gets the title: " + title);

        Assert.assertTrue(title.contains(expectedTitle));
    }

    @Given("User is navigating the MyAccount popup")
    public void user_is_navigating_the_my_account_popup() {
        out.println("User is validating the My Account menus");
    }

    @Then("User gets MyAccount menu items")
    public void user_gets_my_account_menu_items(DataTable menuItemsTable) {
        List<String> expMenuItemsList = menuItemsTable.asList();
        out.print("Expected menu item list: " + expMenuItemsList);

        List<String> actualMenuItemsList = myAccountPage.getAccountMenuItemsList();
        out.print("Actual menu item list: " + actualMenuItemsList);

        Assert.assertTrue(expMenuItemsList.containsAll(actualMenuItemsList));
    }

    @Then("The MyAccount menu items count should be {int}")
    public void the_my_account_menu_items_count_should_be(Integer expectedCount) {
        out.println("Total menu items: " + expectedCount);
        Assert.assertTrue(myAccountPage.getAccountMenuItemsCount() == expectedCount);
    }
}
