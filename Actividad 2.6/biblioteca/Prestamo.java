package biblioteca;

import java.util.Date;

public class Prestamo {
    private Libro libro;
    private Socio socio;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    // [TÉCNICA SUGERIDA] Move Field
    // REFACTOR: Se trasladó el atributo 'diasPlazoPrestamo' desde Socio hacia Prestamo.
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

    // [TÉCNICA SUGERIDA] Introduce Foreign Method
    // REFACTOR: Se creó el método auxiliar sumarDias que recibe Date como primer parámetro.
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

    // [TÉCNICA SUGERIDA] Move Method
    // REFACTOR: Se movió la lógica a Libro.java y ahora Prestamo delega la llamada a Libro.
    public double calcularMulta(int diasRetraso) {
        return libro.calcularMulta(diasRetraso);
    }

    // [TÉCNICA SUGERIDA] Hide Delegate
    // REFACTOR: Métodos delegados para ocultar el objeto Socio a los clientes.
    public String getCiudadSocio() {
        return socio.getCiudad();
    }

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