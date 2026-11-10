package com.example.TalentUp.controller;

import com.example.TalentUp.entity.Empleados;
import com.example.TalentUp.entity.Usuarios;
import com.example.TalentUp.service.empleados.EmpleadosService;
import com.example.TalentUp.service.usuario.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoRestControler {
    private EmpleadosService empleadosService;


    @Autowired
    public EmpleadoRestControler(EmpleadosService empleadosService) {
        this.empleadosService = empleadosService;
    }

    @GetMapping()
    public List<Empleados> findAll(){
        return empleadosService.findAll();
    }

    @GetMapping("/{theId}")
    public Empleados findById(@PathVariable int theId) {
        return empleadosService.findById(theId);
    }

    @PostMapping
    public Empleados addEmpleados(@RequestBody Empleados empleado) {

        return empleadosService.save(empleado);

    }
    @PutMapping()
    public Empleados updateEmpleados(@RequestBody Empleados empleado) {
        Empleados dbEmpleado=empleadosService.save(empleado);
        return dbEmpleado;
    }
    @DeleteMapping("/{theId}")
    public String deleteEmpleados(@PathVariable int theId) {

        empleadosService.deleteById(theId);

        return "Usuario eliminado correctamente. ID: " + theId;
    }
}
