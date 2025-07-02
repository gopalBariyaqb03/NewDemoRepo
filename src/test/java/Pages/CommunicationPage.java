package Pages;

import Utils.Common;
import Utils.Locators;
import org.openqa.selenium.*;

public class CommunicationPage extends Locators {
    Common common = new Common(driver);

    public CommunicationPage(WebDriver driver) {
        super(driver);
    }

    public void redirectToTheCommunicationPage(){

        common.logPrint("Step:: Search communication menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Communication");

        common.logPrint("Step:: Click on the Communication menu");
        common.waitUntilElementToBeVisible(By.xpath(COMMUNICATIONMENU));
        common.click(COMMUNICATIONMENU);

        common.logPrint("Step:: Click on the Email sub-menu");
        common.waitUntilElementsToBeVisible(By.xpath(EMAILSUBMENU));
        common.click(EMAILSUBMENU);
    }

    public void redirectToTheAnnouncementPage(){

        common.logPrint("Step:: Search communication menu");
        common.waitUntilElementToBeVisible(By.xpath(SEARCHFIELDINDASH));
        common.type(SEARCHFIELDINDASH,"Communication");

        common.logPrint("Step:: Click on the Communication menu");
        common.waitUntilElementToBeVisible(By.xpath(COMMUNICATIONMENU));
        common.click(COMMUNICATIONMENU);

        common.logPrint("Step:: Click on the Announcement sub-menu");
        common.waitUntilElementsToBeVisible(By.xpath(ANNOUNCEMENTMENU));
        common.click(ANNOUNCEMENTMENU);
    }

    public String createEmail(String TOEmail){

        common.logPrint("Step:: Login from the RSM user");
        loginWithRSMCredential();

        redirectToTheCommunicationPage();

        common.logPrint("Step:: Click on the compose button");
        common.waitUntilElementsToBeVisible(By.xpath(COMPOSEBTN));
        common.click(COMPOSEBTN);

        common.logPrint("Step:: Select user from TO. dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(TOINP));
        common.type(TOINP, TOEmail);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Enter subject in the subject field");
        String subject = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(SUBJECTINP));
        common.type(SUBJECTINP, subject);

        common.logPrint("Step:: Enter email text in the body field");
        String EmailContains = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(TEXTAREAMAIL));
        common.type(TEXTAREAMAIL, EmailContains);

        common.logPrint("Step:: Click on the send button");
        common.waitUntilElementsToBeVisible(By.xpath(SENDBTNMAIL));
        common.click(SENDBTNMAIL);

        common.refreshPage();

