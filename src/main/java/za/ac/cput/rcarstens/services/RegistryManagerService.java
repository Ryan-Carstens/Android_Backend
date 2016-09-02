package za.ac.cput.rcarstens.services;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.rcarstens.domain.RegistryManager;

/**
 * Created by sanXion on 2016/05/31.
 */
public interface RegistryManagerService extends Services<RegistryManager,Long>{
    boolean exists(Long southAfricanId);
    List<RegistryManager> findByEmailAndPassword(String email, String password);
}
