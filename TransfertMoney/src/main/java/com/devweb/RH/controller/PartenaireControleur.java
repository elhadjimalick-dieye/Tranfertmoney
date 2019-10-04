package com.devweb.RH.controller;

import com.devweb.RH.model.Compte;
import com.devweb.RH.model.Partenaire;
import com.devweb.RH.model.User;
import com.devweb.RH.repository.CompteRepository;
import com.devweb.RH.repository.PartenaireRepository;
import com.devweb.RH.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(value = "/partenaire") // comme symfony Api/...
public class PartenaireControleur {
@Autowired
PasswordEncoder encoder;
    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireRepository partenaireRepository;
    @Autowired // sa permet de donner le reference de l'objet
    private UserRepository userRepository;
    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;


    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Partenaire> list(){
        return  partenaireRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Partenaire add(@RequestBody(required = false) Partenaire partenaire){
        int nombre =(int) (Math.random() *999999999)-10000000;
        nombre *= 9999999;
        partenaire.getUsers().get(0).setPassword(encoder.encode(partenaire.getUsers().get(0).getPassword()));
        partenaire.getComptes().get(0).setNumerocompte(nombre);
        partenaire.getComptes().get(0).setDatecreation(new Date());
        partenaire.getComptes().get(0).setSolde(0);
        partenaire.getComptes().get(0).setPartenaire(partenaire);
        partenaire.getUsers().get(0).setPartenaire(partenaire);
        return  partenaireRepository.save(partenaire); // on peut utiliser aussi saveOnUpdate   return "redirect:/user";
    }
}
