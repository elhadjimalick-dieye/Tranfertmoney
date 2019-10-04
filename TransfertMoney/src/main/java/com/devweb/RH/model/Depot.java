package com.devweb.RH.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(exclude = "depot")
@Table(name = "depot")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datedepot;

    @Column(length = 50)
    private int montant;
    @JoinColumn(name = "compte_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depot")
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

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}