package com.devweb.RH.repository;

import com.devweb.RH.model.Compte;
import com.devweb.RH.model.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
Optional<Compte> findById(int id);
}