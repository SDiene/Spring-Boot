package com.tranfertmoney.wari.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(length = 30)
    private String nomE;
    @NotBlank
    @Column(length = 50)
    private String prenomE;
    @NotBlank
    @Column(length = 50)
    private String telE;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateEnvoie;
    @NotBlank
    @Column(length = 50)
    private String nomEx;
    @NotBlank
    @Column(length = 50)
    private String prenomEx;
    @NotBlank
    @Column(length = 50)
    private String adresseEx;
    @NotBlank
    @Column(length = 15)
    private String telephoneEx;
    @NotBlank
    @Column(length = 100)
    private String montant;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date dateRetrait;
    @NotBlank
    @Column(length = 50)
    private String code;
    @NotBlank
    @Column(length = 50)
    private String cniEx;
    @NotBlank
    @Column(length = 50)
    private String nature;
    @NotBlank
    @Column(length = 50)
    private String frais;
    @NotBlank
    @Column(length = 50)
    private String commissionEtat;
    @NotBlank
    @Column(length = 50)
    private String commissionSysteme;
    @NotBlank
    @Column(length = 50)
    private String commissionEnvoie;
    @NotBlank
    @Column(length = 50)
    private String commissionRetrait;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Compte compte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
    }

    public String getTelE() {
        return telE;
    }

    public void setTelE(String telE) {
        this.telE = telE;
    }

    public Date getDateEnvoie() {
        return dateEnvoie;
    }

    public void setDateEnvoie(Date dateEnvoie) {
        this.dateEnvoie = dateEnvoie;
    }

    public String getNomEx() {
        return nomEx;
    }

    public void setNomEx(String nomEx) {
        this.nomEx = nomEx;
    }

    public String getPrenomEx() {
        return prenomEx;
    }

    public void setPrenomEx(String prenomEx) {
        this.prenomEx = prenomEx;
    }

    public String getAdresseEx() {
        return adresseEx;
    }

    public void setAdresseEx(String adresseEx) {
        this.adresseEx = adresseEx;
    }

    public String getTelephoneEx() {
        return telephoneEx;
    }

    public void setTelephoneEx(String telephoneEx) {
        this.telephoneEx = telephoneEx;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCniEx() {
        return cniEx;
    }

    public void setCniEx(String cniEx) {
        this.cniEx = cniEx;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getFrais() {
        return frais;
    }

    public void setFrais(String frais) {
        this.frais = frais;
    }

    public String getCommissionEtat() {
        return commissionEtat;
    }

    public void setCommissionEtat(String commissionEtat) {
        this.commissionEtat = commissionEtat;
    }

    public String getCommissionSysteme() {
        return commissionSysteme;
    }

    public void setCommissionSysteme(String commissionSysteme) {
        this.commissionSysteme = commissionSysteme;
    }

    public String getCommissionEnvoie() {
        return commissionEnvoie;
    }

    public void setCommissionEnvoie(String commissionEnvoie) {
        this.commissionEnvoie = commissionEnvoie;
    }

    public String getCommissionRetrait() {
        return commissionRetrait;
    }

    public void setCommissionRetrait(String commissionRetrait) {
        this.commissionRetrait = commissionRetrait;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Compte getCompte() { return compte; }

    public void setCompte(Compte compte) { this.compte = compte; }
}