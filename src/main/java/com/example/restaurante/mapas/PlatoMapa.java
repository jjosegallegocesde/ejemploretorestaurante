package com.example.restaurante.mapas;

import com.example.restaurante.DTO.PlatoDTO;
import com.example.restaurante.DTO.PlatoRespuestaDTO;
import com.example.restaurante.entidades.Plato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatoMapa {

    @Mappings({
            @Mapping(source = "nombre", target="nombre"),
            @Mapping(source = "tiempoPreparacion", target="duracionPreparacion"),
            @Mapping(source = "costo", target="costoUnitario")

    })
    public PlatoRespuestaDTO transformarPlato(Plato plato);
    public List<PlatoRespuestaDTO> transformarListaPlatos(List<Plato> platos);

}
