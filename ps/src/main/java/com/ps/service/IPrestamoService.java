package com.ps.service;

import com.ps.model.Prestamo;

import java.util.List;

public interface IPrestamoService {

    List<Prestamo> getAllPrestamos();

    Prestamo getPrestamoById(Long id);

    Prestamo createPrestamo(Prestamo prestamo);

    Prestamo updatePrestamo(Prestamo prestamo);

    boolean deletePrestamo(Long id);
}
