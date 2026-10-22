package models;
import java.math.BigDecimal;
import java.time.LocalDateTime;
public class funko {


    public record Funko(
            Long id,
            String nombre,
            BigDecimal precio,
            Integer cantidad,
            String categoria,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {}
}
