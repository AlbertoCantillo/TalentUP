package com.example.TalentUp.service.usuario;


import com.example.TalentUp.dao.usuario.UsuarioDAO;
import com.example.TalentUp.entity.Usuarios;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuariosService{

    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public List<Usuarios> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public Usuarios findById(int theID) {
        return usuarioDAO.findById(theID);
    }

    @Override
    @Transactional
    public Usuarios save(Usuarios usuario) {
        return usuarioDAO.save(usuario);
    }

    @Override
    public void deleteById(int theId) {
        usuarioDAO.deleteById(theId);
    }
}
