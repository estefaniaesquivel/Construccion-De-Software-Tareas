package Biblioteca;

public class Libro {

    private String tituloLibro;
    private String autorLibro;
    private String isbnLibro;
    private int anioPublicacion;

    public Libro(String tituloLibro, String autorLibro, String isbnLibro, int anioPublicacion) {
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.isbnLibro = isbnLibro;
        this.anioPublicacion = anioPublicacion;
    }
    
    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public void mostrarLibro() {
        System.out.println("Título: " + tituloLibro);
        System.out.println("Autor: " + autorLibro);
        System.out.println("ISBN: " + isbnLibro);
        System.out.println("Año: " + anioPublicacion);
    }

}
