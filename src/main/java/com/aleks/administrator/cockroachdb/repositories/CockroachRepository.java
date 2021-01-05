package com.aleks.administrator.cockroachdb.repositories;

import com.aleks.administrator.cockroachdb.models.Cockroach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Cockroach, Long> {
}
