package com.rafaelrahn.demospringrrr.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "personnel")
public class PersonnelController {

    private PersonnelService personnelService;

    @Autowired
    PersonnelController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @GetMapping
    public List<Personnel> listPersonnel() {
        return this.personnelService.findAll();
    }

    @PostMapping
    public Personnel addPersonnel(@RequestBody Personnel p) {
        return personnelService.addPersonnel(p);
    }

    @DeleteMapping(value = "/{id}")
    public boolean removePersonnel(@PathVariable(value = "id") int id) {
        return this.personnelService.removePersonnel(id);
    }

}
