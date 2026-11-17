package com.example.TalentUp.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private Integer idUsuario;

    private String nombre;

    private String correo;

    private Integer idRol;

    private Integer idEmpleado;

    private String mensaje;
}