        return subject;
    }

    public void verifyEmailIsSentAndShowingInTheSentSection(String subject){

        common.logPrint("Step:: Verify email is showing in the sent list");

        common.logPrint("Enter subject in search field: "+ subject);
        common.waitUntilElementsToBeVisible(By.xpath(SEARCHFIELDCOMMNUNICATION));
        common.pause(2);
        common.type(SEARCHFIELDCOMMNUNICATION, subject);
    }

    public void verifyEmailIsShowingInTheDirectorUsers(String subject){

        common.logPrint("Step:: Verify email is showing in the directors user");

        common.logPrint("Step:: Login with the director user");
        loginWithDirectorCredential();

        redirectToTheCommunicationPage();

        common.logPrint("Step:: Click on the first email");
        common.pause(2);
        WebElement element = driver.findElement(By.xpath(FIRSTEMAILCHECKBOX));
        element.click();

        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementsToBeVisible(By.xpath(VIEWBTNCOM));
        common.click(VIEWBTNCOM);

        common.logPrint("Step:: Get subject from the subject field");
        String getSubject = common.getText(GETSUBJECT);
        common.assertTwoValuesAreEqual(subject, getSubject);
        common.logPrint("Subject is showing properly on the email");

        common.logPrint("Step:: Get To email from the mail");
        String getToEmail = common.getText(GETTO);
        common.assertTwoValuesAreEqual("Bharat Solanki", getToEmail);
        common.logPrint("To email is showing properly on the email");
    }

    public void verifyDraftFunctionality(){

        loginWithDirectorCredential();
        redirectToTheCommunicationPage();

        common.logPrint("Step:: Click on the compose button");
        common.waitUntilElementsToBeVisible(By.xpath(COMPOSEBTN));
        common.click(COMPOSEBTN);

        common.logPrint("Step:: Select user from TO. dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(TODROPDOWN));
        common.click(TODROPDOWN);
        common.pause(1);
        common.downKeyAndEnter();

        common.logPrint("Step:: Enter subject in the subject field");
        String subject = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(SUBJECTINP));
        common.type(SUBJECTINP, subject);

        common.logPrint("Step:: Enter email text in the body field");
        String EmailContains = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(TEXTAREAMAIL));
        common.type(TEXTAREAMAIL, EmailContains);

        common.logPrint("Step:: Click on the Add to Draft button");
        common.waitUntilElementsToBeVisible(By.xpath(ADDTODRAFTBTN));
        common.click(ADDTODRAFTBTN);

        common.logPrint("Step:: Click on the first email");
        common.pause(2);
        WebElement element = driver.findElement(By.xpath(FIRSTEMAILCHECKBOX));
        element.click();

        common.logPrint("Step:: Click on the Compose again button");
        common.waitUntilElementsToBeVisible(By.xpath(COMPOSEAGAINBTN));
        common.click(COMPOSEAGAINBTN);

        common.logPrint("Step:: Verify email subject is showing properly on the email");
        WebElement element1 = driver.findElement(By.xpath("//input[@name='Subject']"));
        String value = element1.getAttribute("value");
        common.logPrint(value);

        String getSubjec = common.getText("//input[@name='Subject']");
        common.assertTwoValuesAreEqual(getSubjec, subject);

        common.logPrint("Step:: Verify email contain is showing properly on the email");
        String emailContain = common.getText(TEXTAREAMAIL);
        common.assertTwoValuesAreEqual(emailContain, EmailContains);

    }

    public void verifyEmailIsShowingInASMAndMRUser(String RSM, String ASM, String MR){

        loginWithRSMCredential();

        redirectToTheCommunicationPage();

        String asmEmail = ASM;
        String asmName = asmEmail.split("@")[0];
        String firstAsmName= asmName.replaceAll("asm", " asm");

        String mrEmail = MR;
        String mrName = mrEmail.split("@")[0];
        String firstMRName= mrName.replaceAll("mr", " mr");

        common.logPrint("Step:: Click on the compose button");
        common.waitUntilElementsToBeVisible(By.xpath(COMPOSEBTN));
        common.click(COMPOSEBTN);

        common.logPrint("Step:: Select user from TO. dropdown");
        common.waitUntilElementsToBeVisible(By.xpath(TOINP));
        common.type(TOINP, firstAsmName);
        common.pause(2);
        common.downKeyAndEnter();

        common.pause(1);
        common.type(TOINP, firstMRName);
        common.pause(2);
        common.downKeyAndEnter();
        common.logPrint("Entered email name is: "+ asmEmail+" and "+mrEmail);

        common.logPrint("Step:: Enter subject in the subject field");
        String subject = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(SUBJECTINP));
        common.type(SUBJECTINP, subject);

        common.logPrint("Step:: Enter email text in the body field");
        String EmailContains = common.GenerateOneLineText(10);
        common.waitUntilElementsToBeVisible(By.xpath(TEXTAREAMAIL));
        common.type(TEXTAREAMAIL, EmailContains);

        common.logPrint("Step:: Click on the send button");
        common.waitUntilElementsToBeVisible(By.xpath(SENDBTNMAIL));
        common.click(SENDBTNMAIL);

        loginWithASMCredential();

        redirectToTheCommunicationPage();

        common.logPrint("Step:: Verify email is showing in the ASM account");

        common.logPrint("Step:: Click on the first email");
        common.pause(2);
        WebElement element = driver.findElement(By.xpath(FIRSTEMAILCHECKBOX));
        element.click();

        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementsToBeVisible(By.xpath(VIEWBTNCOM));
        common.click(VIEWBTNCOM);

        common.logPrint("Step:: Get subject from the subject field");
        String getSubject = common.getText(GETSUBJECT);
        common.assertTwoValuesAreEqual(subject, getSubject);
        common.logPrint("Subject is showing properly on the email");

        common.logPrint("Step:: Get To email from the mail");
        String getToEmail = common.getText(GETTO);
        String[] ToEmails = getToEmail.split(",");

        String toFirstMail = ToEmails[0].trim();
        String toSecondEmail = ToEmails[1].trim();

        common.assertTwoValuesAreEqual(firstAsmName.toLowerCase(), toFirstMail.toLowerCase());
        common.logPrint("To email is showing properly on the email");

        common.assertTwoValuesAreEqual(firstMRName.toLowerCase(), toSecondEmail.toLowerCase());
        common.logPrint("To email is showing properly on the email");

        common.logPrint("Step:: Verify email contain is showing properly on the email");
        String emailContain = common.getText(MESSAGEAREA);
        common.assertTwoValuesAreEqual(emailContain, EmailContains);

        common.logPrint("Step:: Verify with the MR user");

        loginWithMRCredential();

        redirectToTheCommunicationPage();

        common.logPrint("Step:: Verify email is showing in the ASM account");

        common.logPrint("Step:: Click on the first email");
        common.pause(2);
        WebElement element1 = driver.findElement(By.xpath(FIRSTEMAILCHECKBOX));
        element1.click();

        common.logPrint("Step:: Click on the view button");
        common.waitUntilElementsToBeVisible(By.xpath(VIEWBTNCOM));
        common.click(VIEWBTNCOM);

        common.logPrint("Step:: Get subject from the subject field");
        String getSubject1 = common.getText(GETSUBJECT);
        common.assertTwoValuesAreEqual(subject, getSubject1);
        common.logPrint("Subject is showing properly on the email");

        common.logPrint("Step:: Get To email from the mail");
        String getToEmail1 = common.getText(GETTO);
        String[] ToEmails1 = getToEmail1.split(",");

        String toFirstMail1 = ToEmails1[0].trim();
        String toSecondEmail1 = ToEmails1[1].trim();

        common.assertTwoValuesAreEqual(firstAsmName.toLowerCase(), toFirstMail1.toLowerCase());
        common.logPrint("To email is showing properly on the email");

        common.assertTwoValuesAreEqual(firstMRName.toLowerCase(), toSecondEmail1.toLowerCase());
        common.logPrint("To email is showing properly on the email");

        common.logPrint("Step:: Verify email contain is showing properly on the email");
        String emailContain1 = common.getText(MESSAGEAREA);
        common.assertTwoValuesAreEqual(emailContain1, EmailContains);
    }

    public void verifyALlTheMandatoryFields(){

        loginWithDirectorCredential();

        redirectToTheAnnouncementPage();

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Verified To field validation message are showing properly");
        common.waitUntilElementToBeVisible(By.xpath(TOFIELDVALIDATION));
        String getValidation = common.getText(TOFIELDVALIDATION);
        common.assertTwoValuesAreEqual(getValidation, "To is Required");

        common.logPrint("Step:: Verified To field validation message are showing properly");
        common.waitUntilElementToBeVisible(By.xpath(TITLEVALIDATION));
        String getValidationTitle = common.getText(TITLEVALIDATION);
        common.assertTwoValuesAreEqual(getValidationTitle, "Title is required");

    }

    public void verifyCreateAnnouncementScenario(){

        loginWithDirectorCredential();

        redirectToTheAnnouncementPage();

        common.logPrint("Step:: Click on the Add button");
        common.waitUntilElementToBeVisible(By.xpath(ADDBTN));
        common.click(ADDBTN);

        common.logPrint("Step:: Click on the To field dropdown");
        common.waitUntilElementToBeVisible(By.xpath(TOANNOUNCEMENT));
        common.click(TOANNOUNCEMENT);
        common.pause(1);
        common.downKeyAndEnter();

        String title = common.GenerateParagraph(5);
        common.waitUntilElementToBeVisible(By.xpath(TITLEINP));
        common.type(TITLEINP, title);
        common.logPrint("Entered title is"+ title);

        String Message = common.GenerateParagraph(5);
        common.waitUntilElementToBeVisible(By.xpath(MESSAGEINP));
        common.type(MESSAGEINP, Message);
        common.logPrint("Entered title is"+ Message);

        String bodyTextArea = common.GenerateParagraph(5);
        common.waitUntilElementToBeVisible(By.xpath(BODYINP));
        common.type(MESSAGEINP, bodyTextArea);
        common.logPrint("Entered title is"+ bodyTextArea);

        common.logPrint("Step:: Click on the save button");
        common.waitUntilElementToBeVisible(By.xpath(SAVEBUTTON));
        common.click(SAVEBUTTON);

        common.logPrint("Step:: Check validation is displayed");
        common.waitUntilElementToBeVisible(By.xpath(AddedSuccessfully));
        common.assertElementDisplayed(AddedSuccessfully);

    }

}