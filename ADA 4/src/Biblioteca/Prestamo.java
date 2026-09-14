package Biblioteca;

public class Prestamo {
    private String fechaPrestamo;
    private String fechaDevolucion;
    private double multaPorDia;
    private int diasRetraso;

    public Prestamo(String fechaPrestamo, String fechaDevolucion, double multaPorDia, int diasRetraso) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.multaPorDia = multaPorDia;
        this.diasRetraso = diasRetraso;
    }
    
    public void mostrarPrestamo() {
        System.out.println("Préstamo: " + fechaPrestamo);
        System.out.println("Devolución: " + fechaDevolucion);
    }

    public double calcularMulta() {
        return multaPorDia * diasRetraso;
    }

    public void aplicarMulta() {
        double total = calcularMulta();
        System.out.println("Multa total: $" + total);
    }
    

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMultaPorDia() {
        return multaPorDia;
    }

    public void setMultaPorDia(double multaPorDia) {
        this.multaPorDia = multaPorDia;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    
}
