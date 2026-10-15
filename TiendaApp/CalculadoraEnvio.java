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


    //igualmente cambiamos los numeros magicos

    private static final double TARIFA_PESO = 8.0;
    private static final double TARIFA_DISTANCIA = 2.5;

    private static final double RECARGO_URGENTE = 0.50;

    private static final double MIN_PESO_DESCUENTO = 1.0;
    private static final double DESC_PESO_LIGERO = 10.0;
    private static final double DESC_CLIENTE_FRECUENTE = 15.0;

    private static final double COSTO_MINIMO = 20.0;



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
        costoPorPeso = pesoTotal * TARIFA_PESO;
        costoPorDistancia = distanciaKm * TARIFA_DISTANCIA;
    }

    private void calcularRecargo() {
        if (urgente) {
            recargo = (costoBase + costoPorPeso + costoPorDistancia) * RECARGO_URGENTE;
        }
    }

    private void calcularDescuento() {
        if (pesoTotal < MIN_PESO_DESCUENTO) {
            descuento = DESC_PESO_LIGERO;
        }
        if (pedido.getCliente().esFrecuente()) {
            descuento += DESC_CLIENTE_FRECUENTE;
        }
    }

    private double calcularTotalFinal() {
        double total = costoBase + costoPorPeso + costoPorDistancia + recargo - descuento;
        return Math.max(total, COSTO_MINIMO); // Aplica el mínimo de 20
    }

    //Ahora la funcion principal se reduce a esta chica:
    public double calcularCostoEnvio(Pedido pedido, double distanciaKm, boolean urgente) {
        return new CalculadorCostoEnvio(pedido, distanciaKm, urgente).calcular();
    }




}
