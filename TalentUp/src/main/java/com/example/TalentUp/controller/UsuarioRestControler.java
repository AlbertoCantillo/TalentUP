package com.example.TalentUp.controller;

import com.example.TalentUp.entity.Usuarios;
import jakarta.validation.Valid;
import com.example.TalentUp.service.usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioRestControler {
    
    private UsuariosService usuariosService;

    @Autowired
    public UsuarioRestControler(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping()
    public List<Usuarios> findAll(){
        return usuariosService.findAll();
    }

    @GetMapping("/{theID}")
    public Usuarios findById(@PathVariable int theID) {
        return usuariosService.findById(theID);
    }

    @PostMapping
    public Usuarios addUsuario(@Valid @RequestBody Usuarios usuario) {

        return usuariosService.save(usuario);

    }

    @PutMapping
    public Usuarios updateUsuario(@Valid @RequestBody Usuarios usuario) {

        Usuarios dbUsuario = usuariosService.save(usuario);

        return dbUsuario;
    }

    @DeleteMapping("/{theId}")
    public String deleteUsuario(@PathVariable int theId) {

        usuariosService.deleteById(theId);

        return "Usuario eliminado correctamente. ID: " + theId;
    }
}