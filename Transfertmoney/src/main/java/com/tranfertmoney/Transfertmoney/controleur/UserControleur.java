package com.tranfertmoney.Transfertmoney.controleur;

import com.tranfertmoney.Transfertmoney.model.Partenaire;
import com.tranfertmoney.Transfertmoney.model.User;
import com.tranfertmoney.Transfertmoney.repository.PartenaireRepository;
import com.tranfertmoney.Transfertmoney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/user") // comme symfony Api/... on definit les routes
public class UserControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private UserRepository userRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")  // @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<User> list(){
        return userRepository.findAll();
    }
    @Autowired
    PasswordEncoder encoder;
    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) User u){
        u.setPassword(encoder.encode(u.getPassword()));
        return  userRepository.save(u); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
