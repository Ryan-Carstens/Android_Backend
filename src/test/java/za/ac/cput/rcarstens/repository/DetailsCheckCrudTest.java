package za.ac.cput.rcarstens.repository;

import org.testng.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import za.ac.cput.rcarstens.App;
import za.ac.cput.rcarstens.conf.factory.DetailsCheckFactory;
import za.ac.cput.rcarstens.domain.DetailsCheck;

/**
 * Created by rcarstens on 2016/08/12.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class DetailsCheckCrudTest extends AbstractTestNGSpringContextTests {

    private Long id;
    private DetailsCheckFactory detailsCheckFactory;

    @Autowired
    DetailsCheckRepository repository;

    @Test
    public void create() throws Exception{
        DetailsCheck detailsCheck =  new DetailsCheck.Builder().response("Approved").build();
        repository.save(detailsCheck);
        id = detailsCheck.getId();

        System.out.println("id: "+detailsCheck.getId());
        Assert.assertNotNull(detailsCheck.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        DetailsCheck detailsCheck2 = repository.findOne(id);
        String check = detailsCheck2.getResponse();
        Assert.assertEquals("Approved", "" + check);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        DetailsCheck detailsCheckInit = repository.findOne(id);

        DetailsCheck detailsCheckUpdate = new DetailsCheck.Builder().copy(detailsCheckInit).response("Denied").build();
        repository.save(detailsCheckUpdate);
        id = detailsCheckUpdate.getId();

        DetailsCheck detailsCheckUpdated = repository.findOne(id);
        Assert.assertEquals(detailsCheckUpdated.getResponse(), "Denied");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        DetailsCheck detailsCheck3 = repository.findOne(id);
        repository.delete(detailsCheck3);
        DetailsCheck deletedDetailsCheck = repository.findOne(id);
        Assert.assertNull(deletedDetailsCheck);
    }
}
