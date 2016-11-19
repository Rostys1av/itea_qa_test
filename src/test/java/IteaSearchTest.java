import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPageGoogle;
import page.SearchPage1;
import page.SearchPage2;

/**
 * Created by Rost on 19.11.2016.
 */
public class IteaSearchTest extends BaseTest {
    public MainPageGoogle mainPageGoogle;


    @Test
    public void searchIteaInGoogle(){
        MainPageGoogle mainPageGoogle = new MainPageGoogle(getDriver());
        SearchPage1 searchPage1=mainPageGoogle.fillAndClick("ITEA");
        searchPage1.pageIsLoaded();
        Assert.assertEquals(searchPage1.numberOfFoundResults(),5);
        Assert.assertTrue(searchPage1.isSearchLinksContained("ITEA"));
        SearchPage2 searchPage2=searchPage1.clickToNextPage();
        Assert.assertEquals(searchPage2.numberOfFoundResults(),7);
        Assert.assertTrue(searchPage2.isSearchLinksContained("ITEA"));



    }



}
