package com.ps.controller;

import com.ps.model.Prestamo;
import com.ps.service.IPrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final IPrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> getAllPrestamos() {
        return prestamoService.getAllPrestamos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoById(@PathVariable Long id) {
        Prestamo prestamo = prestamoService.getPrestamoById(id);
        if (prestamo != null) {
            return ResponseEntity.ok(prestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Prestamo> createPrestamo(@RequestBody Prestamo prestamo) {
        Prestamo createdPrestamo = prestamoService.createPrestamo(prestamo);
        return new ResponseEntity<>(createdPrestamo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        prestamo.setLoanId(id);
        Prestamo updatedPrestamo = prestamoService.updatePrestamo(prestamo);
        if (updatedPrestamo != null) {
            return ResponseEntity.ok(updatedPrestamo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        boolean deleted = prestamoService.deletePrestamo(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

