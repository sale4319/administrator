package com.aleks.administrator.postgredb.repositories;

import com.aleks.administrator.postgredb.models.Postgre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreRepository extends JpaRepository<Postgre, Long> {
}
