
package com.example.TalentUp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "empleado")
public class Empleados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    @NotBlank(message = "El nombre del empleado es obligatorio")
    @Size(max = 255, message = "El nombre no puede superar los 255 caracteres")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @NotBlank(message = "El documento es obligatorio")
    @Size(max = 255, message = "El documento no puede superar los 255 caracteres")
    @Column(name = "documento", nullable = false)
    private String documento;

    @NotNull(message = "El cargo es obligatorio")
    @Positive(message = "El ID del cargo debe ser positivo")
    @Column(name = "id_cargo", nullable = false)
    private Integer idCargo;

    @NotNull(message = "El departamento es obligatorio")
    @Positive(message = "El ID del departamento debe ser positivo")
    @Column(name = "id_departamento", nullable = false)
    private Integer idDepartamento;

    @NotNull(message = "El tipo de contrato es obligatorio")
    @Positive(message = "El ID del tipo de contrato debe ser positivo")
    @Column(name = "id_tipo_contrato", nullable = false)
    private Integer idTipoContrato;

    @Pattern(
            regexp = "^[0-9]{7,15}$",
            message = "El teléfono debe contener entre 7 y 15 dígitos"
    )
    @Column(name = "telefono")
    private String telefono;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "El correo debe tener un formato válido")
    @Size(max = 255, message = "El correo no puede superar los 255 caracteres")
    @Column(name = "correo", nullable = false)
    private String correo;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @PastOrPresent(message = "La fecha de ingreso no puede ser futura")
    @Column(name = "fecha_ingreso", nullable = false)
    private LocalDate fechaIngreso;
}
