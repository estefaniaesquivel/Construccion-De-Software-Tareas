public class Menu {
    public static void main(String[] args) {
        
        Profesor prof = new Profesor();
        prof.setNombre("Daniel");
        prof.setApellidoPaterno("Baas");
        prof.setApellidoMaterno("Colonia");
        prof.setGradoAcademico("Ingeniero");
        prof.setNumeroEmpleado("EMP-01");

        
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Estefania");
        alumno1.setApellidoPaterno("Esquivel");
        alumno1.setApellidoMaterno("Bacelis");
        alumno1.setNumeroDeCuenta("21201099");

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Isaias");
        alumno2.setApellidoPaterno("Cetina");
        alumno2.setApellidoMaterno("Canul");
        alumno2.setNumeroDeCuenta("24216349");

       
        Grupo grupo = new Grupo();
        grupo.setProfesor(prof);
        grupo.agregarAlumno(alumno1);
        grupo.agregarAlumno(alumno2);

        
        Profesor profesor = grupo.getProfesor();
        System.out.println("INFORMACIÓN DEL GRUPO");
        System.out.println("Profesor: " + profesor.getGradoAcademico() + " " + profesor.getNombre() + " " + profesor.getApellidoPaterno() + " " + profesor.getApellidoMaterno());
        System.out.println("Nº Empleado: " + profesor.getNumeroEmpleado());

        System.out.println("\nLista de Alumnos");
        for (Alumno alumno : grupo.getAlumnos()) {
            System.out.println("- " + alumno.getNombre() + " " + alumno.getApellidoPaterno() + " " + alumno.getApellidoMaterno() + " | Cuenta: " + alumno.getNumeroDeCuenta());
        }
    }
}