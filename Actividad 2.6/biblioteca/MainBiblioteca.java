package biblioteca;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainBiblioteca {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        //se borró la instancia de recepcion ya que era un MIDDLE MAN que se interponia en Catalogo, así que se borró la clase Recepcion y se quitaron sus instancias en el Main - REMOVE MIDDLE MAN

        //ahora en logar de usr recepcion.registrarLibro se usa directamente el metodo de catalogo - REMOVE MIDDLE MAN
        catalogo.agregar(new Libro("Java Basico", "R. Perez", "978-1-11111-111-1", "NOVEDAD", 5, 300));
        catalogo.agregar(new Libro("Estructuras de Datos", "M. Diaz", "978-2-22222-222-2", "NORMAL", 3, 400));
        System.out.println("Libros registrados: " + catalogo.total());

        //ahora se busca directamente en Catalogo , REMOVE MIDDLE MAN
        Libro libro = catalogo.buscarPorTitulo("java basico");

        //se puso instancia a la clase tel, EXTRACT CLASS
        Telefono telefono = new Telefono("999", "1234567");
        
        Socio socio = new Socio("Ana Lopez", "Merida", telefono);//el atributo diasPrestamo ya no está en socio, MOVE FIELD
        Date fechaPrestamo = new GregorianCalendar(2026, Calendar.OCTOBER, 1).getTime();
        Date fechaDevolucion = new GregorianCalendar(2026, Calendar.OCTOBER, 22).getTime();
       
        
        Prestamo prestamo = new Prestamo(libro, socio, fechaPrestamo, fechaDevolucion, 14); //diasPrestamo ahora está en el constructor de prestamo,MOVE FIELD

        System.out.println("-----------------------------");
        prestamo.imprimirResumen();
        System.out.println("-----------------------------");

        // HIDE DELEGATE
        System.out.println("Ciudad del socio: " + prestamo.getCiudadSocio());
        System.out.println("Telefono del socio: " + prestamo.getTelefonoSocio());
        System.out.println("Autor del libro: " + libro.getAutor());//aquí debía llamar a libro ya que el atributo autor no le correspone del todo a Prestamo

        int retraso = prestamo.calcularDiasRetraso();
        System.out.println("Dias de retraso: " + retraso);
        System.out.println("Multa: $" + prestamo.calcularMulta(retraso));
        System.out.println("ISBN: " + libro.getIsbn());
        System.out.println("Telefono local: " + socio.esTelefonoLocal());
    }
}