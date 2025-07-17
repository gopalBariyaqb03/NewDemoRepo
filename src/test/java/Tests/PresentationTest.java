package Tests;

import Config.ReadProperties;
import Pages.PresentationPage;
import Utils.BasePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Locale;

public class PresentationTest extends BasePage {

    @Test
    public void createPresentation() {
        loginWithDirectorCredential();
        //PresentationPage.addPresentation(2);
        PresentationPage.editPresentation();
        //PresentationPage.deletePresentation();
    }

}