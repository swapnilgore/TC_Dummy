package com.airlines.thomascook.scripts.condorDE;

import com.airlines.thomascook.businesslogic.Reusables_DE;
import com.airlines.thomascook.objectrepository.OR_FlightDetails;
import com.airlines.thomascook.objectrepository.OR_HomePage;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;

import static com.airlines.thomascook.utils.ExcelUtilsJxl.getExcelData;


/**
 * Created by E002465 on 06-06-2017.
 */
public class Scenario2_MH_DE extends Reusables_DE implements OR_HomePage,OR_FlightDetails {

    LinkedHashMap<String,String> testData= new LinkedHashMap<String,String>();
    @Test
    public void scenario2_MH_DE() throws Throwable {
        logger=extent.startTest("Scenario2_MH_DE");
        testData=getExcelData(System.getProperty("user.dir")+"\\TestData\\TestData.xls","TCTestData","Scenario2_MH_DE");
        alertAccept(true);
        from(testData.get("From"));
        to(testData.get("To"));
        //oneWayTrip(testData.get("Month"),testData.get("Day"));
        oneWayTrip();
        selectPassengers(testData.get("PAX"));
        clickContinue(passContBtn);
        searchFlights();
        selectOutboundClass(testData.get("OutBoundClass"));
        clickContinue(continueBtn_Gen);
        flexibleFlying();
        if(!(testData.get("Essentials").equals(""))){
            selectEssentials(testData.get("Essentials"),testData.get("SeatMapper"));
        }
        clickContinue(continueBtn_Gen);
        popUpHandler();
        if(!(testData.get("Extras").equals(""))){
            selectExtras(testData.get("Extras"));
        }
        clickContinue(continueBtn_Gen);//temp
        passDetails(testData.get("A1Gender"),testData.get("A1Salutation"),testData.get("A1Firstname"),testData.get("A1Surname"),testData.get("A1DOB"),1);
        passDetails(testData.get("A2Gender"),testData.get("A2Salutation"),testData.get("A2Firstname"),testData.get("A2Surname"),testData.get("A2DOB"),2);
        youngOrChildOrInfantDetails(testData.get("C1Gender"),testData.get("C1Firstname"),testData.get("C1Surname"),testData.get("C1DOB"),3);
        contactDetails(testData.get("Salutation"),testData.get("FirstName"),testData.get("SurName"),testData.get("AddressLine1"),testData.get("Post Code"),testData.get("City"),testData.get("Country"),testData.get("MobilePhone"),testData.get("Email"));
        clickContinue(continueBtn_Gen);
        travelInsurance();
        paymentDetails(testData.get("PaymentType"),testData.get("CardType"),testData.get("NameOnCard"),testData.get("CreditCardNum"),testData.get("ExpMonth"),testData.get("Year"),testData.get("CVV"));
        verifyBookingDetails();
    }

}
