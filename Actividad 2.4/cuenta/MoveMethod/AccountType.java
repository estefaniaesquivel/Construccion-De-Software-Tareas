/*
public class AccountType {
    private boolean premium;

    public boolean isPremium() {
        return premium;
    }

    //el metodo fue movido aquí y recibe daysOverdrawn como parámetro
    public double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double result = 10;
            if (daysOverdrawn > 7) {
                result += (daysOverdrawn - 7) * 0.85;
            }
            return result;
        } else {
            return daysOverdrawn * 1.75;
        }
    }
}
 */



/*SIN REFACTORIZACION
public class AccountType {
    private boolean premium;

    public boolean isPremium() {
        return premium;
    }
}


 */