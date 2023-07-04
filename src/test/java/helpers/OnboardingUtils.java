package helpers;

import database.AcsDatabaseConnections;

import static org.apache.commons.lang3.StringUtils.length;

public class OnboardingUtils {
    public static String getNewPhoneNumber(String phoneNumberTemplate){
        String lastPhoneNumber = AcsDatabaseConnections.lastRegisteredPhoneNumber(phoneNumberTemplate);
        String lastPhoneNumberIndex = lastPhoneNumber.substring(5).replaceFirst("^0+(?!$)", "");
        String nextPhoneNumberIndex = String.valueOf(Integer.parseInt(lastPhoneNumberIndex)+1);
        String fullNextNumber = phoneNumberTemplate + ("000000" + nextPhoneNumberIndex).substring(nextPhoneNumberIndex.length());
        if (length(fullNextNumber) > 13) {
            System.out.println("Too many accounts registered for this phone number extension. PLEASE CHANGE THE PHONE NUMBER TEMPLATE. Current template is " + phoneNumberTemplate);
        }
        System.out.println(fullNextNumber);
        return fullNextNumber;
    }
}
