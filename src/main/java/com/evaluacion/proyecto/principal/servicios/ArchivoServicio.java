package com.evaluacion.proyecto.principal.servicios;

import com.evaluacion.proyecto.principal.modelos.Alumno;
import com.evaluacion.proyecto.principal.modelos.Materia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ArchivoServicio {
	private PromedioServicioImp promediosServicioImp = new PromedioServicioImp();

	public void exportarDatos(Map<String, Alumno> alumnos) {
		FileWriter fw;
		BufferedWriter bw;
		try {			
			fw = new FileWriter("promedios.txt");
			bw = new BufferedWriter(fw);
			for (Alumno alumno : alumnos.values()) {
				bw.write("Alumno : " + alumno.getRut() + " - " + alumno.getNombre());
				bw.newLine();
				bw.newLine();
				for (Materia materia : alumno.getMaterias()) {
					bw.write("\t\tMateria: " + materia.getNombre() + " - Promedio: " + promediosServicioImp.calcularPromedio(materia.getNotas()));
					bw.newLine();
					bw.newLine();
				}
				bw.flush();
				bw.newLine();
				bw.newLine();
			}
			bw.close();
			System.out.println("Datos exportados correctamente.");
		} catch (IOException e) {
			System.err.println("Error. Detalle = " + e.getMessage());
		}
	}
}
