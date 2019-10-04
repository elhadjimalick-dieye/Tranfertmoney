package com.devweb.RH.repository;

import com.devweb.RH.model.Depot;
import com.devweb.RH.model.Partenaire;
import com.devweb.RH.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
// finbBy est la mais ce qui suit doit etre un attribut qui se trouve dans la classe
public interface DepotRepository extends JpaRepository<Depot, Long> {

}

