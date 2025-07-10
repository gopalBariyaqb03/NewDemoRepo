package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.stringtemplate.v4.ST;

public class Locators extends BasePage {
    int DRIVER_WAIT = 5;

    public Locators(WebDriver driver) {
        ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
        PageFactory.initElements(finder, this);
        this.driver = driver;
    }

    // Locator For
    public static String usernameLogin = "//input[@id='loginEmail']";
    public static String passLogin = "//input[@id='loginPassword']";
    public static String loginBtn = "//div[@class='col-12 d-flex justify-content-center mb-4']";

    //Common locator
    public static String AddedSuccessfully = "//*[contains(text(),'Added Successfully')]";
    public static String UpdatedSuccessfully = "//*[contains(text(),'Update Successfully')]";
    public static String DeletedSuccessfully = "//*[contains(text(),'Delete Successfully')]";
    public static String DeleteConfirmationPopUp = "//h6[.='Are you sure you want to delete this item?']";
    public static String DELETEBTNPOP = "//div[@class='MuiCardContent-root css-15q2cw4']//div//button[.='Delete']";
    public static String DoctorApprovedSuccess = "//*[contains(text(),'Doctor Approved Successfully!')] | //*[contains(text(),'Chemist Approved Successfully!')] | //*[contains(text(),'Stockist Approved Successfully!')]";
    public static String NOROWS = "//div[starts-with(text(),'No rows')]";
    public static String VIEWBTN1 = "//button//img[@src='/static/media/eye.f10b3b160555bcdbf184fd21043b5df5.svg']";
    public static String PENDINGSTATUS = "(//button[@aria-label='Pending'])[2]";
    public static String PENDINGSTATUS1 = "(//button[@aria-label='Pending'])[1]";
    public static String APPROVESTATUS = "(//button[@aria-label='Approved'])[2]";
    public static String APPROVESTATUS1 = "(//button[@aria-label='Approved'])[1]";
    public static String FIRSTCHECKBOXDR = "//input[@tabindex='0']";
    public static String SUCCESSMSG = "//*[contains(text(),'Approved Successfull')]";


    //Locator for login screen
    public static String LOGINPAGELOGO = "//img[contains(@src, '/static/media/logo')]";
    public static String USERNAMELABEL = "//label[@id='email-label']";
    public static String USERNAMEFIELD = "//input[@id='email']";
    public static String PASSWORDLABEL = "//label[@for='auth-login-password']";
    public static String PASSWORDFIELD = "//input[@id='auth-login-password']";
    public static String EYEICON = "//button[@type='button']";
    public static String FORGOTPASSLINK = "//a[contains(text(),'Forgot Password?')]";
    public static String LOGINBTN = "//button[contains(.,'Login')]";
    public static String SEARCH_FIELD = "common.logPrint(\"Step::\");";
    public static String DASHBOARDMENU = "//span[normalize-space()='Dashboard']";
    public static String ADMINPANELMENU = "//span[.='Admin Panel']";
    public static String DOCTORMENU = "//div[contains(text(),'Doctor')]";
    public static String CHEMISTMENU = "//div[contains(text(),'Chemist')]";
    public static String STOCKISTMENU = "//div[contains(text(),'Stockist')]";
    public static String HOSPITALMENU = "//div[contains(text(),'Hospital')]";
    public static String PRODUCTMENU = "//div[contains(text(),'Product')]";
    public static String EMPLOYEEMENU = "//div[contains(text(),'Employee')]";
    public static String ACCOUNTLISTMENU = "//div[contains(text(),'Account List')]";
    public static String ROLEMENU = "//div[contains(text(),'Role')]";
    public static String DESIGNATIONMENU = "//div[contains(text(),'Designation')]";

    public static String BACKBTN = "(//div[@class='header']//button)[1]";
    public static String ADDBTN = "//button[contains(.,'Add')]";
    public static String DELETEBTN = "//button[.='Delete']";
    public static String EDITBTN = "//div[.='Edit']";
    public static String VIEWBTN = "(//div[@class='header']//button)[5]";
    public static String PRINTBTN = "(//div[@class='header']//button)[6]";
    public static String EXPORTPDFBTN = "//button[.='Export PDF']";
    public static String EXPORTEXCELBTN = "//button[.='Export Excel']";
    public static String BULKAPPROVEBTN = "//button[.='Bulk Approvals']";
    public static String FINANCIALYEARLBL = "//label[.='Financial Year']";
    public static String YEARDROPDOWN = "//input[@id='autocomplete-dropdown-1']";
    public static String SALESGRAPHINADDDCR = "//div[@class='card MuiBox-root css-0']";
    public static String HQLABEL = "//label[.='HQ']";
    public static String HQDROPDOWN = "//input[@id='autocomplete-undefined']";
    public static String SEARCHFIELD = "//input[@aria-label='search']";
    public static String DOCTORNAMELBL = "//label[.='Doctor Name *']";
    public static String DOCTORNAMEINP = "//input[@name='DoctorName']";
    public static String DOCTORNAMEINTABLE = "";


    public static String CATEGORYLBL = "//label[.='Category *']";
    public static String CATEGORYINP = "//label[.='Category *']/parent::div//button";
    public static String SPECIALITYLBL = "//label[.='Speciality *']";
    public static String SPECIALITYINP = "//label[.='Speciality *']/parent::div//input";
    public static String QUALIFICATIONSLBL = "//label[.='Qualifications *']";
    public static String QUALIFICATIONSINP = "//label[.='Qualifications *']/following-sibling::div//button";
    public static String EMPLOYEELBL = "//label[.='Employee']";
    public static String EMPLOYEEINP = "//label[.='Employee']/parent::div//input";
    public static String EMPLOYEELBLCHE = "//label[.='Employee']";
    public static String EMPLOYEEINPCHE = "//label[.='Employee']/parent::div//input";
    public static String PRODUCTLBL = "//label[.='Product *']";
    public static String PRODUCTINP = "//label[.='Product *']/parent::div//button";
    public static String HOSPITALNAMELBL = "//label[.='Hospital Name']";
    public static String HOSPITALNAMEINP = "//input[@name='HospitalName']";
    public static String EMAILLBL = "//label[.='Email']";
    public static String EMAILINP = "//input[@name='Email']";
    public static String MOBILENOLBL = "//label[contains(.,'Mobile No.')]";
    public static String MOBILENOINP = "//label[contains(.,'Mobile No.')]/parent::div//input";
    public static String PHONENOLBL = "//label[.='Phone No']";
    public static String PHONENOINP = "//label[.='Phone No']/parent::div//input";
    public static String WEBSITELBL = "//label[.='WebSite']";
    public static String WEBSITEINP = "//label[.='WebSite']/parent::div//input";
    public static String DOBLBL = "//label[.='DOB']";
    public static String DOBINP = "//label[.='DOB']/parent::div//input";
    public static String DOALBL = "//label[.='DOA']";
    public static String DOAINP = "//label[.='DOA']/parent::div//input";
    public static String PANCARDNOLBL = "//label[.='PanCard Number']";
    public static String PANCARDNOINP = "//label[.='PanCard Number']/parent::div//input";
    public static String REGISTRATIONNOLBL = "//label[.='Registration Number']";
    public static String REGISTRATIONNOINP = "//label[.='Registration Number']/parent::div//input";
    public static String SOFTWARENAMELBL = "//label[.='Software Name']";
    public static String SOFTWARENAMEINP = "//label[.='Software Name']/parent::div//input";
    public static String ROLEINHOSPITALLBL = "//label[.='Role in Hospital']";
    public static String ROLEINHOSPITALINP = "//label[.='Role in Hospital']/parent::div//input";
    public static String PATIENTSDAILYLBL = "//label[.='Patients Daily']";
    public static String PATIENTSDAILYINP = "//label[.='Patients Daily']/parent::div//input";
    public static String PATIENTSWEEKLYLBL = "//label[.='Patients Weekly']";
    public static String PATIENTSWEEKLYINP = "//label[.='Patients Weekly']/parent::div//input";
    public static String PATIENTSMONTHLYLBL = "//label[.='Patients Monthly']";
    public static String PATIENTSMONTHLYINP = "//label[.='Patients Monthly']/parent::div//input";
    public static String PREFERREDCALLTIMELBL = "//label[.='Preferred Call Time']";
    public static String PREFERREDCALLTIMEINP = "//label[.='Preferred Call Time']/parent::div//input";
    public static String ADDRESSLINE1LBL1 = "(//label[.='Address Line 1'])[1]";
    public static String ADDRESSLINE1INP1 = "(//label[.='Address Line 1'])[1]/parent::div//input";
    public static String AREALBL = "(//label[.='Area'])[1]";
    public static String AREAINP = "(//label[.='Area'])[1]/parent::div//input";
    public static String CITYLBL = "(//label[.='City *'])[1]";
    public static String CITYINP = "(//label[.='City *'])[1]/parent::div//input";
    public static String PINCODELBL = "(//label[.='Pincode *'])[1]";
    public static String PINCODEINP = "(//label[.='Pincode *'])[1]/parent::div//input";
    public static String PANCARDIMGLBL = "//span[.='Pancard Image ']";
    public static String REGISTRATIONIMGLBL = "//span[.='Registration Certificate ']";
    public static String DOCTORIMGLBL = "//span[.='Doctor Image ']";
    public static String VISITINGCARDIMGLBL = "//span[.='Visiting Card Image ']";
    public static String PANCARDUPLOADIMG = "(//div[contains(text(),'Choose Upload')])[1]";
    public static String REGISTRATIONUPLOADIMG = "(//div[contains(text(),'Choose Upload')])[2]";
    public static String DOCTORUPLOADIMG = "(//div[contains(text(),'Choose Upload')])[3]";
    public static String VISITINGCARDUPLOADIMG = "(//div[contains(text(),'Choose Upload')])[4]";

