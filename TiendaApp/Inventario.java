package tienda;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto producto) {
        productos.add(producto);
    }

    // SUBSTITUTE ALGORITHM
    public Producto buscarPorNombre(String nombre) {
        Producto encontrado = null;
        boolean hallado = false;
        int i = 0;
        while (i < productos.size() && hallado == false) {
            if (productos.get(i).getNombre().equalsIgnoreCase(nombre)) {
                encontrado = productos.get(i);
                hallado = true;
            }
            i = i + 1;
        }
        return encontrado;
    }
}
