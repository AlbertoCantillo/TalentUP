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

    // Consultar todos los registros
    @Override
    public List<RegistroLaboral> findAll() {

        return entityManager.createQuery(
                        "SELECT r FROM RegistroLaboral r",
                        RegistroLaboral.class)
                .getResultList();
    }

    // Consultar por empleado
    @Override
    public List<RegistroLaboral> findByIdEmpleado(Integer idEmpleado) {

        return entityManager.createQuery(
                        "SELECT r FROM RegistroLaboral r WHERE r.idEmpleado = :id",
                        RegistroLaboral.class)
                .setParameter("id", idEmpleado)
                .getResultList();
    }

    // Guardar
    @Transactional
    @Override
    public RegistroLaboral save(RegistroLaboral registro) {

        entityManager.persist(registro);
        return registro;
    }

    // Actualizar
    @Transactional
    @Override
    public RegistroLaboral update(RegistroLaboral registro) {

        return entityManager.merge(registro);
    }
}
