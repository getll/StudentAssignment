package student;

/**
 *
 * @author Denmar Ermitano
 */
public class Test {
    public static void main(String[] args) {
        Course course1 = new Course("Programming1", 3, 95, 87);
        Course course2 = new Course("Programming2", 3, 95, 87);
        Course course3 = new Course("Programming3", 3, 95, 87);
        Student s1 = new Student("Denmar", "Male", "ermitano.den@gmail.com", course1, course2, course3);
        
        System.out.println(s1.isEmailValid(s1.getEmail()));
        
        //System.out.println(s1);
    }
    
}
