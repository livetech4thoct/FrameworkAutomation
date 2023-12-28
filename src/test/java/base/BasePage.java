package base;

import org.testng.Assert;

public class BasePage extends BaseTest {
	
	public void validateTitle(String expTitle)
	{
		Assert.assertEquals(driver.getTitle(), expTitle);
	}

}
