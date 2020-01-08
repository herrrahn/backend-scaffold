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
        return this.personnelRepository.addPersonnel(p);
    }

    public boolean removePersonnel(int id) {
        return this.personnelRepository.removePersonnel(id);
    }

    public List<Personnel> findAll() {
        return this.personnelRepository.findAll();
    }
}
