package com.ps.service;

import com.ps.model.Prestamo;
import com.ps.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoService implements IPrestamoService {

    private final PrestamoRepository prestamoRepository;

    @Override
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    @Override
    public Prestamo getPrestamoById(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }

    @Override
    public Prestamo createPrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

    @Override
    public boolean deletePrestamo(Long id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
