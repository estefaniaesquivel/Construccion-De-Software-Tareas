/*REFAC
public class Report {
    public void createBillingPeriod(Date previousEnd) {
        //se invoca el método externo para simplificar el código
        Date newStart = nextDay(previousEnd);
        
    }

    //método externo (introduce foreign method)
    private static Date nextDay(Date arg) {
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    }
}

 */



/*SIN REFAC
public class Report {
    public void createBillingPeriod(Date previousEnd) {
        //código repetido en el cliente para calcular el día siguiente
        Date newStart = new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);
        
    }
}

 */
