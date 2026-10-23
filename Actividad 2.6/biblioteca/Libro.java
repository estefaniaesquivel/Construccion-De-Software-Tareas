package biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;  //AL HACER INLINE CLASS SE NECESITABA BORRAR LA CLASE ISBN
    //Isbn ya estaba encapsulado con constructor y metodo de acceso así que no era necesario
    //solo se cambio de llamar a la clase a String
    private String categoria;       // "NOVEDAD" o "NORMAL"
    private double multaPorDia;
    private double valorReposicion;

    public Libro(String titulo, String autor, String isbn, String categoria,
                 double multaPorDia, double valorReposicion) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;//inline class
        this.categoria = categoria;
        this.multaPorDia = multaPorDia;
        this.valorReposicion = valorReposicion;
    }

    public double calcularMulta(int diasRetraso) {
        if (diasRetraso <= 0) return 0;
            double multa = diasRetraso * multaPorDia;
        if ("NOVEDAD".equals(categoria)) {
            multa *= 2;
        }
        if (multa > valorReposicion) {
            multa = valorReposicion;
        }
        return multa;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }//inline class
    public String getCategoria() { return categoria; }
    public double getMultaPorDia() { return multaPorDia; }
    public double getValorReposicion() { return valorReposicion; }
}
