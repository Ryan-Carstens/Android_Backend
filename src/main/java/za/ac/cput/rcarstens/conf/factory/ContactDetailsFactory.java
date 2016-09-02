package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.ContactDetails;

/**
 * Created by sanXion on 2016/04/03.
 */
public class ContactDetailsFactory {
    private static ContactDetailsFactory factory = null;

    private ContactDetailsFactory() {
    }

    public static ContactDetailsFactory getInstance(){
        if(factory ==null)
            factory = new ContactDetailsFactory();
        return factory;
    }

    public  ContactDetails createContactDetails(String homeNumber, String emailAddress) {
        return new ContactDetails.Builder()
                .homeNumber(homeNumber)
                .emailAddress(emailAddress)
                .build();
    }
}
