package com.rafaelrahn.demospringrrr.personnel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
}
