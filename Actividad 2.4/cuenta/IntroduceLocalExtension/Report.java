import java.util.Date;

public class Report {
    public void createBillingPeriod(MfDateSub previousEnd) {
        //se utiliza directamente la extensión local con su nuevo método integrado
        Date newStart = previousEnd.nextDay();
    }
}

/*SIN REFAC

import java.util.Date;

public class Report {
    public void createBillingPeriod(Date previousEnd) {
        //metodo externo utilizado para calcular la siguiente fecha
        Date newStart = nextDay(previousEnd);
    }

    private static Date nextDay(Date arg) {

        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    }
}
 */

