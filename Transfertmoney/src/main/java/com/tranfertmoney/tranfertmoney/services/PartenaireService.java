package com.tranfertmoney.tranfertmoney.services;

import com.tranfertmoney.tranfertmoney.model.Partenaire;
import com.tranfertmoney.tranfertmoney.model.User;
import com.tranfertmoney.tranfertmoney.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartenaireService {
    @Autowired
    PartenaireRepository partenaireRepository;

    public Partenaire save(Partenaire partenaire){ return partenaireRepository.save(partenaire); }
    public List<Partenaire> findAll(){ return partenaireRepository.findAll(); }
    public Optional<Partenaire> findById(int id){return partenaireRepository.findById(id);}
}
