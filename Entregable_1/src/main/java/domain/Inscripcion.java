package domain;

import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private Alumno alumno;
    private List<Materia> materias;

    public Inscripcion(Alumno alumno, List<Materia> materias) {
        this.alumno = alumno;
        this.materias = materias;
    }

    public boolean aprobada() {
        for (Materia materia : materias) {
            if (!tieneCorrelativasAprobadas(materia, alumno)) {
                return false;
            }
        }
        return true;
    }

    private boolean tieneCorrelativasAprobadas(Materia materia, Alumno alumno) {
        List<Materia> correlativas = materia.getCorrelativas();
        for (Materia correlativa : correlativas) {
            if (!alumno.tieneAprobadas(Collections.singletonList(correlativa)) || !tieneCorrelativasAprobadas(correlativa, alumno)) {
                return false;
            }
        }
        return true;
    }
}