package com.aleks.administrator.cockroachdb.services;

import com.aleks.administrator.cockroachdb.models.Cockroach;
import com.aleks.administrator.cockroachdb.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    public WorkerRepository workerRepository;

    public List<Cockroach> getWorkers() {
        return (List<Cockroach>) workerRepository.findAll();
    }

    public Optional<Cockroach> getWorkerById(Long Id) {
        return workerRepository.findById(Id);
    }


    public void addWorker(Cockroach cockroach) {
        workerRepository.save(cockroach);
    }

    public void updateWorker(Cockroach cockroach) {
        workerRepository.save(cockroach);
    }

    public void deleteWorker(Long Id) {
        workerRepository.deleteById(Id);
    }
}
