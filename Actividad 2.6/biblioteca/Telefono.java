package biblioteca;

//SE CREO LA CLASE TELEFONO POR EL EXTRACT CLASS QUE SE HIZO EN SOCIO
public class Telefono {
    private String codigoArea;
    private String numero;

    public Telefono(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    public String obtenerTelefonoCompleto() {
        return "(" + codigoArea + ") " + numero;
    }

    public boolean esLocal() {
        return codigoArea.equals("999");
    }
}