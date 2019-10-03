package com.tranfertmoney.tranfertmoney.model;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleNom nom;

    public Role() {}

    public Role(RoleNom nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public RoleNom getNom() {
        return nom;
    }

    public void setNom(RoleNom nom) {
        this.nom = nom;
    }
}
