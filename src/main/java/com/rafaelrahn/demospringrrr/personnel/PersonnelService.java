package com.rafaelrahn.demospringrrr.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelService {

    private PersonnelRepository personnelRepository;

    @Autowired
    public PersonnelService(PersonnelRepository personnelRepository) {
        this.personnelRepository = personnelRepository;
    }

    public Personnel addPersonnel(Personnel p) {
        return this.personnelRepository.save(p);
    }

    public boolean removePersonnel(Integer id) {
        this.personnelRepository.deleteById(id);
        return true;
    }

    public List<Personnel> findAll() {
        return this.personnelRepository.findAll();
    }

    public String ping() {
        return "pong from service";
    }
}
