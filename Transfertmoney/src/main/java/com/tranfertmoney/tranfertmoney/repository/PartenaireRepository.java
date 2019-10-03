package com.tranfertmoney.tranfertmoney.repository;

import com.tranfertmoney.tranfertmoney.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartenaireRepository extends JpaRepository<Partenaire, Integer> {
    
}