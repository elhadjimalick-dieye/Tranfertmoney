package com.devweb.RH.controller;

import com.devweb.RH.model.Partenaire;
import com.devweb.RH.model.Role;
import com.devweb.RH.model.RoleName;
import com.devweb.RH.model.User;
import com.devweb.RH.repository.CompteRepository;
import com.devweb.RH.repository.RoleRepository;
import com.devweb.RH.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin

@RequestMapping(value = "/user") // comme symfony Api/...
public class UserController {

@Autowired
    PasswordEncoder encoder;
    @Autowired // sa permet de donner le reference de l'objet
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> list(){
        return  userRepository.findAll();
    }

    @PostMapping (value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) User user){

        user.setPassword(encoder.encode(user.getPassword()));
        return  userRepository.save(user); // on peut utiliser aussi saveOnUpdate
    }
}
