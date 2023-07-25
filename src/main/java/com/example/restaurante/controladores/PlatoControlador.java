package com.example.restaurante.controladores;

import com.example.restaurante.DTO.PlatoDTO;
import com.example.restaurante.DTO.PlatoErrorDTO;
import com.example.restaurante.DTO.PlatoRespuestaDTO;
import com.example.restaurante.entidades.Plato;
import com.example.restaurante.servicios.PlatoServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restauranteAPI/plato")
public class PlatoControlador {

    @Autowired
    private PlatoServicios platoServicio;

    @PostMapping
    public ResponseEntity<PlatoDTO> registrar(@RequestBody Plato datosPlatoEnviadoPorCLiente){
        try{

            PlatoDTO datosRespuesta=platoServicio.registrar(datosPlatoEnviadoPorCLiente);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(datosRespuesta);

        }catch(Exception error){
            PlatoErrorDTO respuestaError= new PlatoErrorDTO();
            respuestaError.setMensajeError(error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuestaError);
        }

    }

    @GetMapping
    public ResponseEntity<List<PlatoRespuestaDTO>> buscarPlatos(){
        try{
            List<PlatoRespuestaDTO> platosEncontradosBD=platoServicio.buscarTodos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(platosEncontradosBD);
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }




}
