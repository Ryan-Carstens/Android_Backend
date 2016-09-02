package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class IdentificationCheckResource extends ResourceSupport {
    private Long resId;
    private String response;

    public Long getResId() {
        return resId;
    }

    public String getResponse() {
        return response;
    }

    private IdentificationCheckResource()
    {

    }

    private IdentificationCheckResource(Builder builder) {
        this.resId = builder.resId;
        this.response = builder.response;
    }

    public static class Builder{
        private Long resId;
        private String response;

        public Builder id(Long value){
            this.resId = value;
            return this;
        }

        public Builder response(String value){
            this.response = value;
            return this;
        }

        public Builder copy(IdentificationCheckResource value) {
            this.resId = value.resId;
            this.response = value.response;
            return this;
        }

        public IdentificationCheckResource build() {
            return new IdentificationCheckResource(this);
        }
    }
}
