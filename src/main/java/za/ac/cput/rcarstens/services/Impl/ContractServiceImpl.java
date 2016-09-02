package za.ac.cput.rcarstens.services.Impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rcarstens.domain.Contract;
import za.ac.cput.rcarstens.repository.ContractRepository;
import za.ac.cput.rcarstens.services.ContractService;


/**
 * Created by sanXion on 2016/05/29.
 */
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository recruitRepository;

    @Override
    public Contract findById(Long Id) {
        return recruitRepository.findOne(Id);
    }

    @Override
    public Contract save(Contract contract) {
        return recruitRepository.save(contract);
    }

    @Override
    public Contract update(Contract contract) {
        return recruitRepository.save(contract);
    }

    @Override
    public void delete(Contract contract) {
        recruitRepository.delete(contract);
    }

    @Override
    public List<Contract> findAll() {
        List<Contract> allContracts = new ArrayList<>();
        Iterable<Contract> contracts = recruitRepository.findAll();
        for (Contract contract : contracts) {
            allContracts.add(contract);
        }
        return allContracts;
    }
}
