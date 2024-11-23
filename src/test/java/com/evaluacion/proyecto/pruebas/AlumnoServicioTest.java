package com.evaluacion.proyecto.pruebas;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.evaluacion.proyecto.principal.modelos.Alumno;
import com.evaluacion.proyecto.principal.modelos.Materia;
import com.evaluacion.proyecto.principal.modelos.MateriaEnum;
import com.evaluacion.proyecto.principal.servicios.AlumnoServicio;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;





@DisplayName("Test para la clase AlumnoServicio")
public class AlumnoServicioTest {
	

	AlumnoServicio alumnoServicioMock = mock(AlumnoServicio.class);
		  
    private Materia matematicas;

    private Materia lenguaje;

    private Alumno mapu;
    
    
    @BeforeEach
    public void setup() {
        
        MockitoAnnotations.openMocks(this);

        matematicas = new Materia(MateriaEnum.MATEMATICAS);
        lenguaje = new Materia(MateriaEnum.LENGUAJE);

        mapu = new Alumno("1.111.111-1", "Juan", "Perez", "Calle 123");

        when(alumnoServicioMock.materiasPorAlumnos("1.111.111-1"))
            .thenReturn(Arrays.asList(matematicas, lenguaje));

        when(alumnoServicioMock.listarAlumnos())
            .thenReturn(Collections.singletonMap(mapu.getRut(), mapu));
    }

    @Test
    public void crearAlumnoTest() {
        alumnoServicioMock.crearAlumno(mapu);

        verify(alumnoServicioMock, times(1)).crearAlumno(mapu);
    }


    @Test
    public void agregarMateriaTest() {

        alumnoServicioMock.agregarMateria(mapu.getRut(), matematicas.getNombre());
        alumnoServicioMock.agregarMateria(mapu.getRut(), lenguaje.getNombre());

        verify(alumnoServicioMock, times(1)).agregarMateria(mapu.getRut(), matematicas.getNombre());
        verify(alumnoServicioMock, times(1)).agregarMateria(mapu.getRut(), lenguaje.getNombre());
    }

    @Test
    public void materiasPorAlumnosTest() {

        List<Materia> materias = alumnoServicioMock.materiasPorAlumnos("1.111.111-1");

        assertEquals(2, materias.size(), "El alumno debe tener dos materias asignadas");
        assertEquals(matematicas, materias.get(0), "La primera materia debe ser Matemáticas");
        assertEquals(lenguaje, materias.get(1), "La segunda materia debe ser Lenguaje");

        verify(alumnoServicioMock, times(1)).materiasPorAlumnos("1.111.111-1");
    }

    @Test
    public void listarAlumnosTest() {

        Map<String, Alumno> listaAlumnos = alumnoServicioMock.listarAlumnos();

        assertEquals(1, listaAlumnos.size(), "Debe haber un alumno en la lista");
        assertEquals(mapu, listaAlumnos.get(mapu.getRut()), "El alumno debe coincidir con el mockeado");

        verify(alumnoServicioMock, times(1)).listarAlumnos();
    }
	
	
}
