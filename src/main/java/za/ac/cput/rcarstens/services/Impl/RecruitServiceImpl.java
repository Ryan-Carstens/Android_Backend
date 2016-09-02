package za.ac.cput.rcarstens.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.rcarstens.domain.Recruit;
import za.ac.cput.rcarstens.repository.RecruitRepository;
import za.ac.cput.rcarstens.services.RecruitService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sanXion on 2016/06/06.
 */
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    private RecruitRepository recruitRepository;

    @Override
    public Recruit findById(Long Id) {
        return recruitRepository.findOne(Id);
    }

    @Override
    public Recruit save(Recruit recruit) {
        return recruitRepository.save(recruit);
    }

    @Override
    public Recruit update(Recruit recruit) {
        return recruitRepository.save(recruit);
    }

    @Override
    public void delete(Recruit recruit) {
        recruitRepository.delete(recruit);
    }

    @Override
    public List<Recruit> findAll() {
        List<Recruit> allRecruits = new ArrayList<>();
        Iterable<Recruit> recruits = recruitRepository.findAll();
        for (Recruit recruit : recruits) {
            allRecruits.add(recruit);
        }
        return allRecruits;
    }
}
