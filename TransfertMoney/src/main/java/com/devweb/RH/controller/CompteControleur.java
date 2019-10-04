package com.devweb.RH.controller;

import com.devweb.RH.model.Compte;
import com.devweb.RH.model.User;
import com.devweb.RH.repository.CompteRepository;
import com.devweb.RH.repository.PartenaireRepository;
import com.devweb.RH.repository.UserRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/compte") // comme symfony Api/...
public class CompteControleur {

    @Autowired // sa permet de donner le reference de l'objet
    private CompteRepository compteRepository;
    @Autowired // sa permet de donner le reference de l'objet
    private UserRepository userRepository;

    @Autowired // sa permet de donner le reference de l'objet
    private PartenaireRepository partenaireRepository;

    @GetMapping(value = "/liste") // on peut faire un getMapping et lui passer tous notre url en parametre
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> list(){
        return  compteRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add(@RequestBody(required = false) Compte compte){
        double nombre =(int) (Math.random() *999999999)+1;
        nombre *= 999999;
        compte.setDatecreation(new Date());
        compte.setNumerocompte((int) nombre);
        compte.setSolde(0);
        compte.setPartenaire(compte.getPartenaire());
        return  compteRepository.save(compte);// on peut utiliser aussi saveOnUpdate
        //Message message = new Message(200,"" );
    }

    @PostMapping(value = "/affectation",consumes = {MediaType.APPLICATION_JSON_VALUE})
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User compteuser(@RequestBody(required = false) User user)throws  Exception{
        User user1 =userRepository.findById(user.getId()).orElseThrow();
        Compte compte = new Compte();
        compte.getId();
        user.setCompte(compte);
        return  userRepository.save(user);// on peut utiliser aussi saveOnUpdate
        //Message message = new Message(200,"" );
    }
}

