package com.example.TalentUp.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name="empleado")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_empleado")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "documento")
    private String documento;

    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name="id_departamento")
    private  Integer idDepartamento;

    @Column(name="id_tipo_contrato")
    private Integer idTipoContrato;

    @Column(name="telefono")
    private String telefono;

    @Column(name="correo")
    private String correo;

    @Column(name="fecha_ingreso")
    private LocalDate fechaIngreso;
}
