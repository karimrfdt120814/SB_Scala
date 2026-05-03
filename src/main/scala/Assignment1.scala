object Assignment1 {

  def main(args:Array[String]):Unit={

    // ** question 1 **//

    val name:String="Karimulla Shaik"
    val age:Int=28
    val salary:Double=60000.0

    // ** question 2 **//

    var a:Int=10
    var b:Int=20

    a = a+b
    b=a-b
    a=a-b
    println("After swapping: a = " + a + ", b = " + b)

    a = a^b
    b=a^b
    a=a^b
    println("after swapping using bitwise operator: a = " + a + ", b = " + b)

   //3. Assign multiple values to multiple variables in a single line.

    val (x,y,z) =(1,2,3)
      println("x = " + x + ", y = " + y + ", z = " + z)

    //4. Take a number and print its datatype.

    val num = 42
    println("The dataType of a num is: "+num.getClass.getSimpleName)

    //5. Convert a string "100" into an integer and perform addition with 50.

    val number = "100"
    val numint = number.toInt + 50
    println("The result of addition is: " + numint)


   /* 6. Take two numbers and perform:
        o Addition
        o Subtraction
        o Multiplication
        o Division */

    val num1 = 100
    val num2 = 50
    println("num1 + num2 = "+(num1+num2))
    println("num1 - num2 = "+(num1 -  num2))
    println("num1 * num2 = "+(num1*num2))
    println("num1/num2 = "+(num1/num2))


    // 7. Find the remainder when a number is divided by 7.

    println("remainder is "+ (num1%7))

    // 8. Calculate the square and cube of a number.

    val n =5;
    println("Square: " +(n*n))
    println("cube: " +(n*n*n))

   // 9. Given total marks and number of subjects, calculate average.

    val total_marks = 570
    val total_subjects = 6
    println("average is: " +(total_marks/total_subjects))

//    10. Calculate simple interest: · Formula: SI = (P × R × T) / 100

    val principal_amount = 110000
    val rateOfInterest = 18
    val time = 4

    val simpleInterest = (principal_amount * rateOfInterest * time)/100

    println("Simple interest is: "+simpleInterest)


    // 11. Check if a number is greater than 100.
    val k =44
    println("Is k > 100 " +(k>100))

    //12. Compare two numbers and print which one is bigger.

    val d = 100
    val e = 200

    if(a>b) println("bigger is: d= "+d) else println("bigger is: e= " +e)

    // 13. Check if a number is equal to 50.

    val f = 75
    println(f>50)


    // 14. Check if a number is not equal to 0.

    val g =10
    println(g!=0)

    // 15. Check if a number is between 10 and 50.

    val h = 100

    if(h > 10 && h <=50)
      println("The number is in given range")
    else
     println ("The number is not in the given range")

    // 16. Check if a person is eligible to vote:

      val Age:Int = 29
    if(Age>=18) println("eligible of vote.") else println("Not eligible for vote")

    // 17. Check if a number is divisible by both 3 and 5.

    val i = 15
    if(i%3==0 && i%5==0)
      println("the given number is divisible by both 3 and 5")
    else if(i%3==0 && i%5!=0)
      println("the given number is only divisible by only 3 but not divisible by 5")
    else if(i%3!=0 && i%5==0)
        println("the given number is only divisible by 5 but not divisible by 3")
    else
        println("the given number is not divisible by both 3 and 5")

    // 18. Check if a student passed: Marks ≥ 35 in all subjects

    val marks = 40
    if(marks >=35) println("Passed") else println("Failed")

    // 19. Check if a number is positive AND even.

    val j = 4
    if(j>0 && j%2==0)
      println("the given number is positive and even")
    else if(j<0 && j%2==0)
      println("the given number is not positive but it is even")
    else if(j>0 && j%2!=0)
      println("the given number is positive but not even")
    else if(j ==0)
      println("the number is '0'")
    else
      println("neither positive nor even number")

    /* 20. Check if a user can login:
     Username = "admin"
     Password = "1234" */

    val userName = "admin"
    val passWord ="1234"

    if(userName == "admin" && passWord=="1234")
      println("Login success.")
    else
      println("Login denied.")







  }

}
