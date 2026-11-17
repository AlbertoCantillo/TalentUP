package com.example.TalentUp.dao.usuario;

import org.springframework.transaction.annotation.Transactional;
import com.example.TalentUp.entity.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {

    private EntityManager entityManager;

    @Autowired
    public UsuarioDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Usuarios> findAll() {
        TypedQuery<Usuarios> query=entityManager.createQuery("from Usuarios", Usuarios.class);
        List<Usuarios> Usuarios=query.getResultList();
        return Usuarios;
    }

    @Override
    public Usuarios findById(int theID) {
        return entityManager.find(Usuarios.class, theID);
    }


    @Override
    public Usuarios save(Usuarios usuario) {

        Usuarios dbEusuario=entityManager.merge(usuario);
        return dbEusuario;

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Usuarios usuario = entityManager.find(Usuarios.class, theId);

        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado con ID: " + theId);
        }

        entityManager.remove(usuario);

    }

    @Override
    public Optional<Usuarios> findByCorreo(String correo) {

        return entityManager.createQuery(
                        "SELECT u FROM Usuarios u WHERE u.correo = :correo",
                        Usuarios.class
                )
                .setParameter("correo", correo)
                .getResultStream()
                .findFirst();
    }
}

