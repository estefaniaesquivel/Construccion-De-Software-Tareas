/*
public class Account {
    private AccountType type;
    private int daysOverdrawn;

    //account delega el calculo a AccountType pasándole su variable
    double overdraftCharge() {
        return type.overdraftCharge(daysOverdrawn);
    }

    double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += overdraftCharge();
        }
        return result;
    }
}

*/


/*  SIN REFACTORIZACION
public class Account {
    private AccountType type;//se asocian las clases por atributo de referencia
    private int daysOverdrawn;

    double overdraftCharge() { 
        // .type es un apuntador que guarda la dirección de un objeto 
        // ya creado (AccountType) para que puedas usar sus métodos
        if (type.isPremium()) { //<- aquí se ve que necesita refactorizar
        //ya que move method se requiere cuando un método es utilizado 
        // por más características de otra clase que de la clase 
        // en la que está definido, (ya que la logica de negocio de 
        // los sobregiros involucra más al tipo de cuenta, que solo a la cuenta)
            double result = 10;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        } else {
            return daysOverdrawn * 1.75;
        }
    }

    double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn > 0) {
            result += overdraftCharge();
        }
        return result;
    }
}



*/