package keywords;

import org.testng.Assert;

public class ValidationKeywords extends GenericKeywords {
	
	public void validateTitle(String expectedTitle)
	{
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}

}
