package com.tranfertmoney.wari.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "compte")
@Table(name = "compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(length = 30)
    private String numerocompte;
    @NotBlank
    @Column(length = 50)
    private String solde;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datecreation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Partenaire partenaire;

    @OneToMany(mappedBy ="compte")

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNumerocompte() { return numerocompte; }

    public void setNumerocompte(String numerocompte) { this.numerocompte = numerocompte; }

    public String getSolde() { return solde; }

    public void setSolde(String solde) { this.solde = solde; }

    public Date getDatecreation() { return datecreation; }

    public void setDatecreation(Date datecreation) { this.datecreation = datecreation; }

    public Partenaire getPartenaire() { return partenaire; }

    public void setPartenaire(Partenaire partenaire) { this.partenaire = partenaire; }
}