package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materiasInscriptas;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        this.materiasInscriptas = new ArrayList<>();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Materia> getMateriasInscriptas() {
        return materiasInscriptas;
    }

    public boolean aprobada() {

        List<Materia> correlativasDeMateriasInscriptas = this.materiasInscriptas
                .stream()
                .flatMap(materia -> materia.getCorrelativas().stream())
                .collect(Collectors.toList());

        return correlativasDeMateriasInscriptas
                .stream()
                .allMatch(correlativa -> this.alumno.getMateriasAprobadas().contains(correlativa));
    }


}
