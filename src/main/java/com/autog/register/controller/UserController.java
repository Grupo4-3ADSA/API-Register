package com.autog.register.controller;

import com.autog.register.dto.request.AutenticacaoRequisicao;
import com.autog.register.entity.Gestor;
import com.autog.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/autenticacao")
    public ResponseEntity autenticao(@RequestBody AutenticacaoRequisicao loginUser){
        Gestor user = repository.findByLoginAndPassword(loginUser.getLogin(), loginUser.getSenha());
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
