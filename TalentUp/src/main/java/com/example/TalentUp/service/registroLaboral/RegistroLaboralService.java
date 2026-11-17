package com.example.TalentUp.service.registroLaboral;
import com.example.TalentUp.entity.RegistroLaboral;

import java.util.List;

public interface RegistroLaboralService {

    List<RegistroLaboral> findByTipoRegistro(String tipoRegistro);

    List<RegistroLaboral> findAll();

    List<RegistroLaboral> findByIdEmpleado(Integer idEmpleado);

    RegistroLaboral save(RegistroLaboral registro);

    RegistroLaboral update(RegistroLaboral registro);
}
