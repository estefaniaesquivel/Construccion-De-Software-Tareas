package tienda;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    // SUBSTITUTE ALGORITHM
    /*
    Los cambios que se hicieron fueron que se eliminaron las siguientes variables:
    Producto encontrado = null
    boolean hallado = false
    int i
    Se reemplazó el ciclo while utilizando las variables ya eliminadas por un ciclo for que
    analice cada producto de la lista de productos, de esta manera si se cumple la condición
    se retorna el producto, de otra manera, si no se cumple retorna simplemente a null.
     */
    public Producto buscarPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
}
