package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Page which include locators and methods for google search page #1
 */
public class SearchPage1 extends BasePage {

    @FindBy (xpath = "//a[@id='logo']")
    private WebElement logo;

    @FindBy (xpath = "//a[@class='_Fmb ab_button']")
    private List<WebElement> numberOfLinks;

    @FindBy(xpath = ".//*[@id='rso']//div/h3")
    private List<WebElement> titleTextLinksList;

    @FindBy(id = "pnnext")
    private WebElement nextPageBtn;

    /**
     * Constructor which extends driver from base page
     * Initialization all elements
     * @param driver
     */
    public SearchPage1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method returns confirmation that is search page is loaded
     * @return page isDisplayed
     */
    public boolean pageIsLoaded(){
        return WaitUntilElementDisplayed(logo,6).isDisplayed();
    }

    /**
     * Method returns size of links
     * @return int
     */
    public int numberOfFoundResults(){
        return numberOfLinks.size();
    }

    /**
     * Method which gets of test from titles
     * @return titleText
     */
    private List<String> getTitlesLinks() {
        List<String> titleText = new ArrayList<String>();
        Iterator<WebElement> iterator = titleTextLinksList.iterator();
        while (iterator.hasNext()) {
            WebElement linksTitel = iterator.next();
            String titleTextList = linksTitel.getText();
            titleText.add(titleTextList);
        }
        return titleText;
    }

    /**
     * Method which compare title test with the searchWord
     * @param searchWord
     * @return true or false
     */
    public boolean isSearchLinksContained(String searchWord){
        List<String> titleText = getTitlesLinks();
        boolean isSearchLinksContained = false;
        for (int i = 0; i < titleText.size(); i++) {
            if (titleText.get(i).contains(searchWord)) {
                isSearchLinksContained = true;
            }
        }
        return isSearchLinksContained;
    }

    /**
     * Method click next page link
     * @return
     */
    public SearchPage2 clickToNextPage(){
        nextPageBtn.click();
        return new SearchPage2(driver);
    }
}
