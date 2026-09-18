public class Profesor {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String gradoAcademico;
    private String numeroEmpleado;

    public Profesor() {
    }

    public Profesor(String nombre, String apellidoPaterno, String apellidoMaterno, String gradoAcademico, String numeroEmpleado) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.gradoAcademico = gradoAcademico;
        this.numeroEmpleado = numeroEmpleado;
    }

    @Override
    public String toString() {
        return "Grado Académico: " + gradoAcademico + " nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + " Numero de empleado: " + numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(String gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }
}