    //Xpath for the addtional detail
    public static String FIRSTROWDATADOCTR = "(//div[@data-colindex='5'])[1]";
    public static String DEGREEMENU = "//button[contains(.,'Degree')]";
    public static String DEGREEDROPDOWN = "//label[contains(.,'Degree')]/following-sibling::div//button";
    public static String DEGREESELECTED = "(//input[@role='combobox'])[1]";
    public static String SPECIALITYDRODOWN = "//label[contains(.,'Speciality')]/following-sibling::div//button";
    public static String ADDMISSIONYEAR = "//input[@name='DegreeAdmissionYear']";
    public static String PASSOUTYEAR = "//input[@name='DegreePassOutYear']";
    public static String DEGREECOLLAGE = "//input[@name='DegreeCollege']";
    public static String DEGREEREGNUM = "//input[@name='DegreeRegistrationNumber']";
    public static String CITYDROPDOWN = "//label[contains(.,'City')]/following-sibling::div//button";
    public static String PINCODEDROPDOWN = "//label[contains(.,'Pincode')]/following-sibling::div//button";
    public static String AREAOFINTEREST = "//span[contains(.,'Area of Interest')]";
    public static String AREAOFINTERESTINMEDICAL = "//label[.='Area Of Interest In Medical Field *']/following-sibling::div//button";
    public static String AREAOFINTERESTINMEDICALS = "//input[@role='combobox']";
    public static String AREAREMARK = "//textarea[contains(@name,'Remarks')]";
    public static String GUIDELINESFOLLOWED = "//span[contains(.,'Guidelines Followed')]";
    public static String GUIDELINEFOLLOWEDDRP = "//label[contains(.,'Guidelines Followed')]/following-sibling::div//button";
    public static String CONFERENCESPECKER = "//span[contains(.,'Conferences Speaker / Participants')]";
    public static String SUBJECTTYPE = "//label[contains(.,'Subject Type')]/following-sibling::div//button";
    public static String STARTDATEINP = "//input[@name='ConferencesAndWebinarStartDate']";
    public static String ENDDATEINP = "//input[@name='ConferencesAndWebinarEndDate']";
    public static String DAYSINP = "//input[@name='ConferencesAndWebinarDays']";
    public static String SUBJECTTOPICINP = "//input[@name='ConferencesAndWebinarSubjectTopic']";
    public static String ATTENDEDASDRP = "//label[.='Attended As *']/following-sibling::div//button";
    public static String VENUEINP = "//input[@name='ConferencesAndWebinarVenue']";
    public static String NOOFATTENDEE = "//input[@name='ConferencesAndWebinarNoOfAttendee']";
    public static String NOOFATTENDEEINP = "//input[@name='ConferencesAndWebinarNoOfAttendee']";
    public static String WEEKENDVACTION = "//span[contains(.,'Weekend / Vacation Activity')]";
    public static String ENTERTAINMENTDRP = "//label[.='Entertainment (Weekend / Vacation) *']/following-sibling::div//button";
    public static String ACTIVITYTYPE = "//label[contains(.,'Activity Type')]/following-sibling::div//button";
    public static String PLACEINPADDITIONALDETAIL = "//input[@name='WeekendAndVacationActivityPlace']";
    public static String PREFFREDDATE = "//input[@name='WeekendAndVacationActivityPreferredDateTime']";
    public static String FAMILYFRIENDDETAIL = "//span[contains(.,'Family / Friends Details')]";
    public static String NAMEINPFamily = "//input[@name='FamilyAndFriendName']";
    public static String RELATIONDRP = "//label[.='Relation *']/following-sibling::div//button";
    public static String DOBINPAdd = "//input[@name='FamilyAndFriendDateOfBirth']";
    public static String DOAINPAdd = "//input[@name='FamilyAndFriendDateOfAnniversary']";
    public static String SPECIALDAYDOBINP = "//input[@name='FamilyAndFriendSpeicialDay']";
    public static String SPECIALDAYDOBINPAdd = "//input[@name='FamilyAndFriendSpeicialDate']";
    public static String REMARKINP = "//textarea[@name='Remarks']";

    //ADDITIONAL DETAILS -> ALUMNI
    public static String COLLEGEALUMNIDETAILS = "//p[normalize-space()='College Mate / Alumni Details']";
    public static String COLLEAGUENAME = "//input[@name='ColleagueName']";
    public static String COLLEAGUEDATEOFBIRTH = "//input[@name='ColleagueDateOfBirth']";
    public static String COLLEAGUESPECIALITY = "(//input[@role='combobox'])[1]";
    public static String COLLEAGUEHOSPITAL = "//input[@name='ColleagueHospitalName']";
    public static String COLLEAGUECOLLEGE = "//input[@name='ColleagueCollegeName']";
    public static String COLLEAGUEPASSOUTYEAR = "//input[@name='ColleaguePassOutYear']";
    public static String REMARKS = "(//textarea[@name='Remarks'])[1]";
    public static String RADDRESSLINE1 = "//input[@name='ColleagueHospitalAddressLine1']";
    public static String RADDRESSLINE2 = "//input[@name='ColleagueHospitalAddressLine2']";
    public static String RCITY = "(//input[@role='combobox'])[2]";
    public static String RPINCODE = "(//input[@role='combobox'])[3]";
    public static String HADDRESSLINE1 = "//input[@name='ColleagueCollegeAddressLine1']";
    public static String HADDRESSLINE2 = "//input[@name='ColleagueCollegeAddressLine2']";
    public static String HCITY = "(//input[@role='combobox'])[4]";
    public static String HPINCODE = "(//input[@role='combobox'])[5]";

    //ADDITIONAL DETAILS -> SOCIAL ACTIVITIES
    public static String CSR = "//p[normalize-space()='Social Activities / CSR']";
    public static String CSRACTIVITY = "//input[@name='TypeOfSocialActivity']";
    public static String CSRNGO = "(//input[@role='combobox'])[1]";
    public static String CSRPARTICIPANTS = "//input[@name='SocialActivityNoOfParticipants']";
    public static String CSRVENUE = "//input[@name='SocialActivityVenue']";
    public static String CSRAMOUNT = "//input[@name='SocialActivityAmountSpent']";
    public static String CSRSPONSORS = "//input[@name='SocialActivitySponsors']";
    public static String CSRREMARKS = "//input[@name='Remarks']";
    public static String CSRDESC = "//input[@name='SocialActivityDescription']";
    public static String CSRAD1 = "//input[@name='SocialActivityAddressLine1']";
    public static String CSRAD2 = "//input[@name='SocialActivityAddressLine2']";
    public static String CSRCITY = "(//input[@role='combobox'])[2]";
    public static String CSRPINCODE = "(//input[@role='combobox'])[3]";

    //ADDITIONAL DETAILS -> ASSOCIATED HOSPITAL
    public static String AH = "//p[normalize-space()='Associated Hospital']";
    public static String AHNAME = "//input[@name='AssociatedHospitalName']";
    public static String AHCITY = "(//input[@role='combobox'])[1]";
    public static String AHACTIVE = "//input[@name='AssociatedHospitalActive']";
    public static String AHRECURSIVE = "(//input[@id='autocomplete-dropdown-7'])[2]";
    public static String AHHOSPITAL = "//input[@name='AssociatedHospitalDaily']";
    public static String AHHOSPITALWEEKLY = "//input[@name='AssociatedHospitalWeekly']";
    public static String AHHOSPITAMONTHLY = "//input[@name='AssociatedHospitalMonthly']";
    public static String AHADDRESS1 = "//input[@name='AssociatedHospitalAddressLine1']";
    public static String AHADDRESS2 = "//input[@name='AssociatedHospitalAddressLine2']";
    public static String AHCITYD = "(//input[@role='combobox'])[3]";
    public static String AHPINCODE = "(//input[@role='combobox'])[4]";

    //ADDITIONAL DETAILS -> PATIENT REFER TO
    public static String PRT = "//p[normalize-space()='Patients Refer TO']";
    public static String PRTDRNAME = "//input[@name='PatientReferToDoctorName']";
    public static String PRTSPECIALITY = "(//input[@role='combobox'])[1]";
    public static String PRTHOSPITALNAME = "//input[@name='PatientReferToHospitalName']";
    public static String PRTPRIORITY = "(//input[@role='combobox'])[2]";
    public static String PRTPATIENTNAME = "//input[@name='PatientName']";
    public static String PRTMOBILE = "//input[@name='Mobile']";
    public static String PRTDATE = "//input[@name='ReferOnDate']";
    public static String PRTAD1 = "//input[@name='PatientReferToHospitalAddressLine1']";
    public static String PRTAD2 = "//input[@name='PatientReferToHospitalAddressLine2']";
    public static String PRTCITY = "(//input[@role='combobox'])[3]";
    public static String PRTPINCODE = "(//input[@role='combobox'])[4]";

