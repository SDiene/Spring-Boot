package com.tranfertmoney.Transfertmoney.repository;

import com.tranfertmoney.Transfertmoney.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    
}