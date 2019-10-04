package com.devweb.RH.model;

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
    @Column(length = 40)
    private int numerocompte;
    @Column(length = 50)
    private int solde;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datecreation;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Partenaire partenaire;




    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getNumerocompte(int random) { return numerocompte; }

    public void setNumerocompte(int numerocompte) { this.numerocompte = numerocompte; }

    public int getSolde() { return solde; }

    public void setSolde(int solde) { this.solde = solde; }

    public Date getDatecreation() { return datecreation; }

    public void setDatecreation(Date datecreation) { this.datecreation = datecreation; }

    public int getNumerocompte() {
        return numerocompte;
    }

    public Partenaire getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Partenaire partenaire) {
        this.partenaire = partenaire;
    }

}