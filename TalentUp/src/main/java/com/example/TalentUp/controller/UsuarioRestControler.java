package com.example.TalentUp.controller;

import com.example.TalentUp.entity.Usuarios;
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
    public Usuarios addUsuario(@RequestBody Usuarios usuario) {

        return usuariosService.save(usuario);

    }
    @PutMapping()
    public Usuarios updateUsuario(@RequestBody Usuarios usuario) {
        Usuarios dbEusuario=usuariosService.save(usuario);
        return dbEusuario;
    }
    @DeleteMapping("/{theId}")
    public String deleteUsuario(@PathVariable int theId) {

        usuariosService.deleteById(theId);

        return "Usuario eliminado correctamente. ID: " + theId;
    }
}