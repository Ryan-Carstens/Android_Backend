package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rcarstens.domain.RegistryManager;
import za.ac.cput.rcarstens.model.RegistryManagerResource;
import za.ac.cput.rcarstens.services.RegistryManagerService;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */

@RestController
@RequestMapping(value="/login/**")
public class LoginPage {

    @Autowired
    private RegistryManagerService registryManagerService;

    @RequestMapping(value="/registryManager/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistryManagerResource> loginRegistryManager(@PathVariable("username") String email, @PathVariable("password") String password)
    {
        List<RegistryManager> registryManager = registryManagerService.findByEmailAndPassword(email, password);

        if(registryManager == null)
        {
            return new ResponseEntity<RegistryManagerResource>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<RegistryManagerResource>(HttpStatus.OK);
    }

    @RequestMapping(value="/user_test/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public RegistryManager userTest(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        List<RegistryManager> registryManager = registryManagerService.findByEmailAndPassword(username, password);
        RegistryManager registryManager1 = registryManager.get(0);

        if(registryManager == null)
        {
            return registryManager1;
        }

        return registryManager1;
    }
}
