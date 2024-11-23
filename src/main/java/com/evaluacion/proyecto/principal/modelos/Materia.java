package com.evaluacion.proyecto.principal.modelos;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private MateriaEnum nombre;
    private List<Double> notas;

    public Materia(MateriaEnum nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
    }

    public MateriaEnum getNombre() {
        return nombre;
    }

    public List<Double> getNotas() {
        return notas;
    }

    
}
