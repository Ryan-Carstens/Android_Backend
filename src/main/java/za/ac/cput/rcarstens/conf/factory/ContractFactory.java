package za.ac.cput.rcarstens.conf.factory;

import za.ac.cput.rcarstens.domain.Contract;
import za.ac.cput.rcarstens.domain.ContractDetails;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class ContractFactory {
    private static ContractFactory factory = null;

    private ContractFactory(){

    }

    public static ContractFactory getInstance(){
        if (factory == null)
        {factory = new ContractFactory();}

        return factory;
    }

    public Contract createContract(int IdCheckNum, int DetailsCheckNum, ContractDetails contractDetails){
        return new Contract.Builder()
                .IdCheckNum(IdCheckNum)
                .DetailsCheckNum(DetailsCheckNum)
                .contractDetails(contractDetails)
                .build();

    }

}