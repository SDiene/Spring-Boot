package com.tranfertmoney.tranfertmoney.controleur;

import com.tranfertmoney.tranfertmoney.model.Role;
import com.tranfertmoney.tranfertmoney.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/role") // comme symfony Api/... on definit les routes
public class RoleControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private RoleRepository roleRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Role> list(){
        return roleRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Role add(@RequestBody(required = false) Role r){

        return  roleRepository.save(r); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
