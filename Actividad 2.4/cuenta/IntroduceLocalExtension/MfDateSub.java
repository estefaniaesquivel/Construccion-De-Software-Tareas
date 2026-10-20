import java.util.Date;

//extensión local implementada como subclase
public class MfDateSub extends Date {
    
    public MfDateSub(String dateString) {
        super(dateString);
    }

    //constructor de conversión que recibe un objeto original como argumento
    public MfDateSub(Date arg) {
        super(arg.getTime());
    }

    //el método externo ahora forma parte natural de la extensión local
    public Date nextDay() {
        return new Date(getYear(), getMonth(), getDate() + 1);
    }
}