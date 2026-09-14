/**
 * descomposicion de procedimientos: se cumple dividiendo el método procesarPedido 
 * en metodos como calcularDescuento(), calcularCostoEnvio(), imprimirResumen()
 * se dividió el método procesarPedido y lo dividimos en esos tres métodos privados 
 * 
 * cláusulas de guarda: se logra colocando validaciones al inicio de 
 * procesarPedido con montoTotal <= 0, tipoCliente == null 
 * 
 * simplificación condicional: Se logra cambiando los if-else anidados 
 * por switch expressions (o switch estándar) dentro de los nuevos métodos
 * 
 * eliminar banderas booleanas: se logra eliminando la variable aprobado
 * 
 */


public class SistemaPedidos {

    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
       
        sistema.procesarPedido("CLIENTE_VIP", 1500.0, true, "MEXICO");
    }

    public void procesarPedido(String tipoCliente, double montoTotal, boolean esDiaEspecial, String destino) {
        // cláusulas de guarda 
        if (montoTotal <= 0) {
            System.out.println("El monto debe ser mayor a cero.");
            return;
        }

        if (tipoCliente == null) {
            System.out.println("Tipo de cliente inválido.");
            return;
        }

        
        double descuento = calcularDescuento(tipoCliente, montoTotal, esDiaEspecial); //descomposicion de procedimiento
        double costoEnvio = calcularCostoEnvio(destino, montoTotal); //descomposicion de procedimiento
        double totalFinal = montoTotal - descuento + costoEnvio; //descomposicion de procedimiento
        //son double porque trabajan con el total del descuento calculado
        //estos atributos están dentro de procesarPedido porque el método es como un coordinador principal de la operacion

        // sin banderas booleanas
        if (totalFinal > 0) {
            imprimirResumen(montoTotal, descuento, costoEnvio, totalFinal);
        } else {
            System.out.println("Error en la transacción.");
        }
    }

    // método para calcular el descuento, ya que se diviio procesar pedido en otras funciones, se cumple
    //el principio de responsabilidad unica
    private double calcularDescuento(String tipoCliente, double montoTotal, boolean esDiaEspecial) {
        double descuentoBase = switch (tipoCliente) {
            case "REGULAR" -> (montoTotal > 1000) ? montoTotal * 0.05 : 0.0;
            case "CLIENTE_VIP" -> {
                if (montoTotal > 2000) yield montoTotal * 0.20;
                if (montoTotal > 1000) yield montoTotal * 0.15;
                yield montoTotal * 0.10;
            }
            case "NUEVO" -> 50.0;
            default -> 0.0;
        };

        if (esDiaEspecial) {
            descuentoBase += (montoTotal * 0.05);
        }

        return descuentoBase;
    }

    // simplificación de las estructuras condicionales usando switch
    private double calcularCostoEnvio(String destino, double montoTotal) {
        if (destino == null) return 0.0;

        return switch (destino) {
            case "LOCAL" -> 50.0;
            case "NACIONAL", "MEXICO" -> (montoTotal > 1500) ? 0.0 : 150.0;
            case "INTERNACIONAL" -> (montoTotal > 3000) ? 100.0 : 500.0;
            default -> 0.0;
        };
    }

    // resultado en la consola
    private void imprimirResumen(double montoBase, double descuento, double costoEnvio, double totalFinal) {
        System.out.println("=== RESUMEN DE COMPRA ===");
        System.out.println("Monto Base: $" + montoBase);
        System.out.println("Descuento Aplicado: $" + descuento);
        System.out.println("Costo de Envío: $" + costoEnvio);
        System.out.println("Total a Pagar: $" + totalFinal);
        System.out.println("Estado: APROBADO");
    }
}