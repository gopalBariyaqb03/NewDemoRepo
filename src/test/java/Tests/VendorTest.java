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
        vendorPage.verifyVendorFromAllTheThreeUsers(name);
    }

    @Test
    public void verifyUpdateVendorInfo(){
        loginWithDirectorCredential();
        String name = common.GenerateRandomName();
        vendorPage.createVendorUsingAdminCredencials(name);
        vendorPage.verifyVendorFromAllTheThreeUsers(name);
        loginWithDirectorCredential();
        String[] updatedValue = vendorPage.updateVendorScenario(name);
        String updatedName = updatedValue[0];
        String updatedNumber = updatedValue[1];
        String updatedRatings = updatedValue[2];
        loginWithMRCredential();
        vendorPage.verifyUpdatedInformationForVendorForAllTheUser(updatedName, updatedNumber, updatedRatings);
    }

    @Test
    public void verifyDeleteVendorScenario(){
        loginWithDirectorCredential();
        String name = common.GenerateRandomName();
        vendorPage.createVendorUsingAdminCredencials(name);
        vendorPage.verifyVendorFromAllTheThreeUsers(name);
        loginWithDirectorCredential();
        vendorPage.deleteVendorFromTheList(name);
        vendorPage.verifyVendorIsRemovedFromAllUser(name);
    }

}