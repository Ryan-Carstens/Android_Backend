package za.ac.cput.rcarstens.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by sanXion on 2016/04/03.
 */
@Embeddable
public class FullNameDetails implements Serializable {
    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    private FullNameDetails()
    {

    }

    private FullNameDetails(Builder builder) {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
    }

    public static class Builder{
        private String firstname;
        private String lastname;

        public Builder firstname(String value){
            this.firstname = value;
            return this;
        }

        public Builder lastname(String value){
            this.lastname = value;
            return this;
        }

        public Builder copy(FullNameDetails value) {
            this.firstname = value.firstname;
            this.lastname = value.lastname;
            return this;
        }

        public FullNameDetails build() {
            return new FullNameDetails(this);
        }
    }
}
