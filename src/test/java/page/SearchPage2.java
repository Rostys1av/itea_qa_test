package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchPage2 extends BasePage{
    @FindBy (xpath = "//a[@class='_Fmb ab_button']")
    private List<WebElement> numberOfLinksOf2thPage;

    @FindBy(xpath = ".//*[@id='rso']//div/h3")
    private List<WebElement> titleTextLinksListOf2thPage;

    /**Constructor which extends driver from base page
     * Initialization all elements
     * @param driver
     */
    public SearchPage2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Method returns size of links
     * @return int
     */
    public int numberOfFoundResults(){
        return numberOfLinksOf2thPage.size();
    }

    /**
     * Method which gets of test from titles
     * @return titleText
     */
    private List<String> getTitlesLinks() {
        List<String> titleText = new ArrayList<String>();
        Iterator<WebElement> iterator = titleTextLinksListOf2thPage.iterator();
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
}
