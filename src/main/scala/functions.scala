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

//  def double(a:Int):Int={
//    a*2
//  }

  def info(x:Int, f:Int=>Int):Int={
    f(x)
  }

  //here, info is a higher order function

//  println(info(10,double))
//  def square(k:Int, n:Int=>Int):Int={
//    n(k)
//  }

  def sqr(y:Int):Int={
    y*y
  }

  // here square is higher order function.

//  println(square(10,sqr))

  //partitally applied function

  def add1(a:Int,b:Int):Int={a+b}

  val add10 = add1(_:Int,10)

  println(add10(5))

  def sum(a:Int,b:Int)={
    var x =100
    a+b
  }

  val partialadd10=sum(10,_:Int)

  println(partialadd10(2))


// closure

  var x=10
  var y=20
  var z=30

  def func(a:Int,b:Int):Int={
    var result = a+b+x+y+z
    result

  }

  println(func(40,50))


  val bonus = 100

//  def addBonus(salary:Int):Int= {
//    val total_salary = salary + bonus
//    total_salary
//  }
//
//  println(addBonus(1000))


  val tax=10
  def calculateTax(Income:Int):Int={
    val deduction = Income* tax/100
    deduction
  }

  println(calculateTax(22000))

  def createCounter()={
    var count=0
    ()=> {
      count = count + 1

      count
    }
  }

  val counter = createCounter()
  println(counter())
  println(counter())
  println(counter())
  println(counter())


  /* implicit functions
  ** if we don't pass the function argument it will take the default value that we defined.
   */

  //variable level

  implicit val default_name="Guest"

  def greet(implicit name:String):Unit={
    println("Hello", name)
  }

  greet // will print Hello, Guest
  greet("Karimulla") // will print Hello, Karimulla

  // function level implicit function

  implicit def intToString(x:Int):String={
    x.toString
  }

  val Num:String=40

 // val myData = List.range(1,10000000)

 // myData.foreach(println)

  def SalaryWithBonus(bonus:Int)(salary:Int):Int={
    salary+bonus
  }

  val addBonus = SalaryWithBonus(10000)(_:Int)
  val total_sal=addBonus(50000)
  println("total_Salary:")
  print(total_sal)

  def multiplyFunc(factor:Int)(number:Int)={
    factor*number
  }

  val double=multiplyFunc(2)_
  val tripple =multiplyFunc(3)_

  println(double(10))
  println(tripple(10))


  println("Enter a number:")

  val input = scala.io.StdIn.readInt()
print(input)



}




