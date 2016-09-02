package za.ac.cput.rcarstens.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sanXion on 2016/04/03.
 */
@Entity
public class DetailsCheck implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String response;

    public Long getId() {
        return id;
    }

    public String getResponse() {
        return response;
    }

    private DetailsCheck()
    {

    }

    private DetailsCheck(Builder builder) {
        this.id = builder.id;
        this.response = builder.response;
    }

    public static class Builder{
        private Long id;
        private String response;

        public Builder id(Long value){
            this.id = value;
            return this;
        }

        public Builder response(String value){
            this.response = value;
            return this;
        }

        public Builder copy(DetailsCheck value) {
            this.response = value.response;
            return this;
        }

        public DetailsCheck build() {
            return new DetailsCheck(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsCheck detailsCheck = (DetailsCheck) o;

        return id != null ? id.equals(detailsCheck.id) : detailsCheck.id == null;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
