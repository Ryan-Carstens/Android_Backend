package za.ac.cput.rcarstens.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by sanXion on 2016/04/03.
 */
@Embeddable
public class ContactDetails implements Serializable {
    private String homeNumber;
    private String emailAddress;

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    private ContactDetails()
    {

    }

    private ContactDetails(Builder builder) {
        this.homeNumber = builder.homeNumber;
        this.emailAddress = builder.emailAddress;
    }

    public static class Builder{
        private String homeNumber;
        private String emailAddress;

        public Builder homeNumber(String value){
            this.homeNumber = value;
            return this;
        }

        public Builder emailAddress(String value){
            this.emailAddress = value;
            return this;
        }

        public Builder copy(ContactDetails value) {
            this.homeNumber = value.homeNumber;
            this.emailAddress = value.emailAddress;
            return this;
        }

        public ContactDetails build() {
            return new ContactDetails(this);
        }
    }
}
