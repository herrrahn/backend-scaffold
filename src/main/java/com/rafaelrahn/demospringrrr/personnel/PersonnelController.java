package com.rafaelrahn.demospringrrr.personnel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Personnel addPersonnel(@RequestBody @Valid Personnel p,
                                  Errors errors) {
        if (errors.hasErrors()) {
            throw new RuntimeException("Personnel is invalid.");
        }
        return personnelService.addPersonnel(p);
    }

    @DeleteMapping(value = "/{id}")
    public boolean removePersonnel(@PathVariable(value = "id") int id) {
        return this.personnelService.removePersonnel(id);
    }
    @GetMapping("ping")
    public @ResponseBody String greeting() {
        return this.personnelService.ping();// "Hello, World";
    }

}
