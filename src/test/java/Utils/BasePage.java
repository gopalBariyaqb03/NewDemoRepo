package Utils;

//import Page.AdminDashboard;
import Config.ReadProperties;
import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Augmenter;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.*;


public class BasePage {

    ReadProperties readProperties = new ReadProperties();
    String adminCredentials[] = readProperties.getDirectorCredentials();
    String username = adminCredentials[0];
    String password = adminCredentials[1];


    static Properties configProperties = null;
    protected static WebDriver driver;
    public static Common common;
    public static String currentTest; // current running test
    public static ThreadLocal<Integer> steps = new ThreadLocal<Integer>();
    private ThreadLocal<WebDriver> threadLocal = new ThreadLocal();
//    public AdminDashboard adminDashboard;
    public HomePage homePage;
    public LMSPage lmsPage;
    public AdminPage adminPage;
    public ApprovalsPage approvalsPage;
    public AttributesPage attributesPage;
    public CFAPage cfaPage;
    public CommunicationPage communicationPage;
    public EventPage eventPage;
    public HolidaysPage holidaysPage;
    public IncentivePage incentivePage;
    public InventoryPage inventoryPage;
    public MappingPage mappingPage;
    public OtherPage otherPage;
    public PresentationPage presentationPage;
    public SFCPage sfcPage;
    public TourProgramPage tourProgramPage;
    public UploadPage uploadPage;
    public VendorPage vendorPage;
    public DataCreationPage dataCreationPage;

    protected List<String> stringList = new ArrayList<>();
    public String LOGOUTBTN = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-auoq4t'])[2]";

    public void loginWithDirectorCredential(){

        long startTime = common.startTime();
        String urlOpen = readProperties.getWebUrl();
        common.logPrint("Open the browser and enter the URL : "+ urlOpen);
        driver.get(urlOpen);
        common.pause(1);

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.logPrint("Login from the Directors user");
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
        common.pause(1);

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.logPrint("Login from the RSM user");
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
        common.pause(1);

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.logPrint("Login from the ASM user");
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
        common.pause(1);

        common.logPrint("Step:: Attempting to logout from the current user");
        if (common.isElementDisplayed(LOGOUTBTN)) {
            common.waitUntilElementsToBeVisible(By.xpath(LOGOUTBTN));
            common.click(LOGOUTBTN);
        } else {
            common.logPrint("Step:: Logout button not found, skipping logout step");
        }

        common.logPrint("Login from the MR user");
        common.logPrint("Step:: Enter username and password");
        common.waitUntilElementsToBeVisible(By.xpath("//input[@id='email']"));
        common.type("//input[@id='email']",MRusername);
        common.waitUntilElementsToBeVisible(By.xpath("//input[@type='password']"));
        common.type("//input[@type='password']",MRpassword);

        common.waitUntilElementsToBeVisible(By.xpath("//button[.='Login']"));
        common.click("//button[.='Login']");
    }

