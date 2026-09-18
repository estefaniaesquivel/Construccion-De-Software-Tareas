import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private Profesor profesor;
    private List<Alumno> alumnos;

    public Grupo() {
        this.alumnos = new ArrayList<>();
    }

    public Grupo(Profesor profesor, List<Alumno> alumnos) {
        this.profesor = profesor;
        this.alumnos = alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }
}