object functions extends App {
  def simple(): Unit = {
    println("Hello!");
  }

  def adder(num1: Int, num2: Int): Unit = {
    println(num1 + num2);
  }

  def greetName(name: String): Unit = {
    println(s"Hello $name!!");
  }

  def isPrime(number: Int): Boolean = {
    for (n <- Range(2,number)) {
      if (number % n == 0)
        return false;
    }
    return true;
  }

  simple();
  adder(4,5);
  greetName("Diego");
  println(isPrime(17)); // True
  println(isPrime(10)); // False
}
