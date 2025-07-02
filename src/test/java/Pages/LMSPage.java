package Pages;

import Utils.Common;
import Utils.Locators;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LMSPage extends Locators {
    Common common = new Common(driver);

    public LMSPage(WebDriver driver) {
        super(driver);
    }


    public void logoutFromCurrentUserAndLoginWithMR(){

    }

    public void verifyAddEventFunctionalityOnHome(){

//        common.logPrint("Step:: Verify News & Events header is present");
//        common.waitUntilElementToBeVisible(By.xpath(NewsAndEventsHed));
//        String eventNews = common.getText(NewsAndEventsHed);
//        common.assertTwoValuesAreEqual(eventNews, "News & Events");

        common.logPrint("Step:: create one news");

        common.logPrint("Step:: Click on the add new post button");
        common.waitUntilElementToBeVisible(By.xpath(AddNewPostBtn));
        common.click(AddNewPostBtn);

        common.logPrint("Step:: Verify Breadcrumb is present for create new post");
        common.waitUntilElementToBeVisible(By.xpath(AddNewPostPath));
        common.assertElementDisplayed(AddNewPostPath);

        common.logPrint("Step:: Verify Add new post header is present");
        common.waitUntilElementToBeVisible(By.xpath(AddPostFormHed));
        common.assertElementDisplayed(AddPostFormHed);

        common.logPrint("Step:: Verify Title label is present");
        common.waitUntilElementToBeVisible(By.xpath(TitleLabel));
        common.assertElementDisplayed(TitleLabel);

        common.logPrint("Step:: Verify Summary label is present");
        common.waitUntilElementToBeVisible(By.xpath(SummaryLbl));
        common.assertElementDisplayed(SummaryLbl);

        common.logPrint("Step:: Verify Post as label is present");
        common.waitUntilElementToBeVisible(By.xpath(PostedasLbl));
        common.assertElementDisplayed(PostedasLbl);

        String titleName1 = common.generateRandomChars(10);
        String titleName = "E"+titleName1;
        common.logPrint("Step:: Enter title name");
        common.waitUntilElementsToBeVisible(By.xpath(TitleInp));
        common.type(TitleInp, titleName);
        common.logPrint("Title Name is: "+ titleName);

        String summaryTitle = common.generateRandomChars(30);
        common.logPrint("Step:: Enter summary");
        common.waitUntilElementsToBeVisible(By.xpath(SummaryInp));
        common.type(SummaryInp, summaryTitle);
        common.logPrint("Title summary is: "+ summaryTitle);

        WebElement selectNews = common.findElement((SelectNewsEvent));
        Select dropdown = new Select(selectNews);
        dropdown.selectByVisibleText("Event");

        common.logPrint("Event is selected in the dropdown");

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SaveBtn));
        common.click(SaveBtn);

        common.logPrint("Step:: Verify success message is coming ");
        common.waitUntilElementToBeVisible(By.xpath(getMessage));
        String successMsg = common.getText(getMessage);
        common.assertTwoValuesAreEqual(successMsg, titleName+" has been uploaded.");
        common.logPrint("Success message is showing: "+successMsg);

        common.logPrint("Step:: Verify event and news are created and showing on the dashboard");
        String createdEvent = "//div[@class='flex justify-between items-center']//h2[contains(text(),'"+titleName+"')]";
        common.waitUntilElementToBeVisible(By.xpath(createdEvent));
        String getTitleName = common.getText(createdEvent);
        common.assertTwoValuesAreEqual(getTitleName, titleName);
        common.logPrint("Event is showing properly on the dashboard: "+ getTitleName);

        String DeleteButton = "//h2[contains(text(), '"+titleName+"')]/../span//a";

        DeleteButton.equalsIgnoreCase(DeleteButton);

        common.pause(2);
        common.waitUntilElementToBeVisible(By.xpath((DeleteButton)));
        common.click(DeleteButton);

        common.waitUntilElementToBeVisible(By.xpath(getMessage));
        String deletemessage = common.getText(getMessage);
        common.logPrint(deletemessage);

    }

    public void verifyEventIsShowingInStudent(){

    }

    public void verifyAddNewsFunctionalityOnHome(){

        common.pause(2);

        common.logPrint("Step:: Verify News & Events header is present");
        common.waitUntilElementToBeVisible(By.xpath(NewsAndEventsHed));
        common.assertElementDisplayed(NewsAndEventsHed);

        common.logPrint("Step:: create one news");

        common.logPrint("Step:: Click on the add new post button");
        common.waitUntilElementToBeVisible(By.xpath(AddNewPostBtn));
        common.click(AddNewPostBtn);

        common.logPrint("Step:: Verify Breadcrumb is present for create new post");
        common.waitUntilElementToBeVisible(By.xpath(AddNewPostPath));
        common.assertElementDisplayed(AddNewPostPath);

        common.logPrint("Step:: Verify Add new post header is present");
        common.waitUntilElementToBeVisible(By.xpath(AddPostFormHed));
        common.assertElementDisplayed(AddPostFormHed);

        common.logPrint("Step:: Verify Title label is present");
        common.waitUntilElementToBeVisible(By.xpath(TitleLabel));
        common.assertElementDisplayed(TitleLabel);

        common.logPrint("Step:: Verify Summary label is present");
        common.waitUntilElementToBeVisible(By.xpath(SummaryLbl));
        common.assertElementDisplayed(SummaryLbl);

        common.logPrint("Step:: Verify Post as label is present");
        common.waitUntilElementToBeVisible(By.xpath(PostedasLbl));
        common.assertElementDisplayed(PostedasLbl);

        String NewstitleName1 = common.generateRandomChars(10);
        String titleName = "N"+NewstitleName1;
        common.logPrint("Step:: Enter title name");
        common.waitUntilElementsToBeVisible(By.xpath(TitleInp));
        common.type(TitleInp, titleName);
        common.logPrint("Title Name is: "+ titleName);

        String summaryTitle = common.generateRandomChars(30);
        common.logPrint("Step:: Enter summary");
        common.waitUntilElementsToBeVisible(By.xpath(SummaryInp));
        common.type(SummaryInp, summaryTitle);
        common.logPrint("Title summary is: "+ summaryTitle);

        WebElement selectNews = common.findElement((SelectNewsEvent));
        Select dropdown = new Select(selectNews);
        dropdown.selectByVisibleText("News");

        common.logPrint("News is selected in the dropdown");

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SaveBtn));
        common.click(SaveBtn);

        common.logPrint("Step:: Verify success message is coming ");
        common.waitUntilElementToBeVisible(By.xpath(getMessage));
        String successMsg = common.getText(getMessage);
        common.assertTwoValuesAreEqual(successMsg, titleName+" has been uploaded.");
        common.logPrint("Success message is showing: "+successMsg);

        common.logPrint("Step:: Verify event and news are created and showing on the dashboard");
        String createdEvent = "//div[@class='flex justify-between items-center']//h2[contains(text(),'"+titleName+"')]";
        common.waitUntilElementToBeVisible(By.xpath(createdEvent));
        String getTitleName = common.getText(createdEvent);
        common.assertTwoValuesAreEqual(getTitleName, titleName);
        common.logPrint("Event is showing properly on the dashboard: "+ getTitleName);

        //String DeleteButton = "//h2[@title='"+titleName+"']/../span//a";
        String DeleteButton = "//h2[contains(text(), '"+titleName+"')]/../span//a";

        DeleteButton.equalsIgnoreCase(DeleteButton);
        //h2[contains(@title, '"+titleName+"')]/../span//a

        common.pause(2);
        common.waitUntilElementToBeVisible(By.xpath((DeleteButton)));
        common.click(DeleteButton);

        common.waitUntilElementToBeVisible(By.xpath(getMessage));
        String deletemessage = common.getText(getMessage);
        common.logPrint(deletemessage);
    }


}