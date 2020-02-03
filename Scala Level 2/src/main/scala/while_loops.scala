import util.control.Breaks._;

object while_loops extends App {
  var count = 10;
  while (count > 0) {
    println(s"x is currently $count");
    count -= 1;
  }

  var y = 0;
  while (y < 10) {
    println(s"y is currently $y");
    println("y is still less than 10, adding 1 to y");
    y += 1;
    if (y == 3)
      break;
  }
}
