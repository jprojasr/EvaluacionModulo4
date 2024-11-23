package com.evaluacion.proyecto.principal.vistas;

import java.util.Scanner;

public class MenuTemplate {
	protected Scanner leer = new Scanner(System.in);

	public void iniciarMenu() {
		int opcion = 0;
		boolean salir = false;
		while(!salir){
			System.out.println("\n1. Crear Alumnos");
			System.out.println("\n2. Listar Alumnos");
			System.out.println("\n3. Agregar Materias");
			System.out.println("\n4. Agregar Notas");
			System.out.println("\n5. Salir");
			System.out.println("\n6. Exportar Datos");
			System.out.print("\nSelección: ");
			opcion = leer.nextInt();
			leer.nextLine(); 
			switch (opcion) {
			case 1:
				crearAlumno();
				break;
			case 2:
				listarAlumnos();
				break;
			case 3:
				agregarMateria();
				break;
			case 4:
				agregarNotaPasoUno();
				break;
			case 5:
				terminarPrograma();
				salir = true;
				break;
			case 6: 
				exportarDatos();	
				break;
			default:
				System.err.println("Opción inválida.");
				break;
			}
		}
	}

	public void crearAlumno() {
	}

	public void listarAlumnos() {
	}

	public void agregarMateria() {
	}

	public void agregarNotaPasoUno() {
	}

	public void exportarDatos() {
	}

	public void terminarPrograma() {
	}
}
