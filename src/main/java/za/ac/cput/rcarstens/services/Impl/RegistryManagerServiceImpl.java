package za.ac.cput.rcarstens.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rcarstens.domain.RegistryManager;
import za.ac.cput.rcarstens.repository.RegistryManagerRepository;
import za.ac.cput.rcarstens.services.RegistryManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sanXion on 2016/05/31.
 */
public class RegistryManagerServiceImpl implements RegistryManagerService {
    @Autowired
    private RegistryManagerRepository registryManagerRepository;

    @Override
    public RegistryManager findById(Long Id) {
        return registryManagerRepository.findOne(Id);
    }

    @Override
    public RegistryManager save(RegistryManager registryManager) {
        return registryManagerRepository.save(registryManager);
    }

    @Override
    public RegistryManager update(RegistryManager registryManager) {
        return registryManagerRepository.save(registryManager);
    }

    @Override
    public void delete(RegistryManager registryManager) {
        registryManagerRepository.delete(registryManager);
    }

    @Override
    public List<RegistryManager> findAll() {
        List<RegistryManager> allRegistryManagers = new ArrayList<>();
        Iterable<RegistryManager> registryManagers = registryManagerRepository.findAll();
        for (RegistryManager registryManager : registryManagers) {
            allRegistryManagers.add(registryManager);
        }
        return allRegistryManagers;
    }

    public boolean exists(Long id)
    {
        RegistryManager registryManager = registryManagerRepository.findOne(id);
        if(registryManager==null)
            return false;

        return true;
    }

    public List<RegistryManager> findByEmailAndPassword(String email, String password)
    {

        try{
            List<RegistryManager> registryManagers = new ArrayList<>();
            List<RegistryManager> result = new ArrayList<>();
            Iterable<RegistryManager> myList = registryManagerRepository.findAll();
            for (RegistryManager registryManager : myList) {
                if(!registryManagers.add(registryManager))
                {
                    return null;
                }
            }

            for(int i=0; i<registryManagers.size(); i++)
                if((registryManagers.get(i).getLoginDetails().getEmail().equalsIgnoreCase(email)) && (registryManagers.get(i).getLoginDetails().getPassword().equalsIgnoreCase(password)))
                    result.add(registryManagers.get(i));

            if(result.size() > 1)
                return result;
            else
                return new ArrayList<RegistryManager>();

        }
        catch(Exception x)
        {
            x.printStackTrace();
        }

        return null;
    }

}
