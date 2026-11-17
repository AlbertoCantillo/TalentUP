package com.example.TalentUp.dao.registroLaboral;

import java.util.List;

import com.example.TalentUp.entity.RegistroLaboral;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegistroLaboralDAOImpl implements RegistroLaboralDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public RegistroLaboralDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Consultar por tipo de registro
    @Override
    public List<RegistroLaboral> findByTipoRegistro(String tipoRegistro) {

        return entityManager.createQuery(
                        "SELECT r FROM RegistroLaboral r WHERE r.tipoRegistro = :tipo",
                        RegistroLaboral.class)
                .setParameter("tipo", tipoRegistro)
                .getResultList();
    }

    @Override
    public List<RegistroLaboral> findAll() {

        return entityManager.createQuery(
                        "SELECT r FROM RegistroLaboral r",
                        RegistroLaboral.class)
                .getResultList();
    }

    @Override
    public List<RegistroLaboral> findByIdEmpleado(Integer idEmpleado) {

        return entityManager.createQuery(
                        "SELECT r FROM RegistroLaboral r WHERE r.idEmpleado = :id",
                        RegistroLaboral.class)
                .setParameter("id", idEmpleado)
                .getResultList();
    }

    @Transactional
    @Override
    public RegistroLaboral save(RegistroLaboral registro) {

        entityManager.persist(registro);
        return registro;
    }

    @Transactional
    @Override
    public RegistroLaboral update(RegistroLaboral registro) {

        return entityManager.merge(registro);
    }
}
