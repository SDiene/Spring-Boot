package com.tranfertmoney.Transfertmoney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "compte")
@Table(name = "depot")
 class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datedepot;
    @NotBlank
    @Column(length = 50)
    private String montant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Compte compte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatedepot() {
        return datedepot;
    }

    public void setDatedepot(Date datedepot) {
        this.datedepot = datedepot;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public Compte getCompte() { return compte; }

    public void setCompte(Compte compte) { this.compte = compte; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}