object Exercises extends App {
  /**
   * 1.) Check for single even: Write a function that takes in an integer and returns a Boolean indicating
   * whether or not if is even. See if you can write this in one line!
   */
  def checkEven = (number:Int) => number % 2 == 0;
  println(checkEven(4)); // True
  println(checkEven(9)); // False

  /**
   * 2.) Check for evens in a List: Write a function that return True if there is an even number inside of a List.
   * Otherwise, return false.
   */
  def containsAnEven(numbers: List[Int]): Boolean = {
    for (number <- numbers) {
      if (number % 2 == 0) return true;
    }
    return false;
  }
  println(containsAnEven(List(1,3,4,5))); // True
  println(containsAnEven(List(1,3,5,7,9))); // False

  /**
   * 3.) Lucky Number Seven: Take in a list of integers and calculate their sum. However, sevens are lucky and they
   * should be counted twice, meaning their value is 14 for the sum. Assume the list is not empty.
   */
  def sumWithLuckySeven(numbers: List[Int]): Int = {
    var sum = 0;
    for (number <- numbers) {
      if (number == 7)
        sum += number*2;
      else
        sum += number;
    }
    return sum;
  }
  println(sumWithLuckySeven(List(1,2,3,7))); // 20

  /**
   * 4.) Can you Balance?: Given a non empty list of integers, return true if there ir a place to split the list so that
   * the sum of the numbers on one side is equals to the sum of the numbers on the other side. For example, given the
   * list (1,5,3,3) would return true, 1+5 = 3+3. Another example (7,3,4) would return true.
   */
  def isBalanced(numbers: List[Int]): Boolean = {
    for (number <- numbers) {
      val left_sum = numbers.slice(0, numbers.indexOf(number)+1).sum;
      val right_sum = numbers.slice(numbers.indexOf(number)+1, numbers.length).sum;
      if (left_sum == right_sum)
        return true;
    }
    return false;
  }
  println(isBalanced(List(7,4,3))); // True
  println(isBalanced(List(1,5,3,3))); // True
  println(isBalanced(List(1,2,3,4,5))); // False

  /**
   * 5.) Palindrome Check: Given a string, return a boolean indicating whether or not it is a palindrome. Try exploring
   * methods yo help you.
   */
  def isPolindrome = (s: String) => s == s.reverse;
  println(isPolindrome("saas")); // True
  println(isPolindrome("Hello")); // False
}
