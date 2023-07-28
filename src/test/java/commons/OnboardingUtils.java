package commons;

import commons.database.requests.AcsFetchNumber;
import commons.database.requests.AcsFetchOtp;

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
        String lastPhoneNumber = AcsFetchNumber.lastRegisteredPhoneNumber(phoneNumberTemplate);
        return lastPhoneNumber;
    }

    public static String getLastUniqueNumber(String projectName){
        String lastUniqueNumber = AcsFetchNumber.lastUniquePhoneNumber(projectName);
        return lastUniqueNumber;
    }
}
