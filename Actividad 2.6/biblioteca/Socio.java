package biblioteca;

public class Socio {
    private String nombre;
    private String ciudad;

    
    // EXTRACT CLASS
    //Se volvió clase TElefono, se borraron los atribtos relacionados a telefono que estaban en socio 
    //después se borro sus constructor de esos atributos y el metodo de accceso
    //luego las funciones del telefono ahora estan en Telefono y se delegó en la
    private Telefono telefono;

    //MOVE FIELD
    //Se eliminó el campo diasPlazoPrestamo de Socio ya que pertenecía al contexto de Prestamo.

    public Socio(String nombre, String ciudad, Telefono telefono) {
        //SE BORRARON LOS THIS DE LOS ATRIBUTOS DEL TEL
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono; 

    }

    public String getNombre() { 
        return nombre; 
    }

    public String getCiudad() { 
        return ciudad; 
    }

    public Telefono getTelefono() { 
        return telefono; 
    }

    public String obtenerTelefonoCompleto() { //delega al objeto Telefono
        return telefono.obtenerTelefonoCompleto();
    }

    public boolean esTelefonoLocal() { //delega al objeto Telefono
        return telefono.esLocal();
    }
}