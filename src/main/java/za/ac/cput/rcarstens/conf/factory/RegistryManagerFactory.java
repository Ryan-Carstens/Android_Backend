package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.FullNameDetails;
import za.ac.cput.rcarstens.domain.LoginDetails;
import za.ac.cput.rcarstens.domain.RegistrationEntry;
import za.ac.cput.rcarstens.domain.RegistryManager;

import java.util.List;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class RegistryManagerFactory {

    public static RegistryManager createRegistryManager(String southAfricanID, FullNameDetails fullNameDetails, LoginDetails loginDetails, List<RegistrationEntry> registrationEntries){
        return new RegistryManager.Builder()
                .southAfricanID(southAfricanID)
                .fullNameDetails(fullNameDetails)
                .loginDetails(loginDetails)
                .registrationEntries(registrationEntries)
                .build();
    }
}
