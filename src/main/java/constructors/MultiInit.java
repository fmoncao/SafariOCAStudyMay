package constructors;

public class MultiInit {
  int x;
  public /* void MUST NOT have a return type
  otherwise you have a method!!! */
  MultiInit() {
    this(99); // this(...) MUST COME FIRST!!!!
    System.out.println("In zero arg constructor");
//    new MultiInit(99); // NO this creates a (second) new object!!
//    this.x = 99;
    // do something with x
  }

  public MultiInit(int x) {
    System.out.println("In one arg constructor x is " + x);
    this.x = x;
    // do something with x
  }

  public static void main(String[] args) {
    MultiInit mi = new MultiInit();
//    mi.MultiInit();
  }
}
