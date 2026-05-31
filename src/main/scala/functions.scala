object functions {

  def main(args:Array[String]):Unit={


    def sum(a:Int,b:Int)={

      a+b

    }
    //println(sum(10,20))
  }

  //pure function
  def fun1(a:Int,b:Int)={
    a*b
    //a=+1 // should not change the value of a. so it is a pure function
  }


  val a = Array(1,2,3,4,5,6,7,8,9)

//impure function
  def fun2(arr:Array[Int]):Unit={
    println(arr(0))
    arr(0)=100
    println(arr(0))
  }

  println(fun2(a))

  //Higher order functions

  def double(a:Int):Int={
    a*2
  }

  def info(x:Int, f:Int=>Int):Int={
    f(x)
  }

  //here, info is a higher order function

  println(info(10,double))
  def square(k:Int, n:Int=>Int):Int={
    n(k)
  }

  def sqr(y:Int):Int={
    y*y
  }

  // here square is higher order function.

  println(square(10,sqr))

}




