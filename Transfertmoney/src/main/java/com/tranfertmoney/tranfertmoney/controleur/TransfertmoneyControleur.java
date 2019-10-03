package com.tranfertmoney.tranfertmoney.controleur;

import com.tranfertmoney.tranfertmoney.form.FormulairePartenaire;
import com.tranfertmoney.tranfertmoney.form.FormulaireUser;
import com.tranfertmoney.tranfertmoney.model.*;
import com.tranfertmoney.tranfertmoney.services.CompteService;
import com.tranfertmoney.tranfertmoney.services.PartenaireService;
import com.tranfertmoney.tranfertmoney.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin

public class TransfertmoneyControleur {
    @Autowired // sa permet de donner le reference de l'objet
    private UserService userService;
    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireService partenaireService;
    @Autowired // sa permet de donner le reference de l'objet
    private CompteService compteService;
    @Autowired
    PasswordEncoder encoder;
    @PostMapping (value = "partenaire/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Message addParteanire(@RequestBody FormulairePartenaire formulairePartenaire){
        Partenaire partenaire = new Partenaire(formulairePartenaire.getNomentreprise(),formulairePartenaire.getAdresse(),formulairePartenaire.getEmailpart(),formulairePartenaire.getNinea(),formulairePartenaire.getRaisonsocial(),formulairePartenaire.getTelephone());
        partenaireService.save(partenaire);
        Compte compte=new Compte();
        SimpleDateFormat formadate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formater = new SimpleDateFormat("yyMM ddhh mmss");
        Date now=new Date();
        String datecreation=formadate.format(now);
        String numerocompte=formater.format(now);
        compte.setNumerocompte(numerocompte);
        compte.setDatecreation(datecreation);
        compte.setPartenaire(partenaire);
        compte.setSolde("0");
        compteService.save(compte);
        User user=new User(formulairePartenaire.getEmail(),formulairePartenaire.getNom(),formulairePartenaire.getPassword(),formulairePartenaire.getPrenom(),formulairePartenaire.getUsername(),"Actif",formulairePartenaire.getImage());
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(4);
        roles.add(role);
        user.setRoles(roles);
        user.setPartenaire(partenaire);
        user.setCompte(compte);
        userService.save(user);
        String msg="L'entreprise "+ partenaire.getRaisonsocial()+" ainsi que son admin principal ont bien été ajouté !! ";
        String msgCompte="Le compte numéro "+compte.getNumerocompte()+"  lui a été assigné";
        Message lire = new Message(200,msg,msgCompte);
        return lire;
    }

    public Message addUser(@RequestBody FormulaireUser formulaireUser){
        User user= new User(formulaireUser.getEmail(),formulaireUser.getNom(),formulaireUser.getPassword(),formulaireUser.getPrenom(),formulaireUser.getUsername(),"Actif",formulaireUser.getImage());
        user.setPassword(encoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(3);
        roles.add(role);
        user.setRoles(roles);
        userService.save(user);
        String msg="L'entreprise ainsi que son admin principal ont bien été ajouté !! ";
        Message lire = new Message(200,msg);
        return lire;
    }

}