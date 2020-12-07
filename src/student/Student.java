package student;

/**
 *
 * @author Denmar Ermitano
 */
public class Student {
    private String name;
    private String gender;
    private String email;
    private Course course1;
    private Course course2;
    private Course course3;

    /**
     * Default constructor
     */
    public Student() {
        this.name = null;
        this.gender = null;
        this.email = null;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }

    /**
     * Constructor with the name, the gender and the email of the student
     * @param name the student's name
     * @param gender the student's gender
     * @param email the student's email
     */
    public Student(String name, String gender, String email) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = new Course();
        this.course2 = new Course();
        this.course3 = new Course();
    }

    /**
     * Constructor with all data members
     * @param name the student's name
     * @param gender the student's gender
     * @param email the student's email
     * @param course1 the student's first course
     * @param course2 the student's second course
     * @param course3 the student's third course
     */
    public Student(String name, String gender, String email,
            Course course1, Course course2, Course course3) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.course1 = course1;
        this.course2 = course2;
        this.course3 = course3;
    }
    
    /**
     * Copy constructor
     * @param student the student to copy
     */
    public Student(Student student) {
        this.name = student.name;
        this.gender = student.gender;
        this.email = student.email;
        this.course1 = new Course(student.course1);
        this.course2 = new Course(student.course2);
        this.course3 = new Course(student.course3);
    }
    
    /**
     * To calculate the number of passed courses
     * @return the number of passed courses
     */
    public int calcPassedCourseNum() {
        int numOfPassedCourses = 0;
        
        if (course1.isPassed())
            numOfPassedCourses++;
        if (course2.isPassed())
            numOfPassedCourses++;
        if (course3.isPassed())
            numOfPassedCourses++;
        
        return numOfPassedCourses;
    }
    
    /**
     * To calculate the total amount of credits earned
     * @return the amount of credits earned
     */
    public double calcTotalCredit() {
        double totalCredit = 0;
        
        if (course1.isPassed())
            totalCredit += course1.getCredit();
        if (course1.isPassed())
            totalCredit += course2.getCredit();
        if (course1.isPassed())
            totalCredit += course3.getCredit();
        
        return totalCredit;
    }
    
    /**
     * To check if the email is valid
     * @return true if the email is valid, false if the email is not valid
     */
    public boolean isEmailValid() {
        int idxOfAt = this.email.indexOf("@");
        int idxOfDot = this.email.lastIndexOf("."); //since you can have a . before the @
        int minDifference = 2;
        int length = this.email.length();
        int maxLength = 320;
        
        if (!this.email.contains("@") || !this.email.contains("."))
            return false;
        else if (idxOfAt > idxOfDot)
            return false;
        else if (idxOfAt == 0)
            return false;
        else if (idxOfDot - idxOfAt < minDifference)
            return false;
        else if (idxOfDot == length - 1)
            return false;
        else
            return (length <= maxLength);
    }
    
    /**
     * To compare two students
     * @param student another student
     * @return true if the students are the same, false if they are different
     */
    public boolean equals(Student student) {
        return this.name.equals(student.name) &&
                this.gender.equals(student.gender) &&
                this.email.equals(student.email) &&
                this.course1.equals(student.course1) &&
                this.course2.equals(student.course2) &&
                this.course3.equals(student.course3);
    }
    
    /**
     * To generate a string to represent a student, their courses included
     * @return the string representing a student
     */
    @Override
    public String toString() {
        String str = "";
        
        //general student information
        str += String.format("%-18s : %s\n", "Name", name);
        str += String.format("%-18s : %s\n", "Gender", gender);
        str += String.format("%-18s : %s\n\n", "Email", email);
        
        //student course information
        str += String.format("%-20s %-30s %-10s %-5s\n", "Course", "Name", "Credit", "Score");
        str += "--------------------------------------------------------------------\n";
        
        str += String.format("%-18s : %-30s %-10s %-5.1f\n", "Course 1",
                course1.getCourseName(), course1.getCredit(), course1.calcFinalScore());
        
        str += String.format("%-18s : %-30s %-10s %-5.1f\n", "Course 2",
                course2.getCourseName(), course2.getCredit(), course2.calcFinalScore());
        
        str += String.format("%-18s : %-30s %-10s %-5.1f\n\n", "Course 3",
                course3.getCourseName(), course3.getCredit(), course3.calcFinalScore());
        
        //student course totals
        str += String.format("%-18s : %d\n", "Passed Courses", calcPassedCourseNum());
        str += String.format("%-18s : %.1f\n", "Total Credits", calcTotalCredit());
        
        return str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Course getCourse1() {
        return course1;
    }

    public void setCourse1(Course course1) {
        this.course1 = course1;
    }

    public Course getCourse2() {
        return course2;
    }

    public void setCourse2(Course course2) {
        this.course2 = course2;
    }

    public Course getCourse3() {
        return course3;
    }

    public void setCourse3(Course course3) {
        this.course3 = course3;
    }
}
