/**
public class SistemaPedidos {

    public static void main(String[] args) {
        SistemaPedidos sistema = new SistemaPedidos();
        sistema.procesarPedido("CLIENTE_VIP", 1500.0, true, "MEXICO");
    }

    public void procesarPedido(String tipoCliente, double montoTotal, boolean esDiaEspecial, String destino) {
        double descuento = 0.0;
        double costoEnvio = 0.0;
        boolean aprobado = false;

        if (montoTotal > 0) {
            if (tipoCliente != null) {
                if (tipoCliente.equals("REGULAR")) {
                    if (montoTotal > 1000) {
                        descuento = montoTotal * 0.05;
                    } else {
                        descuento = 0.0;
                    }
                } else {
                    if (tipoCliente.equals("VIP")) {
                        if (montoTotal > 2000) {
                            descuento = montoTotal * 0.20;
                        } else {
                            if (montoTotal > 1000) {
                                descuento = montoTotal * 0.15;
                            } else {
                                descuento = montoTotal * 0.10;
                            }
                        }
                    } else {
                        if (tipoCliente.equals("NUEVO")) {
                            descuento = 50.0;
                        }
                    }
                }

                if (esDiaEspecial) {
                    descuento = descuento + (montoTotal * 0.05);
                }

                if (destino.equals("LOCAL")) {
                    costoEnvio = 50.0;
                } else if (destino.equals("NACIONAL") || destino.equals("MEXICO")) {
                    if (montoTotal > 1500) {
                        costoEnvio = 0.0;
                    } else {
                        costoEnvio = 150.0;
                    }
                } else if (destino.equals("INTERNACIONAL")) {
                    if (montoTotal > 3000) {
                        costoEnvio = 100.0;
                    } else {
                        costoEnvio = 500.0;
                    }
                }

                double totalFinal = montoTotal - descuento + costoEnvio;

                if (totalFinal > 0) {
                    aprobado = true;
                }

                if (aprobado == true) {
                    System.out.println("=== RESUMEN DE COMPRA ===");
                    System.out.println("Monto Base: $" + montoTotal);
                    System.out.println("Descuento Aplicado: $" + descuento);
                    System.out.println("Costo de Envío: $" + costoEnvio);
                    System.out.println("Total a Pagar: $" + totalFinal);
                    System.out.println("Estado: APROBADO");
                } else {
                    System.out.println("Error en la transacción.");
                }
            } else {
                System.out.println("Tipo de cliente inválido.");
            }
        } else {
            System.out.println("El monto debe ser mayor a cero.");
        }
    }
}
*/