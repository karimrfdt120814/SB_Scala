object practice {

  def main(args:Array[String]): Unit = {

//    val arr = Array(1,2,3,4,4,2,5,9,1)
//
//    val duplicates = arr.groupBy(identity).filter(_._2.length > 1).keys
//    println(duplicates.mkString(","))

    val arr = Array(1, 2, 3, 2, 4, 5, 3, 6, 1)

    val duplicates = arr
      .groupBy(identity)
      .filter(_._2.length > 1)
      .map{case(x,y) =>(x,y.length)}

    duplicates.foreach{
     case(x,y) => println(s"x, $y")
    }

    println(duplicates.mkString(", "))


    val name = "karimulla"
    val dup = name
      .groupBy(identity)
      .filter(_._2.length > 1)
      .map{case(x,y) => (x,y.length)}

    dup.foreach{case(x,y)=>println(s"x,$y")}

    dup.foreach(println)



  }

}
