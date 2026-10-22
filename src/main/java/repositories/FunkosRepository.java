package repositories;

import models.funko;

import java.math.BigDecimal;
import java.util.*;



    public interface FunkosRepository {
        List<funko.Funko>       buscar(Optional<String> categoria, Optional<String> nombre,
                                       Optional<BigDecimal> precioMax);
        Optional<funko.Funko>   findById(Long id);
        boolean           existsByNombre(String nombre);
        funko.Funko save(funko.Funko funko);
        void              update(funko.Funko funko);
        boolean           deleteById(Long id);
        Map<String, Long> contarPorCategoria();
    }

