package com.devweb.RH.controller;

import com.devweb.RH.model.Compte;
import com.devweb.RH.model.Depot;
import com.devweb.RH.repository.CompteRepository;
import com.devweb.RH.repository.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@CrossOrigin

@RequestMapping(value = "/depot") // comme symfony Api/...
public class DepotControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private DepotRepository depotRepository;

    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Depot add(@RequestBody(required = false) Depot depot)throws  Exception{
        Compte  compte =compteRepository.findById(depot.getId()).orElseThrow();
        depot.setDatedepot(new Date());
        depot.setMontant(depot.getMontant());
        compte.setSolde(compte.getSolde() + depot.getMontant());
        compteRepository.save(compte);
        depot.setUser(depot.getUser());
        return  depotRepository.save(depot); // on peut utiliser aussi saveOnUpdate
    }




}

