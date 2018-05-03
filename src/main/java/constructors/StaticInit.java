package constructors;

class Target {
  static int x;
  static {
    System.out.println("Running static initializer x is"
    + x);
  }
  static int y = 99;
  static {
    System.out.println("Initializer 2, x is " + x + " y is " + y);
  }
  Target() {
    System.out.println("In constructor");
  }
  static void show() {
    System.out.println("In Target.show()");
  }
}
public class StaticInit {
  public static void main(String[] args) {
    Target t;
    System.out.println("Class of Target is " + Target.class.getName());
    Target.show();
    t = new Target();
    t = new Target();
    t = new Target();
    t = new Target();
    System.out.println("Exiting program");
  }
}
