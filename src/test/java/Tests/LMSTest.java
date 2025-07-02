package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LMSTest extends BasePage {

    ReadProperties readProperties = new ReadProperties();
    String urlToOpen = readProperties.getWebUrl();

    public void closeCurrentBrowserAndOpenUrlAgain(){
        common.pause(2);
        common.switchToSecondWindow();
        driver.get(urlToOpen);
    }

    @Test
    public void verifyHomePageWithAdminUser(){
        loginWithDirectorCredential();
        lmsPage.verifyAddEventFunctionalityOnHome();
        loginWithMRCredential();
        lmsPage.verifyAddNewsFunctionalityOnHome();
    }

}