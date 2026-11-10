package com.example.TalentUp.service.usuario;

import com.example.TalentUp.entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    public List<Usuarios> findAll();

    Usuarios findById(int theID);

    Usuarios save(Usuarios usuario);

    public void deleteById(int theId);

}

