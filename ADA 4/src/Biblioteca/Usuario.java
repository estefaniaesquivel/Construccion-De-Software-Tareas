package Biblioteca;
public class Usuario {
    private String nombreUsuario;
    private String correoUsuario;
    private int idUsuario;

    public Usuario(String nombreUsuario, String correoUsuario, int idUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.idUsuario = idUsuario;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void mostrarUsuario() {
    System.out.println("Usuario: " + nombreUsuario);
    System.out.println("Correo: " + correoUsuario);
    System.out.println("ID: " + idUsuario);
    }
    
}