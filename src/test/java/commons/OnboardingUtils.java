package commons;

import commons.database.requests.AcsFetchNumber;
import commons.database.requests.CashCheckNumber;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.length;

public class OnboardingUtils {
    public static String getNewPhoneNumber(String phoneNumberTemplate){
        String lastPhoneNumber = AcsFetchNumber.lastRegisteredPhoneNumber(phoneNumberTemplate);
        System.out.println(lastPhoneNumber);
        String lastPhoneNumberIndex = lastPhoneNumber.substring(5).replaceFirst("^0+(?!$)", "");
        String nextPhoneNumberIndex = String.valueOf(Integer.parseInt(lastPhoneNumberIndex)+1);
        String fullNextNumber = phoneNumberTemplate + ("000000" + nextPhoneNumberIndex).substring(nextPhoneNumberIndex.length());
        if (length(fullNextNumber) > 13) {
            System.out.println("Too many accounts registered for this phone number extension. PLEASE CHANGE THE PHONE NUMBER TEMPLATE. Current template is " + phoneNumberTemplate);
        }
        System.out.println(fullNextNumber);
        return fullNextNumber;
    }

    public static String getNumberForLogin(String phoneNumberTemplate){
        return AcsFetchNumber.lastRegisteredPhoneNumber(phoneNumberTemplate);
    }

    public static String getLastUniqueNumber(String projectName){
        return AcsFetchNumber.lastUniquePhoneNumber(projectName);
    }

    public static String getTabysNumber(){
        return AcsFetchNumber.lastTabysApprovedPhoneNumber();
    }

    public static String getCsdNumberWithoutOrders(String projectName) {
        List<String> numbersWithCsdOrders = CashCheckNumber.allNumbersWithCsdOrders();
        String csdNumberWithoutOrders = AcsFetchNumber.lastCsdPhoneNumberWithoutOrders(numbersWithCsdOrders, projectName);
        return csdNumberWithoutOrders;
    }

    public static String getIpoNumberWithoutOrders(String projectName) {
        // First, we make a list of all the numbers that are without any orders (orders for IPO or cash withdrawal), because in these conditions a user can't update their data.
        List<String> numbersWithCsdOrders = CashCheckNumber.allNumbersWithCsdOrders();
        System.out.println(numbersWithCsdOrders);
        List<String> numbersWithActiveCnpCard = AcsFetchNumber.allNumbersWithCnpCard();
        // This method will keep searching for ACS autoapproved IPO numbers with active cards until they find one that is not in the list.
        String ipoNumberWithoutOrders = AcsFetchNumber.lastIpoPhoneNumberWithoutOrders(numbersWithCsdOrders, numbersWithActiveCnpCard, projectName);
        return ipoNumberWithoutOrders;
    }
}
