package com.example.TalentUp.dao.empleado;

import com.example.TalentUp.entity.Empleados;


import java.util.List;

public interface EmpleadoDAO {
    public List<Empleados> findAll();

    Empleados findById(int theID);

    Empleados save(Empleados empleados);

    public void deleteById(int theId);
}
