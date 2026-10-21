class Cliente {
    String nombre;
    String categoria; // "PREMIUM" o "ESTANDAR"
    int aniosAntiguedad;

    /*se aplicó Move Method
    Se movió la lógica del cálculo del porcentaje de descuento desde la clase Pedido hacia Cliente
    Como se explicó en el word, las reglas dependen de la categoría y los años de antigüedad del cliente.
    */
    double calcularDescuento(double monto) {
        if (categoria.equals("PREMIUM")) {
            if (aniosAntiguedad > 5) {
                return monto * 0.20;
            }
            return monto * 0.10;
        }
        return 0;
    }
}

class Pedido{
    private Cliente cliente; //se oculta el acceso directo a Cliente
    double monto;

    //se usa Hide Delegate, que permite asignar el cliente sin acceder al atributo.
    //se creó un método de acceso asignarCliente que impide que el exterior (el Main)
    //acceda directamente al atributo "cliente",cumpliendo encapsulacion y protegiendo la informacion del Pedido
    void asignarCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    //el objeto Cliente actúa como servidor porque recibe la petición (cliente.calcularDescuento(monto)), 
    //y le devuelve el resultado al Pedido
    //Pedido actúa como cliente porque hace una petición (una llamada a un método) a otro objeto (cliente)
    //para que le resuelva el problema.
    //y de esa forma se cumple hide delegate ya que se creó un método de acceso al servidor para ocultar al objeto delegado

   

    //MOVE METHOD
    //dejamos la lógica del método calcularDescuento() en Pedido, ahora Pedido delega el cálculo del descuento a Cliente
    //la delegación hace que un método no ejecute la lógica por sí mismo, sino que le
    //pasa la responsabilidad (llama) a otro objeto para que la realice, algo así como se hace en replace method
    //with method object.
   
    //Pedido ya no decide cómo se calcula el descuento, únicamente le pide a Cliente que lo calcule y devuelve el resultado
    //la clase Pedido delega el calculo a la clase Cliente pasándole su variable monto
    double calcularDescuento() {
        return cliente.calcularDescuento(monto);//cliente es el objeto delegado que antes estaba expuesto
    }

    double total() {
        return monto - calcularDescuento();
    }
}

public class Main {
    public static  void main(String[] args){
        //Caso 1: PREMIUM con más de 5 años (esperado descuento 20%)

        //aunque no tiene que ver con movimiento de funciones, se renombraron
        //las variables c1,c2,c3,p1,p2,p3 ya que las variables no llevan numeros y deben ser descriptivas
        Cliente clienteAna = new Cliente();
        clienteAna.nombre = "Ana";
        clienteAna.categoria = "PREMIUM";
        clienteAna.aniosAntiguedad = 6;

        Pedido pedidoAna = new Pedido();
        pedidoAna.asignarCliente(clienteAna); //se cambio
        pedidoAna.monto = 1000;

        System.out.println("Caso 1 - descuento: " + pedidoAna.calcularDescuento() + " (esperado: 200.0)");
        System.out.println("Caso 1 - total: " + pedidoAna.total() + "(esperado:800.0)");

        //Caso 2: PREMIUM con 5 años o menos (esperado descuento 10%)
        Cliente clienteLuis = new Cliente();
        clienteLuis.nombre = "Luis";
        clienteLuis.categoria = "PREMIUM";
        clienteLuis.aniosAntiguedad = 3;

        Pedido pedidoLuis = new Pedido();
        pedidoLuis.asignarCliente(clienteLuis);//se cambio
        pedidoLuis.monto = 1000;

        System.out.println("Caso 2 - descuento: " + pedidoLuis.calcularDescuento() + "(esperado: 100.0)");
        System.out.println("Caso 2 - total: " + pedidoLuis.total() + "(esperado: 900.0)");

        // Caso 3: ESTANDAR (esperado descuento 0)
        Cliente clienteMarta = new Cliente();
        clienteMarta.nombre = "Marta";
        clienteMarta.categoria = "ESTANDAR";
        clienteMarta.aniosAntiguedad = 10;

        Pedido pedidoMarta = new Pedido();
        pedidoMarta.asignarCliente(clienteMarta);//se cambio
        pedidoMarta.monto = 1000;

        System.out.println("Caso 3 - descuento: " + pedidoMarta.calcularDescuento() + "(esperado: 0.0)");
        System.out.println("Caso 3 - total: " + pedidoMarta.total() + "(esperado: 1000.0)");
    }
}