package com.tranfertmoney.wari.repository;

import com.tranfertmoney.wari.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    
}