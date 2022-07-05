package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		List<Map<String, String>> credList = credTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage=loginPage.doLogin(username, password);
		
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		
		String title = accountsPage.getAccPageTitle();
		System.out.println("Accounts Page Title: " + title);
	   
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		
		List<String>  expactedAccSectionList =sectionsTable.asList();
		System.out.println("Expected Accounts Sections List : "+expactedAccSectionList);
		
		List<String>  actualAccSectionList = accountsPage.getAccSectionsList();
		System.out.println("Actual Accounts Sections List : "+actualAccSectionList);
		
		Assert.assertTrue(expactedAccSectionList.containsAll(actualAccSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		
		Assert.assertTrue(accountsPage.getAccSectionCounts()==expectedSectionCount);
	    
	}

}