    //ADDITIONAL DETAILS -> PATIENT REFERENCE SOURCE
    public static String PRS = "//p[normalize-space()='Patient References Source']";
    public static String PRSNAME = "//input[@name='PatientReferencesSourceDoctorName']";
    public static String PRSSPECIALITY = "(//input[@role='combobox'])[1]";
    public static String PRSHOSPITAL = "//input[@name='PatientReferencesSourceHospitalName']";
    public static String PRSPRIORITY = "(//input[@role='combobox'])[2]";
    public static String PRSPATIENTNAME = "//input[@name='PatientName']";
    public static String PRSMOBILE = "//input[@name='Mobile']";
    public static String PRSREFERDATE = "//input[@name='ReferOnDate']";
    public static String PRSAD1 = "//input[@name='PatientReferencesSourceHospitalAddressLine1']";
    public static String PRSAD2 = "//input[@name='PatientReferencesSourceHospitalAddressLine2']";
    public static String PRSCITY = "(//input[@role='combobox'])[3]";
    public static String PRSPINCODE = "(//input[@role='combobox'])[4]";

    //ADDITIONAL DETAILS -> CONSULTING FEES CLINIC
    public static String CFC = "//p[normalize-space()='Consulting Fees (Clinic)']";
    public static String CFCTYPE = "//input[@role='combobox']";
    public static String CFCAMOUNT = "//input[@name='ConsultingFeesForPatienAmount']";
    public static String CFCSDATE = "//input[@name='ConsultingFeesForPatienStartDate']";
    public static String CFCEDATE = "//input[@name='ConsultingFeesForPatienEndDate']";
    public static String CFCDURATION = "//input[@name='ConsultingFeesForPatienDuration']";
    public static String CFCAMOUNTS = "//input[@name='ConsultingFeesForPatienCurrentAmount']";

    //ADDITIONAL DETAILS -> CONSULTING FEES MR
    public static String CFM = "//p[normalize-space()='Consulting Fees (MR)']";
    public static String CFMTYPE = "//input[@role='combobox']";
    public static String CFMAMOUNT = "//input[@name='ConsultingFeesForMramount']";
    public static String CFMVALIDUPTO = "//input[@name='ConsultingFeesForMrvalidUpto']";

    //ADDITIONAL DETAILS -> MEDICAL ADVISORY/ SPEAKER
    public static String MED= "//p[normalize-space()='Medical Advisory / Speaker']";
    public static String MEDPURPOSE = "//input[@name='MedicalAdvisoryOrSpeakerPurpose']";
    public static String MEDAMOUNT = "//input[@name='MedicalAdvisoryOrSpeakerAmount']";
    public static String MEDCOMPANY = "//input[@name='MedicalAdvisoryOrSpeakerCompanyName']";
    public static String MEDSDATE = "(//input[@name='MedicalAdvisoryOrSpeakerStartDate'])[1]";
    public static String MEDEDATE = "(//input[@name='MedicalAdvisoryOrSpeakerStartDate'])[2]";
    public static String MEDBUSINESS = "//input[@name='MedicalAdvisoryOrSpeakerBussinessValue']";
    public static String MEDREMARKS = "//textarea[@name='Remarks']";
    public static String MEDAD1 = "//input[@name='MedicalAdvisoryOrSpeakerCompanyAddressLine1']";
    public static String MEDAD2 = "//input[@name='MedicalAdvisoryOrSpeakerCompanyAddressLine2']";
    public static String CITY = "(//input[@role='combobox'])[1]";
    public static String PINCODE = "(//input[@role='combobox'])[2]";

    //ADDITIONAL DETAILS -> MEDICAL ADVISROY
    public static String MEDICALADVISORYSPEAKER = "//p[normalize-space()='Medical Advisory / Speaker']";
    public static String MPURPOSE = "//input[@name='MedicalAdvisoryOrSpeakerPurpose']";
    public static String MAMOUNT = "//input[@name='MedicalAdvisoryOrSpeakerAmount']";
    public static String MCOMPANY = "//input[@name='MedicalAdvisoryOrSpeakerCompanyName']";
    public static String MSTARTDATE = "(//input[@name='MedicalAdvisoryOrSpeakerStartDate'])[1]";
    public static String MENDDATE = "(//input[@name='MedicalAdvisoryOrSpeakerStartDate'])[2]";
    public static String MBUSINESS = "//input[@name='MedicalAdvisoryOrSpeakerBussinessValue']";
    public static String MREMARKS = "//textarea[@name='Remarks']";
    public static String MADDRESS = "//input[@name='MedicalAdvisoryOrSpeakerCompanyAddressLine1']";
    public static String MADDRESS2 = "//input[@name='MedicalAdvisoryOrSpeakerCompanyAddressLine2']";
    public static String MCITY = "(//input[@role='combobox'])[1]";
    public static String MPINCODE = "(//input[@role='combobox'])[2]";

    //ADDITIONAL DETAILS -> ACHIEVEMENTS
    public static String ACHIEVEMENTS ="//p[normalize-space()='Achievements']";
    public static String ACHIEVEMENTSADD ="//input[@role='combobox']";
    public static String ACHIEVEMENTSDATE ="//input[@name='AchievementDate']";
    public static String ACHIEVEMENTSREMARKS ="//textarea[@name='Remarks']";
    public static String ACHIEVEMENTSIMAGE ="//input[@type='file']";

    //ADDITIONAL DETAILS -> PROCEDURAL EQUIPMENT
    public static String PE ="//p[normalize-space()='Procedural Equipments']";
    public static String PENAME ="//input[@name='ProceduralEquipmentName']";
    public static String PEVENDOR ="//input[@name='ProceduralEquipmentVendorName']";
    public static String PEDATE ="//input[@name='ProceduralEquipmentInstallationDate']";
    public static String PEPRICE ="//input[@name='ProceduralEquipmentPrice']";
    public static String PEREMARKS ="//textarea[@name='Remarks']";

    //ADDITIONAL DETAILS -> DOCTOR BANK DETAILS
    public static String DBD = "//p[normalize-space()='Doctor Bank Details']";
    public static String DBDBANKNAME = "//input[@name='BankName']";
    public static String DBDACCOUNT = "//input[@name='AccountNo']";
    public static String DBDIFSC = "//input[@name='IFsccode']";
    public static String DBDACCOUNTHOLDER = "//input[@name='AccountHolderName']";

    //ADDITIONAL DETAILS -> SPECIAL DAY
    public static String SD = "//p[normalize-space()='Special Day']";
    public static String SDNAME = "//input[@name='SpecialDayName']";
    public static String SDDATE = "//input[@name='Date']";

    //ADDITIONAL DETAILS -> DOCTOR VENDOR
    public static String DV = "//p[normalize-space()='Doctor Vendor']";
    public static String DVSERVICE = "//input[@role='comboboxs']";
    public static String DVHEAD = "//input[@name='HeadOfService']";
    public static String DVPHONE = "//input[@name='PhoneNumber']";
    public static String DVDATE = "//input[@name='ServiceDateTime']";
    public static String DVNOTE = "//input[@name='Note']";




    //Xpath for the chemist master
    public static String CHEMISTNAMELBL = "//label[.='Chemist Name *']";
    public static String CHEMISTNAMEINP = "//label[.='Chemist Name *']/parent::div//input";
    public static String CHEMISTTYPELBL = "//label[.='Chemist Type *']";
    public static String CHEMISTTYPEINP = "//label[.='Chemist Type *']/parent::div//input";
    public static String POTENTIALBUSINESSLBL = "//label[.='Potential Business']";
    public static String POTENTIALBUSINESSINP = "//label[.='Potential Business']/parent::div//input";
    public static String DLNO1LBL = "//label[.='DL No1']";
    public static String DLNO1INP = "//label[.='DL No1']/parent::div//input";
    public static String DLNO2LBL = "//label[.='DL No2']";
    public static String DLNO2INP = "//label[.='DL No2']/parent::div//input";
    public static String STOCKISTLBL = "//label[.='Stockist']";
    public static String STOCKISTINP = "//label[.='Stockist']/parent::div//input";
    public static String GSTNOLBL = "//label[.='GST No.']";
    public static String GSTNOINP = "//label[.='GST No.']/parent::div//input";
    public static String FSSAILBL = "//label[.='FSSAI']";
    public static String FSSAIINP = "//label[.='FSSAI']/parent::div//input";
    public static String NRXLBL = "//label[.='NRX']";
    public static String NRXINP = "//label[.='NRX']/parent::div//input";
    public static String DOCTORLBL = "//label[.='Doctor']";
    public static String DOCTORINP = "//label[.='Doctor']/parent::div//input";

