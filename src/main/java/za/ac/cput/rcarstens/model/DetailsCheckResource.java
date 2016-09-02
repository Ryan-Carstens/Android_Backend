package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class DetailsCheckResource extends ResourceSupport {
    private Long resId;
    private String response;

    public Long getResId() {
        return resId;
    }

    public String getResponse() {
        return response;
    }

    private DetailsCheckResource()
    {

    }

    private DetailsCheckResource(Builder builder) {
        this.resId = builder.resId;
        this.response = builder.response;
    }

    public static class Builder{
        private Long resId;
        private String response;

        public Builder resId(Long value){
            this.resId = value;
            return this;
        }

        public Builder response(String value){
            this.response = value;
            return this;
        }

        public Builder copy(DetailsCheckResource value) {
            this.response = value.response;
            return this;
        }

        public DetailsCheckResource build() {
            return new DetailsCheckResource(this);
        }
    }
}
