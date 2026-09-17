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
 * para los tipos de cliente y su respectivo descuento se creó la variable descuentoBase asignada al switch  
 * 
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
        //se quitó if (totalFinal > 0) { aprobado = true; ya que no ayuda en nada
        //guardar un estado intermedio cuando se puede evaluar totalFinal > 0 directamente
        if (totalFinal > 0) {
            imprimirResumen(montoTotal, descuento, costoEnvio, totalFinal);
        } else {
            System.out.println("Error en la transacción.");
        }
    }

    // método para calcular el descuento, ya que se diviio procesarPedido en otras funciones, se cumple
    //el principio de responsabilidad unica
    //El tipo de switch que se asigna a una variable se conoce 
    //como switch expression, y su sintaxis utiliza flechas (->)
    private double calcularDescuento(String tipoCliente, double montoTotal, boolean esDiaEspecial) {
        double descuentoBase = switch (tipoCliente) { //se usa un switch que evalúa la variable tipoCliente y asigna el resultado directamente a descuentoBase
            case "REGULAR" -> (montoTotal > 1000) ? montoTotal * 0.05 : 0.0; //si la compra supera $1000, asigna un 5% de descuento, de lo contrario, asigna $0
            //yield es una palabra reservada en Java que se usa dentro de una switch expression
            //para devolver un valor, deteniendo la evaluación de ese caso en particular.
            //un return o break se saldría de todo el método. En cambio yield solo sale del switch, 
            // depositando el valor directamente en la variable descuentoBase
            case "CLIENTE_VIP" -> {
                if (montoTotal > 2000) yield montoTotal * 0.20; //si cumple, entrega este valor y sale del switch
                if (montoTotal > 1000) yield montoTotal * 0.15;
                yield montoTotal * 0.10; //si no cumplió ninguna, entrega este último
            }
            case "NUEVO" -> 50.0;
            default -> 0.0; //si el tipo de cliente no coincide con ningún caso anterior, el descuento base es $0
        };

        if (esDiaEspecial) {
            descuentoBase += (montoTotal * 0.05); //toma el valor de descuentoBase que se calculo en el switch y le suma al descuento un 5% del montoTotal
        }

        return descuentoBase;
    }

    // simplificación de las estructuras condicionales usando switch
    private double calcularCostoEnvio(String destino, double montoTotal) {
        //aquí hay otra claúsula de guarda
        if (destino == null){ //sino se especifica el destino ya no se ejecuta, devuelve 0.0 ya que como es double así lo exige el método
            return 0.0;
        } 
        //el switch devuelve (return) directamente el valor que resulte de la coincidencia
        //así se puede ahorrar declarar la variable costo
        return switch (destino) {
            case "LOCAL" -> 50.0;
            case "NACIONAL", "MEXICO" -> (montoTotal > 1500) ? 0.0 : 150.0; //si se cumple que el total es más de 1500 el envio es gratis, si no son 150
            case "INTERNACIONAL" -> (montoTotal > 3000) ? 100.0 : 500.0; //si es más de 3000 cobra 100, si no cuesta 500
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