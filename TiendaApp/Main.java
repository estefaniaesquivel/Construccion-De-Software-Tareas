package tienda;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        inventario.agregar(new Producto("Laptop", 12000, 2.5));
        inventario.agregar(new Producto("Mouse", 250, 0.2));
        inventario.agregar(new Producto("Teclado", 600, 0.8));

        Cliente cliente = new Cliente("Ana Lopez", "Merida", 7);
        Pedido pedido = new Pedido(cliente, 12.0);

        pedido.agregarItem(inventario.buscarPorNombre("laptop"), 1);
        pedido.agregarItem(inventario.buscarPorNombre("mouse"), 2);
        pedido.agregarItem(inventario.buscarPorNombre("teclado"), 1);

        pedido.imprimirFactura();
        pedido.mostrarResumenImpuestos();

        System.out.println("Requiere revision: " + pedido.requiereRevision());
        System.out.println("Envio gratis: " + pedido.tieneEnvioGratis());
        System.out.println("Con 20% de descuento: " + pedido.aplicarDescuento(1000, 20));

        CalculadoraEnvio calc = new CalculadoraEnvio();
        System.out.println("Envio urgente: $" + calc.calcularCostoEnvio(pedido, 12.0, true));
    }
}
