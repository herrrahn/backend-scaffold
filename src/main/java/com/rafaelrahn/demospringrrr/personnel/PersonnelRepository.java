package com.rafaelrahn.demospringrrr.personnel;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonnelRepository {
    private List<Personnel> personnelList = new ArrayList<>();

    public Personnel addPersonnel(Personnel p) {
        this.personnelList.add(p);
        return p;
    }

    public boolean removePersonnel(int id) {
        return this.personnelList.removeIf(p -> p.getPers_id() == id);
    }

    public List<Personnel> findAll() {
        return this.personnelList;
    }
}
