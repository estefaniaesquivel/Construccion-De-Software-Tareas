package tienda;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemPedido> items = new ArrayList<>();
    private double distanciaKm;

    public Pedido(Cliente cliente, double distanciaKm) {
        this.cliente = cliente;
        this.distanciaKm = distanciaKm;
    }

    public Cliente getCliente() { return cliente; }
    public List<ItemPedido> getItems() { return items; }

    public void agregarItem(Producto producto, int cantidad) {
        items.add(new ItemPedido(producto, cantidad));
    }

    // REPLACE TEMP WITH QUERY
    public double calcularTotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal = subtotal + item.getProducto().getPrecio() * item.getCantidad();
        }

        double descuento = 0;
        if (subtotal > 1000) {
            descuento = subtotal * 0.10;
        } else {
            descuento = subtotal * 0.02;
        }

        return subtotal - descuento + subtotal * 0.16;
    }

    // SPLIT TEMPORARY VARIABLE
    public void mostrarResumenImpuestos() {
        double temp = 0;
        for (ItemPedido item : items) {
            temp = temp + item.getProducto().getPrecio() * item.getCantidad();
        }
        System.out.println("Subtotal: " + temp);

        temp = temp * 0.16;
        System.out.println("IVA: " + temp);
    }

    // INLINE TEMP
    public boolean requiereRevision() {
        double totalPedido = calcularTotal();
        return totalPedido > 5000;
    }

    // INTRODUCE EXPLAINING VARIABLE
    public boolean tieneEnvioGratis() {
        double sub = 0;
        for (ItemPedido item : items) {
            sub = sub + item.getProducto().getPrecio() * item.getCantidad();
        }
        if (cliente.getComprasRealizadas() > 5 && sub > 500
                || cliente.getCiudad().equals("Merida") && sub > 300 && items.size() > 2) {
            return true;
        }
        return false;
    }

    // REMOVE ASSIGNMENTS TO PARAMETERS
    public double aplicarDescuento(double monto, int porcentaje) {
        if (porcentaje > 50) {
            porcentaje = 50;
        }
        monto = monto - (monto * porcentaje / 100);
        return monto;
    }

    // EXTRACT METHOD
    public void imprimirFactura() {
        // Encabezado
        System.out.println("=============================");
        System.out.println("        FACTURA              ");
        System.out.println("=============================");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Ciudad: " + cliente.getCiudad());
        System.out.println("-----------------------------");

        // Detalle
        for (ItemPedido item : items) {
            double importe = item.getProducto().getPrecio() * item.getCantidad();
            System.out.println(item.getProducto().getNombre() + " x" + item.getCantidad()
                    + " = $" + importe);
        }
        System.out.println("-----------------------------");

        // Totales y envio
        CalculadoraEnvio calculadora = new CalculadoraEnvio();
        double envio = tieneEnvioGratis() ? 0 : calculadora.calcularCostoEnvio(this, distanciaKm, false);
        System.out.println("Envio: $" + envio);
        System.out.println("Total: $" + (calcularTotal() + envio));
        System.out.println("=============================");
    }
}
