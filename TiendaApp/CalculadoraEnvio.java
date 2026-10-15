package tienda;

public class CalculadoraEnvio {

    // REPLACE METHOD WITH METHOD OBJECT
    public double calcularCostoEnvio(Pedido pedido, double distanciaKm, boolean urgente) {
        double pesoTotal = 0;
        for (ItemPedido item : pedido.getItems()) {
            pesoTotal = pesoTotal + item.getProducto().getPesoKg() * item.getCantidad();
        }

        double costoBase = 30;
        double costoPorPeso = pesoTotal * 8;
        double costoPorDistancia = distanciaKm * 2.5;

        double recargo = 0;
        if (urgente) {
            recargo = (costoBase + costoPorPeso + costoPorDistancia) * 0.5;
        }

        double descuento = 0;
        if (pesoTotal < 1) {
            descuento = 10;
        }
        if (pedido.getCliente().esFrecuente()) {
            descuento = descuento + 15;
        }

        double total = costoBase + costoPorPeso + costoPorDistancia + recargo - descuento;
        if (total < 20) {
            total = 20;
        }
        return total;
    }
}
