package com.tranfertmoney.wari.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@EqualsAndHashCode(exclude = "partenaires")
@Table(name = "partenaire")
public class Partenaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    @Column(length = 30)
    private String nomentreprise;
    @NotBlank
    @Column(length = 50)
    private String ninea;
    @NotBlank
    @Column(length = 50)
    private String adresse;
    @NotBlank
    @Column(length = 50)
    private String emailpart;
    @NotBlank
    @Column(length = 50)
    private String telephone;
    @NotBlank
    @Column(length = 50)
    private String raisonsocial;
    @OneToMany(mappedBy ="partenaire")


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNomentreprise() { return nomentreprise; }

    public void setNomentreprise(String nomentreprise) { this.nomentreprise = nomentreprise; }

    public String getNinea() { return ninea; }

    public void setNinea(String ninea) { this.ninea = ninea; }

    public String getAdresse() { return adresse; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getEmailpart() { return emailpart; }

    public void setEmailpart(String emailpart) { this.emailpart = emailpart; }

    public String getTelephone() { return telephone; }

    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getRaisonsocial() { return raisonsocial; }

    public void setRaisonsocial(String raisonsocial) { this.raisonsocial = raisonsocial; }
}