import java.util.*;

public class Task_3 {
    public static void main(String[] args) {
        List<Enrollee> enrollees = Arrays.asList(
                new Enrollee("Smith", 80),
                new Enrollee("Johnson", 90),
                new Enrollee("Williams", 70),
                new Enrollee("Brown", 50),
                new Enrollee("Jones", 65)
        );

        List<Enrollee> failedEnrollees = enrollees.stream()
                .filter(e -> e.points < 60)
                .toList();

        failedEnrollees.forEach(e -> System.out.println(e.surname + ": " + e.points));
    }
}
