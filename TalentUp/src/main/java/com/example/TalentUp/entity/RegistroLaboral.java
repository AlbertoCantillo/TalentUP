package com.example.TalentUp.entity;

import jakarta.persistence.*;
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

        @Column(name = "id_empleado")
        private Integer idEmpleado;

        @Column(name = "tipo_registro")
        private String tipoRegistro;

        @Column(name = "fecha_inicio")
        private LocalDateTime fechaInicio;

        @Column(name = "fecha_fin")
        private LocalDateTime fechaFin;

        private String motivo;

        private String observacion;

}
