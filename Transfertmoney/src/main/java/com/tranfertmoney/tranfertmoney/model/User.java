package com.tranfertmoney.tranfertmoney.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        }),
        @UniqueConstraint(columnNames = {
                "email"
        })
})
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String nom;

    @NotBlank
    @Size(min=3, max = 50)
    private String prenom;

    @NotBlank
    @Size(min=3, max = 50)
    private String status;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;

    @Size(min=2, max = 100)
    private String image;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Partenaire partenaire;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Compte compte;

    public User() {}

    public User(String email, String nom, String password, String prenom, String username, String status, String image) {
        this.email = email;
        this.nom = nom;
        this.password = password;
        this.prenom = prenom;
        this.username = username;
        this.status = status;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) { this.image = image; }

    public String getImage() { return image; }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}