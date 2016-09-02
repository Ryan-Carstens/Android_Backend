package za.ac.cput.rcarstens.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rcarstens.domain.RegistrationEntry;
import za.ac.cput.rcarstens.repository.RegistrationEntryRepository;
import za.ac.cput.rcarstens.services.RegistrationEntryService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
public class RegistrationEntryServiceImpl implements RegistrationEntryService{

    @Autowired
    RegistrationEntryRepository repository;

    public List<RegistrationEntry> getRegistrationEntries() {
        List<RegistrationEntry> allEntries= new ArrayList<RegistrationEntry>();

        Iterable<RegistrationEntry> registrationEntries = repository.findAll();
        for (RegistrationEntry registrationEntry : registrationEntries) {
            allEntries.add(registrationEntry);
        }
        return allEntries;
    }

    public RegistrationEntry findBySouthAfricanIdAndPlacementChoice(String southAfricanId, String placementChoice)
    {
        RegistrationEntry registrationEntry = repository.findOne(southAfricanId);
        if(registrationEntry != null)
        {
            if(registrationEntry.getPlacementChoice().equals(placementChoice))
                return registrationEntry;
        }

        return null;
    }

    public RegistrationEntry save(RegistrationEntry entity) {
        return repository.save(entity);
    }

    public RegistrationEntry update(RegistrationEntry entity) {
        return repository.save(entity);
    }

    public void delete(RegistrationEntry entity) {
        repository.delete(entity);

    }

    public boolean exists(String southAfricanId)
    {
        RegistrationEntry registrationEntry = repository.findOne(southAfricanId);
        if(registrationEntry==null)
            return false;

        return true;
    }

    public RegistrationEntry getRegistrationEntry(String southAfricanId)
    {
        RegistrationEntry registrationEntry =  repository.findOne(southAfricanId);

        if(registrationEntry != null)
        {
            return registrationEntry;
        }

        return null;
    }
    
}
