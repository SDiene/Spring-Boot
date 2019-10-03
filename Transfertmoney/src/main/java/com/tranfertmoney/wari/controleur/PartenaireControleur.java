package com.tranfertmoney.wari.controleur;

import com.tranfertmoney.wari.model.Partenaire;
import com.tranfertmoney.wari.repository.PartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/partenaire") // comme symfony Api/... on definit les routes
public class PartenaireControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireRepository partenaireRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<Partenaire> list(){
        return partenaireRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Partenaire add(@RequestBody(required = false) Partenaire p){
        return  partenaireRepository.save(p); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
