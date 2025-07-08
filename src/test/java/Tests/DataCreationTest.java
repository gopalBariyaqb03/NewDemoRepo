package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;

public class DataCreationTest extends BasePage {

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];
    public static String LOGOUTBTN = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-auoq4t'])[2]";

    @Test
    public void createNewRsmAsmMrUsers(){
        Faker faker = new Faker(new Locale("en-IND"));
        String Name = faker.name().firstName();
        String MRName = Name+" MR";
        String MREmail = Name+"mr@yopmail.com";
        String ASMName = Name+" Asm";
        String ASMEmail = Name+"asm@yopmail.com";
        String RSMName = Name+" Rsm";
        String RSMEmail = Name+"rsm@yopmail.com";
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);
        String webURL = urlOpen;
        loginWithDirectorCredential();
        dataCreationPage.createNewUser(RSMName, RSMEmail, "RSM");
        dataCreationPage.addIntoAccountListRSM(RSMEmail,RSMName);
        dataCreationPage.createNewUser(ASMName, ASMEmail, "ASM");
        dataCreationPage.addIntoAccountListASM(ASMEmail, ASMName, RSMName);
        dataCreationPage.createNewUser(MRName, MREmail, "MR");
        dataCreationPage.addIntoAccountListMR(MREmail, MRName, ASMName);
        String RSMPassword = homePage.getPasswordFromYopmailAndLoginToNewUser(RSMEmail);
        dataCreationPage.loginWithNewPass(RSMEmail, RSMPassword, webURL);
        String ASMPassword = homePage.getPasswordFromYopmailAndLoginToNewUser(ASMEmail);
        dataCreationPage.loginWithNewPass(ASMEmail, ASMPassword, webURL);
        String MRPassword = homePage.getPasswordFromYopmailAndLoginToNewUser(MREmail);
        dataCreationPage.loginWithNewPass(MREmail, MRPassword, webURL);
        dataCreationPage.AddRoutForTheUsers(RSMName, ASMName, MRName, webURL);
//        homePage.AddSFCForUsers(RSMName,webURL);
//        homePage.AddSFCForUsers(ASMName,webURL);
//        homePage.AddSFCForUsers(MRName,webURL);
        createNew5Doctors(MREmail, "Admin@123", MRName);
        createNew5Chemist(MREmail, "Admin@123", MRName);
        createNewStockist(MREmail, "Admin@123", MRName);
        createNewHospital(MREmail, "Admin@123", MRName);
        createNew5Doctors(ASMEmail, "Admin@123", ASMName);
        createNew5Chemist(ASMEmail, "Admin@123", ASMName);
        createNewStockist(ASMEmail, "Admin@123", ASMName);
        createNewHospital(ASMEmail, "Admin@123", ASMName);
        createNew5Doctors(RSMEmail, "Admin@123", RSMName);
        createNew5Chemist(RSMEmail, "Admin@123", RSMName);
        createNewStockist(RSMEmail, "Admin@123", RSMName);
        //createNewHospital(ASMEmail, "admin@123", RSMName);
    }

    @Test
    public void createDrChemistStockiest(){
        createNew5Doctors("Satishrsm@yopmail.com", "Admin@123", "Satishrsm");
        createNew5Chemist("Satishrsm@yopmail.com", "Admin@123", "Satishrsm");
        createNewStockist("Satishrsm@yopmail.com", "Admin@123", "Satishrsm");
        //createNewHospital("Menkarsm@yopmail.com", "Admin@123", "Menkarsm");
        createNew5Doctors("Satishasm@yopmail.com", "Admin@123", "Satishasm");
        createNew5Chemist("Satishasm@yopmail.com", "Admin@123", "Satishasm");
        createNewStockist("Satishasm@yopmail.com", "Admin@123", "Satishasm");
        //createNewHospital("MenkaAsm@yopmail.com", "Admin@123", "tanyarsm");
        createNew5Doctors("Satishmr@yopmail.com", "Admin@123", "Satishmr");
        createNew5Chemist("Satishmr@yopmail.com", "Admin@123", "Satishmr");
        createNewStockist("Satishmr@yopmail.com", "Admin@123", "Satishmr");
        //createNewHospital(ASMEmail, "admin@123", RSMName);

    }

    @Test
    public void createNew5Doctors(String email, String password, String name){
        loginWithNewlyCreateUsers(email, password);
        //loginWithSuperAdminInHolyMade();
        dataCreationPage.createNewDoctor("Dr. "+name+" A", "A", "add assignee");
        dataCreationPage.createNewDoctor("Dr. "+name+" B", "B", "add assignee");
        dataCreationPage.createNewDoctor("Dr. "+name+" C", "C", "add assignee");
        dataCreationPage.createNewDoctor("Dr. "+name+ " D", "D", "add assignee");
        dataCreationPage.createNewDoctor("Dr. "+name+ " Reject", "A", "add assignee");
    }

    @Test
    public void createNew5Chemist(String email, String password, String name){
        loginWithNewlyCreateUsers(email, password);
        dataCreationPage.createNewChemist("Chemist. "+name+" A", "A");
        dataCreationPage.createNewChemist("Chemist. "+name+" B", "B");
        dataCreationPage.createNewChemist("Chemist. "+name+" C", "C");
        dataCreationPage.createNewChemist("Chemist. "+name+" D", "D");
        dataCreationPage.createNewChemist("Chemist. "+name+" Reject", "A");
    }

    @Test
    public void createNewStockist(String email, String password, String name){
        loginWithNewlyCreateUsers(email, password);
//        Faker faker = new Faker();
//        String Name = faker.name().firstName();
//        String StockistName = "Chem. "+Name;
        dataCreationPage.createNewStockist("Stockiest. "+name+" A");
        dataCreationPage.createNewStockist("Stockiest. "+name+" B");
        dataCreationPage.createNewStockist("Stockiest. "+name+" Reject");
    }

    @Test
    public void createNewHospital(String email, String password, String name){
        loginWithNewlyCreateUsers(email, password);
//        Faker faker = new Faker();
//        String Name = faker.name().firstName();
//        String StockistName = "Chem. "+Name;
        dataCreationPage.createNewHospital("Hospital. "+name+" A");
        dataCreationPage.createNewHospital("Hospital. "+name+" B");
        dataCreationPage.createNewHospital("Hospital. "+name+" C");
        dataCreationPage.createNewHospital("Hospital. "+name+" D");
        dataCreationPage.createNewHospital("Hospital. "+name+" Reject");
    }

    public void loginWithNewlyCreateUsers(String username, String password){

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        }

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",username);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",password);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    @Test
    public void checkProductAndAddIntoBlank(){
        loginWithDirectorCredential();
        //homePage.addProductInBlankFieldDoctor();
        //homePage.approveBulkApproveDoctor();
        dataCreationPage.approveBulkApproveChemist();
    }

    @Test
    public void addDoctorAttributesFromExcel() {

        loginWithDirectorCredential();
        List<String> qualifications = common.readColumnDataFromExcel("addDoctorQualificationInAttribu");
        for (String qualification : qualifications) {
            dataCreationPage.addDoctorQualificationInAttributes(qualification);
        }

        List<String> specialities = common.readColumnDataFromExcel("addDoctorSpecialityInAttributes");
        for (String speciality : specialities) {
            dataCreationPage.addDoctorSpecialityInAttributes(speciality);
        }

//        List<String> categories = common.readColumnDataFromExcel("addDoctorCategoryInAttributes");
//        for (String category : categories) {
//            homePage.addDoctorCategoryInAttributes(category);
//        }
    }

}