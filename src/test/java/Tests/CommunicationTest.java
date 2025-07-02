package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;
import java.util.Properties;

public class CommunicationTest extends BasePage {

    ReadProperties readProperties = new ReadProperties();
    String rsmCredentials[] = readProperties.getRSMCredentials();
    String Rsmusername = rsmCredentials[0];

    String ASMCredentials[] = readProperties.getASMCredential();
    String Asmusername = ASMCredentials[0];

    String MRCredentials[] = readProperties.getMRCredential();
    String MRusername = MRCredentials[0];

    @Test
    public void verifyEmailIsSentAndReceivedInTheDirectorsUser(){
        String subject = communicationPage.createEmail("directors");
        communicationPage.verifyEmailIsSentAndShowingInTheSentSection(subject);
        communicationPage.verifyEmailIsShowingInTheDirectorUsers(subject);
    }

    @Test
    public void verifyDraftFunctionality(){
        communicationPage.verifyDraftFunctionality();
    }

    @Test
    public void verifyEmailIsShowingInASMAndMRAfterSendingFromTheRSM(){
        communicationPage.verifyEmailIsShowingInASMAndMRUser(Rsmusername, Asmusername, MRusername);
    }

    @Test
    public void verifyAnnouncementScenario(){
        communicationPage.verifyALlTheMandatoryFields();
        communicationPage.verifyCreateAnnouncementScenario();
    }


}