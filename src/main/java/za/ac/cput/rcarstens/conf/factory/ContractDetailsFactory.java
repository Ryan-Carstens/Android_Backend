package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.ContractDetails;

/**
 * Created by rcarstens on 2016/08/10.
 */
public class ContractDetailsFactory {
    private static ContractDetailsFactory factory = null;

    private ContractDetailsFactory(){

    }

    public static ContractDetailsFactory getInstance(){
        if (factory == null)
        {factory = new ContractDetailsFactory();}

        return factory;
    }

    public ContractDetails createContractDetails(String contractType, int contractNum){
        return new ContractDetails.Builder()
                .contractType(contractType)
                .contractNum(contractNum)
                .build();
    }
}
