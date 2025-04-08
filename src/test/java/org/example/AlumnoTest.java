package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {

    @Test
    @DisplayName("Test para comprobar que un alumno puede agregar una materia aprobada")
    public void PuedeAgregarMateriaAprobada() {
        Alumno alumno = new Alumno("Matias");
        Materia materia = new Materia("Algoritmos");

        alumno.agregarMateriaAprobada(materia);

        Assertions.assertTrue(alumno.getMateriasAprobadas().contains(materia));
    }

    @Test
    @DisplayName("Test para que un alumno inicie con lista de materias aprobadas vacía")
    public void listaVaciaAlInicio() {
        Alumno alumno = new Alumno("Carlos");
        Assertions.assertTrue(alumno.getMateriasAprobadas().isEmpty());
    }

}