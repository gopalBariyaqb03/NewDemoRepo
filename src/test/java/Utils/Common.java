package Utils;

import com.github.javafaker.Faker;
import com.google.gson.*;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


/**
 * Define Common Web driver
 *
 * @author whimstay
 */
public class Common extends Locators {

//	protected static WebDriver driver;

    public Common(WebDriver driver) {

        super(driver);
    }

    public WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebDriverWait getWait(long time) {
        // Set time in second to wait for elements
        return new WebDriverWait(driver, Duration.ofSeconds(time));
    }

    public WebElement waitUntilElementToBeClickable(By by) {

        try {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));

        } catch (StaleElementReferenceException e) {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(by));
        }
    }

    public void waitUntilElementToBeClickable(WebElement element) {
        try {
            getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        } catch (StaleElementReferenceException e) {
            getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
        }
    }

    public WebElement waitUntilPresenceOfElementLocated(By by) {
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementToBeClickable(String locator) {

        try {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(findBy(locator)));

        } catch (StaleElementReferenceException e) {
            return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(findBy(locator)));
        }
    }

    public WebElement waitUntilStringLocator(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(findBy(locator)));
    }

    public WebElement waitUntilStringLocatorAsaElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitUntilInvisible(String locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return getWait(150).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(findElement(locator)));
    }

    public Boolean waitUntilElementToBeInvisible(WebElement element) {
        return getWait(150).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.invisibilityOf(element));
    }

    public List<WebElement> waitUntilElementsToBeVisible(By by) {
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public String removeZero (String input){
        input = input.indexOf(".") < 0 ? input : input.replaceAll("0*$", "").replaceAll("\\.$", "");
        return input;
    }

    /**
     * Check alert is present or not and accept it if present.
     *
     * @return Text on alert if present, otherwise null
     */
    public String handleAlert() {
        String strAltert = null;
        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            strAltert = alert.getText();
            alert.accept();
            pause(2);
        }
        return strAltert;
    }

    /**
     * Check alert is present or not.
     *
     * @return True if alert present, otherwise false
     */
    public boolean isAlertPresent() {
        pause(1);
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException ex) {
            return false;
        }
    }

    public String current_window;

    public void switchToSecondWindow() {
        try {
            current_window = this.driver.getWindowHandle();
            Set<String> allwindows = this.driver.getWindowHandles();
            int i = 0;
            for (String s : allwindows) {
                i = i + 1;
                if (i == 2) {
                    this.driver.switchTo().window(s);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void  switch_windows(Set<String>  windowHandles, String title){
        // Iterate through the window handles
        for (String windowHandle : windowHandles) {
            // Switch to the window handle
            driver.switchTo().window(windowHandle);

            // Check the window title
            String windowTitle = driver.getTitle();

            // If the window title matches "Plaid flow", break the loop and stay in this window
            if (windowTitle.equals(title)) {
                common.logPrint("Switched to window with title: " + windowTitle);
                break;
            }
        }

    }

    public void switchToTab(int n){

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(n));
    }

    public void waitUntilSpecificTitle(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public void mouseOver(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform(); // Moves the cursor to the element
    }

    public void switchToWindow(int n) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles()); // "windows" instead of "tabs"
        driver.switchTo().window(windows.get(n));
    }
    /**
     * Get past date in MM/dd/yyyy format as per argument.
     *
     * @param days the days to get past date
     * @return Past date in MM/dd/yyyy format before given days from current date
     */
    public String PastDate(int days) throws ParseException {
        Date dateNow = new Date();
        SimpleDateFormat dateFormatyyyyMMdd = new SimpleDateFormat("MM/dd/yyyy"); // Date Format
        String date_to_string = dateFormatyyyyMMdd.format(dateNow);
        String untilDate = date_to_string;// Current Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance(); // Get Calendar Instance
        cal.setTime(dateFormat.parse(untilDate));
        // Past Date
        cal.add(Calendar.DATE, -days);
        String pastdate = dateFormat.format(cal.getTime());
        return pastdate;
    }

    /**
     * Takes screenshot and adds it to TestNG report.
     *
     * @param driver WebDriver instance.
     */
    public void makeScreenshot(WebDriver driver, String screenshotName) {
        WebDriver augmentedDriver = new Augmenter().augment(driver);
        /* Take a screenshot */
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";

        /* Copy screenshot to specific folder */
        try {
            String reportFolder = "target" + File.separator + "failsafe-reports" + File.separator + "chrome" + File.separator;
            String screenshotsFolder = "screenshots";
            File screenshotFolder = new File(reportFolder + screenshotsFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            FileUtils.copyFile(screenshot, new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile());
        } catch (IOException e) {
            Reporter.log("Failed to capture screenshot: " + e.getMessage());
        }
        Reporter.log(getScreenshotLink(nameWithExtention, nameWithExtention)); // add screenshot link to the report
    }

    /**
     * Generates link for TestNG report.
     *
     * @param screenshot_name Screenshot name.
     * @param link_text       Link text.
     * @return Formatted link for TestNG report.
     */
    public String getScreenshotLink(String screenshot_name, String link_text) {
        Reporter.log("<Strong><font color=#FF0000>--Failed</font></strong>");
        return "<a href='../target/failsafe-reports/firefox/screenshots/" + screenshot_name + "'>" + link_text + "</a>";
    }

    /**
     * Assertion to check that given element is not being displayed.
     *
     * @param locator the locator of element to be checked
     */
    public void assertElementIsNotDisplayed(String locator) {
        pause(2);
        Assert.assertFalse(isElementDisplayed(locator));
    }
    /**
     * Assertion to check that given element is being displayed.
     *
     * @param element the locator of element to be checked
     */
    public void assertElementIsDisplayed(WebElement element) {
        waitUntilElementToBeClickable(element);
        Assert.assertTrue(isElementDisplayed(String.valueOf(element)));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);
    }


    /**
     * Checks that given element is checked or not.
     *
     * @param locator the locator of element to be checked
     * @return true if element checked,otherwise false
     */
    public boolean isChecked(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        return element.isSelected();
    }

    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     *
     * @param locator The locator of element to get its attribute value
     * @return The attribute/property's current value or null if the value is not
     * set.
     */
    public String getValue(String locator) {
        // pause(1);
        WebElement element = waitUntilPresenceOfElementLocated(By.xpath(locator));
        return element.getAttribute("value");
    }

    /**
     * Assertion to check that two values are equal.
     *
     * @param value1 Value-1.
     * @param value2 Value-2.
     */
    public void assertTwoValuesAreEqual(Object value1, Object value2) {
        pause(1);
        Assert.assertEquals(value1, value2);
    }

    /**
     * Assertion to check that two values are not equal.
     *
     * @param value1 Value-1.
     * @param value2 Value-2.
     */
    public void assertTwoValuesAreNotEqual(Object value1, Object value2) {
        pause(2);
        Assert.assertNotEquals(value1, value2);
    }

    /**
     * Checks given element is being displayed or not on page.
     *
     * @param locator the locator of element to be checked present or not
     * @return True if the element displayed, false otherwise
     */
    public boolean isElementDisplayed(String locator) {
        try {
            WebElement element = this.findElement(locator);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementNotDisplayed(String locator) {
        try {
            WebElement element = this.findElement(locator);
            return !element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Common method to send a POST request and get the response as JsonObject
     */
//    public JsonObject sendPostRequestAndGetJsonResponse(String endpoint, String requestBodyPath) {
//        Response response = JSONFileReader.sendPostRequest(endpoint, requestBodyPath);
//        String responseBody = response.getBody().asString();
//        return new JsonParser().parse(responseBody).getAsJsonObject();
//    }

    /**
     * Common method to assert response status code and execution result status
     */
    public void assertResponseStatusAndExecutionResultStatus(Response response, String expectedStatus) {

        JsonObject executionResult = new JsonParser().parse(response.getBody().asString()).getAsJsonObject().getAsJsonObject("executionResult");
        String status = executionResult.get("status").getAsString();
        Assert.assertEquals(status, expectedStatus, "The status is not '" + expectedStatus + "'");
    }

    public WebElement waitUntilElementToBeVisible(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));  // or use By.cssSelector(locator) or By.id(locator), etc.
        return getWait().ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }


    public void mouseOverClick(WebElement element) {
        waitUntilElementToBeClickable(element);
        Actions actions = new Actions(driver);
        highlightElement(element);
        actions.moveToElement(element).click().perform();
    }
    /**
     * Scroll page to element for given locator.
     *
     * @param locator the locator of element where to scroll
     *
     */
    public void scroll_To_Element(String locator) {
        WebElement element = waitUntilElementToBeVisible(findBy(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }


    public WebElement waitUntilElementToBeVisible(By by) {

        try {
            return getWait().ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));

        } catch (StaleElementReferenceException e) {
            return getWait().ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }

    }
    public boolean isElementEnabled(String locator) {
        return true;
    }

    public boolean isElementDisabled(String locator) {

        WebElement element = waitUntilElementToBeVisible(By.xpath(locator));
        if (!element.isEnabled()) {
            return true;
        }
        return false;


    }


    /**
     *  Common method to log response details
     */
    public static void logResponseDetails(JsonObject jsonResponse) {
        JsonObject executionResult = jsonResponse.getAsJsonObject("executionResult");

        // Create a new JSON object to store the filtered fields
        JsonObject filteredResult = new JsonObject();
        filteredResult.add("status", executionResult.get("status"));
        filteredResult.add("discreteCriteriaVersion", executionResult.get("discreteCriteriaVersion"));
        filteredResult.add("criteriaStage", executionResult.getAsJsonObject("criteriaStage"));

        JsonArray offers = jsonResponse.getAsJsonArray("offers");
        JsonElement mck3ScoreElement = executionResult.has("mck3Score") ? executionResult.get("mck3Score") : JsonNull.INSTANCE;

        // Initialize Gson object for pretty printing
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        common.logPrint("Step :: <b>Execution Result = " +"</b>" + gson.toJson(filteredResult));
        common.logPrint("Step :: <b>Offer Result = " +"</b>"+ gson.toJson(offers));
        common.logPrint("Step :: <b>MCK3 Score = " +"</b>" + mck3ScoreElement.toString());
        common.logPrint("Step :: <b>Full Response = "  +"</b>"+ jsonResponse);


        // Extract 'criteriaStage' and 'failedCriterias'
        JsonObject executionResult1 = jsonResponse.getAsJsonObject("executionResult");
        JsonObject criteriaStage = executionResult1.getAsJsonObject("criteriaStage");
        JsonArray failedCriterias = criteriaStage.getAsJsonArray("failedCriterias");

        // Convert 'failedCriterias' to a list of strings
        List<String> failedCriteriasList = new ArrayList<>();
        for (JsonElement criteria : failedCriterias) {
            failedCriteriasList.add(criteria.getAsString());
        }
    }




    /**
     * Check that given element is present or not.
     *
     * @param locator the locator of element to be checked present or not
     * @return True if the element present, false otherwise
     */
    public boolean isElementPresent(String locator) {
        try {
            //pause(5);
            waitUntilStringLocator(locator);
            highlightElement(this.findElement(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check that given element is present or not.
     *
     * @param xpath the xpath of element to be checked present or not
     * @return True if the element present, false otherwise
     */
    public boolean existsElementFalse(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            highlightElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * Assertion to check that given element is not present.
     *
     * @param locator the locator of element
     */
    public void assertElementNotPresent(String locator) {
        pause(2);
        Assert.assertFalse(isElementPresent(locator));
    }

    /**
     * Assertion to check that given element is present.
     *
     * @param locator the locator of element
     */
    public void assertElementPresent(String locator) {
        waitUntilStringLocator(locator);
        highlightElement(locator);
        Assert.assertTrue(isElementPresent(locator));
    }

    /**
     * Assertion to check that given element is present.
     *
     * @param locator the locator of element
     *
     */
    public void assertElementPresentWithMessage(String locator, String message) {

        Assert.assertTrue(isElementPresent(locator), message);
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of seconds, subject to the precision and accuracy of
     * system timers and schedulers. The thread does not lose ownership of any
     * monitors.
     *
     * @param seconds the time in second to pause execution
     */

    public void pause(int seconds) {

//		driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException interruptedException) {
        }
    }

    public String replaceAll(String input) {

        String fundValue = input.replaceAll("[^0-9.]", "");
        double d = Double.parseDouble(fundValue);
        int rounded_fundValue = (int) d;
        return Integer.toString(rounded_fundValue);

    }

    public String replaceSpecialChar(String input) {
        String fundValue = input.replaceAll("[^0-9.]", "");
        return fundValue;
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease execution)
     * for the specified number of milliseconds, subject to the precision and
     * accuracy of system timers and schedulers. The thread does not lose ownership
     * of any monitors.
     */
    public void pause2Sec() {

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    /**
     * Returns the number of elements in this list. If this list contains more than
     * {@code Integer.MAX_VALUE} elements, returns {@code Integer.MAX_VALUE}.
     *
     * @param locator the locator of element to find list to get size
     * @return the number of elements in this list
     */
    public int size(String locator) {
        // pause(2);
        List<WebElement> element = waitUntilElementsToBeVisible(findBy(locator));
        return element.size();
    }

    /**
     * <p>
     * Log the passed string to the HTML reports.
     * </p>
     *
     * <p>
     * Print the passed string and then terminates the line.
     * </p>
     *
     * @param print the message to log and to print
     */
    public void logPrint(String print) {
        if (print.startsWith("Step")) {
            int stepcount = BasePage.steps.get();
            String[] msg = print.split("::");
            Reporter.log("<br>Step " + stepcount + " : " + msg[1].trim(),true);
//            System.out.println("Step " + stepcount + " : " + msg[1].trim());
            BasePage.steps.set(stepcount + 1);
        } else {
            Reporter.log("<br>Message : " + print,true);
//            System.out.println("Message : " + print);

        }
    }

    /**
     * Select the option of given element at random index. This is done by examining
     * the "index" attribute of an element, and not merely by counting.
     *
     * @param locator the locator of element to be selected by random index
     * @return The element's current visible text after selection or null if the
     * value is not set.
     */
    public int selectByRandomIndex(String locator) {
        WebElement element = waitUntilElementToBeClickable(locator);
        highlightElement(element);
        Select dropdown = new Select(element);
        Random random = new Random();
        dropdown.selectByIndex(random.nextInt(dropdown.getOptions().size()));
        handleAlert();
        return 0;
    }

    /**
     * Method to move to an element
     */

    public void moveToElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void moveToElementAndClick(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }
    public void moveToElementAndClick(String locator){
        Actions actions = new Actions(driver);
        WebElement element = waitUntilElementToBeClickable(locator);
        actions.moveToElement(element).click().build().perform();
    }


    /**
     * Check the checkbox or toggle element.
     *
     * @param locator the locator of checkbox element to be checked
     */
    public void checkChkBox(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        highlightElement(element);
        boolean isCheckBoxChecked = element.isSelected();
        if (!isCheckBoxChecked) {
            try {
                element.click();
            } catch (Exception e) {
                jsClickWithoutWait(element);
            }
        }
    }

    public void scrollToElement(String locator)  {
        WebElement element = waitUntilStringLocator(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Thread.sleep(500);
    }

    public void scroll_To_Element(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    /**
     * <p>
     * Creates a random character string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of alphabetic characters.
     * </p>
     *
     * @param length the length of random character string to create
     * @return The random character string in lower case
     */
    public  String generateRandomChars(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }
    /**
     * <p>
     * Creates a random character string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of alphabetic characters.
     * </p>
     *
     * @param length the length of random character string to create
     * @return The random character string in lower case
     */
    public  String generateRandomCharsToUpperCase(int length) {
        return RandomStringUtils.randomAlphabetic(length).toUpperCase();
    }

    /**
     * <p>
     * Creates a random number string whose length is the number of characters
     * specified.
     * </p>
     *
     * <p>
     * Characters will be chosen from the set of numeric characters.
     * </p>
     *
     * @param length the length of random number string to create
     * @return The random number string
     */
    public  String generateRandomNumberString(int length) {

        return RandomStringUtils.randomNumeric(length);
    }

    public  String generateRandomNumberString(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return String.valueOf(randomNumber);
    }




    /**
     * Highlight given element
     *
     * @param locator the locator of element to be highlighted
     */
    public void highlightElement(String locator) {
        WebElement element = waitUntilStringLocator(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
    }

    /**
     * Highlight given element
     *
     * @param element the element to be highlighted
     */
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid yellow'", element);
    }

    public void highlightElementClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid green'", element);
    }

    public static By findBy(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return By.partialLinkText(locator);
            return By.linkText(locator);
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return By.id(locator);
        } else if (locator.startsWith("//") || locator.startsWith("(//")) {
            return By.xpath(locator);
        } else if (locator.startsWith("#")) {
            return By.cssSelector(locator);
        } else if (locator.startsWith("css=")) {
            locator = locator.substring(4);
            return By.cssSelector(locator);
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return By.name(locator);
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return By.className(locator);
        } else if (locator.equalsIgnoreCase("body")) {
            return By.cssSelector(locator);
        } else {
            return By.id(locator);
        }
    }

    /**
     * Find the first {@link WebElement} using the given method. This method is
     * affected by the 'implicit wait' times in force at the time of execution. The
     * findElement(..) invocation will return a matching row, or try again
     * repeatedly until the configured timeout is reached.
     *
     * @param locator the locator to be used by locating mechanism to find element
     * @return The first matching element on the current page
     * @throws NoSuchElementException If no matching elements are found
     */
    public WebElement findElement(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return driver.findElement(By.partialLinkText(locator));
            return driver.findElement(By.linkText(locator));
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return driver.findElement(By.id(locator));
        } else if (locator.startsWith("//") || locator.startsWith("(//")) {
            return driver.findElement(By.xpath(locator));
        } else if (locator.startsWith("#")) {
            return driver.findElement(By.cssSelector(locator));
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return driver.findElement(By.name(locator));
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return driver.findElement(By.className(locator));
        } else if (locator.equalsIgnoreCase("body")) {
            return driver.findElement(By.cssSelector(locator));
        } else {
            return driver.findElement(By.id(locator));
        }
    }

    /**
     * Find all elements within the current page using the given mechanism. This
     * method is affected by the 'implicit wait' times in force at the time of
     * execution. When implicitly waiting, this method will return as soon as there
     * are more than zero items in the found collection, or will return an empty list
     * if the timeout is reached.
     *
     * @param locator the locator to be used by locating mechanism to find elements
     * @return A list of all matching {@link WebElement}s, or an empty list if
     * nothing matches
     */
    public List<WebElement> findElements(String locator) {
        if (locator.startsWith("link=") || locator.startsWith("LINK=")) {
            locator = locator.substring(5); // remove "link=" from locator
            if (locator.contains(" ")) return driver.findElements(By.partialLinkText(locator));
            return driver.findElements(By.linkText(locator));
        } else if (locator.startsWith("id=")) {
            locator = locator.substring(3); // remove "id=" from locator
            return driver.findElements(By.id(locator));
        } else if (locator.startsWith("//")) {
            return driver.findElements(By.xpath(locator));
        } else if (locator.startsWith("#")) {
            return driver.findElements(By.cssSelector(locator));
        } else if (locator.startsWith("name=")) {
            locator = locator.substring(5); // remove "name=" from locator
            return driver.findElements(By.name(locator));
        } else if (locator.startsWith("class=")) {
            locator = locator.substring(6); // remove "class=" from locator
            return driver.findElements(By.className(locator));
        } else if (locator.equalsIgnoreCase("body")) {
            return driver.findElements(By.cssSelector(locator));
        } else {
            return driver.findElements(By.id(locator));
        }
    }

    /**
     * Refresh the current page
     */
    public void refreshPage() {
        this.driver.navigate().refresh();

    }

    // For complete page load
    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        wait.until(pageLoadCondition);

    }

    /**
     * If given element is a form entry element, this will reset its value first
     * then simulate typing into an element, which may set its value.
     *
     * @param locator    The locator of element where to send keys
     * @param keysToSend the character sequence to send to the element
     */
    public void type(String locator, String keysToSend) {

        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        scroll_To_Element(element);
        element.clear();
        element.sendKeys(keysToSend);
        //element.sendKeys(Keys.TAB);
    }

    public void typeAndTab(String locator, String keysToSend) {


        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        scroll_To_Element(element);
        element.clear();
        element.sendKeys(keysToSend);
        element.sendKeys(Keys.TAB);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * If given element is a form entry element, this will reset its value first
     * then simulate typing into an element, which may set its value.
     * @param element    the element where to send keys
     * @param keysToSend the character sequence to send to the element
     */
    public void type(WebElement element, String keysToSend) {
        waitUntilElementToBeClickable(element);
        highlightElement(element);
        element.clear();
        element.sendKeys(keysToSend);
    }

    /**
     * Click on a given element. If this causes a new page to load, you should discard
     * all references to a given element and any further operations performed on a given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible, and it must have a height and width greater than 0.
     *
     * @param locator the locator of element to be clicked.
     */
    public void click(String locator) {
        WebElement element = waitUntilElementToBeClickable(locator);
        //scroll_To_Element(element);
        highlightElementClick(element);
        try {
            element.click();
        } catch (Exception e) {
            jsClickWithoutWait(element);
        }
    }


    public void clickAndClear(String locator) {
        WebElement element = waitUntilElementToBeClickable(locator);
        highlightElementClick(element);
        try {
            element.click();
            element.clear();
        } catch (Exception e) {
            jsClickWithoutWait(element);
        }
    }


    /**
     * Click on given element. If this causes a new page to load, you should discard
     * all references to given element and any further operations performed on given
     * element will throw a StaleElementReferenceException.
     * <p>
     * There are some preconditions for an element to be clicked. the element must
     * be visible, and it must have a height and width greater than 0.
     * @param element the element to be clicked.
     */

    public void click(WebElement element) {
        waitUntilElementToBeClickable(element);
//        scroll_To_Element(element);
        highlightElementClick(element);
        try {
            element.click();
        } catch (Exception e) {
            jsClickWithoutWait(element);
        }
    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param locator the locator of element to be clicked.
     */
    public void jsClick(String locator) {
//        scroll_To_Element(locator);
        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='4px solid yellow'", element);
        js.executeScript("return arguments[0].click();", element);

    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param element the element to be clicked.
     */
    public void jsClick(WebElement element) {
        waitUntilElementToBeClickable(element);
//        scroll_To_Element(element);
        highlightElementClick(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);

    }

    public String removeSpecialCharacters(String input) {

        input = input.substring(0, input.indexOf("."));
        //  input = input.replace(",", "");
        input = input.replaceAll("[^0-9]", "");
        return input;
    }

    /**
     * Clicks on visible or not visible element through javascript.
     * @param element the element to be clicked.
     */
    public void jsClickWithoutWait(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return arguments[0].click();", element);

    }

    /**
     * If given element is a form entry element, this will reset its value.
     *
     * @param locator the locator of element to be cleared
     */
    public void clear(String locator) {
        WebElement element = waitUntilElementToBeClickable(findBy(locator));
        highlightElementClick(element);
        element.clear();
    }

    /**
     * Get the visible (i.e. not hidden by CSS) text of given element, including
     * sub-elements.
     *
     * @param locator the locator of element from where to get visible text
     * @return The visible text of given element.
     */
    public String getText(String locator) {
//        scroll_To_Element(locator);
        WebElement element = waitUntilStringLocator(locator);
        highlightElement(element);
        return element.getText().trim();
    }

    public String getTextwithouthighlight(String locator) {
        pause(2);
        WebElement element = this.findElement(locator);
//        highlightElement(element);
        return element.getText().trim();
    }

    // Get and return the random integer
    // within Min and Max
    public int getRandomIntergerValue(int Min, int Max) {

        return ThreadLocalRandom.current().nextInt(Min, Max);
    }

    // Get and return the random double
    // within Min and Max
    public double getRandomDoubleValue(double Min, double Max) {
        return ThreadLocalRandom.current().nextDouble(Min, Max);
    }
    /**
     * Get the visible (i.e. not hidden by CSS) text of given element, including
     * sub-elements.
     *
     * @param element the element from where to get visible text
     * @return The visible text of given element.
     */
    public String getText(WebElement element) {
//        scroll_To_Element(element);
        pause(2);
        highlightElement(element);
        return element.getText();
    }
    public static void printCurrentTime(String time)
    {
        // Get the current time in IST
        SimpleDateFormat istFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        istFormat.setTimeZone(TimeZone.getTimeZone("CST"));
        String cstTime = istFormat.format(new Date());
        System.out.println("<br>Script " + time + ":" + cstTime);
        Reporter.log("<br>Script " + time + ":" + cstTime);
        // Check if the script is running on a server
        String serverIndicatorProperty = System.getProperty("server.indicator");
        if (serverIndicatorProperty != null && serverIndicatorProperty.contains("true")) {
            // Get the server time
            SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
            serverFormat.setTimeZone(TimeZone.getTimeZone("Server/Time/Zone"));  // Replace with the actual time zone
            cstTime = serverFormat.format(new Date());
            System.out.println("Server Time: " + cstTime);
        }
    }
    public void assertElementDisplayed(String locator) {
        waitUntilStringLocator(locator);
        highlightElement(locator);
        Assert.assertTrue(isElementDisplayed(locator));
        common.click(CLOSEBTN);

    }
    public void upload_File_Using_Robot(String file) throws AWTException {

        //String path_win = "C:\\Users\\testc\\OneDrive\\Desktop\\Automation new\\qa-automation\\test_data\\Screenshot_1.png";
        String path_win = System.getProperty("user.dir")+ file;
        StringSelection filepath = new StringSelection(path_win);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, filepath);
        Robot robot = new Robot();
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(500);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(1000);
        robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
        robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
        robot.delay(1000);
    }


    public static int generateRandomInteger(int lowerBound, int upperBound) {
        return (int) (Math.random() * (upperBound - lowerBound + 1) + lowerBound);
    }

    public static Year getCurrentYear() {
        Year thisYear = Year.now(Clock.systemUTC());

        // Print the year object
        System.out.println("year " + thisYear);

        return thisYear;
    }

    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     * <p>
     * More exactly, this method will return the value of the property with the
     * given name, if it exists. If it does not, then the value of the attribute
     * with the given name is returned. If neither exists, null is returned.
     * <p>
     * To get tooltip you have to give attribute "title" as argument.
     * <p>
     * The "style" attribute is converted as best can be to a text representation
     * with a trailing semi-colon.
     * <p>
     * The following are deemed to be "boolean" attributes, and will return either
     * "true" or null:
     * <p>
     * async, autofocus, autoplay, checked, compact, complete, controls, declare,
     * defaultchecked, defaultselected, defer, disabled, draggable, ended,
     * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
     * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
     * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
     * selected, truespeed, willvalidate
     * <p>
     * Finally, the following commonly mis-capitalized attribute/property names are
     * evaluated as expected:
     * <ul>
     * <li>If the given name is "class", the "className" property is returned.
     * <li>If the given name is "readonly", the "readOnly" property is returned.
     * </ul>
     *
     * @param locator The locator of element to get its attribute value
     * @return The attribute/property's current value or null if the value is not
     * set.
     */
    public String getAttribute(String locator, String attributeName) {
        WebElement element = waitUntilPresenceOfElementLocated(findBy(locator));
        highlightElement(element);
        return element.getAttribute(attributeName);
    }
    /**
     * Get the value of the given attribute of the element. Will return the current
     * value, even if this has been modified after the page has been loaded.
     * <p>
     * More exactly, this method will return the value of the property with the
     * given name, if it exists. If it does not, then the value of the attribute
     * with the given name is returned. If neither exists, null is returned.
     * <p>
     * The "style" attribute is converted as best can be to a text representation
     * with a trailing semi-colon.
     * <p>
     * The following are deemed to be "boolean" attributes, and will return either
     * "true" or null:
     * <p>
     * async, autofocus, autoplay, checked, compact, complete, controls, declare,
     * defaultchecked, defaultselected, defer, disabled, draggable, ended,
     * formnovalidate, hidden, indeterminate, iscontenteditable, ismap, itemscope,
     * loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open,
     * paused, pubdate, readonly, required, reversed, scoped, seamless, seeking,
     * selected, truespeed, willvalidate
     * <p>
     * Finally, the following commonly mis-capitalized attribute/property names are
     * evaluated as expected:
     * <ul>
     * <li>If the given name is "class", the "className" property is returned.
     * <li>If the given name is "readonly", the "readOnly" property is returned.
     * </ul>
     *
     * @param element       the element to get its attribute value
     * @param attributeName The name of the attribute
     * @return The attribute/property's current value or null if the value is not
     *         set.
     */
    public String getAttribute(WebElement element, String attributeName) {
        waitUntilStringLocatorAsaElement(element);
        return element.getAttribute(attributeName);
    }

    public long startTime() {
        return System.currentTimeMillis();
    }
    public void endTime(long startTime, String msg) {
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        logPrint("Step ::Total Time for loading the " + msg + " in Seconds: "
                + TimeUnit.MILLISECONDS.toSeconds(totalTime));
    }

    public boolean isElementVisible(WebDriver driver, By locator) {
        try {
            // Create WebDriverWait with timeout in seconds
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true; // Element is visible
        } catch (TimeoutException e) {
            return false; // Element is not visible within the timeout
        }
    }

    public void verifyElementIsDisplayed(String element) {

        boolean bool = false;
        try {
            if (findElement(element).isDisplayed()) {
                common.logPrint("Element Is displayed - PASS");
                bool = true;
            } else {
                bool = false;
            }
        } catch (Exception e) {
        }
        if (!bool) {
            common.logPrint("Element is displayed - failed");
            Assert.assertTrue(false);
        }
    }

    public void downKeyAndEnter(){
        common.pause(1);
        // Create Actions instance
        Actions actions = new Actions(driver);

        // Press DOWN arrow key, then ENTER
        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                .sendKeys(org.openqa.selenium.Keys.ENTER)
                .build()
                .perform();
    }

    public void selectCheckBox(String checkboxValue){
        WebElement element = driver.findElement(By.xpath(checkboxValue));
        element.click();
    }

    public String[] fetchDetails() {
        WebElement element1 = driver.findElement(By.xpath(EDITVAL1));
        String value1 = element1.getText();

        WebElement element2 = driver.findElement(By.xpath(EDITVAL2));
        String value2 = element2.getText();

        return new String[] { value1, value2 };
    }

    public void twoDownKeyAndEnter(){

        common.pause(1);

        Actions actions = new Actions(driver);

        actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.ARROW_DOWN)
                .sendKeys(org.openqa.selenium.Keys.ENTER)
                .build()
                .perform();
    }
    public void pressEnter(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
    }
    public void pressSpace(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.SPACE).build().perform();
    }

    public void dynamicDownKeyPress(int amount){
        Actions actions = new Actions(driver);

        for(int i =0; i< amount; i++) {
            actions.sendKeys(Keys.DOWN).build().perform();
        }
        actions.sendKeys(Keys.ENTER).perform();
    }



    public String fakeName(){
        Faker faker = new Faker();
        String Name = faker.name().firstName();
        return Name;
    }

    public void openNewIncognitoBrowser(){
        // Initialize ChromeOptions to configure browser settings
        ChromeOptions options = new ChromeOptions();
        // Add the argument for incognito mode
        options.addArguments("--incognito");
        // Initialize ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);

        //Switch to a new tab
        for (String tab: driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }
    }

    public void openNewWindow(){
        ((JavascriptExecutor) driver).executeScript("window.open();");

        //Switch to a new tab
        for (String tab: driver.getWindowHandles()){
            driver.switchTo().window(tab);
        }

    }

    public void openNewUrl(String linkUrl){
        driver.get(linkUrl);
    }

    public void switchToFrameWithId(String idString){
        driver.switchTo().frame(idString);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public WebDriver openAndFocusNewIncognitoBrowser() {
        // Setup options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // Create a completely new browser session
        WebDriver incognitoDriver = new ChromeDriver(options);

        // Maximize the new window
        incognitoDriver.manage().window().maximize();

        // Optional: Wait for the window to fully load and appear
        try {
            Thread.sleep(1000); // small delay to let OS switch focus
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        common.logPrint("New incognito browser opened, maximized, and focused - PASS");

        return incognitoDriver;
    }

    public void hoverOverTheElement(String element){

        Actions actions = new Actions(driver);

        WebElement menuOption = driver.findElement(By.xpath(element));

        actions.moveToElement(menuOption).click().perform();
    }

    public void hoverAndClickOnElement(String element){

        WebElement element1 = driver.findElement(By.xpath(String.valueOf(element)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).pause(Duration.ofSeconds(2)).click().perform();
    }

    public void scrollPageUsingPixel(){

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");

    }

    public static List<String> readColumnDataFromExcel(String sheetName){
        List<String> dataList = new ArrayList<>();
        String filePath = "C:\\Main_Folder\\Automation\\Web_Automation\\src\\test\\resources\\DoctorAttributes.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + sheetName);
            }

            for (Row row : sheet) {
                Cell cell = row.getCell(0);
                if (cell != null && cell.getCellType() == CellType.STRING) {
                    String value = cell.getStringCellValue().trim();
                    if (!value.isEmpty()) {
                        dataList.add(value);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public WebElement waitForElementWithStaleCheck(By locator, int maxRetries, int waitSeconds){

        int attempts = 0;

        while (attempts < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            } catch (StaleElementReferenceException e) {
                common.logPrint("StaleElementReferenceException caught. Retrying... Attempt: " + (attempts + 1));
            } catch (TimeoutException e) {
                common.logPrint("Timeout waiting for element: " + locator);
                break; // No point in retrying if element never appeared
            }
            attempts++;
        }
        throw new RuntimeException("Failed to locate element after " + maxRetries + " retries: " + locator);

    }

    Faker faker = new Faker();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); // Correct format for your system

    /**
     * Generates a date string based on the type: "past", "future", "current", "next", or "between"
     * @param type Type of date to generate ("past", "future", "current", "next", "between")
     * @param startDateStr Required for "between" - format "MM/dd/yyyy"
     * @param endDateStr Required for "between" - format "MM/dd/yyyy"
     * @return Formatted date as String (e.g., "05/28/2025")
     */
    public String generateDate(String type, String startDateStr, String endDateStr) {
        Date resultDate = null;

        try {
            switch (type.toLowerCase()) {
                case "past":
                    resultDate = faker.date().past(3650, java.util.concurrent.TimeUnit.DAYS); // up to 10 years back
                    break;

                case "future":
                    resultDate = faker.date().future(3650, java.util.concurrent.TimeUnit.DAYS); // up to 10 years ahead
                    break;

                case "current":
                    resultDate = new Date(); // today's date
                    break;

                case "next":
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE, 1);
                    resultDate = calendar.getTime(); // tomorrow
                    break;

                case "between":
                    if (startDateStr == null || endDateStr == null) {
                        throw new IllegalArgumentException("Start and end dates are required for 'between' type.");
                    }

                    Date startDate = formatter.parse(startDateStr);
                    Date endDate = formatter.parse(endDateStr);

                    if (!startDate.before(endDate)) {
                        throw new IllegalArgumentException("Start date must be before end date.");
                    }

                    long randomMillis = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
                    resultDate = new Date(randomMillis);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid date type: " + type);
            }

            return formatter.format(resultDate);

        } catch (Exception e) {
            logPrint("Exception in generateDate(): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a"); // Example: 03:45 PM

    /**
     * Generates a time string based on the type: "past", "future", "current", or "between"
     * @param type Type of time to generate ("past", "future", "current", "between")
     * @param startTimeStr Start time (e.g., "09:00 AM") for "between"
     * @param endTimeStr End time (e.g., "05:00 PM") for "between"
     * @return Formatted time as String (e.g., "03:45 PM")
     */
    public String generateTime(String type, String startTimeStr, String endTimeStr) {
        try {
            Date resultTime;

            switch (type.toLowerCase()) {
                case "past":
                    resultTime = faker.date().past(1, java.util.concurrent.TimeUnit.DAYS);
                    break;

                case "future":
                    resultTime = faker.date().future(1, java.util.concurrent.TimeUnit.DAYS);
                    break;

                case "current":
                    resultTime = new Date();
                    break;

                case "between":
                    if (startTimeStr == null || endTimeStr == null) {
                        throw new IllegalArgumentException("Start and end times are required for 'between' type.");
                    }

                    // Parse start and end times into today's date
                    SimpleDateFormat parser = new SimpleDateFormat("hh:mm a");
                    Calendar startCal = Calendar.getInstance();
                    Calendar endCal = Calendar.getInstance();

                    Date startTime = parser.parse(startTimeStr);
                    Date endTime = parser.parse(endTimeStr);

                    startCal.setTime(startTime);
                    endCal.setTime(endTime);

                    // Normalize to today's date
                    Calendar base = Calendar.getInstance();
                    for (Calendar cal : new Calendar[]{startCal, endCal}) {
                        cal.set(Calendar.YEAR, base.get(Calendar.YEAR));
                        cal.set(Calendar.MONTH, base.get(Calendar.MONTH));
                        cal.set(Calendar.DAY_OF_MONTH, base.get(Calendar.DAY_OF_MONTH));
                    }

                    if (!startCal.before(endCal)) {
                        throw new IllegalArgumentException("Start time must be before end time.");
                    }

                    long randomMillis = ThreadLocalRandom.current().nextLong(
                            startCal.getTimeInMillis(), endCal.getTimeInMillis());
                    resultTime = new Date(randomMillis);
                    break;

                default:
                    throw new IllegalArgumentException("Invalid time type: " + type);
            }

            return timeFormatter.format(resultTime);

        } catch (Exception e) {
            logPrint("Exception in generateTime(): " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static String GenerateRandomName() {
        Faker faker = new Faker();
        return faker.name().fullName();  // e.g., "John Doe"
    }

    public String GenerateOneLineText(int count){
        String Name = faker.lorem().sentence(count);

        return Name;
    }

    public String GenerateParagraph(int count){
        String Name = faker.lorem().paragraph(count);

        return Name;
    }

    public String GenerateEmail(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        return email;
    }

    public String GeneratePhoneNUm(){
        Faker faker = new Faker();
        String Mobile = faker.phoneNumber().phoneNumber();
        return Mobile;
    }

    public String generateRandomYear(String fromYear, String toYear) {
        int startYear = Integer.parseInt(fromYear);
        int endYear = Integer.parseInt(toYear);

        // Validate that fromYear is less than or equal to toYear
        if (startYear > endYear) {
            throw new IllegalArgumentException("fromYear should be less than or equal to toYear.");
        }

        int randomYear = ThreadLocalRandom.current().nextInt(startYear, endYear + 1);
        return String.valueOf(randomYear);
    }
    public void fillAddress(){
        common.logPrint("Step :: Adding address line 1");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYADDRESS1));
        common.type(COMPANYADDRESS1,"Ahmedabad");

        common.logPrint("Step :: Adding Area");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYAREA));
        common.type(COMPANYAREA,"Ahmedabad");

        common.logPrint("Step :: Adding City");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYCITY));
        common.type(COMPANYCITY,"Ahmedabad");
        common.twoDownKeyAndEnter();

        common.logPrint("Step :: Adding Pincode");
        common.waitUntilElementsToBeVisible(By.xpath(COMPANYPINCODE));
        common.click(COMPANYPINCODE);
        common.type(COMPANYPINCODE, "");
        common.twoDownKeyAndEnter();

    }

    public void fillBothAddress(){
        common.logPrint("Step :: Adding address line 1");
        common.waitUntilElementsToBeVisible(By.xpath(RADDRESSLINE1));
        common.type(RADDRESSLINE1,"Ahmedabad");

        common.logPrint("Step :: Adding Area");
        common.waitUntilElementsToBeVisible(By.xpath(RADDRESSLINE2));
        common.type(RADDRESSLINE2,"Ahmedabad");

        common.logPrint("Step :: Adding City");
        common.waitUntilElementsToBeVisible(By.xpath(RCITY));
        common.type(RCITY,"Ahmedabad");
        common.pause(1);
        common.downKeyAndEnter();
        common.pause(1);

        common.logPrint("Step :: Adding Pincode");
        common.waitUntilElementsToBeVisible(By.xpath(RPINCODE));
        common.click(RPINCODE);
        common.type(RPINCODE, "");
        common.pause(1);
        common.downKeyAndEnter();
        common.pause(1);

        common.logPrint("Step :: Adding address line 1");
        common.waitUntilElementsToBeVisible(By.xpath(HADDRESSLINE1));
        common.type(HADDRESSLINE1,"Ahmedabad");

        common.logPrint("Step :: Adding Area");
        common.waitUntilElementsToBeVisible(By.xpath(HADDRESSLINE2));
        common.type(HADDRESSLINE2,"Ahmedabad");

        common.logPrint("Step :: Adding City");
        common.waitUntilElementsToBeVisible(By.xpath(HCITY));
        common.type(HCITY,"Ahmedabad");
        common.pause(1);
        common.downKeyAndEnter();
        common.pause(1);

        common.logPrint("Step :: Adding Pincode");
        common.waitUntilElementsToBeVisible(By.xpath(HPINCODE));
        common.click(HPINCODE);
        common.type(HPINCODE, "");
        common.pause(1);
        common.downKeyAndEnter();
        common.pause(1);

    }

    public void searchAndValidate(String searchValue) {

        String in_string = searchValue.toLowerCase();
        common.type(COMPANYSEARCH, in_string);

        try {
            WebElement result = driver.findElement(By.xpath("//div[@title='"+searchValue+"']"));
            String searched_result = result.getText();
            String l_searched_result = searched_result.toLowerCase();

            if (searched_result.equals(searchValue)) {
                System.out.println("Success: Element with title '" + in_string + "' found.");
            } else if (in_string.equals(l_searched_result)) {
                System.out.println("Success: Element with title '" + result + "' found.");

            }
        } catch (NoSuchElementException e) {
            System.out.println(" Element with title '" + in_string + "' not found.");
        }
    }
    public String generateCurDate(){
        LocalDate todays = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return todays.format(formatter);
    }
    public void tab()
    {

    }

    public void selectRandomValueFromDropdown(String dropdownXpath, int optionsCount){

        WebElement element = driver.findElement(By.xpath(dropdownXpath));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        element.click();

        common.pause(1);

        //generate random index between 1 and optionCount -1
        Random random = new Random();
        int randomIndex = random.nextInt(optionsCount - 1)+1;

        Actions actions = new Actions(driver);

        for(int i = 0; i< randomIndex; i++){
            actions.sendKeys(Keys.ARROW_DOWN);
        }

        actions.sendKeys(Keys.ENTER).build().perform();

        common.logPrint("Selected random index from dropdown: " + randomIndex);
    }
    public void pressDownKeysByArgument(int downCount){
            common.pause(1);

            Actions actions = new Actions(driver);

            for (int i = 0; i < downCount; i++) {
                actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN);
            }
            actions.sendKeys(org.openqa.selenium.Keys.ENTER)
                    .build()
                    .perform();

    }

    public void selectDateFromDynamicCalendar(By calendarIcon, String dateToSelect) {

        driver.findElement(calendarIcon).click();
        common.pause(1); // give time to render

        try {
            // Re-fetch every time to avoid stale references
            WebElement dateElement = driver.findElement(By.xpath("//td[normalize-space()='" + dateToSelect + "']"));
            dateElement.click();
            common.logPrint("Selected date from calendar: " + dateToSelect);
        } catch (NoSuchElementException e) {
            common.logPrint("Calendar popup didn't render as expected. Retrying...");
            driver.findElement(calendarIcon).click();
            common.pause(1);
            WebElement dateElement = driver.findElement(By.xpath("//td[normalize-space()='" + dateToSelect + "']"));
            dateElement.click();
        }
    }
    public String resetAndCheck(){
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        boolean allFieldsEmpty = true;

        for (WebElement input : inputFields) {
            String inputType = input.getAttribute("type");
            if (inputType.equals("text") || inputType.equals("password") || inputType.equals("email")) {
                String value = input.getAttribute("value");
                if (value != null && !value.trim().isEmpty()) {
                    allFieldsEmpty = false;
                    System.out.println("Input field with ID '" + input.getAttribute("id") + "' is not empty: " + value);
                }
            }
        }

        if (allFieldsEmpty) {
           return System.out.printf("All input fields are empty after reset.").toString();
        } else {
            return System.out.printf("Some input fields are not empty after reset.").toString();
        }

    }

    public void enterDateAndConfirm(String dateInput, String dateValue) {

        WebElement element = driver.findElement(By.xpath(dateInput));

        //element.click();
        element.clear();
        element.sendKeys(dateValue);
        element.sendKeys(Keys.TAB); // or ENTER
        common.logPrint("Date entered manually and confirmed: " + dateValue);
    }

    public static String convertDateFormat(String inputDate){

        SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }

    public void textFileReader(String filePath) throws IOException {

        FileReader reader = new FileReader(System.getProperty("user.dir")+filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while((line = bufferedReader.readLine()) !=null){
            common.logPrint(line);
        }
    }

    public void addDate(String sentDateAndMonth, String element){
        common.logPrint("Step :: Adding the daily tour plan date");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        common.pause(1);

        common.waitUntilElementToBeVisible(element);
        common.type(element, sentDateAndMonth);

        actions.sendKeys(Keys.DOWN).perform();
    }
    public void updatedSuccessfullyValidationLog(String module_name, String prev_value, String cur_value) {

        if (!prev_value.equals(cur_value)) {
            System.out.println(module_name + " Updated Successfully from " + prev_value + " To " + cur_value);
        } else {
            System.out.println("Error while updating " + prev_value + " To " + cur_value);
        }
    }

    public void noRowsAssertion(){
        common.logPrint("Step :: Asserting No Rows");
        WebElement noRow = driver.findElement(By.xpath(NOROWSMSG));
        String noRow_value = noRow.getText();

        if (noRow.isDisplayed()){
            System.out.println("No row message displayed, Deleted Successfully");
        }
        else{
            System.out.println("Error While deleting");
        }
    }


}



