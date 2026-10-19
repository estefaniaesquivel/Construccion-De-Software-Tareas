package tienda;

/**
 * Representa un producto disponible en el catálogo de la tienda.
 * Contiene información de identificación, precio y peso para cálculos de envío.
 */
public class Producto {
    private String nombre;
    private double precio;
    private double pesoKg;

    /**
     * Construye una nueva instancia de Producto.
     *
     * @param nombre nombre descriptivo del producto
     * @param precio precio unitario del producto
     * @param pesoKg peso del producto en kilogramos
     */
    public Producto(String nombre, double precio, double pesoKg) {
        this.nombre = nombre;
        this.precio = precio;
        this.pesoKg = pesoKg;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre del producto
     */
    public String getNombre() { return nombre; }

    /**
     * Obtiene el precio unitario del producto.
     *
     * @return precio unitario
     */
    public double getPrecio() { return precio; }

    /**
     * Obtiene el peso del producto en kilogramos.
     *
     * @return peso en kilogramos
     */
    public double getPesoKg() { return pesoKg; }
}
