object Apr25Demo {

  def main(args: Array[String]):Unit={



    val a = 10
    val b=20
    val c=5;

    println(a>b)
    println(a+b)
    println(a-b)
    println(a*b)
    println(a/b)
    println(a%b)

   // println("a = " + a);

    if(a>b && a>c){
      println("a is greater than b and c")
      println("long highest value is " + Long.MaxValue)
    }

  }

}
