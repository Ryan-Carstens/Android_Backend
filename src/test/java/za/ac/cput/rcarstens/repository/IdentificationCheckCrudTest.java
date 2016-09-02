package za.ac.cput.rcarstens.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.rcarstens.App;
import za.ac.cput.rcarstens.conf.factory.IdentificationCheckFactory;
import za.ac.cput.rcarstens.domain.IdentificationCheck;

/**
 * Created by rcarstens on 2016/08/12.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class IdentificationCheckCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private IdentificationCheckFactory identificationCheckFactory;

    @Autowired
    IdentificationCheckRepository repository;

    @Test
    public void create() throws Exception {
        IdentificationCheck identificationCheck = new IdentificationCheck.Builder().response("Approved").build();
        repository.save(identificationCheck);
        id = identificationCheck.getId();

        System.out.println("id: " + identificationCheck.getId());
        Assert.assertNotNull(identificationCheck.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        IdentificationCheck identificationCheck2 = repository.findOne(id);
        String check = identificationCheck2.getResponse();
        Assert.assertEquals("Approved", "" + check);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        IdentificationCheck identificationCheckInit = repository.findOne(id);

        IdentificationCheck identificationCheckUpdate = new IdentificationCheck.Builder().copy(identificationCheckInit).response("Denied").build();
        repository.save(identificationCheckUpdate);
        id = identificationCheckUpdate.getId();

        IdentificationCheck identificationCheckUpdated = repository.findOne(id);
        Assert.assertEquals(identificationCheckUpdated.getResponse(), "Denied");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        IdentificationCheck identificationCheck3 = repository.findOne(id);
        repository.delete(identificationCheck3);
        IdentificationCheck deletedIdentificationCheck = repository.findOne(id);
        Assert.assertNull(deletedIdentificationCheck);
    }
}