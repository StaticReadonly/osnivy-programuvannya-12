import java.util.*;
import java.util.stream.Collectors;

class Enrollee {
    String surname;
    int points;

    public Enrollee(String surname, int points) {
        this.surname = surname;
        this.points = points;
    }
}

public class Task_1 {
    public static void main(String[] args) {
        List<Enrollee> enrollees = Arrays.asList(
                new Enrollee("Smith", 80),
                new Enrollee("Johnson", 90),
                new Enrollee("Williams", 70),
                new Enrollee("Brown", 50),
                new Enrollee("Jones", 65)
        );


        List<Enrollee> budgetEnrollees = enrollees.stream()
                .filter(e -> e.points >= 60)
                .sorted(Comparator.comparing(e -> e.surname))
                .toList();

        budgetEnrollees.forEach(e -> System.out.println(e.surname + ": " + e.points));
    }
}