    //Xpath for the Stockist
    public static String STOCKISTNAMELBL = "//label[.='Stockist Name *']";
    public static String STOCKISTNAMEINP = "//label[.='Stockist Name *']/parent::div//input";
    public static String STOCKISTTYPELBL = "//label[.='Stockist Type *']";
    public static String STOCKISTTYPEINP = "//label[.='Stockist Type *']/parent::div//input";
    public static String MOBILENO1LBLSTO = "//label[contains(.,'Mobile No. 1 *')]";
    public static String MOBILENO1INPSTO = "//label[contains(.,'Mobile No. 1 *')]/parent::div//input";
    public static String MOBILENO2LBL = "//label[contains(.,'Mobile No. 2')]";
    public static String MOBILENO2INP = "//label[contains(.,'Mobile No. 2')]/parent::div//input";
    public static String MOBILENO3LBL = "//label[contains(.,'Mobile No. 3')]";
    public static String MOBILENO3INP = "//label[contains(.,'Mobile No. 3')]/parent::div//input";
    public static String PLACELBL = "//label[contains(.,'Place')]";
    public static String PLACEINP = "//label[contains(.,'Place')]/parent::div//input";
    public static String CFALOCATIONLBL = "//label[contains(.,'CFA Location')]";
    public static String CFALOCATIONINP = "//label[contains(.,'CFA Location')]/parent::div//input";
    public static String CONTACTPERSONLBL = "//label[contains(.,'Contact Person')]";
    public static String CONTACTPERSONINP = "//label[contains(.,'Contact Person')]/parent::div//input";
    public static String CODEREFLBL = "//label[contains(.,'Code Ref')]";
    public static String CODEREFINP = "//label[contains(.,'Code Ref')]/parent::div//input";
    public static String SAVEBUTTON = "//button[contains(.,'Save')]";

    //Xpath for the Hospital
    public static String HOSPITALLABEL = "//label[.='Hospital Name *']";
    public static String HOSPITALINP = "//input[@name='HospitalName']";
    public static String GSTLABEL = "//label[.='GST No. *']";
    public static String GSTINP = "//input[@name='GstNo']";
    public static String ADDRESSLINE1 = "//label[.='Address Line 1']";
    public static String ADDRESSLINEINP = "//input[@name='AddressLine1']";
    public static String AREALLBL = "//label[.='Area']";
    public static String AREAINPUT = "//input[@name='AddressLine2']";
    public static String HOSPITALNETABLE = "(//div[@data-field='HospitalName'])[2]";

    //Xpath for mandatory field
    public static String DoctorError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[1]";
    public static String CategoryError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[2]";
    public static String SpecialityError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[3]";
    public static String QualificationsError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[4]";
    public static String EmployeeError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[5]";
    public static String ProductError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[6]";
    public static String MobileNoError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[7]";
    public static String nameError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[8]";
    public static String packingTypeError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[9]";
    public static String HSNCodeError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[10]";
    public static String PTRPTSError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[11]";
    public static String GSTError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[12]";
    public static String MRPError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[13]";
    public static String ContentError = "(//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeSmall')])[14]";

    public static String ReportingSenior = "(//p[@id='autocomplete-undefined-helper-text'])[4]";
    public static String zoneError = "(//p[@id='autocomplete-undefined-helper-text'])[5]";
    public static String stateError = "(//p[@id='autocomplete-undefined-helper-text'])[6]";
    public static String regionError = "(//p[@id='autocomplete-undefined-helper-text'])[7]";
    public static String districtError = "(//p[@id='autocomplete-undefined-helper-text'])[8]";
    public static String cityError = "(//p[@id='autocomplete-undefined-helper-text'])[9]";


    public static String CityError = "(//p[@id='autocomplete-tags-standard-helper-text'])[1]";
    public static String PincodeError = "(//p[@id='autocomplete-tags-standard-helper-text'])[2]";
    public static String City2Error = "(//p[@id='autocomplete-tags-standard-helper-text'])[3]";
    public static String Pincode2Error = "(//p[@id='autocomplete-tags-standard-helper-text'])[4]";

    //Xpath for Tour Plan
    public static String TOURPLANMENU = "//a[.='Tour Program']";
    public static String MONTHLYTOURPLAN = "//div[contains(text(),'Monthly Tour Plan')]";
    public static String TODAYDATE = "//div[@class='rbc-day-bg rbc-today']";

    //Xpath for LMS
    public static String NewsAndEventsHed = "//main//div//h1";
    public static String AddNewPostBtn = "//span[contains(normalize-space(),'Add New Post')]";
    public static String AddNewPostPath = "//div[@class='flex flex-wrap justify-between items-center gap-2 p-4 pb-0']";
    public static String AddPostFormHed = "//span[.='Add Post Form']";
    public static String TitleLabel = "//label[.='Title*']";
    public static String SummaryLbl = "//label[.='Summary']";
    public static String PostedasLbl = "//label[.='Posted as*']";
    public static String TitleInp = "//input[@id='id_title']";
    public static String SummaryInp = "//textarea[@id='id_summary']";
    public static String SelectNewsEvent = "//select[@id='id_posted_as']";
    public static String SaveBtn = "//button[.='Save']";
    public static String CancelBtn = "//button[.='Cancel']";
    public static String getMessage = "//span[@class='ml-3 text-sm font-medium']";

    //Xpath for the create new MR ASM And RSM users
    public static String NAMEINP = "//input[@name='Name']";
    public static String DIVISIONINP = "(//input[@id='autocomplete-dropdown-7'])[1]";
    public static String BIOSDERMAOP = "//*[contains(.,'BIOS DERMA')]";
    public static String PHONENO = "//input[@name='Phone']";
    public static String MOBILENO = "//input[@name='Mobile']";
    public static String JOININGDATE = "//input[@name='JoiningDate']";
    public static String COMMNUNICATIONCITY = "(//input[@id='autocomplete-tags-standard'])[1]";
    public static String COMMNUCATIONPINCODE = "(//label[.='Pincode *']/following-sibling::div//input)[1]";
    public static String PERMANENTCITY = "(//input[@id='autocomplete-tags-standard'])[3]";
    public static String PERMANENTPINCODE = "(//label[.='Pincode *']/following-sibling::div//input)[2]";

    //Xpath for the Account list
    public static String USERNAMELABELAC = "//label[.='User Name *']";
    public static String USERNAME = "//input[@name='UserName']";
    public static String HQLBEL = "//label[.='Hq *']";
    public static String HQINP = "//label[.='Hq *']/following-sibling::div//input";
    public static String DESIGNATIONLBL = "//label[.='Designation *']";
    public static String DESIGNATIONINP = "//label[.='Designation *']/following-sibling::div//input";
    public static String EMPLOYEELBLAC = "//label[.='Employee *']";
    public static String EMPLOYEEINPEMP = "//label[.='Employee *']/following-sibling::div//input";
    public static String ROLELABEL = "//label[.='Role *']";
    public static String ROLEINP = "//label[.='Role *']/following-sibling::div//input";
    public static String REPORTINGSENIOR = "//label[.='Reporting Senior *']";
    public static String REPORTINGSENIORINP = "//label[.='Reporting Senior *']/following-sibling::div//input";
    public static String ZONELABL = "//label[.='Zone *']";
    public static String ZONEINP = "//label[.='Zone *']/following-sibling::div//input";
    public static String STATELBL = "//label[.='State *']";
    public static String STATEINP = "//label[.='State *']/following-sibling::div//input";
    public static String REGIONALLBL = "//label[.='Region *']";
    public static String REGIONINP = "//label[.='Region *']/following-sibling::div//input";
    public static String DISTRICTLBL = "//label[.='District *']";
    public static String DISTRICTINP = "//label[.='District *']/following-sibling::div//input";
    public static String CITYLABEL = "//label[.='City *']";
    public static String CITYINPEMP = "//label[.='City *']/following-sibling::div//input";

    public static String NEWPASSWORDFIELD = "//input[@name='NewPassword']";
    public static String CONFIRMPASSWORD = "//input[@name='ConfirmPassword']";
    public static String SUBMITBTN = "//button[.='Submit ']";

    //Xpath for the Role menu
    public static String ROLENAMELABEL = "//label[.='Role Name *']";
    public static String ROLENAMEINP = "//input[@name='RoleName']";