    /**
     * Setup Method
     *
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method, ITestResult testResult) throws Exception {
        Reporter.setCurrentTestResult(testResult);

        currentTest = method.getName(); // get Name of current test.

        String browser = getPropertyValue("browser");
        String headless = getPropertyValue("headless");
        String driverPathChrome = getPropertyValue("driverPathChrome");
        String driverPathChromeMac = getPropertyValue("driverPathChromeMac");
        String driverPathFirefox = getPropertyValue("driverFirefox");
        String driverPathEdge = getPropertyValue("drivePathEdge");
        String opportunity = System.getProperty("opportunity");

        /*
         * Browser = Chrome
         */
        if (browser.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", driverPathChromeMac);
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            if (headless.equals("true")) {
                //Run browser in headless mode
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");            // open Browser in maximized mode
            options.addArguments("--incognito");
            options.addArguments("--disable-dev-shm-usage");    // overcome limited resource problems
            options.addArguments("--no-sandbox");               // Bypass an OS security model
            options.addArguments("--remote-allow-origins=*");
            options.addArguments(
                    "user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (HTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");
            driver = new ChromeDriver(options);
        }
        else if (browser.equalsIgnoreCase("edge")) {

            //System.setProperty("webdriver.edge.driver", driverPathEdge);
            WebDriverManager.edgedriver().setup();
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("-private");
            options.addArguments("start-maximized");

            if (headless.equals("true")) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("user-agent=Mozilla/5.0 (Linux; Android 8.0.0; TA-1053 Build/OPR1.170623.026) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.0 Mobile Safari/537.36");

            }

            driver = new EdgeDriver(options); // Pass options to EdgeDriver

        }
        else if (browser.equals("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
              options.addArguments("-private");
            //  options.addPreference("devtools.toolbox.selectedTool","netmonitor");
            if (headless.equals("true")) {
                options.addArguments("--headless");
            }

            driver = new FirefoxDriver(options);
        }

        threadLocal.set(driver);
        driver = threadLocal.get();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        lmsPage = new LMSPage(driver);
        common = new Common(driver);
        adminPage = new AdminPage(driver);
        approvalsPage = new ApprovalsPage(driver);
        dataCreationPage = new DataCreationPage(driver);
        attributesPage = new AttributesPage(driver);
        cfaPage = new CFAPage(driver);
        communicationPage = new CommunicationPage(driver);
        eventPage = new EventPage(driver);
        holidaysPage = new HolidaysPage(driver);
        incentivePage = new IncentivePage(driver);
        inventoryPage = new InventoryPage(driver);
        mappingPage = new MappingPage(driver);
        otherPage = new OtherPage(driver);
        tourProgramPage = new TourProgramPage(driver);
        vendorPage = new VendorPage(driver);
//        MyScreenRecorder.startRecording(currentTest);
        steps.set(1);
        Common.printCurrentTime("Starting Time");
    }
    protected Properties getConfigProperties() {
        if (configProperties == null) {
            configProperties = this.loadProperties(Paths.get("src/test/java/Config").toAbsolutePath().normalize() + "//config.properties");
        }
        return configProperties;
    }

    protected String getPropertyValue(String value) {
        Properties properties = getConfigProperties();
        return properties.getProperty(value);
    }

    /**
     * Check that given element is present or not.
     *
     * @param xpath the xpath of element to be checked present or not
     *
     * @return True if the element present, false otherwise
     */

    public boolean existsElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    /**
     * Load Properties
     * @return properties
     */
    private Properties loadProperties(String filePath) {
        File file = new File(filePath);
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();

        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    /**
     * After Method {TearDown}
     */
    @AfterMethod(alwaysRun = true)
//     public void tearDown(ITestResult testResult,String TestCycle, String TestCase) throws Exception {
   public void tearDown(ITestResult testResult) throws Exception {

        String testName = testResult.getName();
        Reporter.setCurrentTestResult(testResult);

        if (testResult.getStatus() == 2) {
            Reporter.log("<font color = 'red'><b><i><u><br>Fail :: " + testResult.getName() + "</u></i></b></font>");
            makeScreenshot(driver, testName);
            Reporter.log("Failed page URL: "+driver.getCurrentUrl());
        }
        // MyScreenRecorder.stopRecording();
        if (testResult.getStatus() == 1) {
            Reporter.log("<font color = 'green'><b><i><u><br>Pass :: " + testResult.getName() + "</u></i></b></font>");
//           MyScreenRecorder.deleteFile(testName+".avi");
            testResult.getThrowable();
            // makeScreenshot(driver, testName);
        }
//        for (String logs : stringList) {
//            Reporter.log(logs,true);
//        }

        Common.printCurrentTime("Ending Time");
        driver.manage().deleteAllCookies();
        //driver.quit();
    }

    public void makeScreenshot(WebDriver driver, String screenshotName) {

        WebDriver augmentedDriver = new Augmenter().augment(driver);
        File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
        String nameWithExtention = screenshotName + ".png";
        try {
            String reportFolder = "target" + File.separator + "test-output" + File.separator + "screenshots";
            File screenshotFolder = new File(reportFolder);
            if (!screenshotFolder.getAbsoluteFile().exists()) {
                screenshotFolder.mkdir();
            }
            File destFile = new File(screenshotFolder + File.separator + nameWithExtention).getAbsoluteFile();
            FileUtils.copyFile(screenshot, destFile);
            Reporter.log("<a href='" + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/"
                    + destFile.getName() + "'> <img src='"
                    + "https://app.testreport.io/qa-java-api/api/v1/user/getImage/SCREENSHOT/" + destFile.getName()
                    + "' height='250' width='500'/> </a>");
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }


}
