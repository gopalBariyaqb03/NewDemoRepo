
package Pages;

import Config.ReadProperties;
import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class InventoryPage extends Locators {
    private static final Logger log = LoggerFactory.getLogger(InventoryPage.class);
    Common common = new Common(driver);

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];

    public void loginWithDirectorCredential(){
        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL: " + urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",username);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",password);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    public void loginWithRSMCredential(){
        String rsmCredentials[] = readProperties.getRSMCredentials();
        String Rsmusername = rsmCredentials[0];
        String RSMpassword = rsmCredentials[1];

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL: " + urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",Rsmusername);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",RSMpassword);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    public void loginWithASMCredential(){
        String ASMCredentials[] = readProperties.getASMCredential();
        String Asmusername = ASMCredentials[0];
        String Asmpassword = ASMCredentials[1];

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL: " + urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",Asmusername);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",Asmpassword);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    public void loginWithMRCredential(){
        String MRCredentials[] = readProperties.getMRCredential();
        String MRusername = MRCredentials[0];
        String MRpassword = MRCredentials[1];

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL: " + urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",MRusername);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",MRpassword);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    public void clickOnInventoryMaster(){
        common.logPrint("Step:: Click on the Inventory menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMENU));
        common.click(INVENTORYMENU);

        common.logPrint("Step:: Click on the Inventory Master sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERMENU));
        common.click(INVENTORYMASTERMENU);
    }

    public void createInventoryMasterCompany(){
        clickOnInventoryMaster();

        common.logPrint("Step:: Click on the Inventory Master Company sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERCOMPANY));
        common.click(INVENTORYMASTERCOMPANY);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Adding Company Name");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNAME));
        String COM_NAME = common.generateRandomChars(10);
        common.type(COMPANYNAME, COM_NAME);

        common.logPrint("Step :: Adding Company GST");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYGST));
        common.type(COMPANYGST, "12312312312312Z1");

        common.logPrint("Step :: Adding Company Currency");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYCURRENCY));
        common.click(COMPANYCURRENCY);
        common.downKeyAndEnter();

        common.logPrint("Step :: Adding Company FSSAI");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYFSSAI));
        common.type(COMPANYFSSAI, "123112312");

        common.logPrint("Step :: Adding Company DL NO 1");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1));
        common.type(COMPANYDLNO1, "123112312");

        common.logPrint("Step :: Adding Company DL NO 2");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2));
        common.type(COMPANYDLNO2, "123112312");

        common.logPrint("Step :: Adding Company NRX");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRX));
        common.type(COMPANYNRX, "123112312");

        common.logPrint("Step :: Adding Company FSSAI Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDATE));
        common.type(COMPANYDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company DL 1 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1EXPDATE));
        common.type(COMPANYDLNO1EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company DL 2 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2EXPDATE));
        common.type(COMPANYDLNO2EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company NRX Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRXDATE));
        common.type(COMPANYNRXDATE,"29-05-2025");

        common.fillAddress();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("Step :: Searching for added company");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYSEARCH));
        common.click(COMPANYSEARCH);
        common.type(COMPANYSEARCH, COM_NAME);
        common.click(COMPANYSEARCH_CLICK);

        common.logPrint("Step :: Validating");
        common.searchAndValidate(COM_NAME);

//                String searchResult = driver.findElement(By.xpath("//div[@title='" + COM_NAME + "']")).getText();
//                System.out.println("search Result: " + searchResult);
//                if (!searchResult.isBlank()) {
//                    common.logPrint("Step: Validated Successfully");
//                } else {
//                    common.logPrint("Step: Validation Failed");
//                }
    }

    public void createInventoryMasterCurrency(){
        common.logPrint("Step:: Click on the Inventory menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMENU));
        common.click(INVENTORYMENU);

        common.logPrint("Step:: Click on the Inventory Master sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERMENU));
        common.click(INVENTORYMASTERMENU);

        common.logPrint("Step:: Click on Inventory Master's Currency sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERCURRENCY));
        common.click(INVENTORYMASTERCURRENCY);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Adding Currency name");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String CUR_NAME = common.fakeName();
        common.type(CURRENCYNAME, CUR_NAME);

        common.logPrint("Step:: Adding Currency Symbol");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSYMBOL));
        common.type(CURRENCYSYMBOL, "R");

        common.logPrint("Step:: Adding Currency Format");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYFORMAT));
        common.type(CURRENCYFORMAT, "##,##,##");

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.logPrint("Step :: Searching for added Currency");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSEARCH));
        common.click(CURRENCYSEARCH);
        common.type(CURRENCYSEARCH, CUR_NAME);
        common.click(CURRENCYSEARCH);

        common.searchAndValidate(CUR_NAME);