    //xpath for the Product
    public static String DIVISIONLBL = "//label[.='Division *']";
    public static String DIVISIONINPProduct = "//label[.='Division *']/following-sibling::div//input";
    public static String DRUGHEADLBL = "//label[.='Drug Head *']";
    public static String DRUGHEADINP = "//label[.='Drug Head *']/following-sibling::div//input";
    public static String PRODUCTLINELBL = "//label[.='Product Line *']";
    public static String PRODUCTLINEINP = "//label[.='Product Line *']/following-sibling::div//input";
    public static String PRODUCTGROUPLBL = "//label[.='Product Group *']";
    public static String PRODUCTGROUPINP = "//label[.='Product Group *']/following-sibling::div//input";
    public static String PRODUCTCLASSLBL = "//label[.='Product Class *']";
    public static String PRODUCTCLASSINP = "//label[.='Product Class *']/following-sibling::div//input";
    public static String PRODUCTTYPELBL = "//label[.='Product Type *']";
    public static String PRODUCTTYPEINP = "//label[.='Product Type *']/following-sibling::div//input";
    public static String SHORTNAMELBL = "//label[.='Short Name *']";
    public static String SHORTNAMEINP = "//label[.='Short Name *']/following-sibling::div//input";
    public static String NAMELBL = "//label[.='Name *']";
    public static String NAMEINPProduct = "//label[.='Name *']/following-sibling::div//input";
    public static String PACKINGTYPELBL = "//label[.='Packing Type *']";
    public static String PACKINGTYPEINP = "//label[.='Packing Type *']/following-sibling::div//input";
    public static String CODEREF1LBL = "//label[.='Code Ref 1']";
    public static String CODEREF1INP = "//label[.='Code Ref 1']/following-sibling::div//input";
    public static String HSNCODELBL = "//label[.='Hsn code *']";
    public static String HSNCODEINP = "//label[.='Hsn code *']/following-sibling::div//input";
    public static String PTSANDPTRLBL = "//label[.='PTS AND PTR *']";
    public static String PTSANDPTRINP = "//label[.='PTS AND PTR *']/following-sibling::div//input";
    public static String MARGINLBL = "//label[.='MARGIN']";
    public static String MARGININP = "//label[.='MARGIN']/following-sibling::div//input";
    public static String GSTPERCENTLBL = "//label[.='GST % *']";
    public static String GSTPERCENTINP = "//label[.='GST % *']/following-sibling::div//input";
    public static String MRPLBL = "//label[.='MRP *']";
    public static String MRPINP = "//label[.='MRP *']/following-sibling::div//input";
    public static String PTRLBL = "//label[.='PTR *']";
    public static String PTRINP = "//label[.='PTR *']/following-sibling::div//input";
    public static String PTSLBL = "//label[.='PTS *']";
    public static String PTSINP = "//label[.='PTS *']/following-sibling::div//input";
    public static String CONTENTLBL = "//label[.='Content *']";
    public static String CONTENTINP = "//textarea[@name='Contents']";

    //Xpath for the employee
    public static String NAMELBLEMP = "//label[.='Name *']";
    public static String NAMEINPEMP = "//label[.='Name *']/following-sibling::div//input";
    public static String DIVISIONLBLEMP = "//label[.='Division *']";
    public static String DIVISIONINPEMP = "//label[.='Division *']/following-sibling::div//input";
    public static String REFERENCELBLEMP = "//label[.='Reference']";
    public static String REFERENCEINPEMP = "//label[.='Reference']/following-sibling::div//input";
    public static String PHONENOLBLEMP = "//label[.='Phone No *']";
    public static String PHONENOINPEMP = "//label[.='Phone No *']/following-sibling::div//input";
    public static String MOBILENOLBLEMP = "//label[.='Mobile No. *']";
    public static String MOBILENOINPEMP = "//label[.='Mobile No. *']/following-sibling::div//input";
    public static String EMAILLBLEMP = "//label[.='Email *']";
    public static String EMAILINPEMP = "//label[.='Email *']/following-sibling::div//input";
    public static String PREVEXPLBL = "//label[.='Previous Experience']";
    public static String PREVEXPINP = "//label[.='Previous Experience']/following-sibling::div//input";
    public static String PASSPORTLBL = "//label[.='Passport']";
    public static String PASSPORTINP = "//label[.='Passport']/following-sibling::div//input";
    public static String PANCARDLBL = "//label[.='Pan Card Number']";
    public static String PANCARDINP = "//label[.='Pan Card Number']/following-sibling::div//input";
    public static String PFNOLBL = "//label[.='PF No.']";
    public static String PFNOINP = "//label[.='PF No.']/following-sibling::div//input";
    public static String UANNOLBL = "//label[.='UanNo']";
    public static String UANNOINP = "//label[.='UanNo']/following-sibling::div//input";
    public static String BLOODGROUPLBL = "//label[.='Blood Group']";
    public static String BLOODGROUPINP = "//label[.='Blood Group']/following-sibling::div//input";
    public static String RELIGIONLBL = "//label[.='Religion']";
    public static String RELIGIONINP = "//label[.='Religion']/following-sibling::div//input";
    public static String BIRTHDATELBL = "//label[.='Birth Date']";
    public static String BIRTHDATEINP = "//label[.='Birth Date']/following-sibling::div//input";
    public static String MARITALSTATUSLBL = "//label[.='Marital Status']";
    public static String MARITALSTATUSINP = "//label[.='Marital Status']/following-sibling::div//input";
    public static String GENDERLBL = "//label[.='Gender']";
    public static String GENDERINP = "//label[.='Gender']/following-sibling::div//input";
    public static String ANNIDATELBL = "//label[.='Anniversary Date']";
    public static String ANNIDATEINP = "//label[.='Anniversary Date']/following-sibling::div//input";
    public static String JOININGDATELBL = "//label[.='Joining Date *']";
    public static String JOININGDATEINP = "//label[.='Joining Date *']/following-sibling::div//input";
    public static String LASTWORKINGDATELBL = "//label[.='Last Working Date']";
    public static String LASTWORKINGDATEINP = "//label[.='Last Working Date']/following-sibling::div//input";
    public static String BANKIFSCLBL = "//label[.='Bank IFSC code']";
    public static String BANKIFSCINP = "//label[.='Bank IFSC code']/following-sibling::div//input";
    public static String SALARYBANKNAMELBL = "//label[.='Salary Bank Name']";
    public static String SALARYBANKNAMEINP = "//label[.='Salary Bank Name']/following-sibling::div//input";
    public static String BANKACCOUNTNOLBL = "//label[.='Bank Account No.']";
    public static String BANKACCOUNTNOINP = "//label[.='Bank Account No.']/following-sibling::div//input";
    public static String NAMEASBANKLBL = "//label[.='Name As Bank Registered']";
    public static String NAMEASBANKINP = "//label[.='Name As Bank Registered']/following-sibling::div//input";
    public static String AADHARLBL = "//label[.='Aadhar Card Number']";
    public static String AADHARINP = "//label[.='Aadhar Card Number']/following-sibling::div//input";
    public static String DRIVINGLICENCELBL = "//label[.='Driving License No']";
    public static String DRIVINGLICENSEINP = "//label[.='Driving License No']/following-sibling::div//input";
    public static String EXPENSEBANKNAMELBL = "//label[.='Expense Bank Name']";
    public static String EXPENSEBANKNAMEINP = "//label[.='Expense Bank Name']/following-sibling::div//input";
    public static String EXPENSEBANKACCLBL = "//label[.='Expense Bank Account Number']";
    public static String EXPENSEBANKACCINP = "//label[.='Expense Bank Account Number']/following-sibling::div//input";
    public static String PROMOTIONDATELBL = "//label[.='Promotion Date']";
    public static String PROMOTIONDATEINP = "//label[.='Promotion Date']/following-sibling::div//input";
    public static String DEMOTIONDATELBL = "//label[.='Demotion Date']";
    public static String DEMOTIONDATEINP = "//label[.='Demotion Date']/following-sibling::div//input";
    public static String CONFORMATIONDATELBL = "//label[.='Conformation Date']";
    public static String CONFORMATIONDATEINP = "//label[.='Conformation Date']/following-sibling::div//input";
    public static String METROLBL = "//label[.='Metro']";
    public static String METROINP = "//label[.='Metro']/following-sibling::div//input";
    public static String APPOINTMENTLETTLBL = "//label[.='Appointment Letter']";
    public static String APPOINTMENTLETTINP = "//label[.='Appointment Letter']/following-sibling::div//input";
    public static String EDUCATIONLBL = "//label[.='Education']";
    public static String EDUCATIONINP = "//label[.='Education']/following-sibling::div//input";
    public static String FATHERHUSBNAMELBL = "//label[.='Father/Husband Name']";
    public static String FATHERHUSBNAMEINP = "//label[.='Father/Husband Name']/following-sibling::div//input";
    public static String FATHERHUSBCONTACTLBL = "//label[.='Father/Husband Contact Number']";
    public static String FATHERHUSBCONTACTINP = "//label[.='Father/Husband Contact Number']/following-sibling::div//input";
    public static String ABHANOLBL = "//label[.='Abha Number']";
    public static String ABHANOINP = "//label[.='Abha Number']/following-sibling::div//input";
    public static String AAYUSHMANCARDLBL = "//label[.='Aayushman Card Number']";
    public static String AAYUSHMANCARDINP = "//label[.='Aayushman Card Number']/following-sibling::div//input";
    public static String SPOUSENAMELBL = "//label[.='Spouse Name']";
    public static String SPOUSENAMEINP = "//label[.='Spouse Name']/following-sibling::div//input";
    public static String SPOUSECONTACTLBL = "//label[.='Spouse Contact Number']";
    public static String SPOUSECONTACTINP = "//label[.='Spouse Contact Number']/following-sibling::div//input";
    public static String SONNAMELBL = "//label[.='Son Name']";
    public static String SONNAMEINP = "//label[.='Son Name']/following-sibling::div//input";
    public static String SONCONTACTLBL = "//label[.='Son Contact Number']";
    public static String SONCONTACTINP = "//label[.='Son Contact Number']/following-sibling::div//input";
    public static String DAUGHTERNAMELBL = "//label[.='Daughter Name']";
    public static String DAUGHTERNAMEINP = "//label[.='Daughter Name']/following-sibling::div//input";
    public static String DAUGHTERCONTACTLBL = "//label[.='Daughter Contact Number']";
    public static String DAUGHTERCONTACTINP = "//label[.='Daughter Contact Number']/following-sibling::div//input";
    public static String SKILLSLBL = "//label[.='Skills']";
    public static String SKILLSINP = "//label[.='Skills']/following-sibling::div//input";
    public static String AREADEVLBL = "//label[.='Area Of Development']";
    public static String AREADEVINP = "//label[.='Area Of Development']/following-sibling::div//input";
    public static String SHORTGOALLBL = "//label[.='Short Term Goal']";
    public static String SHORTGOALINP = "//label[.='Short Term Goal']/following-sibling::div//input";
    public static String LONGGOALLBL = "//label[.='Long Term Goal']";
    public static String LONGGOALINP = "//label[.='Long Term Goal']/following-sibling::div//input";
    public static String INVESTMENTSLBL = "//label[.='Investments']";
    public static String INVESTMENTSINP = "//label[.='Investments']/following-sibling::div//input";
    public static String LIABILITIESLBL = "//label[.='Liabilities']";
    public static String LIABILITIESINP = "//label[.='Liabilities']/following-sibling::div//input";
    public static String REFNAME1LBL = "//label[.='Reference Name 1']";
    public static String REFNAME1INP = "//label[.='Reference Name 1']/following-sibling::div//input";
    public static String REF1CONTACTLBL = "//label[.='Reference Name 1 Contact Number']";
    public static String REF1CONTACTINP = "//label[.='Reference Name 1 Contact Number']/following-sibling::div//input";
    public static String REFNAME2LBL = "//label[.='Reference Name 2']";
    public static String REFNAME2INP = "//label[.='Reference Name 2']/following-sibling::div//input";
    public static String REF2CONTACTLBL = "//label[.='Reference Name 2 Contact Number']";
    public static String REF2CONTACTINP = "//label[.='Reference Name 2 Contact Number']/following-sibling::div//input";
    public static String REFNAME3LBL = "//label[.='Reference Name 3']";
    public static String REFNAME3INP = "//label[.='Reference Name 3']/following-sibling::div//input";
    public static String REF3CONTACTLBL = "//label[.='Reference Name 3 Contact Number']";
    public static String REF3CONTACTINP = "//label[.='Reference Name 3 Contact Number']/following-sibling::div//input";
    public static String EXPERIENCESLBL = "//label[.='Experinces']";
    public static String EXPERIENCESINP = "//label[.='Experinces']/following-sibling::div//input";
    // Repeating address fields
    public static String ADDRESSLINE1LBL = "//label[.='Address Line 1']";
    public static String ADDRESSLINE1INP = "//label[.='Address Line 1']/following-sibling::div//input";
    public static String AREALBLEMP = "//label[.='Area']";
    public static String AREAINPEMP = "//label[.='Area']/following-sibling::div//input";
    public static String CITYLBLEMP = "//label[.='City *']";
    public static String CITYINPEMP1 = "//label[.='City *']/following-sibling::div//input";
    public static String PINCODELBLEMP = "//label[.='Pincode *']";
    public static String PINCODEINPEMP = "//label[.='Pincode *']/following-sibling::div//input";


