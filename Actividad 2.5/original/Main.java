/*
class Cliente {
    String nombre;
    String categoria; // "PREMIUM" o "ESTANDAR"
    int aniosAntiguedad;

}

class Pedido{
    Cliente cliente;
    double monto;

    double calcularDescuento(){
        if (cliente.categoria.equals("PREMIUM")) {
            if (cliente.aniosAntiguedad > 5) {
                return monto * 0.20;
            }
            return monto * 0.10;
        }
        return 0;
    }
    
    double total(){
        return monto - calcularDescuento();
    }
}

public class Main {

    public static void main(String[] args){
    //Caso 1: PREMIUM con más de 5 años (esperando desucneot 20%)
    Cliente c1 = new Cliente();
    c1.nombre = "Ana";
    c1.categoria = "PREMIUM";
    c1.aniosAntiguedad = 6;

    Pedido p1 = new Pedido();
    p1.cliente = c1;
    p1.monto = 1000;

    System.out.println("Caso 1 - descuento: " + p1.calcularDescuento() + " (esperado: 200.0)");
    System.out.println("Caso 1 - total: " + p1.total() + "/esperando:800.0)");

    //Caso 2: PREMIUM con 5 años o menos (10%)

    Cliente c2 = new Cliente();
    c2.nombre = "Luis";
    c2.categoria = "PREMIUM";
    c2.aniosAntiguedad = 3;

    Pedido p2 = new Pedido();
    p2.cliente = c2;
    p2.monto = 1000;

    System.out.println("Caso 2 - descuento: " + p2.calcularDescuento() + "(esperado: 100.0)");
    System.out.println("Caso 3 - total: " + p2.total() + "esperado: 900.0");
    
    //caso 3: ESTANDAR 0%
    Cliente c3 = new Cliente();
    c3.nombre = "Marta";
    c3.categoria = "ESTANDAR";
    c3.aniosAntiguedad = 10;

    Pedido p3 = new Pedido();
    p3.cliente = c3;
    p3.monto = 1000;

    System.out.println("Caso 2 - descuento: " + p3.calcularDescuento() + "(esperado: 0.0)");
    System.out.println("Caso 3 - total: " + p3.total() + "(esperado: 1000.0)");

    }
}
*/
