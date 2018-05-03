package constructors;

class Q25Base {
  int x = 99;
//  Q25Base() {}
  Q25Base(int x) {
    this.x = x;
  }
}

class Q25Sub extends Q25Base {
  static int stat;
  static {
    stat = 123;
  }

  int y = 100;
  String q = "Hello " + "world";

  Q25Sub(int x) {
    super(x);
    System.out.println("in constructor, x is " + x);
  }

  float f;
  {
    float f = 0;
    for (int i = 0; i < 3; i++) {
      f = i;
    }
    f = f + 0.14F;
    this.f = f;
  }

  public static void go() {
    new Q25Sub(1);
  }
}

public class Ex1 {
  public static void main(String[] args) {
    Q25Sub.go();
  }
}