    //Xpath for the yopmail
    public static String EMAILINPFIELD = "//input[@class='ycptinput']";
    public static String ENTERICONMAIL = "//i[@class='material-icons-outlined f36']";
    public static String MAILCONTENT = "//div[@id='mail']";
    public static String LOGOUTBTN = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-auoq4t'])[2]";

    //Xpath for the add rout for the users
    public static String UPLAODMENU = "//span[.='Upload']";
    public static String SRCMENU = "//div[contains(text(),'SRC')]";
    public static String EMPLOYEEFIELD = "//input[@id='autocomplete-dropdown-7']";
    public static String STARTCITYFIELD = "//input[@id='autocomplete-start-city']";
    public static String ENDCITYFIELD = "//input[@id='autocomplete-end-city-0']";
    public static String KMSFIELD = "//input[@type='number']";
    public static String ADDBUTTON = "//button[.='Add']";

    //Xpath for the SFC
    public static String SFCMENU = "//span[.='SFC']";
    public static String CONFIGURATIONBTN = "//button[contains(.,'Configuration')]";
    public static String DAILYALLOWANCE = "//div[contains(text(),'Daily Allowance')]";
    public static String EMPLOYEEFIELDSFC = "//label[.='Employee *']/following-sibling::div//input";
    public static String HQTYPESFC = "//label[.='Hq Type *']/following-sibling::div//input";
    public static String HRCALCULATIONSFC = "//label[.='Hq Calculation Type *']/following-sibling::div//input";
    public static String HQFIELDSFC = "//label[.='Hq *']/following-sibling::div//input";
    public static String EXHQCALCULATIONSFC = "//label[.='Ex Hq Calculation Type *']/following-sibling::div//input";
    public static String EXHQSFC = "//label[.='ExHq *']/following-sibling::div//input";
    public static String OSCALCULATIONTYPE = "//label[.='Os Calculation Type *']/following-sibling::div//input";
    public static String OSFIEDL = "//label[.='Os *']/following-sibling::div//input";
    public static String CLEARBTN = "//label[.='Employee']/following-sibling::div//button[1]";

    //Xpath for the Chemist
    public static String CHEMISTNAME = "//label[.='Chemist Name *']/following-sibling::div//input";
    public static String CHEMMISTTYPE = "//label[.='Chemist Type *']/following-sibling::div//input";
    public static String CITYINPUT = "//label[.='City *']/following-sibling::div//input";
    public static String PINCODEINPUT = "//label[.='Pincode *']/following-sibling::div//input";

    //xpath for the Stockist
    public static String STOCKISTNAME = "//label[.='Stockist Name *']/following-sibling::div//input";
    public static String STOCKISTTYPE = "//label[.='Stockist Type *']/following-sibling::div//input";
    public static String MOBILENO1FIELD = "//label[contains(.,'Mobile No. 1')]/following-sibling::div//input";

    public static String DESIGNATIONLBL1 = "//label[.='Designation *']";
    public static String DESIGNATIONINPUT = "//input[@name='DesignationName']";
    public static String PARENTDESIGNATIONLBL = "//label[.='Parent Designation *']";
    public static String PARENTDESIGNATIONINP = "//label[.='Parent Designation *']/following-sibling::div//input";

    //Xpath for the Bulk approval
    public static String BULKAPPROVALBTN = "//button[.='Bulk Approvals']";
    public static String CHECKBOX = "(//div[@style='--width: 50px;'])[1]";
    public static String APPROVEBTN = "//img[@alt='Approve']";

    public static String CLOSEBTN = "//button[@aria-label='close']";
    public static String FIRSTCHECKBOX = "(//*[local-name()='svg']/ancestor::span//input)[2]";

    //xpath for the holiday module
    public static String SEARCHFIELDINDASH = "//input[@placeholder='Search...']";
    public static String HOLIDAYSMENU = "//span[.='Holidays']";
    public static String DATEINP = "//input[@name='Date']";
    public static String HOLIDAYCHECKBOX = "(//span[contains(@class,'MuiButtonBase-root MuiRadio-root')])[1]";
    public static String HOLIDAYNAMEFIEDL = "//input[@name='HolidayName']";
    public static String REASONTEXTAREA = "//textarea[@name='Reason']";

    //Vendor xpath
    public static String VENDORMENU = "//span[.='Vendor']";
    public static String VENDORSERTYPE = "//label[.='Vendor Service Type']/following-sibling::div//input";
    public static String VENDORNAMEFIELD = "//input[@name='Name']";
    public static String PHONENUMBER = "//input[@name='Phone']";
    public static String CONTACTPHONENUM = "//input[@name='ContactPhone']";
    public static String RATINGFIELD = "//input[@name='Rating']";
    public static String REMARKFIELD = "//textarea[@name='Remark']";
    public static String ADDRESSLINE1MAN = "//label[.='Address Line 1 *']/following-sibling::div//input";
    public static String AREALMAN = "//label[.='Area *']/following-sibling::div//input";
    public static String CREATEDVALUE = "//div[@data-id='1']//div[@data-colindex='2']";
    public static String CONTACTNUMBER = "//div[@data-id='1']//div[@data-colindex='5']";
    public static String RATINGSTABLE = "//div[@data-colindex='6']//span[@aria-label='4 Stars']";
    public static String SEARCHFIELDTAB = "//input[@placeholder='Search']";

