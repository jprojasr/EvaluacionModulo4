package com.evaluacion.proyecto.principal.vistas;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.evaluacion.proyecto.principal.modelos.Alumno;
import com.evaluacion.proyecto.principal.modelos.Materia;
import com.evaluacion.proyecto.principal.modelos.MateriaEnum;
import com.evaluacion.proyecto.principal.servicios.AlumnoServicio;
import com.evaluacion.proyecto.principal.servicios.ArchivoServicio;
import com.evaluacion.proyecto.principal.utilidades.Utilidad;

public class Menu extends MenuTemplate {
	private AlumnoServicio alumnoServicio = new AlumnoServicio();
	private ArchivoServicio archivoServicio = new ArchivoServicio();

	@Override
	public void crearAlumno() {
		Utilidad.limpiarPantalla();
		Utilidad.mostrarMensaje("--- Crear Alumno ---");
		System.out.print("\nIngrese RUT: ");
		String rut = leer.nextLine();
		System.out.print("\nIngrese Nombre: ");
		String nombre = leer.nextLine();
		System.out.print("\nIngrese Apellido: ");
		String apellido = leer.nextLine();
		System.out.print("\nIngrese Dirección: ");
		String direccion = leer.nextLine();
		Alumno alumno = new Alumno(rut, nombre, apellido, direccion);

		alumnoServicio.crearAlumno(alumno);
		Utilidad.pausar();
		Utilidad.limpiarPantalla();
	}

	@Override
	public void listarAlumnos() {
		Utilidad.limpiarPantalla();
		System.out.println("--- Listar Alumnos --");
		alumnoServicio.listarAlumnos().forEach((rut, alumno) -> {
			System.out.println("\nDatos Alumno");
			System.out.println("\n\tRUT: " + rut);
			System.out.println("\n\tNombre: " + alumno.getNombre());
			System.out.println("\n\tApellido: " + alumno.getApellido());
			System.out.println("\n\tDirección: " + alumno.getDireccion());

			System.out.println("\n\tMaterias");
			List<Materia> materias = new ArrayList<Materia>();
			materias = alumnoServicio.materiasPorAlumnos(alumno.getRut());
			if (materias.isEmpty()) {
				System.out.println("\t\tNo tiene materias asignadas.");
			} else {
				materias.forEach(materia -> {
					System.out.println("\n\t\t" + materia.getNombre());

					
					if (materia.getNotas().isEmpty()) {
						System.out.println("\n\t\t\tNo tiene notas registradas.");
					} else {
						System.out.println("\n\t\t\tNotas: ");
						System.out.print("\n\t\t\t");
						materia.getNotas().forEach(nota -> {
							System.out.print("[" + nota + "] ");
						});
						System.out.println(); 
					}

				});
			}

		});
		Utilidad.pausar();
		Utilidad.limpiarPantalla();
	}

	@Override
	public void agregarMateria() {
		Utilidad.limpiarPantalla();
		Utilidad.mostrarMensaje("--- Agregar Materia ---");
		System.out.print("\nIngrese RUT del alumno: ");
		String rut = leer.nextLine();


		Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();


		Alumno alumno = alumnos.get(rut);

		if (alumno != null) {
			

			for (MateriaEnum materia : MateriaEnum.values()) {
				System.out.println(materia.ordinal() + 1 + ". " + materia); 
			}
			Utilidad.mostrarMensaje("\n\nSeleccione una materia:");
			int opcion = leer.nextInt();
			leer.nextLine(); 

			
			if (opcion >= 1 && opcion <= MateriaEnum.values().length) {
				MateriaEnum currentMate = MateriaEnum.values()[opcion - 1];

				
				alumnoServicio.agregarMateria(rut, currentMate);
			} else {
				System.out.println("Opción inválida.");
			}
		} else {
			System.out.println("\n--- ¡Alumno no encontrado! ---");
		}

		Utilidad.pausar();
		Utilidad.limpiarPantalla();
	}

	@Override
	public void agregarNotaPasoUno() {
		Utilidad.limpiarPantalla();
		Utilidad.mostrarMensaje("--- Agregar Nota ---");
		System.out.print("\nIngrese RUT del alumno: ");
		String rut = leer.nextLine();
		double nota = 0;

		
		Map<String, Alumno> alumnos = alumnoServicio.listarAlumnos();

		
		Alumno alumno = alumnos.get(rut);

		if (alumno != null) {
			
			List<Materia> materias = new ArrayList<Materia>();
			materias = alumnoServicio.materiasPorAlumnos(alumno.getRut());
			if (materias.isEmpty()) {
				System.out.println("El alumno no tiene materias asignadas.");

			} else {
				System.out.println("\nAlumno tiene las siguientes materias agregadas: ");
				for (int i = 0; i < materias.size(); i++) {
					System.out.println("\n" + (i + 1) + ". " + materias.get(i).getNombre());
				}

				
				Utilidad.mostrarMensaje("\n\nSeleccionar materia:");
				int opcionMateria = leer.nextInt();
				leer.nextLine(); 

				if (opcionMateria < 1 || opcionMateria > materias.size()) {
					System.out.println("Opción inválida.");

				} else {
					
					Materia materiaSeleccionada = materias.get(opcionMateria - 1);

					
					do {
						System.out.print("\nIngrese Nota: ");
						nota = leer.nextDouble();
						leer.nextLine(); 
						if (nota < 0 || nota > 7) {
							System.out.println("La nota debe estar entre 0.0 - 7.0. Vuelva a ingresarla.");
						}
					} while (nota < 0.0 || nota > 7.0);

					
					materiaSeleccionada.getNotas().add(nota);

					System.out.println("\n\n--- ¡Nota agregada a " + materiaSeleccionada.getNombre() + "! ---");
				}

			}

		} else {
			System.out.println("\n--- ¡Alumno no encontrado! ---");
		}
		Utilidad.pausar();
		Utilidad.limpiarPantalla();
	}

	@Override
	public void exportarDatos() {
		Utilidad.limpiarPantalla();
		archivoServicio.exportarDatos(alumnoServicio.listarAlumnos());
		Utilidad.pausar();
		Utilidad.limpiarPantalla();
	}

	@Override
	public void terminarPrograma() {
		Utilidad.limpiarPantalla();
		System.out.println("Finalizando programa...");
	}
}
