package com.example.restaurante.validaciones;

import org.springframework.stereotype.Component;

@Component
public class PlatoValidaciones {

    public boolean verificarCosto(Integer costo){
        //return (costo<0)?false:true;

        if(costo<0){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarDuracion(Integer duracion){
        if(duracion<0){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificarNombreLlegoVacio(String nombre){
        if(nombre.length()==0){
            return true;
        }else{
            return false;
        }
    }


}
