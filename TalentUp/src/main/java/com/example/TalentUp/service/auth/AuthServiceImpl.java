package com.example.TalentUp.service.auth;

import com.example.TalentUp.dao.usuario.UsuarioDAO;
import com.example.TalentUp.dto.LoginRequest;
import com.example.TalentUp.dto.LoginResponse;
import com.example.TalentUp.entity.Usuarios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthServiceImpl implements AuthService {
    private final UsuarioDAO usuarioDAO;

    public AuthServiceImpl(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        Usuarios usuario = usuarioDAO.findByCorreo(request.getCorreo())
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Correo o contraseña incorrectos"
                        )
                );

        if (usuario.getPassword() == null ||
                !usuario.getPassword().equals(request.getPassword())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Correo o contraseña incorrectos"
            );
        }

        if (!"ACTIVO".equalsIgnoreCase(usuario.getEstado())) {

            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "El usuario se encuentra inactivo"
            );
        }

        LoginResponse response = new LoginResponse();

        response.setIdUsuario(usuario.getId());
        response.setNombre(usuario.getNombre());
        response.setCorreo(usuario.getCorreo());
        response.setIdRol(usuario.getIdRol());
        response.setIdEmpleado(usuario.getIdEmpleado());
        response.setMensaje("Inicio de sesión exitoso");

        return response;
    }
}
