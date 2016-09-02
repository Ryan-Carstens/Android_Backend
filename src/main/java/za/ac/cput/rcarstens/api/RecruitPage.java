package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.rcarstens.domain.Recruit;
import za.ac.cput.rcarstens.services.RecruitService;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
@RestController
@RequestMapping(value="/recruit/**")
public class RecruitPage {
    @Autowired
    private RecruitService service;

    @RequestMapping(value = "/recruits/", method = RequestMethod.GET)
    public ResponseEntity<List<Recruit>> listAllRecruits() {
        List<Recruit> recruitList = service.findAll();
        if(recruitList.isEmpty()){
            return new ResponseEntity<List<Recruit>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Recruit>>(recruitList, HttpStatus.OK);
    }

    @RequestMapping(value = "/recruit/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Recruit> getRecruit(@PathVariable("id") long id) {
        System.out.println("Fetching Recruit with id " + id);
        Recruit recruit = service.findById(id);
        if (recruit == null) {
            System.out.println("Recruit with id " + id + " not found");
            return new ResponseEntity<Recruit>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Recruit>(recruit, HttpStatus.OK);
    }

    @RequestMapping(value = "/recruit/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createRecruit(@RequestBody Recruit recruit,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Recruit " + recruit.getId());

//     YOU CAN USE THIS - TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(recruit);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/recruit/{id}").buildAndExpand(recruit.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/recruit/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Recruit> updateRecruit(@PathVariable("id") long id, @RequestBody Recruit recruit) {
        System.out.println("Updating recruit " + id);

        Recruit currentRecruit = service.findById(id);

        if (currentRecruit==null) {
            System.out.println("Recruit with id " + id + " not found");
            return new ResponseEntity<Recruit>(HttpStatus.NOT_FOUND);
        }

        Recruit updatedRecruit = new Recruit
                .Builder()
                .copy(currentRecruit)
                .id(recruit.getId())
                .southAfricanID(recruit.getSouthAfricanID())
                .fullNameDetails(recruit.getFullNameDetails())
                .contactDetails(recruit.getContactDetails())
                .build();
        service.update(updatedRecruit);
        return new ResponseEntity<Recruit>(updatedRecruit, HttpStatus.OK);
    }

    @RequestMapping(value = "/recruit/delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Recruit> deleteRecruit(@PathVariable("id") long id, @RequestBody Recruit emp) {
        System.out.println("Fetching & Deleting Recruit with id " + id);

        Recruit recruit1 = service.findById(id);
        if (recruit1 == null) {
            System.out.println("Unable to delete. Recruit with id " + id + " not found");
            return new ResponseEntity<Recruit>(HttpStatus.NOT_FOUND);
        }

        service.delete(recruit1);
        return new ResponseEntity<Recruit>(HttpStatus.OK);
    }
}
