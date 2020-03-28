package com.rafaelrahn.demospringrrr.personnel;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Personnel {
    @Id
    private int pers_id;
    @NotNull
    @Size(min=3, max = 15)
    private String full_name;
    private String email;
    private LocalDate birthday;
    private PersonnelType pers_type;

    public Personnel() {
    }

    public Personnel(int pers_id, String full_name, String email, LocalDate birthday, PersonnelType pers_type) {
        this.pers_id = pers_id;
        this.full_name = full_name;
        this.email = email;
        this.birthday = birthday;
        this.pers_type = pers_type;
    }

    public int getPers_id() {
        return pers_id;
    }

    public void setPers_id(int pers_id) {
        this.pers_id = pers_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public PersonnelType getPers_type() {
        return pers_type;
    }

    public void setPers_type(PersonnelType pers_type) {
        this.pers_type = pers_type;
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "pers_id=" + pers_id +
                ", full_name='" + full_name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", pers_type=" + pers_type +
                '}';
    }
}
