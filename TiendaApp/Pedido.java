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
    private double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal = subtotal + item.getProducto().getPrecio() * item.getCantidad();
        }
        return subtotal;
    }

    public double calcularTotal() {
        double subtotal = calcularSubtotal();
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
    //Se hizo cambio el return ya que era innecesaria la variable temporal
    public boolean requiereRevision() {
<<<<<<< HEAD
 
=======

>>>>>>> 91f54eb1d9fbbce7f32d394f31d98f9a4166aeb7
        return calcularTotal > 5000;
    }

    // INTRODUCE EXPLAINING VARIABLE
    // Problema: La condición para determinar el envío gratuito contenía una expresión booleana compleja y difícil de interpretar a simple vista.
    // REFACTOR: Se introdujeron variables explicativas (esClienteFrecuenteValido y esEnvioLocalMeridaValido) para descomponer la lógica en reglas de negocio claras.
    public boolean tieneEnvioGratis() {
        double sub = 0;
        for (ItemPedido item : items) {
            sub = sub + item.getProducto().getPrecio() * item.getCantidad();
        }

        boolean esClienteFrecuenteValido = cliente.getComprasRealizadas() > 5 && sub > 500;
        boolean esEnvioLocalMeridaValido = cliente.getCiudad().equals("Merida") && sub > 300 && items.size() > 2;

        return esClienteFrecuenteValido || esEnvioLocalMeridaValido;
    }

    /* REMOVE ASSIGNMENTS TO PARAMETERS
    Se reasignaban valores directamente a los parámetros de entrada (porcentaje y monto),pero consideramos que es una mala 
    práctica porque destruye el valor original pasado por la llamada. Para solucionarlo, se crearon variables locales 
    (porcentajeEfectivo y montoFinal) que realizan las modificaciones y cálculos de forma segura sin alterar las variables originales.
    */
    public double aplicarDescuento(double monto, int porcentaje) {
        int porcentajeEfectivo = porcentaje;
        if (porcentajeEfectivo > 50) {
            porcentajeEfectivo = 50;
        }

        double montoFinal = monto - (monto * porcentajeEfectivo / 100.0);
        return montoFinal;
    }

    /* EXTRACT METHOD
    dado a que el método por sí solo, imprime todos los resultados, se crearon tres funciones más,
    donde cada funcion realiza una impresión específica de cada cosa, se extrajo las secciones del
    reporte en métodos auxiliares, quedando los 3 métodos que se llaman en imprimirFactura*/
    public void imprimirFactura() {
        imprimirEncabezado();
        imprimirDetalle();
        imprimirTotales();
    }

    private void imprimirEncabezado() {
        System.out.println("=============================");
        System.out.println("         FACTURA             ");
        System.out.println("=============================");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Ciudad: " + cliente.getCiudad());
        System.out.println("-----------------------------");
    }

    private void imprimirDetalle() {
        for (ItemPedido item : items) {
            double importe = item.getProducto().getPrecio() * item.getCantidad();
            System.out.println(item.getProducto().getNombre() + " x" + item.getCantidad()
                    + " = $" + importe);
        }
        System.out.println("-----------------------------");
    }

    private void imprimirTotales() {
        CalculadoraEnvio calculadora = new CalculadoraEnvio();
        double envio = tieneEnvioGratis() ? 0 : calculadora.calcularCostoEnvio(this, distanciaKm, false);
        System.out.println("Envio: $" + envio);
        System.out.println("Total: $" + (calcularTotal() + envio));
        System.out.println("=============================");
    }
}
