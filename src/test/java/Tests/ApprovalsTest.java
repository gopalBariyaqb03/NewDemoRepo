package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class ApprovalsTest extends BasePage {

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];
    public static String LOGOUTBTN = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-auoq4t'])[2]";

    public void loginWithDirectorCredential(){
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

    public void loginWithRSMCredential(){
        String rsmCredentials[] = readProperties.getRSMCredentials();
        String Rsmusername = rsmCredentials[0];
        String RSMpassword = rsmCredentials[1];

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
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
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
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
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);

        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",MRusername);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",MRpassword);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }


}