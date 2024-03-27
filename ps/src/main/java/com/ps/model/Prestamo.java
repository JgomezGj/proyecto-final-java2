package com.ps.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prestamos")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanId")
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    private BigDecimal monto;
    private BigDecimal tasaInteres;
    private Integer plazo;
    private Date fechaInicio;
    private String estado;
}
