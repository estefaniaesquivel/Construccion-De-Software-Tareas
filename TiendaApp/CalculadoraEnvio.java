package tienda;

public class CalculadoraEnvio {



    // REPLACE METHOD WITH METHOD OBJECT

    //consideramos que lo mejor es remplazar las variables temporales por atributos de la clase
    //ya que no se puede aplicar extract method por las dependencias (si se intenta extraer)
    //lo que pasaría tendrias que pasar como parametro todas esas variables
    /*Como dice en la diapo lo quepide replace method withh object
    Solución: 
    Este detalle se resuelve convirtiendo el método en su propio
    objeto, de manera que todas las variables locales se
    conviertan en atributos de ese objeto*/

    //los parametros originales ahora son atributos
    private final Pedido pedido;
    private final double distanciaKm;
    private final boolean urgente;

    //y ahora las variables temporales ahora son atributos de la clase
    private double pesoTotal;
    private double costoBase = 30;
    private double costoPorPeso;
    private double costoPorDistancia;
    private double recargo = 0;
    private double descuento = 0;



    //faltaba constructor
    public CalculadoraEnvio(Pedido pedido, double distanciaKm, boolean urgente) {
        this.pedido = pedido;
        this.distanciaKm = distanciaKm;
        this.urgente = urgente;
    }

    //aqui empiezan los metodos extraidos (EXTRACT METHOD)
    public double calcular() {
        calcularPesoTotal();
        calcularCostos();
        calcularRecargo();
        calcularDescuento();
        return calcularTotalFinal();
    }

    private void calcularPesoTotal() {
        pesoTotal = 0;
        for (ItemPedido item : pedido.getItems()) {
            pesoTotal += item.getProducto().getPesoKg() * item.getCantidad();
        }
    }

    private void calcularCostos() {
        costoPorPeso = pesoTotal * 8;
        costoPorDistancia = distanciaKm * 2.5;
    }

    private void calcularRecargo() {
        if (urgente) {
            recargo = (costoBase + costoPorPeso + costoPorDistancia) * 0.5;
        }
    }

    private void calcularDescuento() {
        if (pesoTotal < 1) {
            descuento = 10;
        }
        if (pedido.getCliente().esFrecuente()) {
            descuento += 15;
        }
    }

    private double calcularTotalFinal() {
        double total = costoBase + costoPorPeso + costoPorDistancia + recargo - descuento;
        return Math.max(total, 20); // Aplica el mínimo de 20
    }

    //Ahora la funcion principal se reduce a esta chica:
    public double calcularCostoEnvio(Pedido pedido, double distanciaKm, boolean urgente) {
        return new CalculadorCostoEnvio(pedido, distanciaKm, urgente).calcular();
    }




}
