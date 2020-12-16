package com.aleks.administrator.workers.services;

import com.aleks.administrator.workers.models.Worker;
import com.aleks.administrator.workers.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    @Autowired
    public WorkerRepository workerRepository;

    public List<Worker> getWorkers() {
        return (List<Worker>) workerRepository.findAll();
    }

    public Optional<Worker> getWorkerById(Long Id) {
        return workerRepository.findById(Id);
    }


    public void addWorker(Worker worker) {
        workerRepository.save(worker);
    }

    public void updateWorker(Worker worker) {
        workerRepository.save(worker);
    }

    public void deleteWorker(Long Id) {
        workerRepository.deleteById(Id);
    }
}
