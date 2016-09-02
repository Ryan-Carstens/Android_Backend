package za.ac.cput.rcarstens.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sanXion on 2016/04/03.
 */
@Entity
public class RegistryManager implements Serializable, UserInterface {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String southAfricanID;
    private FullNameDetails fullNameDetails;
    private LoginDetails loginDetails;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "registryManager_id")
    private List<RegistrationEntry> registrationEntries;

    public Long getId() {
        return id;
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


    private RegistryManager()
    {

    }

    private RegistryManager(Builder builder) {
        this.id = builder.id;
        this.southAfricanID = builder.southAfricanID;
        this.fullNameDetails = builder.fullNameDetails;
        this.loginDetails = builder.loginDetails;
        this.registrationEntries = builder.registrationEntries;
    }

    public static class Builder{
        private Long id;
        private String southAfricanID;
        private FullNameDetails fullNameDetails;
        private LoginDetails loginDetails;
        private List<RegistrationEntry> registrationEntries;

        public Builder id(Long value){
            this.id = value;
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

        public Builder copy(RegistryManager value) {
            this.id = value.id;
            this.southAfricanID = value.southAfricanID;
            this.fullNameDetails = value.fullNameDetails;
            this.loginDetails = value.loginDetails;
            this.registrationEntries = value.registrationEntries;
            return this;
        }

        public RegistryManager build() {
            return new RegistryManager(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistryManager registryManager = (RegistryManager) o;

        return id != null ? id.equals(registryManager.id) : registryManager.id == null;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}