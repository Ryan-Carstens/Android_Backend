package za.ac.cput.rcarstens.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.rcarstens.App;
import za.ac.cput.rcarstens.conf.factory.RegistryManagerFactory;
import za.ac.cput.rcarstens.domain.FullNameDetails;
import za.ac.cput.rcarstens.domain.LoginDetails;
import za.ac.cput.rcarstens.domain.RegistrationEntry;
import za.ac.cput.rcarstens.domain.RegistryManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rcarstens on 2016/08/12.
 */

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class RegistryManagerCrudTest extends AbstractTestNGSpringContextTests {
    private Long id;
    private RegistryManagerFactory registryManagerFactory;
    private List<RegistrationEntry> registrationEntryList;

    @Autowired
    private RegistryManagerRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        registrationEntryList = new ArrayList<RegistrationEntry>();
    }

    @Test
    public void create() throws Exception{
        FullNameDetails fullNameDetails = new FullNameDetails.Builder().firstname("Chris").lastname("Henrico").build();
        LoginDetails loginDetails = new LoginDetails.Builder().email("chenrico@gmail.com").password("chen783").build();
        RegistrationEntry registrationEntry = new RegistrationEntry.Builder().southAfricanID("9104234567088").gender("male").placementChoice("army").build();
        registrationEntryList.add(registrationEntry);
        RegistryManager registryManager = new RegistryManager.Builder().fullNameDetails(fullNameDetails).loginDetails(loginDetails).registrationEntries(registrationEntryList).build();
        repository.save(registryManager);
        id = registryManager.getId();

        System.out.println("id: "+registryManager.getId());
        Assert.assertNotNull(registryManager.getId());
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
        RegistryManager registryManager2 = repository.findOne(id);
        String check = registryManager2.getSouthAfricanID();
        Assert.assertEquals("9104234567088", "" + check);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
        RegistryManager registryManagerInit = repository.findOne(id);

        RegistryManager registryManagerUpdate = new RegistryManager.Builder().copy(registryManagerInit).southAfricanID("9204234567088").build();
        repository.save(registryManagerUpdate);
        id = registryManagerUpdate.getId();

        RegistryManager registryManagerUpdated = repository.findOne(id);
        Assert.assertEquals(registryManagerUpdated.getSouthAfricanID(), "9204234567088");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        RegistryManager registryManager3 = repository.findOne(id);
        repository.delete(registryManager3);
        RegistryManager deletedRegistryManager = repository.findOne(id);
        Assert.assertNull(deletedRegistryManager);
    }
}
