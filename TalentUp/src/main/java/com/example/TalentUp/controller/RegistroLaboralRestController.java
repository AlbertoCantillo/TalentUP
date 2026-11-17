
package com.example.TalentUp.controller;

import com.example.TalentUp.entity.RegistroLaboral;
import com.example.TalentUp.service.registroLaboral.RegistroLaboralService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registro-laboral")
public class RegistroLaboralRestController {

    private  RegistroLaboralService registroLaboralService;

    @Autowired
    public RegistroLaboralRestController(
            RegistroLaboralService registroLaboralService) {
        this.registroLaboralService = registroLaboralService;
    }

    @GetMapping("/tipo/{tipoRegistro}")
    public List<RegistroLaboral> findByTipoRegistro(
            @PathVariable String tipoRegistro) {

        return registroLaboralService.findByTipoRegistro(
                tipoRegistro.toUpperCase());
    }

    @GetMapping("/historial")
    public List<RegistroLaboral> findAll() {
        return registroLaboralService.findAll();
    }


    @GetMapping("/empleado/{idEmpleado}")
    public List<RegistroLaboral> findByIdEmpleado(
            @PathVariable Integer idEmpleado) {

        return registroLaboralService.findByIdEmpleado(idEmpleado);
    }

    @PostMapping
    public RegistroLaboral save(@Valid @RequestBody RegistroLaboral registro) {
        return registroLaboralService.save(registro);
    }

    @PutMapping
    public RegistroLaboral update(@Valid @RequestBody RegistroLaboral registro) {
        return registroLaboralService.update(registro);
    }
}
