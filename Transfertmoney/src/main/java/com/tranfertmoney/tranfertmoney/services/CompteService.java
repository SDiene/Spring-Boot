package com.tranfertmoney.tranfertmoney.services;

import com.tranfertmoney.tranfertmoney.model.Compte;
import com.tranfertmoney.tranfertmoney.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompteService {
    @Autowired
    CompteRepository compteRepository;

    public Compte save(Compte compte){ return compteRepository.save(compte); }

}
