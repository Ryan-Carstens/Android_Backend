package za.ac.cput.rcarstens.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.rcarstens.domain.ContractDetails;

/**
 * Created by rcarstens on 2016/08/30.
 */
public class ContractResource extends ResourceSupport {
    private Long resId;
    private int IdCheckNum;
    private int DetailsCheckNum;
    private ContractDetails contractDetails;

    public Long getResId() {
        return resId;
    }

    public int getDetailsCheckNum() {
        return DetailsCheckNum;
    }

    public int getIdCheckNum() {
        return IdCheckNum;
    }

    public ContractDetails getContractDetails() {
        return contractDetails;
    }

    public ContractResource()
    {

    }

    private ContractResource(Builder builder) {
        this.resId = builder.resId;
        this.IdCheckNum = builder.IdCheckNum;
        this.DetailsCheckNum = builder.DetailsCheckNum;
        this.contractDetails = builder.contractDetails;
    }

    public static class Builder{
        private Long resId;
        private int IdCheckNum;
        private int DetailsCheckNum;
        private ContractDetails contractDetails;

        public Builder resId(Long value){
            this.resId = value;
            return this;
        }

        public Builder IdCheckNum(int value){
            this.IdCheckNum = value;
            return this;
        }

        public Builder DetailsCheckNum(int value){
            this.DetailsCheckNum = value;
            return this;
        }

        public Builder contractDetails(ContractDetails value){
            this.contractDetails = value;
            return this;
        }

        public Builder copy(ContractResource value) {
            this.resId = value.resId;
            this.IdCheckNum = value.IdCheckNum;
            this.DetailsCheckNum = value.DetailsCheckNum;
            this.contractDetails = value.contractDetails;
            return this;
        }

        public ContractResource build() {
            return new ContractResource(this);
        }
    }
}