package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rcarstens.domain.RegistryManager;
import za.ac.cput.rcarstens.services.RegistryManagerService;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
@RestController
@RequestMapping(value="/registrymanager/**")
public class RegistryManagerPage {
    @Autowired
    private RegistryManagerService service;

    @RequestMapping(value = "/registryManagers/", method = RequestMethod.GET)
    public ResponseEntity<List<RegistryManager>> listAllRegistryManagers() {
        List<RegistryManager> registryManagerList = service.findAll();
        if(registryManagerList.isEmpty()){
            return new ResponseEntity<List<RegistryManager>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<RegistryManager>>(registryManagerList, HttpStatus.OK);
    }

    @RequestMapping(value = "/registryManager/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistryManager> getRegistryManager(@PathVariable("id") long id) {
        System.out.println("Fetching RegistryManager with id " + id);
        RegistryManager registryManager = service.findById(id);
        if (registryManager == null) {
            System.out.println("RegistryManager with id " + id + " not found");
            return new ResponseEntity<RegistryManager>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<RegistryManager>(registryManager, HttpStatus.OK);
    }

    @RequestMapping(value = "/registryManager/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createRegistryManager(@RequestBody RegistryManager registryManager,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating RegistryManager " + registryManager.getId());

//     YOU CAN USE THIS - TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(registryManager);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/registryManager/{id}").buildAndExpand(registryManager.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/registryManager/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RegistryManager> updateRegistryManager(@PathVariable("id") long id, @RequestBody RegistryManager registryManager) {
        System.out.println("Updating registryManager " + id);

        RegistryManager currentRegistryManager = service.findById(id);

        if (currentRegistryManager==null) {
            System.out.println("RegistryManager with id " + id + " not found");
            return new ResponseEntity<RegistryManager>(HttpStatus.NOT_FOUND);
        }

        RegistryManager updatedRegistryManager = new RegistryManager
                .Builder()
                .copy(currentRegistryManager)
                .id(registryManager.getId())
                .southAfricanID(registryManager.getSouthAfricanID())
                .fullNameDetails(registryManager.getFullNameDetails())
                .loginDetails(registryManager.getLoginDetails())
                .registrationEntries(registryManager.getRegistrationEntries())
                .build();
        service.update(updatedRegistryManager);
        return new ResponseEntity<RegistryManager>(updatedRegistryManager, HttpStatus.OK);
    }

    @RequestMapping(value = "/registryManager/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<RegistryManager> deleteRegistryManager(@PathVariable("id") long id, @RequestBody RegistryManager emp) {
        System.out.println("Fetching & Deleting RegistryManager with id " + id);

        RegistryManager registryManager1 = service.findById(id);
        if (registryManager1 == null) {
            System.out.println("Unable to delete. RegistryManager with id " + id + " not found");
            return new ResponseEntity<RegistryManager>(HttpStatus.NOT_FOUND);
        }

        service.delete(registryManager1);
        return new ResponseEntity<RegistryManager>(HttpStatus.OK);
    }
}
