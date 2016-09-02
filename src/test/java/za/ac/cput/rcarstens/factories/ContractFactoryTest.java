package za.ac.cput.rcarstens.factories;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.rcarstens.conf.factory.ContractDetailsFactory;
import za.ac.cput.rcarstens.conf.factory.ContractFactory;
import za.ac.cput.rcarstens.domain.ContractDetails;
import za.ac.cput.rcarstens.domain.Contract;

/**
 * Created by rcarstens on 2016/08/08.
 */
public class ContractFactoryTest {

    private ContractDetailsFactory detailsFactory;
    private ContractFactory contractFactory;

    @BeforeMethod
    public void setUp() throws Exception {
        detailsFactory = ContractDetailsFactory.getInstance();
        contractFactory = ContractFactory.getInstance();
    }

    @Test
    public void testContractCreation() throws Exception {
        ContractDetails contractDetails = detailsFactory.createContractDetails("7825647", 100042);
        Contract contract = contractFactory.createContract(21304, 21304, contractDetails);

        Assert.assertEquals(21304, contract.getIdCheckNum());

    }
}
