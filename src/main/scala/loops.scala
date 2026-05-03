object loops {

  def main(args:Array[String]):Unit={
/*
    1
    2 3
    4 5 6
    7 8 9 10
    11 12 13 14 15 */

    var num =1

    for(i <- 1 to 5){
      for(j <- 1 to i){
        print(num + " ")
        num = num+1

      }

    println("")
    }

    for(i <- 1 to 5){
      for(j <- 1 to i){
        print(j+ " ")
      }
      println("")
    }


    for(i <- 1 to 5){
      for(j <- 1 to i) {
        print(i+ " ")
      }
      println("")


    }

  }

}
