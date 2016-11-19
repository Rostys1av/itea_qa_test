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
    public SearchPage2(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public int numberOfFoundResults(){
        return numberOfLinksOf2thPage.size();
    }

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
