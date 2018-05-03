package lambdaspt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Criterion<E> {
//  void doStuff();
  boolean test(E s);
}

class SmartCriterion implements Criterion<Student> {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3;
  }
}

class EnthusiasmCriterion implements Criterion<Student> {
  @Override
  public boolean test(Student s) {
    return s.getClasses().size() > 2;
  }
}

public class School {
  public static List<Student> getStudentsByCriterion(Iterable<Student> in,
                                               Criterion<Student> crit) {
    List<Student> rv = new ArrayList<>();
    for (Student s : in) {
      if (crit.test(s)) {
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
    showAll(getStudentsByCriterion(roster, new SmartCriterion()));
    showAll(getStudentsByCriterion(roster, new EnthusiasmCriterion()));

//    showAll(getStudentsByCriterion(roster, new/* ...make one of these...
//    class SmartCriterion implements */Criterion<Student>() {
//      @Override
//      public boolean test(Student s) {
//        return s.getGpa() > 3;
//      }
//    }
    // anonymous inner class...
//    showAll(getStudentsByCriterion(roster, new Criterion<Student>() {
//      @Override
//      public boolean test(Student s) {
//        return s.getGpa() > 3;
//      }
//    }

//    showAll(getStudentsByCriterion(roster, /*new Criterion<Student>() {*/
//      /*@Override
//      public boolean test*/(Student s) -> {
//        return s.getGpa() > 3;
//      }
//    /*}*/

//    showAll(getStudentsByCriterion(roster,
//        (Student s) -> { return s.getGpa() > 3;}
//        ));

//    showAll(getStudentsByCriterion(roster,
//        (s) -> { return s.getGpa() > 3;}
//        ));

//    showAll(getStudentsByCriterion(roster,
//        s -> { return s.getGpa() > 3;}
//        ));

//    showAll(getStudentsByCriterion(roster,
//        s -> { return s.getGpa() > 3;}
//        ));

    showAll(getStudentsByCriterion(roster, s -> s.getGpa() < 3));
    showAll(getStudentsByCriterion(roster, s -> s.getName().charAt(0) == 'J'));
  }
}
