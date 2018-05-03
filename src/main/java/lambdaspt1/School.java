package lambdaspt1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

class SmartCriterion implements StudentCriterion {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3;
  }
}

class EnthusiasmCriterion implements StudentCriterion {
  @Override
  public boolean test(Student s) {
    return s.getClasses().size() > 2;
  }
}

public class School {
  public static List<Student> getStudentsByCriterion(Iterable<Student> in,
                                               StudentCriterion crit) {
    List<Student> rv = new ArrayList<>();
    for (Student s : in) {
      if (crit.test(s)) {
        rv.add(s);
      }
    }
    return rv;
  }

  public static List<Student> getSmartStudents(Iterable<Student> in,
                                               float threshold) {
    List<Student> rv = new ArrayList<>();
    for (Student s : in) {
      if (s.getGpa() > threshold) {
        rv.add(s);
      }
    }
    return rv;
  }

  public static List<Student> getEnthusiasticStudents(Iterable<Student> in,
                                               int threshold) {
    List<Student> rv = new ArrayList<>();
    for (Student s : in) {
      if (s.getClasses().size() > threshold) {
        rv.add(s);
      }
    }
    return rv;
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
    showAll(getSmartStudents(roster, 3.8F));
    showAll(getEnthusiasticStudents(roster, 2));
    showAll(getStudentsByCriterion(roster, new SmartCriterion()));
    showAll(getStudentsByCriterion(roster, new EnthusiasmCriterion()));
  }
}
