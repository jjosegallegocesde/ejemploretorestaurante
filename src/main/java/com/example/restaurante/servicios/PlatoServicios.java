package com.example.restaurante.servicios;

import com.example.restaurante.DTO.PlatoDTO;
import com.example.restaurante.DTO.PlatoRespuestaDTO;
import com.example.restaurante.entidades.Plato;
import com.example.restaurante.mapas.PlatoMapa;
import com.example.restaurante.repositorios.PlatoRepositorio;
import com.example.restaurante.validaciones.PlatoValidaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoServicios {

    @Autowired
    private PlatoRepositorio platoRepositorio;

    @Autowired
    private PlatoMapa platoMapa;

    @Autowired
    private PlatoValidaciones validaciones;

    public PlatoRespuestaDTO registrar(Plato datosPlatoRegistrar) throws Exception{

        try{

            if(datosPlatoRegistrar.getRol()!=1){
                throw new Exception("El ROL no esta autorizado para registrar un plato");
            }else if(platoRepositorio.existsByNombre(datosPlatoRegistrar.getNombre())){
                throw new Exception("El plato ya existe");
            }else if(validaciones.verificarNombreLlegoVacio(datosPlatoRegistrar.getNombre())){
                throw new Exception("EL nombre no puede estar vacio");
            }else if(validaciones.verificarCosto(datosPlatoRegistrar.getCosto())){
                throw new Exception("El costo es invalido");
            }else if(validaciones.verificarDuracion(datosPlatoRegistrar.getTiempoPreparacion())){
                throw new Exception(("Tempo de coccion invalido"));
            }else{
                PlatoRespuestaDTO platoDTOGuardado=platoMapa.transformarPlato(platoRepositorio.save(datosPlatoRegistrar));
                return platoDTOGuardado;
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<PlatoRespuestaDTO> buscarTodos() throws Exception{
        try{
            return platoMapa.transformarListaPlatos(platoRepositorio.findAll());

        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }




}
