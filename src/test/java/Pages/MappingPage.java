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
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class MappingPage extends Locators {
    Common common = new Common(driver);

    public MappingPage(WebDriver driver) {
        super(driver);

    }

    public String VerifyAddDoctorChemistMapping() {
        common.logPrint("Step:: Verify Doctor Chemist mapping");
        common.logPrint("Step:: Click on Mapping ");
        common.click(MAPPINGMENU);

        common.logPrint("Step:: Click on Doctor chemist mapping menu");
        common.click(DOCTORCHEMISTMAP);

        common.logPrint("Step:: Click on ADD button");
        common.click(ADDBTN);

        common.logPrint("Step:: Select Doctor from Dropdown");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMAP));
        common.click(DOCTORMAP);
        common.type(DOCTORMAP, " ");
        common.pause(4);
        common.twoDownKeyAndEnter();
        String enteredDoctor = driver.findElement(By.xpath(DOCTORMAP)).getAttribute("value");
        System.out.println("Selected Doctor :" + enteredDoctor);


        common.logPrint("Step:: Select Chemist from Dropdown");
        common.waitUntilElementToBeVisible(By.xpath(CHEMMAP));
        common.click(CHEMMAP);
        common.pause(4);
        common.twoDownKeyAndEnter();

        List<WebElement> chemistOptions = driver.findElements(By.xpath(CHEMLIST));
       // common.logPrint("Selected Chemist: " + Chemlist);


        common.logPrint("Step:: Click on Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
   return enteredDoctor;

       // common.assertElementPresent(AddedSuccessfully);
    }

    public void VerifyViewDocChemMapping() {

        common.logPrint("Step:: Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);
        common.click(VIEWBTN);

        common.logPrint("Step:: View doctor chemist mapping ");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(VIEWDOCTORMAP));
        String ViewdocName = common.getValue(VIEWDOCTORMAP);
        common.logPrint(ViewdocName);


        common.waitUntilElementToBeVisible(By.xpath(VIEWCHEMNAME));
        String CheckChem = driver.findElement(By.xpath(VIEWCHEMNAME)).getAttribute("value");
        common.logPrint(" chemist :" + CheckChem);


        common.logPrint("Step::Back to mapping page ");
        common.waitUntilElementToBeVisible(By.xpath(BACKBTN));
        common.click(BACKBTN);
    }

    public void VerifyEditDocChemMapping() {


        common.logPrint("Step:: Select mapping for EDIT");
        common.pause(5);
        // common.waitUntilElementToBeVisible(By.xpath(MAPCHECKBOX));
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("Step:: CLick on edit button");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);


        common.logPrint("Step:: Adding one Chemist");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(CHEMMAP));
        common.click(CHEMMAP);
        common.pause(4);
        common.twoDownKeyAndEnter();


        common.logPrint("Step::Save the edit mapping ");
        common.pause(4);
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
    }

    public void VerifyCancelDeleteDocChemMappingAndSearch() {
        common.logPrint("Step:: Verify Cancel Delete Coctor chemist mapping");

        String enteredDoctor = driver.findElement(By.xpath(DOCTORMAP)).getAttribute("value");
        common.logPrint("Step:: Selected Doctor :" + enteredDoctor);

        common.logPrint("Step:: Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("Step:: Delete the mapping ");
        common.pause(2);
        common.click(DELETEBTN);
        common.click(DELETEBTNPOPCANCEL);

        common.logPrint("Step:: Search deleted Doctor mapping ");
        common.pause(2);
        common.click(SEARCHFIELD);
        common.logPrint("Step:: Enter Doctor name in search");
        common.type(SEARCHFIELD, enteredDoctor);
        common.pause(2);



        common.waitUntilElementToBeVisible(By.xpath(SEARCHRESULT));
        common.pause(2);
        common.assertElementDisplayed(SEARCHRESULT);
        common.logPrint("Step:: Searched Doctor is present ");

        common.logPrint("Step::Click on back button");
        common.waitUntilElementToBeVisible(By.xpath(BACKBTN));
        common.click(BACKBTN);


    }


    public void VerifyDeleteDocChemMappingAndSearch(String docname) {

        common.logPrint("Step::Verifying Search Deleted Doctor Chrmist Mapping");
        common.logPrint("Step::Click on Doctor chemist mapping Menu");
        common.click(DOCTORCHEMISTMAP);


        //String enteredDoctor = driver.findElement(By.xpath(SEARCHEDDOC)).getText();
        //System.out.println("Selected Doctor :" + enteredDoctor);


        common.logPrint("Step::Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);

        common.logPrint("Step::Delete the mapping ");

        common.click(DELETEBTN);
        common.pause(2);
        common.click(DELETEBTNPOP);


        common.logPrint("Step:: Search deleted Doctor mapping ");
        common.pause(2);
        common.click(SEARCHFIELD);
        common.logPrint("Step:: Enter Doctor name in search");
        common.type(SEARCHFIELD, docname);
        common.pause(2);

        common.waitUntilElementToBeVisible(By.xpath(NOROWS));
        String emptyRowText = driver.findElement(By.xpath(NOROWS)).getText();
       common.logPrint("Step:: Selected Doctor :" + emptyRowText + " Doctor not Found");


        common.assertElementDisplayed(NOROWS);
        common.logPrint("Step:: Searched Doctor is not present  ");


    }

    public void VerifyAddDoctorProductMapping() {
        common.logPrint("Step:: Verifying Doctor Product mapping");
        common.logPrint("Step:: Click on Mapping ");
        common.click(MAPPINGMENU);

        common.click(DOCTORPRODUCT);

        common.logPrint("Click on ADD button");
        common.click(ADDBTN);


        common.logPrint("Step::Select Doctor from Dropdown");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMAP));
        common.click(DOCTORMAP);
        common.type(DOCTORMAP, " ");
        common.pause(4);
        common.twoDownKeyAndEnter();
        String enteredDoctor = driver.findElement(By.xpath(DOCTORMAP)).getAttribute("value");
        System.out.println("Selected Doctor :" + enteredDoctor);


        common.logPrint("Step::Selecct product from DropDown");
        common.waitUntilElementToBeVisible(By.xpath(PRODUCTMAP));
        common.click(PRODUCTMAP);
        common.type(PRODUCTMAP, " ");
        common.pause(4);
        common.twoDownKeyAndEnter();
        String enteredProduct = driver.findElement(By.xpath(PRODUCTMAP)).getAttribute("value");
        System.out.println("Selected Product :" + enteredProduct);

        common.logPrint("Step:: Save doctor product mapping");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);
    }

    public void VerifyViewDoctorProductMapping ()
    {

        common.logPrint("Step::Select 1st mapping");
        common.pause(4);
        common.selectCheckBox(MAPCHECKBOX);
        common.click(VIEWBTN);




    }

}




