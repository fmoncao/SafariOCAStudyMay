package abstractstuff;

public class Tiger extends Mammal implements Mover {
  @Override
  public String noise() {
    return "ROAR!!!";
  }

  @Override
  public void nurse() {
    System.out.println("suckling the young...");
  }

  @Override
  public void move() {
    System.out.println("Running across the savannah");
  }
}
