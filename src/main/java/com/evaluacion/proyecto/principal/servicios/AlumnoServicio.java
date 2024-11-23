package com.evaluacion.proyecto.principal.servicios;

import com.evaluacion.proyecto.principal.modelos.Alumno;
import com.evaluacion.proyecto.principal.modelos.Materia;
import com.evaluacion.proyecto.principal.modelos.MateriaEnum;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AlumnoServicio {
	private Map<String, Alumno> listaAlumnos = new LinkedHashMap<>();

	public void crearAlumno(Alumno alumno) {
		listaAlumnos.put(alumno.getRut(), alumno);
		System.out.println("\n--- ¡Alumno agregado! ---");
	}

	public void agregarMateria(String rut, MateriaEnum currentMate) {
		Alumno alumno = listaAlumnos.get(rut);
		Materia materia = new Materia(currentMate); 
		alumno.agregarMateria(materia);
		System.out.println("\n--- ¡Materia agregada! --- ");
	}

	
	  public List<Materia> materiasPorAlumnos(String rut) {
		  Alumno alumno = listaAlumnos.get(rut);
		  return alumno.getMaterias();
	 }
	 

	public Map<String, Alumno> listarAlumnos() {
		return listaAlumnos;
	}
}
