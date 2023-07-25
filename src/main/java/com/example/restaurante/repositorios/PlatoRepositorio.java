package com.example.restaurante.repositorios;

import com.example.restaurante.entidades.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoRepositorio extends JpaRepository <Plato, Integer>{

    boolean existsByNombre(String nombre);

}
