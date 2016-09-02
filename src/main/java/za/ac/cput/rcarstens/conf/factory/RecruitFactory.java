package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.ContactDetails;
import za.ac.cput.rcarstens.domain.FullNameDetails;
import za.ac.cput.rcarstens.domain.Recruit;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class RecruitFactory {
    private static RecruitFactory factory = null;

    private RecruitFactory(){

    }

    public static RecruitFactory getInstance(){
        if (factory == null)
        {factory = new RecruitFactory();}

        return factory;
    }

    public Recruit createRecruit(String southAfricanID, FullNameDetails fullNameDetails, ContactDetails contactDetails){
        return new Recruit.Builder()
                .southAfricanID(southAfricanID)
                .fullNameDetails(fullNameDetails)
                .contactDetails(contactDetails)
                .build();
    }
}
