package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Locale;

public class InventoryTest extends BasePage {

    @Test
    public void createInventoryMaster(){
       common.loginWithDirectorCredential();
//        attributesPage.createAttributeMethod();
//        inventoryPage.createInventoryMasterCompany();
//        inventoryPage.createInventoryMasterCurrency();
//        inventoryPage.createInventoryMasterCustomer();
//        inventoryPage.createInventoryHSN();
//        inventoryPage.createInventoryPaymentMethod();
//        inventoryPage.createInventoryWarehouse();
//        inventoryPage.createInventoryVendor();
        inventoryPage.createInventoryGift();


    }

    @Test
    public void createPurchaseInvoice()
    {

        loginWithDirectorCredential();
        inventoryPage.createPurchaseInvoice();
        inventoryPage.returnPurchaseInvoice();

    }

}