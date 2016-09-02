package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.RegistrationEntry;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class RegistrationEntryFactory {

    public static RegistrationEntry createRegistrationEntry(String southAfricanID, String gender, String placementChoice){
        return new RegistrationEntry.Builder()
                .southAfricanID(southAfricanID)
                .gender(gender)
                .placementChoice(placementChoice)
                .build();
    }
}