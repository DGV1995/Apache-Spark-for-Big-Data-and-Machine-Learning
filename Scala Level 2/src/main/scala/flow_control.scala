object flow_control extends App {
    val person = "Jose";
    if (person.equals("Sammy"))
        println("Welcome Sammy")
    else if (person.equals("George"))
        println("Welcome George")
    else
        println(s"Welcome $person");

    // AND
    println(1 <= 2 && 2 == 2) // true

    // OR
    println(1==2 || 2==2) // true

    // NOT
    println(!(1==1)) // false
}
