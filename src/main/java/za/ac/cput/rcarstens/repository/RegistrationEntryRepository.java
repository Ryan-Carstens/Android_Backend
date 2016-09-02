package za.ac.cput.rcarstens.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rcarstens.domain.RegistrationEntry;

/**
 * Created by sanXion on 2016/04/24.
 */
public interface RegistrationEntryRepository extends CrudRepository<RegistrationEntry,String> {
}
