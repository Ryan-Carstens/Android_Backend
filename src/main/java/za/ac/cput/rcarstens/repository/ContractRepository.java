package za.ac.cput.rcarstens.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.rcarstens.domain.Contract;

/**
 * Created by sanXion on 2016/05/15.
 */
public interface ContractRepository extends CrudRepository<Contract,Long> {
}
