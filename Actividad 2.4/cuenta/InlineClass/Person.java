/*REFAC
public class Person {
    private String name;
    private String areaCode;
    private String number;

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return ("(" + areaCode + ") " + number);
    }

    String getAreaCode() {
        return areaCode;
    }

    void setAreaCode(String arg) {
        areaCode = arg;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String arg) {
        number = arg;
    }
}

 */



/*SIN REFAC
public class Person {
    private String name;
    private TelephoneNumber officeTelephone = new TelephoneNumber();

    public String getName() {
        return name;
    }

    public String getTelephoneNumber() {
        return officeTelephone.getTelephoneNumber();
    }

    TelephoneNumber getOfficeTelephone() {
        return officeTelephone;
    }
}
 */

