package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.rcarstens.domain.FullNameDetails;
import za.ac.cput.rcarstens.domain.LoginDetails;
import za.ac.cput.rcarstens.domain.RegistrationEntry;
import java.util.List;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class RegistryManagerResource extends ResourceSupport {

    private Long resId;
    private String southAfricanID;
    private FullNameDetails fullNameDetails;
    private LoginDetails loginDetails;
    private List<RegistrationEntry> registrationEntries;

    private RegistryManagerResource()
    {

    }

    private RegistryManagerResource(Builder builder) {
        this.resId = builder.resId;
        this.southAfricanID = builder.southAfricanID;
        this.fullNameDetails = builder.fullNameDetails;
        this.loginDetails = builder.loginDetails;
        this.registrationEntries = builder.registrationEntries;
    }

    public Long getResId() {
        return resId;
    }

    public String getSouthAfricanID() {
        return southAfricanID;
    }

    public FullNameDetails getFullNameDetails() {
        return fullNameDetails;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public List<RegistrationEntry> getRegistrationEntries() {return registrationEntries;}



    public static class Builder{
        private Long resId;
        private String southAfricanID;
        private FullNameDetails fullNameDetails;
        private LoginDetails loginDetails;
        private List<RegistrationEntry> registrationEntries;

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

        public Builder loginDetails(LoginDetails value){
            this.loginDetails = value;
            return this;
        }

        public Builder registrationEntries(List<RegistrationEntry> value)
        {
            this.registrationEntries = value;
            return this;
        }

        public Builder copy(RegistryManagerResource value) {
            this.resId = value.resId;
            this.southAfricanID = value.southAfricanID;
            this.fullNameDetails = value.fullNameDetails;
            this.loginDetails = value.loginDetails;
            this.registrationEntries = value.registrationEntries;
            return this;
        }

        public RegistryManagerResource build() {
            return new RegistryManagerResource(this);
        }
    }
}
