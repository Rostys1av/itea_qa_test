package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Rost on 19.11.2016.
 */
public class MainPageGoogle extends BasePage {
    @FindBy (id = "lst-ib")
    private WebElement searchForm;

    @FindBy(name = "btnG")
    private WebElement submitBtn;

    public MainPageGoogle(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        WaitUntilElementDisplayed(searchForm);

    }
    public SearchPage1 fillAndClick(String keywords){
        searchForm.clear();
        searchForm.sendKeys(keywords);
        submitBtn.click();
        return new SearchPage1(driver);
    }
}
