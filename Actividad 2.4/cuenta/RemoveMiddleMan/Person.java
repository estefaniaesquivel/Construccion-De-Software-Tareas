/*
public class Person {
    private Department department;

    //se expone el objeto delegado mediante su getter
    public Department getDepartment() {
        return department;
    }
}

 */


/*SIN REFAC
public class Person {
    private Department department;

    //metodo intermediario de delegación simple
    public Person getManager() {
        return department.getManager();
    }
}
 */