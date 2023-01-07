public class HelloGoodbye {

  //? The String[] args here is pretty convinient to pass on several parameters
  public static void main(String[] args) {
    System.out.println(String.format("Hello %s and %s.", args[0], args[1]));
    System.out.println(String.format("Goodbye %s and %s.", args[1], args[0]));
  }
}
