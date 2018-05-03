package lambdaspt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class School {
  public static List<Student> getStudentsByCriterion(Iterable<Student> in,
                                               Predicate<Student> crit) {
    List<Student> rv = new ArrayList<>();
    for (Student s : in) {
      if (crit.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }
  public static Predicate<Student> getNameInFirstHalfOfAlphabetPredicate() {
    return s -> s.getName().charAt(0) <= 'M';
  }

  public static void showAll(Iterable<Student> in) {
    for(Student s : in) {
      System.out.println("> " + s);
    }
    System.out.println("--------------------");
  }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        new Student("Fred", 2.9F, "Art"),
        new Student("Jim", 3.9F, "Math", "Engineering"),
        new Student("Sheila", 3.8F, "Physics", "Quantum Mechanics", "Astrophysics")
    );
    showAll(roster);

    showAll(getStudentsByCriterion(roster, s -> s.getGpa() < 3));
    showAll(getStudentsByCriterion(roster, s -> s.getName().charAt(0) == 'J'));
    Predicate<Student> ps;
    ps = s -> s.getGpa() < 3;
    ps.test(new Student("Alfie", 2.2F, "Art"));
    showAll(getStudentsByCriterion(roster,
        getNameInFirstHalfOfAlphabetPredicate()));
  }
}
