package za.ac.cput.rcarstens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.rcarstens.domain.RegistrationEntry;
import za.ac.cput.rcarstens.model.RegistrationEntryResource;
import za.ac.cput.rcarstens.services.RegistrationEntryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
@RestController
@RequestMapping(value="/registrationentry/**")
public class RegistrationEntryPage {
    @Autowired
    private RegistrationEntryService service;

    @RequestMapping(value = "/all_registrationentries", method = RequestMethod.GET)
    public List<RegistrationEntryResource> getRegistrationEntrys() {
        List<RegistrationEntryResource> hateos = new ArrayList<RegistrationEntryResource>();
        List<RegistrationEntry> registrationEntries = service.getRegistrationEntries();

        for (RegistrationEntry registrationEntry : registrationEntries) {
            RegistrationEntryResource res = new RegistrationEntryResource
                    .Builder()
                    .southAfricanID(registrationEntry.getSouthAfricanID())
                    .gender(registrationEntry.getGender())
                    .placementChoice(registrationEntry.getPlacementChoice())
                    .build();
            hateos.add(res);
        }
        return hateos;
    }


    @RequestMapping(value="/registrationEntry/{registrationEntry}", method= RequestMethod.GET)
    public RegistrationEntryResource getRegistrationEntry(@PathVariable("registrationEntry") String entry) {
        RegistrationEntry registrationEntry = service.getRegistrationEntry(entry);

        RegistrationEntryResource res = new RegistrationEntryResource
                .Builder()
                .southAfricanID(registrationEntry.getSouthAfricanID())
                .gender(registrationEntry.getGender())
                .placementChoice(registrationEntry.getPlacementChoice())
                .build();
        System.out.println(res.toString());
        return res;
    }
}
