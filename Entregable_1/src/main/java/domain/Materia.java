package domain;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List <Materia> correlativas;

    public Materia(String nombre) {
        this.nombre = nombre;
        this.correlativas = new ArrayList<>();
    }
    public void agregarCorrelativa(Materia materia) {
        correlativas.add(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorrelativas(List<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public List<Materia> getCorrelativas() {
        return this.correlativas;
    }
}

