package com.example.restaurante.DTO;

public class PlatoRespuestaDTO extends PlatoDTO{

    private String nombre;
    private Integer duracionPreparacion;
    private Integer costoUnitario;


    public PlatoRespuestaDTO() {
    }

    public PlatoRespuestaDTO(String nombre, Integer duracionPreparacion, Integer costoUnitario) {
        this.nombre = nombre;
        this.duracionPreparacion = duracionPreparacion;
        this.costoUnitario = costoUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDuracionPreparacion() {
        return duracionPreparacion;
    }

    public void setDuracionPreparacion(Integer duracionPreparacion) {
        this.duracionPreparacion = duracionPreparacion;
    }

    public Integer getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Integer costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
