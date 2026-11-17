package com.example.TalentUp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 255, message = "El correo no puede superar los 255 caracteres")
    @Column(name = "correo", nullable = false)
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(max = 255, message = "La contraseña no puede superar los 255 caracteres")
    @Column(name = "password_hash", nullable = false)
    private String password;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 255, message = "El documento no puede superar los 255 caracteres")
    @Column(name = "documento", nullable = false)
    private String documento;

    @NotBlank(message = "El estado es obligatorio")
    @Column(name = "estado", nullable = false)
    private String estado;

    @NotNull(message = "El rol es obligatorio")
    @Positive(message = "El ID del rol debe ser positivo")
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;

    @Positive(message = "El ID del empleado debe ser positivo")
    @Column(name = "id_empleado")
    private Integer idEmpleado;
}