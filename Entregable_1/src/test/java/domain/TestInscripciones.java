package domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestInscripciones {
    @Test
    public void aceptaInscripcionCaso1(){
        Materia materia1 = new Materia("materia1");
        Materia materia2 = new Materia("materia2");
        Materia materia3 = new Materia("materia3");
        Materia materia4 = new Materia("materia4");

        List<Materia> materiasCorrelativas = new ArrayList<>();
        materiasCorrelativas.add(materia1);
        materiasCorrelativas.add(materia2);
        materiasCorrelativas.add(materia3);

        materia4.setCorrelativas(materiasCorrelativas);

        Alumno alumno = new Alumno(materiasCorrelativas);

        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(materia4);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        Assert.assertTrue(inscripcion.aprobada());
    }
    @Test
    public void aceptaInscripcionCaso2() {
        Materia materia3 = new Materia("Materia3");
        Materia materia2 = new Materia("Materia2");
        materia2.agregarCorrelativa(materia3);
        Materia materia1 = new Materia("Materia1");
        materia1.agregarCorrelativa(materia2);

        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(materia2);
        materiasAprobadas.add(materia3);
        // Crear alumno
        Alumno alumno = new Alumno(materiasAprobadas);

        // Crear inscripción
        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(materia1);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        Assert.assertTrue(inscripcion.aprobada());
    }

    @Test
    public void noAceptaInscripcion() {
        Materia materia3 = new Materia("Materia3");
        Materia materia2 = new Materia("Materia2");
        Materia materia1 = new Materia("Materia1");

        materia1.agregarCorrelativa(materia2);
        materia2.agregarCorrelativa(materia3);

        // Solo aprobo materia 2
        List<Materia> materiasAprobadas = new ArrayList<>();
        materiasAprobadas.add(materia2);
        // Crear alumno
        Alumno alumno = new Alumno(materiasAprobadas);

        // Crear inscripción
        List<Materia> materiasInscripcion = new ArrayList<>();
        materiasInscripcion.add(materia1);

        Inscripcion inscripcion = new Inscripcion(alumno, materiasInscripcion);

        Assert.assertFalse(inscripcion.aprobada());
    }
}