
package com.example.TalentUp.controller;

import com.example.TalentUp.entity.RegistroLaboral;
import com.example.TalentUp.service.registroLaboral.RegistroLaboralService;
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


    // Consultar por tipo: ASISTENCIA o AUSENCIA
    @GetMapping("/tipo/{tipoRegistro}")
    public List<RegistroLaboral> findByTipoRegistro(
            @PathVariable String tipoRegistro) {

        return registroLaboralService.findByTipoRegistro(
                tipoRegistro.toUpperCase());
    }

    // Consultartodo el historial
    @GetMapping("/historial")
    public List<RegistroLaboral> findAll() {
        return registroLaboralService.findAll();
    }

    // Consultar por empleado
    @GetMapping("/empleado/{idEmpleado}")
    public List<RegistroLaboral> findByIdEmpleado(
            @PathVariable Integer idEmpleado) {

        return registroLaboralService.findByIdEmpleado(idEmpleado);
    }

    // Guardar
    @PostMapping
    public RegistroLaboral save(@RequestBody RegistroLaboral registro) {
        return registroLaboralService.save(registro);
    }

    // Actualizar
    @PutMapping
    public RegistroLaboral update(@RequestBody RegistroLaboral registro) {
        return registroLaboralService.update(registro);
    }
}
