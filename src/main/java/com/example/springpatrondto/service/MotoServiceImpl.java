package com.example.springpatrondto.service;

import com.example.springpatrondto.persistence.repository.MotoRepository;
import com.example.springpatrondto.service.dto.MotoDto;
import com.example.springpatrondto.persistence.entity.Moto;
import com.example.springpatrondto.mapper.MotoInDtoToMoto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MotoServiceImpl implements MotoService {

    private final MotoRepository motoRepository;

    private final MotoInDtoToMoto motoMapper;

    /**
     * List all motorcycles
     *
     * @return List<Map < String, Object>>
     */
    @Override
    public List<Map<String, Object>> listMotorcycleCatalog() {
        return this.motoRepository.listMotorcycleCatalog();
    }

    /**
     * save motorcycle
     *
     * @param motoSaveDto motoSaveDto
     * @return Moto
     */
    @Override
    public Moto saveMotorcycle(MotoDto motoSaveDto) {
        return this.motoRepository.save(this.motoMapper.map(motoSaveDto));
    }

    /**
     * update motorcycle
     *
     * @param id            id
     * @param motoUpdateDto motoUpdateDto
     * @return Optional<Moto>
     */
    @Override
    @Transactional
    public Optional<Moto> updateMotorcycle(Long id, MotoDto motoUpdateDto) {
        return this.motoRepository.findById(id)
                .map(moto -> {
                    moto = this.motoMapper.MotoTransferData(id, motoUpdateDto);
                    return this.motoRepository.save(moto);
                });
    }

    /**
     * Find motorcycle by id
     *
     * @param id id
     * @return Optional<Map < String, Object>>
     */
    @Override
    public Optional<Map<String, Object>> findMotorcycleById(Long id) {
        return this.motoRepository.findByIdDto(id);
    }

    /**
     * Remove motorcycle by id
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean removeMotorcycle(Long id) {
        return this.motoRepository.findById(id)
                .map(moto -> {
                    this.motoRepository.delete(moto);
                    return true;
                }).orElse(false);
    }
}
