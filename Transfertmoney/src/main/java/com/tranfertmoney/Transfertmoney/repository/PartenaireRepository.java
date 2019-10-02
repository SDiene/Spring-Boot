package com.tranfertmoney.Transfertmoney.repository;

import com.tranfertmoney.Transfertmoney.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    
}