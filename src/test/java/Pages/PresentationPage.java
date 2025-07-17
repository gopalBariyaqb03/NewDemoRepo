package Pages;
import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.apache.cassandra.index.sasi.sa.SA;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PresentationPage extends Locators {
    static Common common = new Common(driver);

    public PresentationPage(WebDriver driver) {
        super(driver);
    }

    public static void redirectsToPresentation() {
        common.logPrint("Step:: Click on the Presentation menu");
        common.waitUntilElementToBeVisible(By.xpath(PRESENTATIONMENU));
        common.click(PRESENTATIONMENU);
    }

    public static String addPresentation(int amountOfImages){

        redirectsToPresentation();

        common.logPrint("Step :: Clicking the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Entering Presentation Name");
        common.waitUntilElementsToBeVisible(By.xpath(PRESNAME));
        common.click(PRESNAME);
        String name = common.fakeName();
        common.type(PRESNAME, name);

        for (int i=0; i< amountOfImages; i++) {
            common.logPrint("Step :: Selecting VA");
            common.waitUntilElementsToBeVisible(By.xpath(PRESVA));
            common.click(PRESVA);
            common.dynamicDownKeyPress(i+10);
            common.pause(1);
        }

        common.logPrint("Step :: Selecting a Doc");
        common.waitUntilElementsToBeVisible(By.xpath(PRESDOC));
        common.click(PRESDOC);
        common.dynamicDownKeyPress(15);

        common.logPrint("Step :: Entering Presentation Description");
        common.waitUntilElementsToBeVisible(By.xpath(PRESDESC));
        common.click(PRESDESC);
        common.type(PRESDESC, name);

        common.logPrint("Step :: Clicking the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.pause(2);
        common.searchAndValidate(name);


        return name;
    }

    public static void editPresentation(){

        String name = addPresentation(3);
        common.selectCheckBox(PRESCB);

        List<WebElement> chips = driver.findElements(By.xpath(PRESBE));

        List<String> selectedProducts = new ArrayList<>();
        for (WebElement chip : chips) {
            selectedProducts.add(chip.getText());
            System.out.println("Selected Products" + selectedProducts);
        }

        common.logPrint("Step :: Clicking the Edit button");
        common.waitUntilElementsToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step :: Selecting VA");
        common.waitUntilElementsToBeVisible(By.xpath(PRESVA));
        common.click(PRESVA);
        common.dynamicDownKeyPress(15);
        common.pause(1);

        common.logPrint("Step :: Clicking the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.pause(2);
        common.searchAndValidate(name);

        List<WebElement> editChips = driver.findElements(By.xpath(PRESBE));

        List<String> editSelectedProducts = new ArrayList<>();
        for (WebElement chip : editChips) {
            editSelectedProducts.add(chip.getText());
            System.out.println("Post Edit Products" + editSelectedProducts);
        }

        if (editSelectedProducts.equals(selectedProducts)){
            System.out.println("Before Edit" + selectedProducts + " After Edit" + editSelectedProducts+ "Edit didn't work");
        }
        else{
            System.out.println("Before Edit" + selectedProducts + " After Edit" + editSelectedProducts+ " Edited Successfully");
        }
    }

    public static void deletePresentation(){

        String name = addPresentation(3);
        common.selectCheckBox(PRESCB);

        common.logPrint("Step :: Clicking the Delete Button");
        common.waitUntilElementToBeVisible(By.xpath(DELETEBTN));
        common.click(DELETEBTN);

        common.click(PRODUCTDELETEYES);
        common.pause(1);
        common.assertElementDisplayed(DeletedSuccessfully);
        common.searchAndValidate(name);

        WebElement noRows = driver.findElement(By.xpath(PRESDELVAL));

        if (noRows.isDisplayed()){
        System.out.println("Deleted Successfully");
        }
        else{
            System.out.println("Didn't delete");
        }
    }

}