package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {
    @Test
    @DisplayName("Test de una inscripcion exitosa para un alumno que cumple con las correlativas")
    public void inscripcionExitosaPorCorrelativasAprobadas() {

        Alumno unAlumno = new Alumno("Pepe");
        Materia am2 = new Materia("am2");
        Materia am1 = new Materia("am1");
        Materia aga = new Materia("aga");

        unAlumno.agregarMateriaAprobada(am1);
        unAlumno.agregarMateriaAprobada(aga);

        Inscripcion inscripcionPrimerCuatrimestre = new Inscripcion(unAlumno);
        inscripcionPrimerCuatrimestre.getMateriasInscriptas().add(am2);

        am2.agregarCorrelativa(am1);
        am2.agregarCorrelativa(aga);

        Assertions.assertTrue(inscripcionPrimerCuatrimestre.aprobada());
    }

    @Test
    @DisplayName("Test de una inscripcion rechazada para un alumno que no cumple con las correlativas")
    public void inscripcionRechazadaPorFaltaDeCorrelativas() {

        Alumno unAlumno = new Alumno("Matias");
        Materia ssoo = new Materia("ssoo");
        Materia arquitectura = new Materia("arquitectura");

        Inscripcion inscripcion = new Inscripcion(unAlumno);
        inscripcion.getMateriasInscriptas().add(ssoo);

        ssoo.agregarCorrelativa(arquitectura);

        Assertions.assertFalse(inscripcion.aprobada());
    }

    @Test
    @DisplayName("Test de una inscripcion exitosa para una materia sin correlativas")
    public void inscripcionAprobadaAMateriaSinCorrelativas() {
        Alumno unAlumno = new Alumno("ingresante");
        Materia ayed = new Materia("ayed");

        Inscripcion inscripcion = new Inscripcion(unAlumno);
        inscripcion.getMateriasInscriptas().add(ayed);

        Assertions.assertTrue(inscripcion.aprobada());
    }

}