    //Xpath for the attributes
    public static String ATTRIBUTESMENU = "//span[.='Attributes']";
    public static String DOCTORMENUATT = "//div[contains(text(),'Doctor')]";
    public static String DOCTORCATEGORY = "//div[contains(text(),'Doctor Category')]";
    public static String CATEGORYNAME = "//input[@name='CategoryName']";
    public static String CATEGORYORDER = "//input[@name='CategoryOrder']";
    public static String EXPECTEDVISIT = "//input[@name='ExpectedVisit']";
    public static String DOCTORSPECIALITY = "//div[contains(text(),'Doctor Speciality')]";
    public static String SPECIALITYNAME = "//input[@name='SpecialityName']";
    public static String REMARKSINP = "//input[@name='Remarks']";
    public static String QUALIFICATIONINP = "//label[.='Qualifications *']/following-sibling::div//input";
    public static String DOCTORQUALIFICATION = "//div[contains(text(),'Doctor Qualification')]";
    public static String QUALIFICATIONINPATT = "//input[@name='QualificationName']";
    public static String DOCTORDEGREETYPE = "//div[contains(text(),'Doctor Degree Type')]";
    public static String DOCTORDEGREETYPEINP = "//input[@name='DoctorDegreeTypeName']";
    public static String DOCTORGUIDELINESTYPEMENU = "//div[contains(text(),'Doctor Guidelines Type')]";
    public static String DOCTORGUIDELINESTYPEINP = "//input[@name='DoctorGuidelinesTypeName']";
    public static String ENTERTAINMENTMENU = "//div[contains(text(),'Entertainment Type')]";
    public static String ENTERTAINMENTMINP = "//input[@name='EntertainmentTypeName']";
    public static String ENTERTAINMENTACTIVITYTYPE = "//div[contains(text(),'Entertainment Activity Type')]";
    public static String ENTERTAINMENTACTIVITYINP = "//input[@name='EntertainmentActivityTypeName']";
    public static String HOSPITALROLETYPE = "//div[contains(text(),'Hospital Role Type')]";
    public static String HOSPITALROLEINP = "//input[@name='HospitalRoleTypeName']";
    public static String DOCTORAREAOFINTEREST = "//div[contains(text(),'Doctor Area Of Interest Type')]";
    public static String DOCTORAREAOFINTERESTINP = "//input[@name='DoctorAreaOfInterestTypeName']";
    public static String VENDORTYPEMENU = "//div[contains(text(),'Vendor Type')]";
    public static String VENDORTYPETYPE = "//input[@name='VendorServiceTypeName']";
    public static String ACHIVEMENTTYPEMENU = "//div[contains(text(),'Achievement Type')]";
    public static String ACHIVEMENTTYPETYPE = "//input[@name='AchievementTypeName']";
    public static String FEESTYPEMENU = "//div[contains(text(),'Fees Type')]";
    public static String FEESTYPEINP = "//input[@name='ConsultingFeesTypeName']";
    public static String CONFERENCEANDWEBINARATTENDEDTYPEMENU = "//div[contains(text(),'Conference And Webinar Attended Type')]";
    public static String CONFERENCEANDWEBINARATTENDEDTYPEINP = "//input[@name='ConferencesAndWebinarAttendedAsTypeName']";
    public static String CONFERENCEANDWEBINARSUBJECTTYPEMENU = "//div[contains(text(),'Conferences And Webinar Subject Type')]";
    public static String CONFERENCEANDWEBINARSUBJECTTYPEINP = "//input[@name='ConferencesAndWebinarSubjectTypeName']";
    public static String RELATIONTYPE = "//div[contains(text(),'Relation Type')]";
    public static String RELATIONTYPEINP = "//input[@name='RelationName']";
    public static String DOCTORNATURE = "//div[contains(text(),'Doctor Nature')]";
    public static String DOCTORFEEDBACKONGIFT = "//div[contains(text(),'Doctor Feedback on Gift')]";
    public static String DCCTORSUPPORT = "//div[contains(text(),'Doctor Support')]";
    public static String DCCTORFEEDBACK = "//div[text()='Doctor Feedback']";
    public static String FIRSTROWDATA = "//div[@data-colindex='2']";
    public static String CHEMISTMENUATT = "//div[contains(text(),'Chemist')]";
    public static String CHEMISTCATEGORY = "//div[contains(text(),'Category')]";
    public static String CATEGORYNAMEATT= "//input[@name='ChemistCategoryName']";
    public static String CATEGORYORDERATT= "//input[@name='ChemistCategoryOrder']";
    public static String CONTACTPERSON = "//div[contains(text(),'Contact Person')]";
    public static String CHEMISTNAMEDRP = "//label[.='Chemist Name *']/following-sibling::div//input";
    public static String CHEMISTCONTACTPERSONNAME= "//input[@name='ChemistContactPersonName']";
    public static String EAMILFIELD= "//input[@name='Email']";
    public static String MOBILNOFIELD = "//input[@name='MobileNo']";
    public static String CHEMISTTYPE = "//input[@name='ChemistTypeName']";
    public static String TYPEMENU = "//div[contains(text(),'Type')]";
    public static String HOSPITALMENUATT = "//div[contains(text(),'Hospital')]";
    public static String HOSPITALCONTACTPERSON= "//div[contains(text(),'Hospital Contact Person')]";
    public static String HOSPITALNAMEINPATT = "//label[.='Hospital Name *']/following-sibling::div//input";
    public static String HOSCONTACTPERSON = "//label[.='Hospital Contact Person Name *']/following-sibling::div//input";



    //Xpath for the email communication
    public static String COMMUNICATIONMENU = "//span[.='Communication']";
    public static String EMAILSUBMENU = "//div[contains(text(),'Email')]";
    public static String COMPOSEBTN = "//button[.=' Compose']";
    public static String TOINP = "//label[.='To: *']/following-sibling::div//input";
    public static String SUBJECTINP = "//label[.='Subject: *']/following-sibling::div//input";
    public static String TEXTAREAMAIL = "//div[@class='ql-editor ql-blank']";
    public static String SENDBTNMAIL = "//button[.='Send']";
    public static String SEARCHFIELDCOMMNUNICATION = "//input[contains(@aria-label,'search')]";
    public static String FIRSTEMAILCHECKBOX = "(//input[@type='checkbox' and @name='select_row'])[1]";
    public static String VIEWBTNCOM = "(//div[@class='container']//button)[2]";
    public static String GETSUBJECT = "//h6[contains(.,'Subject :')]//span";
    public static String GETFROM = "//h6[contains(.,'From :')]//span";
    public static String GETTO = "//h6[contains(.,'To :')]//span";
    public static String TODROPDOWN = "//label[.='To: *']/following-sibling::div//button";
    public static String ADDTODRAFTBTN = "//button[.='Add To Draft']";
    public static String COMPOSEAGAINBTN = "//button[.='Compose Again']";
    public static String MESSAGEAREA = "//h6[.='Message :']/parent::div//p";
    public static String ANNOUNCEMENTMENU = "//div[contains(text(),'Announcement')]";
    public static String TOANNOUNCEMENT= "//label[.='To *']/following-sibling::div//button";
    public static String TITLEINP = "//label[.='Title *']/following-sibling::div//input";
    public static String MESSAGEINP = "//label[.='Message *']/following-sibling::div//textarea[@name='Message']";
    public static String BODYINP = "//div[@class='ql-container ql-snow']//p";
    public static String TOFIELDVALIDATION = "//p[@id='autocomplete-dropdown-7-helper-text']";
    public static String TITLEVALIDATION = "//p[contains(.,'Title is required')]";
    //public static String = "";

    //Xpath for the Doctor availability
    public static String TOURPROGRAMMENU = "//a[.='Tour Program']";
    public static String DOCTORAPPROVALAVAILABILITY = "//div[contains(text(),'Doctor Availibility')]";
    public static String DOCTORINPDRAVAIL = "//label[.='Doctor *']/following-sibling::div//input";
    public static String LEAVESTARTDATE = "//input[@name='LeaveStartDate']";
    public static String LEAVEENDDATE = "//input[@name='LeaveEndDate']";
    public static String CREATEDDOCTOR = "(//div[@data-colindex='4'])[1]";
    public static String APPROVALMENU = "//span[.='Approvals']";
    public static String DELETEAPPROVALDOCTOR = "//div[contains(text(),'Delete Approval Doctor')]";
    public static String DELETEAPPROVALCHEMIST = "//div[contains(text(),'Delete Approval Chemist')]";
    public static String DELETEAPPROVALSTOCKIEST = "//div[contains(text(),'Delete Approval Stockist')]";
    public static String DOCTORAVAILIBILITY = "//div[contains(text(),'Doctor Availibility')]";
    public static String DOCTORDROPDOWNICN = "//label[.='Doctor *']/following-sibling::div//input";
    public static String DOCTORVALUEINP = "//input[@aria-autocomplete='list']";
    public static String DOCTORSTARTDATE = "//label[.='Start Date *']/following-sibling::div//input";
    public static String DOCTORENDDATE = "//label[.='End Date *']/following-sibling::div//input";
    public static String FIRSTCHECKBOXAPPROVE = "(//tr[@class='MuiTableRow-root css-1rz7w7v']//td//span//input)[1]";

    //Xpath for Daily tour plan
    public static String DAILYTOURPLANMENU = "//div[contains(text(),'Daily Tour plan')]";
    public static String TOURPLANDATEINP = "//input[@name='TourDate']";
    public static String DOCTORINPDAILYPLAN = "//label[.='Doctor *']/following-sibling::div//input";


    //xpath for inventory
    public static String INVENTORYMENU = "//a[@href='/inventory']";

    //xpath for inventory Master
    public static String INVENTORYMASTERMENU = "//div[contains(text(),'Master')]";

