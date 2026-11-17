package com.example.TalentUp.service.empleados;

import com.example.TalentUp.dao.empleado.EmpleadoDAO;
import com.example.TalentUp.entity.Empleados;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadosService{
    private EmpleadoDAO empleadoDAO;

    public EmpleadoServiceImpl(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }

    @Override
    public List<Empleados> findAll() {
        return empleadoDAO.findAll();
    }

    @Override
    public Empleados findById(int theID) {
        return empleadoDAO.findById(theID);
    }

    @Override
    @Transactional
    public Empleados save(Empleados empleado) {
        return empleadoDAO.save(empleado);
    }

    @Override
    public void deleteById(int theId) {
        empleadoDAO.deleteById(theId);
    }
}
