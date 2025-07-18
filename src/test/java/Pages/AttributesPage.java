package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;

public class AttributesPage extends Locators {
    Common common = new Common(driver);

    public AttributesPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToDoctorMenu() {
        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);

        common.logPrint("Step:: Click on the Doctor sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORMENUATT));
        common.click(DOCTORMENUATT);
    }

    public void addMasterData(String inputXpath) {
        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        String randomText = common.generateRandomChars(10);
        common.logPrint("Step:: Enter data into input field");
        common.waitUntilElementToBeVisible(By.xpath(inputXpath));
        common.type(inputXpath, randomText);

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

        verifyDataIsCreatedAndShowingInTheTable(randomText);
    }

    public void verifyDataIsCreatedAndShowingInTheTable(String name){

        common.pause(1);
        common.logPrint("Step:: Verify that attributes is created");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELD));
        common.type(SEARCHFIELD, name);

        common.logPrint("Step:: Data is showing in the table");
        common.waitUntilElementToBeVisible(By.xpath(FIRSTROWDATA));
        String getData = common.getText(FIRSTROWDATA);
        common.assertTwoValuesAreEqual(getData, name);
    }

    public void createDoctorDegreeType(){

        navigateToDoctorMenu();

        common.logPrint("Step:: Click on the Doctor Degree type sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORDEGREETYPE));
        common.click(DOCTORDEGREETYPE);

        addMasterData(DOCTORDEGREETYPEINP);
        common.logPrint("Doctor Degree Type is created and showing properly");
    }

    public void createDoctorGuidelinesType(){

        navigateToDoctorMenu();

        common.logPrint("Step:: Click on the Doctor guidelines sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORGUIDELINESTYPEMENU));
        common.click(DOCTORGUIDELINESTYPEMENU);

        addMasterData(DOCTORGUIDELINESTYPEINP);
        common.logPrint("Doctor guidelines is created and showing properly");
    }

    public void createEntertainmentType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Entertainment Type menu");
        common.waitUntilElementToBeVisible(By.xpath(ENTERTAINMENTMENU));
        common.click(ENTERTAINMENTMENU);

        addMasterData(ENTERTAINMENTMINP);
        common.logPrint("Entertainment Type is created and showing properly");
    }

    public void createEntertainmentActivityType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Entertainment Activity Type menu");
        common.waitUntilElementToBeVisible(By.xpath(ENTERTAINMENTACTIVITYTYPE));
        common.click(ENTERTAINMENTACTIVITYTYPE);

        addMasterData(ENTERTAINMENTACTIVITYINP);
        common.logPrint("Entertainment Activity is created and showing properly");
    }

    public void createHospitalRoleType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Hospital Role Type menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALROLETYPE));
        common.click(HOSPITALROLETYPE);

        addMasterData(HOSPITALROLEINP);
        common.logPrint("Hospital role is created and showing properly");
    }

    public void createDoctorAreaOfInterestType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Doctor Area Of Interest Type menu");
        common.waitUntilElementToBeVisible(By.xpath(DOCTORAREAOFINTEREST));
        common.click(DOCTORAREAOFINTEREST);

        addMasterData(DOCTORAREAOFINTERESTINP);
        common.logPrint("Area of Interest Type created and showing properly");
    }

    public void createVendorType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Vendor Type menu");
        common.waitUntilElementToBeVisible(By.xpath(VENDORTYPEMENU));
        common.click(VENDORTYPEMENU);

        addMasterData(VENDORTYPETYPE);
        common.logPrint("Vendor type is created and showing properly");
    }

    public void createAchievementType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Achievement Type menu");
        common.waitUntilElementToBeVisible(By.xpath(ACHIVEMENTTYPEMENU));
        common.click(ACHIVEMENTTYPEMENU);

        addMasterData(ACHIVEMENTTYPETYPE);
        common.logPrint("Achievement type is created and showing properly");
    }

    public void createFeesType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Fees Type menu");
        common.waitUntilElementToBeVisible(By.xpath(FEESTYPEMENU));
        common.click(FEESTYPEMENU);

        addMasterData(FEESTYPEINP);
        common.logPrint("Fees type is created and showing properly");
    }

    public void createConferenceAndWebinarAttendedType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Conferences And Webinar Attended Type menu");
        common.waitUntilElementToBeVisible(By.xpath(CONFERENCEANDWEBINARATTENDEDTYPEMENU));
        common.click(CONFERENCEANDWEBINARATTENDEDTYPEMENU);

        addMasterData(CONFERENCEANDWEBINARATTENDEDTYPEINP);
        common.logPrint("Conference And Webinar Attended Type is created and showing properly");
    }

    public void createConferencesAndWebinarSubjectType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Conferences And Webinar Subject Type menu");
        common.waitUntilElementToBeVisible(By.xpath(CONFERENCEANDWEBINARSUBJECTTYPEMENU));
        common.click(CONFERENCEANDWEBINARSUBJECTTYPEMENU);

        addMasterData(CONFERENCEANDWEBINARSUBJECTTYPEINP);
        common.logPrint("Conferences And Webinar Subject Type is created and showing properly");
    }

    public void createRelationType() {
        navigateToDoctorMenu();
        common.logPrint("Step:: Click on the Relation Type menu");
        common.waitUntilElementToBeVisible(By.xpath(RELATIONTYPE));
        common.click(RELATIONTYPE);

        addMasterData(RELATIONTYPEINP);
        common.logPrint("Relation Type is created and showing properly");
    }

    public void verifyDegreeTypeIsShowingInMaster(String name){

        //common.openNewUrl(getPropertyValue());

    }

    public void navigateToChemisMenuAndSubmenu(String menuXpath) {
        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);

        common.logPrint("Step:: Click on the Chemist sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTMENUATT));
        common.click(CHEMISTMENUATT);

        common.logPrint("Step:: Click on the sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(menuXpath));
        common.click(menuXpath);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);
    }

    public void createChemistCategory() {

        navigateToChemisMenuAndSubmenu(CHEMISTCATEGORY);

        common.logPrint("Step:: Enter chemist category name");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYNAMEATT));
        String categoryName = common.generateRandomChars(5);
        common.type(CATEGORYNAMEATT,categoryName);

        common.logPrint("Step:: Enter category order");
        common.waitUntilElementToBeVisible(By.xpath(CATEGORYORDERATT));
        String categoryorder = common.generateRandomNumberString(2);
        common.type(CATEGORYORDERATT,categoryorder);

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

        verifyDataIsCreatedAndShowingInTheTable(categoryName);

    }

    public void createChemistContactPerson() {

        navigateToChemisMenuAndSubmenu(CONTACTPERSON);

        common.logPrint("Step:: Select chemist Name");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTNAMEDRP));
        common.click(CHEMISTNAMEDRP);
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Enter chemist contact name");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTCONTACTPERSONNAME));
        String ContactPerson = common.generateRandomChars(8);
        common.type(CHEMISTCONTACTPERSONNAME, ContactPerson);

        common.logPrint("Step:: Enter email");
        common.waitUntilElementToBeVisible(By.xpath(EAMILFIELD));
        String email = common.GenerateEmail();
        common.type(EAMILFIELD, email);

        common.logPrint("Step:: Enter email");
        common.waitUntilElementToBeVisible(By.xpath(MOBILNOFIELD));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILNOFIELD, mobileNum);

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.click(COMMNUCATIONPINCODE);
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

        verifyDataIsCreatedAndShowingInTheTable(ContactPerson);

    }

    public void createChemistCategoryType() {

        navigateToChemisMenuAndSubmenu(TYPEMENU);

        common.logPrint("Step:: Enter chemist Type name");
        common.waitUntilElementToBeVisible(By.xpath(CHEMISTTYPE));
        String categorytype = common.generateRandomChars(5);
        common.type(CHEMISTTYPE, categorytype);

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

        verifyDataIsCreatedAndShowingInTheTable(categorytype);

    }

    public void createHospitalContactPerson() {

        common.logPrint("Step:: Click on the Attributes menu");
        common.waitUntilElementToBeVisible(By.xpath(ATTRIBUTESMENU));
        common.click(ATTRIBUTESMENU);

        common.logPrint("Step:: Click on the Hospital sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALMENUATT));
        common.click(HOSPITALMENUATT);

        common.logPrint("Step:: Click on the sub-menu");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALCONTACTPERSON));
        common.click(HOSPITALCONTACTPERSON);

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Select Hospital Name");
        common.waitUntilElementToBeVisible(By.xpath(HOSPITALNAMEINPATT));
        common.click(CHEMISTNAMEDRP);
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Enter Hospital contact name");
        common.waitUntilElementToBeVisible(By.xpath(HOSCONTACTPERSON));
        String HospitalPerson = common.generateRandomChars(8);
        common.type(HOSCONTACTPERSON, HospitalPerson);

        common.logPrint("Step:: Enter email");
        common.waitUntilElementToBeVisible(By.xpath(EAMILFIELD));
        String email = common.GenerateEmail();
        common.type(EAMILFIELD, email);

        common.logPrint("Step:: Enter mobile num");
        common.waitUntilElementToBeVisible(By.xpath(MOBILNOFIELD));
        String mobileNum = common.generateRandomNumberString(10);
        common.type(MOBILNOFIELD, mobileNum);

        common.logPrint("Step:: Select communication city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUNICATIONCITY));
        common.type(COMMNUNICATIONCITY, "AHMEDABAD");
        common.pause(2);
        common.downKeyAndEnter();

        common.logPrint("Step:: Select Pincode city");
        common.waitUntilElementToBeVisible(By.xpath(COMMNUCATIONPINCODE));
        common.click(COMMNUCATIONPINCODE);
        common.pause(1);
        common.twoDownKeyAndEnter();

        common.logPrint("Step:: Click on the Save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.assertElementDisplayed("");

        verifyDataIsCreatedAndShowingInTheTable(HospitalPerson);

    }












}