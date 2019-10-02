package com.tranfertmoney.Transfertmoney.controleur;

import com.tranfertmoney.Transfertmoney.model.Compte;
import com.tranfertmoney.Transfertmoney.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/compte") // comme symfony Api/...
public class CompteControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;

    @GetMapping(value = "/liste") // on peut faire un getMapping et lui passer tous notre url en parametre
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> list(){
        return  compteRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add(@RequestBody(required = false) Compte c){
        return  compteRepository.save(c); // on peut utiliser aussi saveOnUpdate
    }
}

