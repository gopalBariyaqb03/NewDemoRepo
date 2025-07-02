package Tests;

import Config.ReadProperties;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class VendorTest extends BasePage {

    @Test
    public void verifyVendorIsCreatedAndShowingInTheAllUsers(){
        loginWithDirectorCredential();
        Faker faker = new Faker();
        String name = faker.name().firstName();
        vendorPage.createVendorUsingAdminCredencials(name);
        vendorPage.VerifyVendorFromMRUser(name);
        vendorPage.VerifyVendorFromASMUser(name);
        vendorPage.VerifyVendorFromRSMUser(name);
    }

}