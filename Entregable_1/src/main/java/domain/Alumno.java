package domain;

import domain.Inscripcion;
import java.util.List;

public class Alumno {
    private List <Materia> materiasAprobadas;
    private Integer legajo;
    public Alumno(List<Materia> materias) {
        this.materiasAprobadas = materias;
    }

    public boolean tieneAprobadas(List <Materia> materias){
        return materiasAprobadas.containsAll(materias);
    }
}