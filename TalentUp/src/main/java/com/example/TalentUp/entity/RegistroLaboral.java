
package com.example.TalentUp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "registro_laboral")
public class RegistroLaboral {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_registro")
        private Integer id;

        @NotNull(message = "El empleado es obligatorio")
        @Positive(message = "El ID del empleado debe ser positivo")
        @Column(name = "id_empleado", nullable = false)
        private Integer idEmpleado;

        @NotBlank(message = "El tipo de registro es obligatorio")
        @Pattern(
                regexp = "ASISTENCIA|AUSENCIA",
                message = "El tipo de registro debe ser ASISTENCIA o AUSENCIA"
        )
        @Column(name = "tipo_registro", nullable = false)
        private String tipoRegistro;

        @NotNull(message = "La fecha de inicio es obligatoria")
        @Column(name = "fecha_inicio", nullable = false)
        private LocalDateTime fechaInicio;

        @Column(name = "fecha_fin")
        private LocalDateTime fechaFin;

        @Size(max = 255, message = "El motivo no puede superar los 255 caracteres")
        private String motivo;

        @Size(max = 255, message = "La observación no puede superar los 255 caracteres")
        private String observacion;
}
