/*REFAC
public class Person {
    private Department department;

    public Person getManager() {
        return department.getManager();
    }

    public void setDepartment(Department arg) {
        department = arg;
    }
}
 */


/*SIN REFAC
public class Person {
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department arg) {
        department = arg;
    }
}


*/