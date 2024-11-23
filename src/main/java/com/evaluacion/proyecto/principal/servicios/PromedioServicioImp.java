package com.evaluacion.proyecto.principal.servicios;

import java.util.List;

public class PromedioServicioImp {
	
	public PromedioServicioImp() {
		
	}

	public double calcularPromedio(List<Double> notas) {
        return notas.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }
	
	

}
