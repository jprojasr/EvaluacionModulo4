package com.evaluacion.proyecto.pruebas;
import com.evaluacion.proyecto.principal.servicios.PromedioServicioImp;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;

@DisplayName("Test para la clase PromedioServicioImp")
public class PromedioServicioImpTest {
	private final PromedioServicioImp promedioServicio = new PromedioServicioImp();
	
	@Test
	public void calcularPromedioTest() {
        List<Double> notas = Arrays.asList(5.0, 6.0, 7.0);        
        assertEquals(6.0, promedioServicio.calcularPromedio(notas));//El promedio de 5.0, 6.0, 7.0 debe ser 6.0
	}
	
	/*@Test
	public void calcularPromedioTestErr() {
        List<Double> notas = Arrays.asList(5.0, 6.0, 7.0);
        assertEquals(1.0, promedioServicio.calcularPromedio(notas));//El promedio de 5.0, 6.0, 7.0 debe ser 6.0 y no 1.0
	}*/
	
	
}