    //xpath for inventory Master company
    public static String INVENTORYMASTERCOMPANY = "//div[contains(text(),'Company')]";
    public static String COMPANYNAME = "//input[@name='Name']";
    public static String COMPANYGST = "//input[@name='GstNo']";
    public static String COMPANYCURRENCY = "(//input[@role='combobox'])[1]";
    public static String COMPANYFSSAI = "//input[@name='FssAi']";
    public static String COMPANYDLNO1 = "//input[@name='DlNo1']";
    public static String COMPANYDLNO2 = "//input[@name='DlNo2']";
    public static String COMPANYNRX = "//input[@name='Nrx']";
    public static String COMPANYDATE = "//input[@name='FssAiExpiryDate']";
    public static String COMPANYDLNO1EXPDATE = "//input[@name='DlNo1ExpiryDate']";
    public static String COMPANYDLNO2EXPDATE = "//input[@name='DlNo2ExpiryDate']";
    public static String COMPANYNRXDATE = "//input[@name='NrxExpiryDate']";
    public static String COMPANYADDRESS1 = "//input[@name='AddressLine1']";
    public static String COMPANYAREA = "//input[@name='AddressLine2']";
    public static String COMPANYCITY = "(//input[@role='combobox'])[2]";
    public static String COMPANYPINCODE = "(//input[@role='combobox'])[3]";
    public static String COMPANYSEARCH = "//input[@placeholder='Search']";
    public static String COMPANYSEARCH_CLICK = "form[class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 css-1gh1qyt'] button[aria-label='search']";

    //xpath for inventory Master Currency
    public static String INVENTORYMASTERCURRENCY = "//div[contains(text(),'Currency')]";
    public static String CURRENCYNAME = "//input[@name='Name']";
    public static String CURRENCYSYMBOL = "//input[@name='Symbol']";
    public static String CURRENCYFORMAT = "//input[@name='Format']";
    public static String CURRENCYSEARCH = "//input[@placeholder='Search']";

    //xpath for inventory master Customer
    public static String INVENTORYMASTERCUSTOMER = "//div[contains(text(),'Customer')]";
    public static String CUSTOMERNAME = "//input[@name='Name']";
    public static String CUSTOMERGRNUMBER = "//input[@name='GRNumber']";
    public static String CUSTOMERGSTNUMBER = "//input[@name='Gstno']";
    public static String CUSTOMERCOMPANY = "//label[contains(., 'Company')]/following-sibling::div//input";
    public static String CUSTOMERDISCOUNT = "//input[@name='Discount']";
    public static String CUSTOMERHQ = "//label[contains(., 'HQ')]/following-sibling::div//input";

    //xpath for inventory master HSN
    public static String INVENTORYHSNMENU = "//div[contains(text(),'HSN')]";
    public static String SGST= "//input[@name='Sgst']";
    public static String CGST= "//input[@name='Cgst']";
    public static String IGST= "//input[@name='Igst']";
    public static String HSNTYPE= "//input[@role='combobox']";
    public static String UQC= "//input[@name='Uqcunit']";

    //xpath for inventory master payment method
    public static String INVENTORYPAYMENTMETHODMENU = "//div[contains(text(),'Payment Method')]";

    //xpath for inventory master warehouse
    public static String INVENTORYWAREHOUSE = "//div[contains(text(),'Warehouse')]";
    public static String INVENTORYCOMPANY = "//input[@role='combobox']";

    //xpath for inventory master vendor
    public static String INVENTORYVENDORMENU = "//div[contains(text(),'Vendor')]";
    public static String VENDORNAME = "//input[@name='VendorName']";
    public static String GSTNUMBER = "//input[@name='Gstno']";
    public static String COMPANY = "(//input[@role='combobox'])[1]";
    public static String DLNO1 = "//input[@name='DlNo1']";
    public static String DLNO2 = "//input[@name='DlNo2']";
    public static String NRX = "//input[@name='Nrx']";
    public static String FSSAIEXPIRYDATE = "//input[@name='FssAiExpiryDate']";
    public static String DLNO1EXPIRYDATE = "//input[@name='DlNo1ExpiryDate']";
    public static String DLNO2EXPIRYDATE = "//input[@name='DlNo2ExpiryDate']";
    public static String NRXEXPIRYDATE = "//input[@name='NrxExpiryDate']";
    public static String FSSAI = "//input[@name='FssAi']";
    public static String PHONE = "//input[@name='Phone']";
    public static String DISCOUNT = "//input[@name='Discount']";

    //xpath for inventory master gift
    public static String INVENTORYGIFT = "//div[contains(text(),'Gift')]";
    public static String GIFTNAME = "//input[@name='GiftName']";
    public static String GIFTPRICE = "//input[@name='GiftPrice']";
    public static String DIVISION = "//input[@role='combobox']";
    public static String DOCTORGIFT = "//span[normalize-space()='Doctor Gift']";
    public static String CHEMISTGIFT = "//span[normalize-space()='Chemist Gift']";
    public static String STOCKIESTGIFT = "//span[normalize-space()='Stockist Gift']";
    public static String EMPLOYEEGIFT = "//span[normalize-space()='Employee Gift']";
    public static String SELECTCHECKBOX = "(//input[@name='select_row'])[1]";
    public static String MREMARK = "//textarea[@name='Remark']";

    //xpath for inventory purchase invoice
    public static String PURCHASINVOICE = "//div[contains(text(),'Purchase Invoice')]";
    public static String INITIALVALUE = "//tbody[@class='MuiTableBody-root css-y6j1my']/tr[@class='MuiTableRow-root css-16xx7dv'][1]/td[5]";
    public static String CURRENTVALUE = "//tbody[@class='MuiTableBody-root css-y6j1my']/tr[@class='MuiTableRow-root css-16xx7dv'][1]/td[5]";
    public static String VENDOR = "(//input[@role='combobox'])[1]";
    public static String WAREHOUSE = "(//input[@role='combobox'])[2]";
    public static String BILLNO = "//input[@name='BillNo']";
    public static String BILLDATE = "//input[@name='BillDate']";
    public static String EXTRACHARGES = "//input[@name='ExtraCharges']";
    public static String TOTALDISCOUNT = "(//input[@name='Discount'])[1]";
    public static String NOTE = "//textarea[@name='Note']";
    public static String PRODUCT = "(//input[@role='combobox'])[3]";
    public static String HSN = "(//input[@role='combobox'])[4]";
    public static String BATCH_NO = "//input[@name='BatchNo']";
    public static String PURCHASEPRICE = "//input[@name='PurchasePrice']";
    public static String QUANTITY = "//input[@name='Quantity']";
    public static String SAMPLEQUANTITY = "//input[@name='SampleQuantity']";
    public static String DISCOUNT2 = "(//input[@name='Discount'])[2]";
    public static String MFGDATE = "//input[@name='ManufactureDate']";
    public static String EXPDATE = "//input[@name='ExpiryDate']";
    public static String MRP = "//input[@name='MRP']";
    public static String ADD = "(//button[@type='button'][normalize-space()='Add'])[1]";
    public static String PAYMENTMETHOD = "(//input[@role='combobox'])[5]";
    public static String AMOUNT = "//input[@name='Amount']";
    public static String NOTES = "//textarea[@name='Notes']";
    public static String ADD2 = "(//button[@type='button'][normalize-space()='Add'])[2]";
    public static String SAVE = "//button[normalize-space()='Save']";

    //xpath for purchase return
    public static String PURCHASERETURN = "//tbody[@class='MuiTableBody-root css-y6j1my']/tr[@class='MuiTableRow-root css-16xx7dv'][1]/td[16]";
    public static String RETURNTYPE = "(//input[@role='combobox'])[1]";
    public static String STOCKTYPE = "(//input[@role='combobox'])[2]";
    public static String PREXTRACHARGES = "//input[@name='ExtraCharges']";
    public static String PRDISCOUNT = "//input[@name='Discount']";
    public static String PRNOTE = "//textarea[@name='Note']";
    public static String PREDIT = "//img[@alt='Edit']";
    public static String PRQTY = "//input[@name='Quantity']";
    public static String PRPRICE = "//input[@name='PurchasePrice']";
    public static String PRDISCOUNT2 = "(//input[@name='Discount'])[2]";
    public static String ACCEPT = "//img[@alt='Update']";
    public static String CANCEL = "//img[@alt='Cancle']";

    //Xpath for the Expense
    public static String EXPENSEMENU = "//div[contains(text(),'Expense')]";
    public static String EXPENSEDATEINP = "//input[@name='ExpenseDate']";
    public static String EXPENSETYPEDRP = "//input[@id='autocomplete-dropdown-7']";
    public static String AMOUNTINP = "//input[@name='Amount']";
    public static String NOTETEXTAREA = "//textarea[@name='Note']";
    public static String BILLIMAGEINP = "//div//input[@name='BillImage']";
    public static String GETEXPENSETYPE = "(//div[@aria-colindex='4'])[2]";
    public static String GETEXPENSEDATE = "(//div[@aria-colindex='5'])[2]";
    public static String GETEXPENSEAMOUNT = "(//div[@aria-colindex='6'])[2]";

    //xpath for the Leave
    public static String LEAVEMENU = "//div[contains(text(),'Leave')]";
    public static String HALFDAYCHECKBOX = "//input[contains(@value,'1')]";
    public static String FULLDAYCHECKBOX = "//input[contains(@value,'2')]";
    public static String MULTIPLEDAYCHECKBOX = "//input[contains(@value,'3')]";
    public static String LEAVETYPEINP = "//input[@aria-autocomplete='list']";
    public static String FROMDATEINP = "//input[@name='FromDate']";
    public static String REASONINP = "//textarea[@name='Reason']";
//    public static String = "";
//    public static String = "";
//    public static String = "";
//    public static String = "";


}