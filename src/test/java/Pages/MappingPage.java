package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.google.inject.spi.Elements.getElements;

public class MappingPage extends Locators {
    Common common = new Common(driver);

    public MappingPage(WebDriver driver) {
        super(driver);

    }

    public void VerifyAddDoctorChemistMapping() {
        common.logPrint("Verify Doctor Chemist mapping");
        common.logPrint("Click on Mapping ");
        common.click(MAPPINGMENU);

        common.logPrint("Click on Doctor chemist mapping menu");
        common.click(DOCTORCHEMISTMAP);

        common.logPrint("Click on ADD button");
        common.click(ADDBTN);

        common.logPrint("Select Doctor from Dropdown");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMAP));
        common.click(DOCTORMAP);
        common.type(DOCTORMAP, " ");
        common.pause(4);
        common.twoDownKeyAndEnter();
        String enteredDoctor = driver.findElement(By.xpath(DOCTORMAP)).getAttribute("value");
        System.out.println("Selected Doctor :" + enteredDoctor);


        common.logPrint("Select Chemist from Dropdown");
        common.waitUntilElementToBeVisible(By.xpath(CHEMMAP));
        common.click(CHEMMAP);
        common.pause(4);
        common.twoDownKeyAndEnter();
        String Chemname = common.getText(chememap);
        common.logPrint("Selected Chemist: " + Chemname);


        common.logPrint("Click on Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
    }

    public void VerifyViewDocChemMapping() {

        common.logPrint("Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);
        common.click(VIEWBTN);

        common.logPrint("View doctor chemist mapping ");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(VIEWDOCTORMAP));
        String ViewdocName = common.getValue(VIEWDOCTORMAP);
        common.logPrint(ViewdocName);


        common.waitUntilElementToBeVisible(By.xpath(VIEWCHEMNAME));
        String CheckChem = driver.findElement(By.xpath(VIEWCHEMNAME)).getAttribute("value");
        common.logPrint(" chemist :" + CheckChem);


        common.logPrint("Back to mapping page ");
        common.waitUntilElementToBeVisible(By.xpath(BACKBTN));
        common.click(BACKBTN);
    }

    public void VerifyEditDocChemMapping() {


        common.logPrint("Select mapping for EDIT");
        common.pause(5);
        // common.waitUntilElementToBeVisible(By.xpath(MAPCHECKBOX));
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("CLick on edit button");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);


        common.logPrint("Adding one Chemist");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(CHEMMAP));
        common.click(CHEMMAP);
        common.pause(4);
        common.twoDownKeyAndEnter();


        common.logPrint("Save the edit mapping ");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
    }
    public void VerifyCancelDeleteDocChemMappingAndSearch() {
        common.logPrint("Verify Cancel Delete Coctor chemist mapping");

        String enteredDoctor = driver.findElement(By.xpath(DOCTORMAP)).getAttribute("value");
        System.out.println("Selected Doctor :" + enteredDoctor);

        common.logPrint("Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("Delete the mapping ");
        common.pause(2);
        common.click(DELETEBTN);
        common.click(DELETEBTNPOPCANCEL);

        common.logPrint("Search deleted Doctor mapping ");
        common.pause(2);
        common.click(SEARCHFIELD);
        common.logPrint("Enter Doctor name in search");
        common.type(SEARCHFIELD, enteredDoctor);
        common.pause(2);

       ;

         common.waitUntilElementToBeVisible(By.xpath(SEARCHRESULT));
         common.pause(2);
         common.assertElementDisplayed(SEARCHRESULT);
         common.logPrint("Searched Doctor is present ");

         Common.logPrint("Click on back button");
        common.waitUntilElementToBeVisible(By.xpath(BACKBTN));
        common.click(BACKBTN);


    }



        public void VerifyDeleteDocChemMappingAndSearch() {

        common.logPrint("Verifying Search Deleted Doctor Chrmist Mapping");
            common.logPrint("Click on Doctor chemist mapping menu");
            common.click(DOCTORCHEMISTMAP);


       String enteredDoctor = driver.findElement(By.xpath(SEARCHEDDOC)).getText();
       System.out.println("Selected Doctor :" + enteredDoctor);



        common.logPrint("Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("Delete the mapping ");

        common.click(DELETEBTN);
            common.pause(2);
        common.click(DELETEBTNPOP);


        common.logPrint("Search deleted Doctor mapping ");
        common.pause(2);
        common.click(SEARCHFIELD);
        common.logPrint("Enter Doctor name in search");
        common.type(SEARCHFIELD, enteredDoctor);
        common.pause(2);

       String emptyRowText = driver.findElement(By.xpath(NOROWS)).getText();
         System.out.println("Selected Doctor :" + emptyRowText+"No Doctor Found");



        common.assertElementDisplayed(NOROWS);
        common.logPrint("Searched Doctor is not present  ");




    }
}