//                String searchResult = driver.findElement(By.xpath("//div[@title='" + CUR_NAME + "']")).getText();
//                System.out.println("search Result: " + searchResult);
//
//                if (!searchResult.isBlank()) {
//                    common.logPrint("Step: Validated Failed");
//                } else {
//                    common.logPrint("Step: Validation Successfully");
//                }
    }

    public void createInventoryMasterCustomer(){
        common.logPrint("Step:: Click on the Inventory menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMENU));
        common.click(INVENTORYMENU);

        common.logPrint("Step:: Click on the Inventory Master sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERMENU));
        common.click(INVENTORYMASTERMENU);

        common.logPrint("Step:: Click on Inventory Master's Customer sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMASTERCUSTOMER));
        common.click(INVENTORYMASTERCUSTOMER);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Adding Customer name");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERNAME));
        String Customer_name = common.fakeName();
        common.type(CUSTOMERNAME,Customer_name);

        common.logPrint("Step :: Adding Customer GR Number");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERGRNUMBER));
        common.type(CUSTOMERGRNUMBER,"123");

        common.logPrint("Step :: Adding Customer GST Number");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERGSTNUMBER));
        String GST = common.generateRandomNumberString(15);
        common.type(CUSTOMERGSTNUMBER,GST);

        common.logPrint("Step :: Adding Customer Company");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERCOMPANY));
        common.type(CUSTOMERCOMPANY,"");
        common.pause((int) 0.5);
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Adding Customer FSSAI");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYFSSAI));
        common.type(COMPANYFSSAI, "123112312");

        common.logPrint("Step :: Adding Customer DL NO 1");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1));
        common.type(COMPANYDLNO1, "123112312");

        common.logPrint("Step :: Adding Customer DL NO 2");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2));
        common.type(COMPANYDLNO2, "123112312");

        common.logPrint("Step :: Adding Customer NRX");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRX));
        common.type(COMPANYNRX, "123112312");

        common.logPrint("Step :: Adding Customer FSSAI Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDATE));
        common.type(COMPANYDATE,"29-05-2025");

        common.logPrint("Step :: Adding Customer DL 1 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1EXPDATE));
        common.type(COMPANYDLNO1EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Customer DL 2 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2EXPDATE));
        common.type(COMPANYDLNO2EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Customer NRX Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRXDATE));
        common.type(COMPANYNRXDATE,"29-05-2025");

        common.logPrint("Step :: Adding Customer Phone Number");
        common.waitUntilElementsToBeVisible(By.xpath(PHONENO));
        common.type(PHONENO, "0980909011");

        common.logPrint("Step :: Adding Customer Discount");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERDISCOUNT));
        common.type(CUSTOMERDISCOUNT, "10");

        common.logPrint("Step :: Adding Customer HQ");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERHQ));
        common.type(CUSTOMERHQ, "ahmedabad");
        common.downKeyAndEnter();

        common.fillAddress();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(Customer_name);
    }

    public void createInventoryHSN(){
        clickOnInventoryMaster();

        common.logPrint("Step:: Click on the Inventory Master HSN sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYHSNMENU));
        common.click(INVENTORYHSNMENU);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Adding HSN name");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String Cur_name = common.generateRandomNumberString(5);
        common.type(CURRENCYNAME, Cur_name);

        common.logPrint("Step:: Adding SGST");
        common.waitUntilElementsToBeVisible(By.xpath(SGST));
        common.type(SGST, "12");

        common.logPrint("Step:: Adding CGST");
        common.waitUntilElementsToBeVisible(By.xpath(CGST));
        common.type(CGST, "12");

        common.logPrint("Step :: Adding HSN Type");
        common.waitUntilElementsToBeVisible(By.xpath(HSNTYPE));
        common.type(HSNTYPE, "");
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Adding UQC");
        common.waitUntilElementsToBeVisible(By.xpath(UQC));
        common.type(UQC, "12");

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(Cur_name);
    }

    public void createInventoryPaymentMethod(){
        clickOnInventoryMaster();

        common.logPrint("Step:: Click on the Inventory Master HSN sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYPAYMENTMETHODMENU));
        common.click(INVENTORYPAYMENTMETHODMENU);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Adding a Payment Method ");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String Cur_Name = common.fakeName();
        common.type(CURRENCYNAME, Cur_Name);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(Cur_Name);
    }

    public void createInventoryWarehouse() {
        clickOnInventoryMaster();

        common.logPrint("Step :: Clicking on Warehouse");
        common.waitUntilElementsToBeVisible(By.xpath(INVENTORYWAREHOUSE));
        String Warehouse = common.fakeName();
        common.click(INVENTORYWAREHOUSE);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Adding Warehouse Name");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERNAME));
        common.type(CUSTOMERNAME,Warehouse);
        common.downKeyAndEnter();

        common.logPrint("Step :: Selecting Warehouse");
        common.waitUntilElementsToBeVisible(By.xpath(INVENTORYCOMPANY));
        common.type(INVENTORYCOMPANY, "AHMEDABAD WAREHOUSE");
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(Warehouse.toLowerCase());
    }

    public void createInventoryVendor(){
        clickOnInventoryMaster();

        String vendorName = common.fakeName();

        common.logPrint("Step :: Clicking on Vendor");
        common.waitUntilElementsToBeVisible(By.xpath(INVENTORYVENDORMENU));
        common.click(INVENTORYVENDORMENU);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Adding Vendor Name");
        common.waitUntilElementsToBeVisible(By.xpath(VENDORNAME));
        common.type(VENDORNAME,  vendorName);

        common.logPrint("Step :: Adding GSTNUMBER");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNUMBER));
        String GST = common.generateRandomNumberString(15);
        common.type(GSTNUMBER, GST);

        common.logPrint("Step :: Selecting a Company");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANY));
        common.click(COMPANY);
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Selecting a DLNO1");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1));
        common.type(DLNO1, "10");

        common.logPrint("Step :: Selecting a DLNO2");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2));
        common.type(DLNO2, "20");

        common.logPrint("Step :: Selecting a NRX");
        common.waitUntilElementsToBeVisible(By.xpath(NRX));
        common.type(NRX, "30");

        common.logPrint("Step :: Selecting a FSSAIEXPIRYDATE");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAIEXPIRYDATE));
        common.type(FSSAIEXPIRYDATE, "20-06-2025");

        common.logPrint("Step :: Selecting a DLNO1EXPIRYDATE");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO1EXPIRYDATE));
        common.type(DLNO1EXPIRYDATE, "20-06-2025");

        common.logPrint("Step :: Selecting a DLNO2EXPIRYDATE");
        common.waitUntilElementsToBeVisible(By.xpath(DLNO2EXPIRYDATE));
        common.type(DLNO2EXPIRYDATE, "20-06-2025");

        common.logPrint("Step :: Selecting a NRXEXPIRYDATE");
        common.waitUntilElementsToBeVisible(By.xpath(NRXEXPIRYDATE));
        common.type(NRXEXPIRYDATE, "20-06-2025");

        common.logPrint("Step :: Selecting a FSSAI");
        common.waitUntilElementsToBeVisible(By.xpath(FSSAI));
        common.type(FSSAI, "10203040506070");

        common.logPrint("Step :: Selecting a PHONE");
        common.waitUntilElementsToBeVisible(By.xpath(PHONE));
        common.type(PHONE, "1020304050");

        common.logPrint("Step :: Selecting a DISCOUNT");
        common.waitUntilElementsToBeVisible(By.xpath(DISCOUNT));
        common.type(DISCOUNT, "10");

        common.fillAddress();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(vendorName.toLowerCase());
    }

    public class GiftSelector {
        public static void selectRandomGift(Common common, WebDriver driver) {
            String[] giftOptions = {DOCTORGIFT, CHEMISTGIFT, STOCKIESTGIFT, EMPLOYEEGIFT};
            Random random = new Random();
            int index = random.nextInt(giftOptions.length);

            String selectedGift = giftOptions[index];
            WebElement element = driver.findElement(By.xpath(selectedGift));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();

            common.logPrint("Step :: Randomly selected and clicked: " + selectedGift);
        }
    }

    public void createInventoryGift(){
        clickOnInventoryMaster();

        String giftName = common.fakeName();

        common.logPrint("Step :: Clicking Inventory Gift");
        common.waitUntilElementsToBeVisible(By.xpath(INVENTORYGIFT));
        common.click(INVENTORYGIFT);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Adding Gift Name");
        common.waitUntilElementsToBeVisible(By.xpath(GIFTNAME));
        common.type(GIFTNAME,  giftName);

        common.logPrint("Step :: Adding Gift Price");
        common.waitUntilElementsToBeVisible(By.xpath(GIFTPRICE));
        common.type(GIFTPRICE, "100");

        common.logPrint("Step :: Selecting Division");
        common.waitUntilElementsToBeVisible(By.xpath(DIVISION));
        common.click(DIVISION);
        common.pause(1);
        common.twoDownKeyAndEnter();

        GiftSelector.selectRandomGift(common, driver);

        common.logPrint("Step :: Entering Remarks");
        common.waitUntilElementsToBeVisible(By.xpath(MREMARK));
        common.type(MREMARK, giftName);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(AddedSuccessfully);

        common.searchAndValidate(giftName.toLowerCase());
    }

    public void createPurchaseInvoice() {
        common.logPrint("Step:: Click on the Inventory menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMENU));
        common.click(INVENTORYMENU);

        common.logPrint("Step :: Clicking Purchase Invoice");
        common.waitUntilElementsToBeVisible(By.xpath(PURCHASINVOICE));
        common.click(PURCHASINVOICE);

        common.logPrint("Step :: Capturing initial invoice number");
        common.waitUntilElementToBeVisible(By.xpath(INITIALVALUE));
        String initialValueText = common.getText(INITIALVALUE).trim();
        common.logPrint("Initial Invoice Number: " + initialValueText);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step :: Selecting a Vendor");
        common.waitUntilElementsToBeVisible(By.xpath(VENDOR));
        common.click(VENDOR);
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Selecting a Warehouse");
        common.waitUntilElementsToBeVisible(By.xpath(WAREHOUSE));
        common.click(WAREHOUSE);
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Entering Bill No");
        common.waitUntilElementsToBeVisible(By.xpath(BILLNO));
        common.type(BILLNO, "2306");

        common.logPrint("Step :: Entering Bill Date");
        common.waitUntilElementsToBeVisible(By.xpath(BILLDATE));
        common.type(BILLDATE, "23-06-2025");

        common.logPrint("Step :: Entering Extra Charges");
        common.waitUntilElementsToBeVisible(By.xpath(EXTRACHARGES));
        common.type(EXTRACHARGES, "200");

        common.logPrint("Step :: Entering Discount");
        common.waitUntilElementsToBeVisible(By.xpath(TOTALDISCOUNT));
        common.type(TOTALDISCOUNT, "10");

        common.logPrint("Step :: Entering Note");
        common.waitUntilElementsToBeVisible(By.xpath(NOTE));
        common.type(NOTE, "NOTE");

        common.logPrint("Step :: Selecting a PRODUCT");
        common.waitUntilElementsToBeVisible(By.xpath(PRODUCT));
        common.type(PRODUCT, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Selecting a HSN");
        common.waitUntilElementsToBeVisible(By.xpath(HSN));
        common.type(HSN, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Entering Batch No");
        common.waitUntilElementsToBeVisible(By.xpath(BATCH_NO));
        common.type(BATCH_NO, "2306");

        common.logPrint("Step :: Entering Price");
        common.waitUntilElementsToBeVisible(By.xpath(PURCHASEPRICE));
        common.type(PURCHASEPRICE, "2306");

        common.logPrint("Step :: Entering Quantity");
        common.waitUntilElementsToBeVisible(By.xpath(QUANTITY));
        common.type(QUANTITY, "100");

        common.logPrint("Step :: Entering Sample Quantity");
        common.waitUntilElementsToBeVisible(By.xpath(SAMPLEQUANTITY));
        common.type(SAMPLEQUANTITY, "10");

        common.logPrint("Step :: Entering Discount");
        common.waitUntilElementsToBeVisible(By.xpath(DISCOUNT2));
        common.type(DISCOUNT2, "10");

        common.logPrint("Step :: Entering Manufacture Date");
        common.waitUntilElementsToBeVisible(By.xpath(MFGDATE));
        common.type(MFGDATE, "23-06-2025");

        common.logPrint("Step :: Entering Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(EXPDATE));
        common.type(EXPDATE, "23-06-2025");

        common.logPrint("Step :: Entering MRP");
        common.waitUntilElementsToBeVisible(By.xpath(MRP));
        common.type(MRP, "200");

        common.logPrint("Step :: Clicking the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADD));
        common.click(ADD);

        common.logPrint("Step :: Selecting a Payment Method");
        common.waitUntilElementsToBeVisible(By.xpath(PAYMENTMETHOD));
        common.type(PAYMENTMETHOD, "");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Clicking the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(AMOUNT));
        common.type(AMOUNT, "200");

        common.logPrint("Step :: Additing Notes");
        common.waitUntilElementsToBeVisible(By.xpath(NOTES));
        common.type(NOTES, "200");

        common.logPrint("Step :: Clicking the Add button");
        common.waitUntilElementsToBeVisible(By.xpath(ADD2));
        common.click(ADD2);

        common.logPrint("Step :: Clicking the SAVE button");
        common.waitUntilElementsToBeVisible(By.xpath(SAVE));
        common.click(SAVE);

        common.assertElementDisplayed(AddedSuccessfully);

        try {
            common.logPrint("Step :: Capturing updated invoice number");
            common.waitUntilElementToBeVisible(By.xpath(CURRENTVALUE));
            String currentValueText = common.getText(CURRENTVALUE).trim();
            common.logPrint("Updated Invoice Number: " + currentValueText);

            int initialNumber = Integer.parseInt(initialValueText.replace("P", ""));
            int currentNumber = Integer.parseInt(currentValueText.replace("P", ""));

            if (currentNumber == initialNumber + 1) {
                common.logPrint("Validation passed: Invoice number incremented from " + initialValueText + " to " + currentValueText);
            } else {
                common.logPrint("Validation failed: Expected " + (initialNumber + 1) + ", but got " + currentValueText);
                throw new AssertionError("Invoice number did not increment by 1");
            }
        } catch (NumberFormatException e) {
            common.logPrint("Validation failed: Invalid invoice number format - " + e.getMessage());
            throw new AssertionError("Invalid invoice number format", e);
        } catch (Exception e) {
            common.logPrint("Validation failed: " + e.getMessage());
            throw new AssertionError("Error during invoice number validation", e);
        }
    }

    public void returnPurchaseInvoice() {
        common.logPrint("Step:: Click on the Inventory menu");
        common.waitUntilElementToBeVisible(By.xpath(INVENTORYMENU));
        common.click(INVENTORYMENU);

        common.logPrint("Step :: Clicking Purchase Invoice");
        common.waitUntilElementsToBeVisible(By.xpath(PURCHASINVOICE));
        common.click(PURCHASINVOICE);

        common.logPrint("Step :: Clicking the Purchase Return icon");
        common.waitUntilElementsToBeVisible(By.xpath(PURCHASERETURN));
        common.click(PURCHASERETURN);

        common.logPrint("Step :: Selecting a Return Type");
        common.waitUntilElementsToBeVisible(By.xpath(RETURNTYPE));
        common.pause(1);
        common.click(RETURNTYPE);
        common.downKeyAndEnter();

        common.logPrint("Step :: Selecting a Stock Type");
        common.waitUntilElementsToBeVisible(By.xpath(STOCKTYPE));
        common.click(STOCKTYPE);
        common.downKeyAndEnter();

        common.logPrint("Step :: Entering Extra Charges");
        common.waitUntilElementsToBeVisible(By.xpath(PREXTRACHARGES));
        common.type(PREXTRACHARGES,"100");

        common.logPrint("Step :: Entering Discount");
        common.waitUntilElementsToBeVisible(By.xpath(PRDISCOUNT));
        common.type(PRDISCOUNT,"10");

        common.logPrint("Step :: Entering Discount");
        common.waitUntilElementsToBeVisible(By.xpath(PRNOTE));
        common.type(PRNOTE,"Note");

        common.logPrint("Step :: Clicking the Edit");
        common.waitUntilElementsToBeVisible(By.xpath(PREDIT));
        common.click(PREDIT);

        common.logPrint("Step :: Capturing original purchase quantity");
        common.waitUntilElementToBeVisible(By.xpath(PRQTY));
        common.pause(1);
        int originalPurchaseQty = Integer.parseInt(common.getValue(PRQTY));
        System.out.println(originalPurchaseQty);

        int returnPurchaseNumber = originalPurchaseQty - 1;

        common.logPrint("" + returnPurchaseNumber);
        common.pause(1);
        common.type(PRQTY, "" + (originalPurchaseQty - returnPurchaseNumber));

        common.logPrint("Step :: Changing Purchase Price");
        common.waitUntilElementsToBeVisible(By.xpath(PRPRICE));
        common.type(PRPRICE, "100");

        common.logPrint("Step :: Giving Discounts");
        common.waitUntilElementsToBeVisible(By.xpath(PRDISCOUNT2));
        common.type(PRDISCOUNT2, "10");

        common.logPrint("Step :: Clicking Accept");
        common.waitUntilElementsToBeVisible(By.xpath(ACCEPT));
        common.click(ACCEPT);

        common.logPrint("Step :: Clicking the SAVE button");
        common.waitUntilElementsToBeVisible(By.xpath(SAVE));
        common.click(SAVE);
    }

    public void editInventoryMasterCompany(){
        createInventoryMasterCompany();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.logPrint("Step :: Adding Company Name");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNAME));
        String COM_NAME = common.generateRandomChars(10);
        common.type(COMPANYNAME, COM_NAME);

        common.logPrint("Step :: Adding Company GST");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYGST));
        common.type(COMPANYGST, "12312312312312Z1");

        common.logPrint("Step :: Adding Company Currency");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYCURRENCY));
        common.click(COMPANYCURRENCY);
        common.downKeyAndEnter();

        common.logPrint("Step :: Adding Company FSSAI");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYFSSAI));
        common.type(COMPANYFSSAI, "123112312");

        common.logPrint("Step :: Adding Company DL NO 1");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1));
        common.type(COMPANYDLNO1, "123112312");

        common.logPrint("Step :: Adding Company DL NO 2");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2));
        common.type(COMPANYDLNO2, "123112312");

        common.logPrint("Step :: Adding Company NRX");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRX));
        common.type(COMPANYNRX, "123112312");

        common.logPrint("Step :: Adding Company FSSAI Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDATE));
        common.type(COMPANYDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company DL 1 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO1EXPDATE));
        common.type(COMPANYDLNO1EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company DL 2 Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYDLNO2EXPDATE));
        common.type(COMPANYDLNO2EXPDATE,"29-05-2025");

        common.logPrint("Step :: Adding Company NRX Expiry Date");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYNRXDATE));
        common.type(COMPANYNRXDATE,"29-05-2025");

        common.fillAddress();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.logPrint("Step :: Searching for added company");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYSEARCH));
        common.click(COMPANYSEARCH);
        common.type(COMPANYSEARCH, COM_NAME);
        common.click(COMPANYSEARCH_CLICK);

        common.logPrint("Step :: Validating");
        common.searchAndValidate(COM_NAME);


    }

    public void editInventoryCurrency(){

        createInventoryMasterCurrency();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(CUSTOMERNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step:: Editing Currency name");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String CUR_NAME = common.fakeName();
        common.type(CURRENCYNAME, CUR_NAME);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.logPrint("Step :: Searching for Updated Currency");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSEARCH));

        common.searchAndValidate(CUR_NAME);

        common.updatedSuccessfullyValidationLog("Inventory Currency", prev_value, CUR_NAME);
 }

    public void editInventoryCustomer(){
        createInventoryMasterCustomer();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(CUSTOMERNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step :: Adding Customer name");
        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERNAME));
        String Customer_name = common.fakeName();
        common.type(CUSTOMERNAME,Customer_name);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.searchAndValidate(Customer_name);

        common.updatedSuccessfullyValidationLog("Inventory Customer", prev_value, Customer_name);

    }

    public void editInventoryMasterHSN(){

        createInventoryHSN();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(CUSTOMERNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step:: Editing HSN name");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String Cur_name = common.generateRandomNumberString(5);
        common.type(CURRENCYNAME, Cur_name);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.logPrint("Step :: Searching for Updated Currency");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSEARCH));

        common.searchAndValidate(Cur_name);

        common.updatedSuccessfullyValidationLog("Inventory HSN", prev_value, Cur_name);

    }

    public void editInventoryPaymentMethod(){
        createInventoryPaymentMethod();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(CUSTOMERNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step:: Editing a Payment Method ");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYNAME));
        String Cur_Name = common.fakeName();
        common.type(CURRENCYNAME, Cur_Name);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.logPrint("Step :: Searching for Updated Currency");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSEARCH));

        common.searchAndValidate(Cur_Name);

        common.updatedSuccessfullyValidationLog("Inventory Payment Method", prev_value, Cur_Name);

    }

    public void editInventoryWarehouse(){
        createInventoryWarehouse();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(CUSTOMERNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        String Warehouse = common.fakeName();
        common.logPrint("Step :: Adding Warehouse Name");

        common.waitUntilElementsToBeVisible(By.xpath(CUSTOMERNAME));
        common.type(CUSTOMERNAME, Warehouse);
        common.downKeyAndEnter();

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.logPrint("Step :: Searching for Updated Currency");
        common.waitUntilElementsToBeVisible(By.xpath(CURRENCYSEARCH));

        common.searchAndValidate(Warehouse);

        common.updatedSuccessfullyValidationLog("Inventory Warehouse", prev_value, Warehouse);

    }

    public void editInventoryVendor(){

        createInventoryVendor();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(VENDORNAME));
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step :: Editing GSTNUMBER");
        common.waitUntilElementsToBeVisible(By.xpath(GSTNUMBER));

        String GST = common.generateRandomNumberString(15);
        String vendorName = common.fakeName();
        common.type(GSTNUMBER, GST);

        common.logPrint("Step :: Adding Vendor Name");
        common.waitUntilElementsToBeVisible(By.xpath(VENDORNAME));
        common.type(VENDORNAME,  vendorName);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.searchAndValidate(vendorName.toLowerCase());

        common.updatedSuccessfullyValidationLog("Inventory Vendor", prev_value, vendorName);

    }

    public void editInventoryGift(){

        createInventoryGift();

        common.selectCheckBox(EDITCB);

        common.logPrint("Step:: Clicking on the Edit Button");
        common.waitUntilElementToBeVisible(By.xpath(EDITBTN));
        common.click(EDITBTN);

        common.pause(1);

        WebElement prev_cur = driver.findElement(By.xpath(GIFTNAME));
        String giftName = common.fakeName();
        String prev_value = prev_cur.getAttribute("value");
        System.out.println("Previous Customer Name "+prev_value);

        common.logPrint("Step :: Adding Gift Name");
        common.waitUntilElementsToBeVisible(By.xpath(GIFTNAME));
        common.type(GIFTNAME,  giftName);

        common.logPrint("Step :: Clicking Save");
        common.waitUntilElementsToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.assertElementDisplayed(UpdatedSuccessfully);

        common.searchAndValidate(giftName.toLowerCase());

        common.updatedSuccessfullyValidationLog("Inventory Gift ",prev_value, giftName);





    }



}