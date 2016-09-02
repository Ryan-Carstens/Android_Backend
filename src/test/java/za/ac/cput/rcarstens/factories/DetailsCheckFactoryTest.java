package za.ac.cput.rcarstens.factories;

import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.rcarstens.conf.factory.DetailsCheckFactory;
import za.ac.cput.rcarstens.domain.DetailsCheck;

/**
 * Created by rcarstens on 2016/08/11.
 */
public class DetailsCheckFactoryTest {
    private DetailsCheckFactory detailsCheckFactory;

    @BeforeMethod
    public void setUp() throws Exception {
        //detailsCheckFactory = DetailsCheckFactory.getInstance();
    }

    @Test
    public void testContractCreation() throws Exception {
        DetailsCheck detailsCheck = detailsCheckFactory.createDetailsCheck("Approved");

        System.out.println("id: "+detailsCheck.getId());
        Assert.assertEquals("Approved", detailsCheck.getResponse());
    }
}
