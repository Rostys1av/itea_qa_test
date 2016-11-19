package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page which include locators and methods for google main page
 */
public class MainPageGoogle extends BasePage {
    @FindBy (id = "lst-ib")
    private WebElement searchForm;

    @FindBy(name = "btnG")
    private WebElement submitBtn;

    /**
     * Constructor which extends driver from base page
     * Initialization all elements
     * @param driver
     */
    public MainPageGoogle(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WaitUntilElementDisplayed(searchForm);

    }

    /**
     * Method for fill search form and click submit button
     * @param keywords
     * @return
     */
    public SearchPage1 fillAndClick(String keywords){
        searchForm.clear();
        searchForm.sendKeys(keywords);
        submitBtn.click();
        return new SearchPage1(driver);
    }
}
