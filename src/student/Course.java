package student;

/**
 *
 * @author Denmar Ermitano
 */
public class Course {
    private String courseName;
    private double credit;
    private double examScore;
    private double assignmentScore;

    /**
     * Default constructor
     */
    public Course() {
        this.courseName = null;
        this.credit = 0;
        this.examScore = 0;
        this.assignmentScore = 0;
    }
    
    /**
     * Constructor with the name of the course and the number of credits
     * @param courseName the name of the course
     * @param credit the amount of credits the course is worth
     */
    public Course(String courseName, double credit) {
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = 0;
        this.assignmentScore = 0;
    }

    /**
     * Constructor with all data members
     * @param courseName the name of the course
     * @param credit the amount of credits the course is worth
     * @param examScore the score obtained on the course exam
     * @param assignmentScore the score obtained on the course assignment
     */
    public Course(String courseName, double credit, double examScore, double assignmentScore) {
        this.courseName = courseName;
        this.credit = credit;
        this.examScore = examScore;
        this.assignmentScore = assignmentScore;
    }
    
    /**
     * Copy constructor
     * @param course the course to copy
     */
    public Course(Course course) {
        this.courseName = course.courseName;
        this.credit = course.credit;
        this.examScore = course.examScore;
        this.assignmentScore = course.assignmentScore;
    }
    
    /**
     * To calculate the final weighted score of the course
     * @return the final score of the course
     */
    public double calcFinalScore() {
        double examRatio = 0.6;
        double assignmentRatio = 0.4;
        
        return examRatio * examScore + assignmentRatio * assignmentScore;
    }
    
    /**
     * To check if the course is passed, the final score being 60 or higher
     * @return true if the student passed the course, false if they did not pass the course
     */
    public boolean isPassed() {
        int passingScore = 60;
        
        return calcFinalScore() >= passingScore;
    }
    
    /**
     * To compare two courses
     * @param course another course
     * @return true if both courses are the same, false if they are different
     */
    public boolean equals(Course course) {
        return this.courseName.equals(course.courseName) &&
                this.credit == course.credit &&
                this.examScore == course.examScore &&
                this.assignmentScore == course.assignmentScore;
    }
    
    /**
     * To generate a string to represent a course
     * @return the string representing the course
     */
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s : %s\n", "Course Name", courseName);
        str += String.format("%-20s : %.1f\n", "Credit", credit);
        str += String.format("%-20s : %.1f\n", "Exam Score", examScore);
        str += String.format("%-20s : %.1f\n", "Assignment Score", assignmentScore);
        str += String.format("%-20s : %.1f\n", "Final Score", calcFinalScore());
        
        return str;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getExamScore() {
        return examScore;
    }

    public void setExamScore(double examScore) {
        this.examScore = examScore;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }
}
