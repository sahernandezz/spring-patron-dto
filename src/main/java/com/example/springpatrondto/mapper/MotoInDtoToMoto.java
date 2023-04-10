package com.example.springpatrondto.mapper;

import com.example.springpatrondto.service.dto.MotoDto;
import com.example.springpatrondto.persistence.entity.Moto;
import org.springframework.stereotype.Component;

@Component
public class MotoInDtoToMoto implements IMapper<MotoDto, Moto> {

    public Moto MotoTransferData(Long id, MotoDto motoDto) {
        Moto moto = map(motoDto);
        moto.setId(id);
        return moto;
    }

    @Override
    public Moto map(MotoDto in) {
        Moto moto = new Moto();
        moto.setCilindrada(in.getCilindrada());
        moto.setTipo(in.getTipo());
        moto.setMarca(in.getMarca());
        moto.setModelo(in.getModelo());
        moto.setColor(in.getColor());
        moto.setPlaca(in.getPlaca());
        return moto;
    }
}
