package com.evaluacion.proyecto.principal.utilidades;



public class Utilidad {

	public static void limpiarPantalla() {
       
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        	System.err.println("Error: " + e);
        }
    }
}
