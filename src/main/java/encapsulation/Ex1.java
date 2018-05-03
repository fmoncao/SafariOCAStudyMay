package encapsulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Student {
  private /*final */String name; // should not be null
  private /*final */float gpa; // 0 - 4
  private /*final makes the pointer unchangeable, NOT the thing
  pointed at!!!!!*/ List<String> classes; // ??
  public Student(String name, float gpa, String ... courses) {
    if (name == null) throw new IllegalArgumentException("Must have a name");
    if (gpa < 0 || gpa > 4) throw new IllegalArgumentException("Bad gpa " + gpa);
    this.name = name;
    this.gpa = gpa;
    this.classes = new ArrayList<>(Arrays.asList(courses));
  }

  public String getName() {
    return name;
  }

  public float getGpa() {
    return gpa;
  }

  public List<String> getClasses() {
//    return classes;
    return Collections.unmodifiableList(classes);
  }

  public void addCourse(String course) {
    if (classes.contains(course)) {
      throw new IllegalArgumentException("Course already being taken");
    }
    classes.add(course);
  }

//  static void validateElements(String name....)
  @Override
  public String toString() {
    return "Student name: " + this.name + " gpa: " + this.gpa
        + " taking: " + this.classes;
  }
}

//class VIPStudent extends Student {
//  public String name;
//  public VIPStudent(String name, float gpa, String... courses) {
//    super(name, gpa, courses);
//    this.name = name;
//  }
//  @Override
//  public String getName() {
//    return this.name;
//  }
//  public void destroyName() {
//    name = null;
//  }
//}
public class Ex1 {
  public static void main(String[] args) {
    Student s = new Student("Fred", 3.8F, "Math", "Physics");
//    s.gpa = -100; // should not be permitted
    s.addCourse("Quantum Mechanics");
    System.out.println(s);
//    s.addCourse("Math");
    s.getClasses().add("Math");
    System.out.println(s);

//    VIPStudent s1 = new VIPStudent("Sheila", 3.9F, "Art");
//    s1.destroyName();
//    s = s1;
//    System.out.println("Student name is " + s.getName());
  }
}
