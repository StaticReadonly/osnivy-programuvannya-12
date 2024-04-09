import java.util.*;
import java.util.stream.Stream;

class Student {
    String firstName;
    String lastName;
    int studentId;
    double averageScore;

    public Student(String firstName, String lastName, int studentId, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageScore = averageScore;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getStudentId() {
        return studentId;
    }
}

class Faculty {
    String name;
    List<Student> students;

    public Faculty(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Stream<Student> studentStream() {
        return students.stream();
    }
}

class Institute {
    String name;
    List<Faculty> faculties;

    public Institute(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public Stream<Student> getAllStudents() {
        return faculties.stream()
                .flatMap(Faculty::studentStream);
    }
}

public class Task_2 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("John", "Smith", 12345, 75.5),
                new Student("Alice", "Johnson", 23456, 85.0),
                new Student("Bob", "Williams", 34567, 70.25),
                new Student("Emily", "Brown", 45678, 60.75),
                new Student("David", "Jones", 56789, 92.3)
        );

        List<Faculty> faculties = Arrays.asList(
                new Faculty("FICT", Arrays.asList(students.get(0), students.get(1))),
                new Faculty("FAM", Arrays.asList(students.get(2), students.get(3), students.get(4)))
        );

        Institute institute = new Institute("KPI", faculties);

        institute.getAllStudents()
                .sorted(Comparator.comparing(Student::getLastName)
                        .thenComparing(Student::getFirstName)
                        .thenComparingInt(Student::getStudentId))
                .forEach(s -> System.out.println(s.lastName + " " + s.firstName + " - ID: " + s.studentId));
    }
}
