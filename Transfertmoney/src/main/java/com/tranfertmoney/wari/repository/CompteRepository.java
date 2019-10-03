package com.tranfertmoney.wari.repository;

import com.tranfertmoney.wari.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    
}