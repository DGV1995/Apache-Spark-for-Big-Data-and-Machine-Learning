object for_loops extends App {
  for (item <- List(1,2,3,4)) {
    println(s"Hello item $item");
  }

  for (i <- Range(0,10)) {
    if (i % 2 == 0)
      println(s"$i is even");
    else
      println(s"$i is odd");
  }

  val names = List("John", "Susan", "Peter", "Mary", "James");
  for (name <- names) {
    if (name.startsWith("J"))
      println(s"$name starts with J");
  }
}
