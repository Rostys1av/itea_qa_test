package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchPage1 extends BasePage {

    @FindBy (xpath = "//a[@id='logo']")
    private WebElement logo;

    @FindBy (xpath = "//a[@class='_Fmb ab_button']")
    private List<WebElement> numberOfLinks;

    @FindBy(xpath = ".//*[@id='rso']//div/h3")
    private List<WebElement> titleTextLinksList;

    @FindBy(id = "pnnext")
    private WebElement nextPageBtn;

    public SearchPage1(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public boolean pageIsLoaded(){
        return WaitUntilElementDisplayed(logo,6).isDisplayed();
    }
    public int numberOfFoundResults(){
        return numberOfLinks.size();
    }

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
    public SearchPage2 clickToNextPage(){
        nextPageBtn.click();
        return new SearchPage2(driver);
    }
}
