package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class RegistrationEntryResource extends ResourceSupport {

    private Long resId;
    private String southAfricanID;
    private String gender;
    private String placementChoice;


    public Long getResId() {
        return resId;
    }

    public String getSouthAfricanID() {
        return southAfricanID;
    }

    public String getGender() {
        return gender;
    }

    public String getPlacementChoice() {
        return placementChoice;
    }

    private RegistrationEntryResource()
    {

    }

    private RegistrationEntryResource(Builder builder) {
        this.resId = builder.resId;
        this.southAfricanID = builder.southAfricanID;
        this.gender = builder.gender;
        this.placementChoice = builder.placementChoice;
    }

    public static class Builder{
        private Long resId;
        private String southAfricanID;
        private String gender;
        private String placementChoice;

        public Builder resId(Long value){
            this.resId = value;
            return this;
        }

        public Builder southAfricanID(String value){
            this.southAfricanID = value;
            return this;
        }

        public Builder gender(String value){
            this.gender = value;
            return this;
        }

        public Builder placementChoice(String value){
            this.placementChoice = value;
            return this;
        }

        public Builder copy(RegistrationEntryResource value) {
            this.resId = value.resId;
            this.southAfricanID = value.southAfricanID;
            this.gender = value.gender;
            this.placementChoice = value.placementChoice;
            return this;
        }

        public RegistrationEntryResource build() {
            return new RegistrationEntryResource(this);
        }
    }
}
