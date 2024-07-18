package flipkart;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.HomePage;

import Base.TestBase;

public class HomePageTest extends TestBase {
	@Test
	public void verifySearchResultOnSearchingMobile() {
		HomePage homepage = PageFactory.initElements(getDriver(), HomePage.class);
	}
}
