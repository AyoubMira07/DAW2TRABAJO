package mappers;


import dto.FunkoCreateRequest;
import dto.FunkoResponse;
import dto.FunkoUpdateRequest;

import models.funko;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class FunkoMapper {

    public FunkoResponse toResponse(funko.Funko f) {
        return new FunkoResponse(f.id(), f.nombre(), f.precio(), f.cantidad(),
                f.categoria(), f.createdAt(), f.updatedAt());
    }

    public List<FunkoResponse> toResponse(List<funko.Funko> funkos) {
        return funkos.stream().map(this::toResponse).toList();
    }

    /** POST: nuevo. El id lo pone la BD; las fechas, el servidor. */
    public funko.Funko toModel(FunkoCreateRequest r) {
        var ahora = LocalDateTime.now();
        return new funko.Funko(
                null,
                r.nombre().trim(),
                r.precio(),
                r.cantidad(),
                r.categoria().toUpperCase(),
                ahora,
                ahora);
    }

    /** PUT: reemplaza todo menos el id y la fecha de creación. */
    public funko.Funko reemplazar(funko.Funko original, FunkoCreateRequest r) {
        return new funko.Funko(
                original.id(),
                r.nombre().trim(),
                r.precio(),
                r.cantidad(),
                r.categoria().toUpperCase(),
                original.createdAt(),
                LocalDateTime.now());
    }

    /** PATCH: cambia solo lo que llega distinto de null. */
    public funko.Funko parchear(funko.Funko original, FunkoUpdateRequest r) {
        return new funko.Funko(
                original.id(),
                r.nombre()    != null ? r.nombre().trim()           : original.nombre(),
                r.precio()    != null ? r.precio()                  : original.precio(),
                r.cantidad()  != null ? r.cantidad()                : original.cantidad(),
                r.categoria() != null ? r.categoria().toUpperCase() : original.categoria(),
                original.createdAt(),
                LocalDateTime.now());
    }
}