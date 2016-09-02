package za.ac.cput.rcarstens.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by sanXion on 2016/04/03.
 */
@Embeddable
public class LoginDetails implements Serializable {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    private LoginDetails()
    {

    }

    private LoginDetails(Builder builder) {
        this.email = builder.email;
        this.password = builder.password;
    }

    public static class Builder{
        private String email;
        private String password;

        public Builder email(String value){
            this.email = value;
            return this;
        }

        public Builder password(String value){
            this.password = value;
            return this;
        }

        public Builder copy(LoginDetails value) {
            this.email = value.email;
            this.password = value.password;
            return this;
        }

        public LoginDetails build() {
            return new LoginDetails(this);
        }
    }
}
