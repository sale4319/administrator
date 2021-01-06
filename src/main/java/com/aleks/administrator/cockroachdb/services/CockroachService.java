package com.aleks.administrator.cockroachdb.services;

import com.aleks.administrator.cockroachdb.models.Cockroach;
import com.aleks.administrator.cockroachdb.repositories.CockroachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CockroachService {

    @Autowired
    public CockroachRepository cockroachRepository;

    public List<Cockroach> getCockroaches() {
        return (List<Cockroach>) cockroachRepository.findAll();
    }

    public Optional<Cockroach> getCockroachById(Long Id) {
        return cockroachRepository.findById(Id);
    }


    public void addCockroach(Cockroach cockroach) {
        cockroachRepository.save(cockroach);
    }

    public void updateCockroach(Cockroach cockroach) {
        cockroachRepository.save(cockroach);
    }

    public void deleteCockroach(Long Id) {
        cockroachRepository.deleteById(Id);
    }
}
