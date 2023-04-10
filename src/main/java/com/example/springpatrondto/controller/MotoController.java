package com.example.springpatrondto.controller;

import com.example.springpatrondto.persistence.entity.Moto;
import com.example.springpatrondto.service.MotoService;
import com.example.springpatrondto.service.dto.MotoDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/moto")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MotoController {

    private final MotoService motoService;

    /**
     * List all motorcycles
     *
     * @return List<Map < String, Object>>
     */
    @GetMapping(produces = "application/json")
    ResponseEntity<List<Map<String, Object>>> listMotorcycleCatalog() {
        return ResponseEntity.ok(this.motoService.listMotorcycleCatalog());
    }

    /**
     * save motorcycle
     *
     * @param motoSaveDto motoSaveDto
     * @return Moto
     */
    @PostMapping(produces = "application/json", consumes = "application/json")
    ResponseEntity<Moto> saveMotorcycle(@RequestBody MotoDto motoSaveDto) {
        return ResponseEntity.ok(this.motoService.saveMotorcycle(motoSaveDto));
    }

    /**
     * update motorcycle
     *
     * @param id            id
     * @param motoUpdateDto motoUpdateDto
     * @return Optional<Moto>
     */
    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    ResponseEntity<Moto> updateMotorcycle(@PathVariable Long id, @RequestBody MotoDto motoUpdateDto) {
        return this.motoService.updateMotorcycle(id, motoUpdateDto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * find motorcycle by id
     *
     * @param id id
     * @return Optional<Map < String, Object>>
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<Map<String, Object>> findMotorcycleById(@PathVariable Long id) {
        return this.motoService.findMotorcycleById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * remove motorcycle
     *
     * @param id id
     * @return boolean
     */
    @DeleteMapping(value = "/{id}", produces = "application/json")
    ResponseEntity<Boolean> removeMotorcycle(@PathVariable Long id) {
        return ResponseEntity.ok(this.motoService.removeMotorcycle(id));
    }


}
