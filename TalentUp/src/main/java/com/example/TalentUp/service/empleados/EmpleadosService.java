package com.example.TalentUp.service.empleados;

import com.example.TalentUp.entity.Empleados;

import java.util.List;

public interface EmpleadosService {
    public List<Empleados> findAll();

    Empleados findById(int theId);

    Empleados save(Empleados empleados);

    public void deleteById(int theId);
}
