package com.example.springpatrondto.persistence.repository;

import com.example.springpatrondto.persistence.entity.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {

    @Query(
            "SELECT new map(" +
                    "m.marca as marca, " +
                    "m.modelo as modelo, " +
                    "m.color as color, " +
                    "m.cilindrada as cilindrada, " +
                    "m.tipo as tipo) " +
                    "FROM Moto m order by m.marca asc"
    )
    List<Map<String, Object>> listMotorcycleCatalog();

    @Query(
            "SELECT new map(" +
                    "m.marca as marca, " +
                    "m.modelo as modelo, " +
                    "m.color as color, " +
                    "m.cilindrada as cilindrada, " +
                    "m.tipo as tipo, " +
                    "m.placa as placa) " +
                    "FROM Moto m where m.id = ?1"
    )
    Optional<Map<String, Object>> findByIdDto(Long id);
}
