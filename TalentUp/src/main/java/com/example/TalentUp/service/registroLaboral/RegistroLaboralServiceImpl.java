package com.example.TalentUp.service.registroLaboral;

import java.util.List;

import com.example.TalentUp.dao.registroLaboral.RegistroLaboralDAO;
import com.example.TalentUp.dao.usuario.UsuarioDAO;
import com.example.TalentUp.entity.RegistroLaboral;
import org.springframework.stereotype.Service;

@Service
public class RegistroLaboralServiceImpl implements RegistroLaboralService{


        private RegistroLaboralDAO registroLaboralDAO;

        public RegistroLaboralServiceImpl(RegistroLaboralDAO registroLaboralDAO) {
        this.registroLaboralDAO = registroLaboralDAO;
    }

        @Override
        public List<RegistroLaboral> findByTipoRegistro(String tipoRegistro) {
            return registroLaboralDAO.findByTipoRegistro(tipoRegistro);
        }


        @Override
        public List<RegistroLaboral> findAll() {
            return registroLaboralDAO.findAll();
        }

        @Override
        public List<RegistroLaboral> findByIdEmpleado(Integer idEmpleado) {
            return registroLaboralDAO.findByIdEmpleado(idEmpleado);
        }

        @Override
        public RegistroLaboral save(RegistroLaboral registro) {
            return registroLaboralDAO.save(registro);
        }

        @Override
        public RegistroLaboral update(RegistroLaboral registro) {
            return registroLaboralDAO.update(registro);
        }
    }


