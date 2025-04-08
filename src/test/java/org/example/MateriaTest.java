package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MateriaTest {
    @Test
    @DisplayName("Test para comprobar que una materia añade correlativas")
    public void materiaConCorrelativaAñadida() {
        Materia unaMateria = new Materia("Materia inicial");
        Materia materiaCorrelativa = new Materia("algoritmos");

        unaMateria.agregarCorrelativa(materiaCorrelativa);

        Assertions.assertTrue(!unaMateria.getCorrelativas().isEmpty());
        Assertions.assertEquals(unaMateria.getCorrelativas().size(), 1);
    }

    @Test
    @DisplayName("Test para comprobar que una materia inicia con lista vacia")
    public void listaVaciaDeMateriasCorrelativasAlInicio() {
        Materia unaMateria = new Materia("Materia inicial");

        Assertions.assertTrue(unaMateria.getCorrelativas().isEmpty());
        Assertions.assertEquals(unaMateria.getCorrelativas().size(), 0);
    }
}