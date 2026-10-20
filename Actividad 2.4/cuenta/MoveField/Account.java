/*
public class Account {
    private AccountType type;
    //el campo interestRate fue eliminado para moverse a AccountType

    public double interestForAmountAndDays(double amount, int days) {
        //account obtiene la tasa de interés consultando al tipo de cuenta
        return type.getInterestRate() * amount * days / 365;
    }
}
 */


/*SIN REFACTORIZACION

public class Account {
    //atributo de referencia que conecta la clase 
    //Account con la clase AccountType
    private AccountType type;

    private double interestRate; //campo candidato a ser movido
    //ya que la tasa de interés no es una característica 
    //aislada de una cuenta individual, sino una regla de negocio que 
    //pertenece al tipo de la cuenta (representada por AccountType)

    public double interestForAmountAndDays(double amount, int days) {
        return interestRate * amount * days / 365;
    }
}


 */

