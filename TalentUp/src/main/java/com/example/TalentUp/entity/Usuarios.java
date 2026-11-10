package com.example.TalentUp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password_hash")
    private String password;

    @Column(name="documento")
    private  String documento;

    @Column(name="estado")
    private String estado;

    @Column(name="id_rol")
    private Integer idRol;

    @Column(name="id_empleado")
    private Integer idEmpleado;


}
