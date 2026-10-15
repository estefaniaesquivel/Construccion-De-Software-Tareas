package tienda;

public class Producto {
    private String nombre;
    private double precio;
    private double pesoKg;

    public Producto(String nombre, double precio, double pesoKg) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoKg = pesoKg;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getPesoKg() { return pesoKg; }
}
