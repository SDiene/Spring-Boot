package com.tranfertmoney.wari.controleur;

import com.tranfertmoney.wari.form.FormulaireUser;
import com.tranfertmoney.wari.model.User;
import com.tranfertmoney.wari.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin

public class TransfertmoneyControleur {
    @Autowired // sa permet de donner le reference de l'objet
    private UserService userService;
    @Autowired
    PasswordEncoder encoder;
    /*@PostMapping (value = "user/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(FormulaireUser formulaireUser){
        //User user = new User(FormulaireUser.getEmail());
       //return user;
    }*/
}

