package org.example.funkos.services;


import org.example.funkos.dto.EstadisticasResponse;
import org.example.funkos.dto.FunkoCreateRequest;
import org.example.funkos.dto.FunkoResponse;
import org.example.funkos.dto.FunkoUpdateRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FunkosService {
    List<FunkoResponse> buscar(Optional<String> categoria, Optional<String> nombre,
                               Optional<BigDecimal> precioMax);
    FunkoResponse findById(Long id);
    FunkoResponse save(FunkoCreateRequest funko);
    FunkoResponse replace(Long id, FunkoCreateRequest funko);
    FunkoResponse update(Long id, FunkoUpdateRequest funko);
    void deleteById(Long id);
    EstadisticasResponse estadisticas();
}