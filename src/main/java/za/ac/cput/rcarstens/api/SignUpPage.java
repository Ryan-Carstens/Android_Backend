package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rcarstens.domain.RegistryManager;
import za.ac.cput.rcarstens.services.RegistryManagerService;

/**
 * Created by sanXion on 2016/09/02.
 */
@RestController
@RequestMapping(value="/signup/**")
public class SignUpPage {

    @Autowired
    private RegistryManagerService registryManagerService;

    @RequestMapping(value = "/registrymanager", method = RequestMethod.POST)
    public ResponseEntity<Void> subscribeRegistryManager(@RequestBody RegistryManager registryManager, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating registryManager " + registryManager.getId());

        if (registryManagerService.exists(registryManager.getId())) {
            System.out.println("A RegistryManager with Id: " + registryManager.getId() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        registryManagerService.save(registryManager);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/registrymanager/{id}").buildAndExpand(registryManager.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
}
