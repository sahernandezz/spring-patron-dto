package com.example.springpatrondto.service;

import com.example.springpatrondto.service.dto.MotoDto;
import com.example.springpatrondto.persistence.entity.Moto;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MotoService {

    List<Map<String, Object>> listMotorcycleCatalog();

    Moto saveMotorcycle(MotoDto motoSaveDto);

    Optional<Moto> updateMotorcycle(Long id, MotoDto motoUpdateDto);

    Optional<Map<String, Object>> findMotorcycleById(Long id);

    boolean removeMotorcycle(Long id);
}
