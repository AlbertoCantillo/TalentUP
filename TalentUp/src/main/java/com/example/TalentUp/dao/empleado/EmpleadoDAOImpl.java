package com.example.TalentUp.dao.empleado;

import com.example.TalentUp.entity.Empleados;
import com.example.TalentUp.entity.Usuarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
@Repository
public class EmpleadoDAOImpl implements EmpleadoDAO{

    private final EntityManager entityManager;

    @Autowired
    public EmpleadoDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Empleados> findAll() {
        TypedQuery<Empleados> query=entityManager.createQuery("from Empleados", Empleados.class);
        return query.getResultList();
    }

    @Override
    public Empleados findById(int theID) {
        return entityManager.find(Empleados.class, theID);
    }


    @Override
    public Empleados save(Empleados empleados) {

        return entityManager.merge(empleados);

    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Empleados empleados = entityManager.find(Empleados.class, theId);

        if (empleados == null) {
            throw new RuntimeException("Empleado no encontrado con ID: " + theId);
        }

        entityManager.remove(empleados);

    }
}
