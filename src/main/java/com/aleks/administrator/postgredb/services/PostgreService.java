package com.aleks.administrator.postgredb.services;

import com.aleks.administrator.postgredb.models.Postgre;
import com.aleks.administrator.postgredb.repositories.PostgreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostgreService {

    @Autowired
    public PostgreRepository postgreRepository;

    public List<Postgre> getPostgres() {
        return (List<Postgre>) postgreRepository.findAll();
    }

    public Optional<Postgre> getPostgreById(Long Id) {
        return postgreRepository.findById(Id);
    }


    public void addPostgre(Postgre postgre) {
        postgreRepository.save(postgre);
    }

    public void updatePostgre(Postgre postgre) {
        postgreRepository.save(postgre);
    }

    public void deletePostgre(Long Id) {
        postgreRepository.deleteById(Id);
    }

}
