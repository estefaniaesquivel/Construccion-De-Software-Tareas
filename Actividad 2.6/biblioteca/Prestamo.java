package biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    //MOVE FIELD
    //Se trasladó el atributo "diasPlazoPrestamo" desde Socio hacia Prestamo.
    private int diasPlazoPrestamo;

    public Prestamo(Libro libro, Socio socio, Date fechaPrestamo, Date fechaDevolucion, int diasPlazoPrestamo) {
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.diasPlazoPrestamo = diasPlazoPrestamo;
    }

    public Libro getLibro() { return libro; }
    public Socio getSocio() { return socio; }
    public int getDiasPlazoPrestamo() { return diasPlazoPrestamo; }

    //INTRODUCE FOREIGN METHOD
    //se creó el método sumarDias que recibe Date como primer parámetro
    private static Date sumarDias(Date fecha, int dias) {
        return new Date(fecha.getTime() + dias * 24L * 60 * 60 * 1000);
    }

    public Date calcularFechaVencimiento() {
        // Usa directamente el atributo local diasPlazoPrestamo
        return sumarDias(fechaPrestamo, diasPlazoPrestamo);
    }

    public int calcularDiasRetraso() {
        return FechaBiblioteca.diasEntre(calcularFechaVencimiento(), fechaDevolucion);
    }

    //MOVE METHOD
    //Se movió la lógica a Libro.java y ahora Prestamo delega la llamada a Libro
    public double calcularMulta(int diasRetraso) {
        return libro.calcularMulta(diasRetraso);
    }

    //HIDE DELEGATE
    //método delegado para ocultar el objeto Socio 
    public String getCiudadSocio() {
        return socio.getCiudad();
    }
     //método delegado para ocultar el objeto Socio
    public String getTelefonoSocio() {
        return socio.getTelefono().obtenerTelefonoCompleto();
    }

    public void imprimirResumen() {
        System.out.println("Libro: " + libro.getTitulo());
        System.out.println("Socio: " + socio.getNombre());
        System.out.println("Prestado: " + FechaBiblioteca.formatearFecha(fechaPrestamo));
        System.out.println("Vence: " + FechaBiblioteca.formatearFecha(calcularFechaVencimiento()));
        System.out.println("Vence en fin de semana: " + FechaBiblioteca.esFinDeSemana(calcularFechaVencimiento()));
        System.out.println("Devuelto: " + FechaBiblioteca.formatearFecha(fechaDevolucion));
    }
}