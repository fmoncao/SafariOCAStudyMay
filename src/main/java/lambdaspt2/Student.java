package lambdaspt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class Student {
  private String name; // should not be null
  private float gpa; // 0 - 4
  private List<String> classes; // ??
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
    return Collections.unmodifiableList(classes);
  }

  @Override
  public String toString() {
    return "Student name: " + this.name + " gpa: " + this.gpa
        + " taking: " + this.classes;
  }
}