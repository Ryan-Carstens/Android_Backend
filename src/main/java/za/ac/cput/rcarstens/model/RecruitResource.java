package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.rcarstens.domain.ContactDetails;
import za.ac.cput.rcarstens.domain.FullNameDetails;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class RecruitResource extends ResourceSupport {
    private Long resId;
    private String southAfricanID;
    private FullNameDetails fullNameDetails;
    private ContactDetails contactDetails;


    public Long getResId() {
        return resId;
    }

    public String getSouthAfricanID() {
        return southAfricanID;
    }

    public FullNameDetails getFullNameDetails() {
        return fullNameDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    private RecruitResource()
    {

    }

    private RecruitResource(Builder builder) {
        this.resId = builder.resId;
        this.southAfricanID = builder.southAfricanID;
        this.fullNameDetails = builder.fullNameDetails;
        this.contactDetails = builder.contactDetails;
    }

    public static class Builder{
        private Long resId;
        private String southAfricanID;
        private FullNameDetails fullNameDetails;
        private ContactDetails contactDetails;

        public Builder resId(Long value){
            this.resId = value;
            return this;
        }

        public Builder southAfricanID(String value){
            this.southAfricanID = value;
            return this;
        }

        public Builder fullNameDetails(FullNameDetails value){
            this.fullNameDetails = value;
            return this;
        }

        public Builder contactDetails(ContactDetails value){
            this.contactDetails = value;
            return this;
        }

        public Builder copy(RecruitResource value) {
            this.resId = value.resId;
            this.southAfricanID = value.southAfricanID;
            this.fullNameDetails = value.fullNameDetails;
            this.contactDetails = value.contactDetails;
            return this;
        }

        public RecruitResource build() {
            return new RecruitResource(this);
        }
    }
}
