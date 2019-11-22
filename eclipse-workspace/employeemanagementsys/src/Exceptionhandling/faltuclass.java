/*import java.util.ArrayList;
import java.util.List;
 
public class Main {
public static void main(String[] args) {
 
    // Create an Empty List of Student, And add few objects to the List
    List<Student> students = new ArrayList<Student>();
    students.add(new Student("ST001", "James Smith", "james_smith@gmail.com", 23, 'A'));
    students.add(new Student("ST002", "Philip Duncan", "philip_duncan@gmail.com", 22, 'c'));
    students.add(new Student("ST003", "Patrick Fixler", "patrick_fixler@gmail.com", 25, 'b'));
    students.add(new Student("ST004", "Nancy Goto", "nancy_goto@gmail.com", 24, 'A'));
    students.add(new Student("ST005", "Maria Hong", "maria_hong@gmail.com", 22, 'e'));
 
    // Print the list objects in tabular format.
    System.out.println("-----------------------------------------------------------------------------");
    System.out.printf("%10s %30s %20s %5s %5s", "STUDENT ID", "EMAIL ID", "NAME", "AGE", "GRADE");
    System.out.println();
    System.out.println("-----------------------------------------------------------------------------");
    for(Student student: students){
        System.out.format("%10s %30s %20s %5d %5c",
                student.getId(), student.getEmailId(), student.getName(), student.getAge(), student.getGrade());
        System.out.println();
    }
    System.out.println("-----------------------------------------------------------------------------");
}
}*/