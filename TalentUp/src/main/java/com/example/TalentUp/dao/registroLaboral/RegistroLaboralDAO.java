package com.example.TalentUp.dao.registroLaboral;
import com.example.TalentUp.entity.RegistroLaboral;

import java.util.List;

public interface RegistroLaboralDAO {

    // Consultar por tipo de registro
    List<RegistroLaboral> findByTipoRegistro(String tipoRegistro);

    // Consultartodo el historial de asistencia
    List<RegistroLaboral> findAll();

    // Consultar por empleado
    List<RegistroLaboral> findByIdEmpleado(Integer idEmpleado);

    // Guardar
    RegistroLaboral save(RegistroLaboral registro);

    // Actualizar
    RegistroLaboral update(RegistroLaboral registro);
}
