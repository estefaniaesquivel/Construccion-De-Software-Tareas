package Biblioteca;

public class Main {
    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario("Estefania", "a21201099@alumnos.uady.com", 21201099);
        Libro libro = new Libro("CleanCode", "Robert C", "12345", 2009);
        Prestamo prestamo = new Prestamo("14-09-26", "01-10-20", 50, 2);
        
        usuario.mostrarUsuario();
        libro.mostrarLibro();
        prestamo.mostrarPrestamo();
        prestamo.aplicarMulta();

    }
}
