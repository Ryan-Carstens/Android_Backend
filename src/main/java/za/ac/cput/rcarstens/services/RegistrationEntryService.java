package za.ac.cput.rcarstens.services;

import za.ac.cput.rcarstens.domain.RegistrationEntry;

import java.util.List;

/**
 * Created by sanXion on 2016/09/02.
 */
public interface RegistrationEntryService {

    List<RegistrationEntry> getRegistrationEntries();
    RegistrationEntry findBySouthAfricanIdAndPlacementChoice(String southAfricanId, String placementChoice);
    RegistrationEntry save(RegistrationEntry entity);
    RegistrationEntry update(RegistrationEntry entity);
    RegistrationEntry getRegistrationEntry(String southAfricanId);
    void delete(RegistrationEntry entity);
    boolean exists(String southAfricanId);
}
