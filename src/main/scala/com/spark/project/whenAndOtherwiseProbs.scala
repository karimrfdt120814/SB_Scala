package com.spark.project

import org.apache.spark.sql.functions
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions
import org.apache.spark.sql.SparkSession




object whenAndOtherwiseProbs {


  def main(args:Array[String]):Unit= {

    val spark = SparkSession.builder().appName("whenAndOtherwise").master("local[*]").getOrCreate()

    import spark.implicits._

    val employees = List(
      (1, "AJAY", 28),
      (2, "VIJAY", 35),
      (3, "MANOJ", 22)
    ).toDF("id", "name", "age")


/***  How would you add a new column is_adult which is true if the age is greater than or equal
    to 18, and false oth ***/

    employees.select(
      col("id"),
      col("name"),
      col("age"),
      when(col("age") >=18,"true").otherwise("false").alias("is_adult")
    ).show(false)

    val grades = List(
      (1, 85),
      (2, 42),
      (3, 73)
    ).toDF("student_id", "score")

    /***
     * Question: How would you add a new column grade with values "Pass" if score is greater than or
     * equal to 50, and "Fail" otherwise?
     ***/

    grades.select(
      col("student_id"),
      col("score"),
      when(col("score")>=50, "Pass").otherwise("Fail").alias("grade")
    ).show(false)

    /*
    Question: How would you add a new column category with values "High" if amount is greater than
    1000, "Medium" if amount is between 500 and 1000, and "Low" otherwise?
     */

    val transactions = List(
      (1, 1000),
      (2, 200),
      (3, 5000)
    ).toDF("transaction_id", "amount")


    transactions.select(
      col("transaction_id"),
      col("amount"),
      when(col("amount")>1000,"High")
        .when(col("amount").between(500,1000),"Medium")
        .otherwise("Low").alias("category")
        .alias("category")
    ).show(false)

    /*
    * Question: How would you add a new column price_range with values "Cheap" if price is less than 50,
      "Moderate" if price is between 50 and 100, and "Expensive" otherwise?
     */

    val products = List(
      (1, 30.5),
      (2, 150.75),
      (3, 75.25)
    ).toDF("product_id", "price")

    products.select(
      col("product_id"),
      col("price"),
      when(col("price")<50,"Cheap")
        .when(col("price").between(50,100),"Moderate")
        .otherwise("Expensive")
        .alias("price_range")
    ).show(false)


    /*
    How would you add a new column is_holiday which is true if the date is "2024-12-25" or
"2025-01-01", and false otherwise?
     */

    val events = List(
      (1, "2024-07-27"),
      (2, "2024-12-25"),
      (3, "2025-01-01")
    ).toDF("event_id", "date")

    events.select(
      col("event_id"),
      col("date"),
      when(col("date")==="2024-12-25" || col("date")==="2025-01-01","True")
        .otherwise("False")
        .alias("is_holiday")
    ).show(false)

    /*
    How would you add a new column stock_level with values "Low" if quantity is less than 10,
"Medium" if quantity is between 10 and 20, and "High" otherwise?
     */

    val inventory = List(
      (1, 5),
      (2, 15),
      (3, 25)
    ).toDF("item_id", "quantity")

    inventory.select(
      col("item_id"),
      col("quantity"),
      when(col("quantity")<10,"Low")
        .when(col("quantity").between(10,20),"Medium").otherwise("High")
        .alias("stock_level")
    ).show(false)


    /*
     How would you add a new column email_provider with values "Gmail" if email contains
    "gmail", "Yahoo" if email contains "yahoo", and "Other" otherwise?
     */

    val customers = List(
      (1, "john@gmail.com"),
      (2, "jane@yahoo.com"),
      (3, "doe@hotmail.com")
    ).toDF("customer_id", "email")

    customers.select(
      col("customer_id"),
      col("email"),
      when(col("email").contains("gmail"),"Gmail")
        .when(col("email").contains("yahoo"),"Yahoo")
        .otherwise("Other")
        .alias("email_provider")
    ).show(false)

    /* How would you add a new column season with values "Summer" if order_date is in June,
    July, or August, "Winter" if in December, January, or February, and "Other" otherwise? */

    val orders = List(
      (1, "2024-07-01"),
      (2, "2024-12-01"),
      (3, "2024-05-01")
    ).toDF("order_id", "order_date")

    orders.select(
      col("order_id"),
      col("order_date"),
      when(date_format(to_date(col("order_date"),"yyyy-MM-dd"),"MMMM").isin("June","July","August"),"Summer")
        .when(date_format(to_date(col("order_date"),"yyyy-MM-dd"),"MMMM").isin("December","January","February"),"Winter")
        .otherwise("Other").alias("Season")
    ).show(false)

    /*
    Question: How would you add a new column discount with values 0 if amount is less than 200, 10 if
    amount is between 200 and 1000, and 20 if amount is greater than 1000
     */

    val sales = List(
      (1, 100),
      (2, 1500),
      (3, 300)
    ).toDF("sale_id", "amount")

    sales.select(
      col("sale_id"),
      col("amount"),
      when(col("amount")<200,lit(0))
        .when(col("amount").between(200,1000),lit(10))
        .when(col("amount")>1000,lit(20))
        .otherwise(null)
        .alias("discount")
    ).show(false)

   /* Question: How would you add a new column is_morning which is true if login_time is before 12:00,
    and false otherwise? */

    val logins = List(
      (1, "09:00"),
      (2, "18:30"),
      (3, "14:00")
    ).toDF("login_id", "login_time")


//    logins.select(
//      col("login_id"),
//      col("login_time"),
//      (to_timestamp(col("login_time"), "HH:mm") < to_timestamp(lit("12:00"), "HH:mm"))
//        .alias("is_morning")
//    ).show(false)

    logins.select(
      col("login_id"),
      col("login_time"),
      when((to_timestamp(col("login_time"),"HH:mm" ) < to_timestamp(lit("12:00"), "HH:mm")),true)
        .otherwise(false)
        .alias("is_morning")

    ).show(false)

    /*
    Question: How would you add a new column category with values "Young & Low Salary" if age is less
than 30 and salary is less than 35000, "Middle Aged & Medium Salary" if age is between 30 and 40
and salary is between 35000 and 45000, and "Old & High Salary" otherwise?
     */

    val employee = List(
      (1, 25, 30000),
      (2, 45, 50000),
      (3, 35, 40000)
    ).toDF("employee_id", "age", "salary")

    employee.select(
      col("employee_id"),
      col("age"),
      col("salary"),
      when(col("age") < 30 && col("salary") < 35000,"Young & Low Salary")
        .when(col("age").between(30,40) && col("salary").between(35000,45000),"Middle Aged & Medium Salary")
        .otherwise("Old & High Salary")
        .alias("category")
    ).show(false)

    /*
    Question: How would you add two new columns, feedback with values "Bad" if rating is less than 3,
"Good" if rating is 3 or 4, and "Excellent" if rating is 5, and is_positive with values true if rating is
greater than or equal to 3, and false otherwise?
     */

    val reviews = List(
      (1, 1),
      (2, 4),
      (3, 5),
      (4,6)
    ).toDF("review_id", "rating")

    reviews.select(
      col("review_id"),
      col("rating"),
      when(col("rating")<3,"Bad")
        .when(col("rating").isin(3,4),"Good")
        .when(col("rating")===5,"Excellent").otherwise("Invalid_rating").alias("feedback"),
      when(col("rating")>=3,true)
        .otherwise(false).alias("is_positive")
    ).show(false)

    /*
    How would you add a new column content_category with values "Animal Related" if
    content contains "fox", "Placeholder Text" if content contains "Lorem", and "Tech Related" if content
    contains "Spark"?
     */

    val documents = List(
      (1, "The quick brown fox"),
      (2, "Lorem ipsum dolor sit amet"),
      (3, "Spark is a unified analytics engine")
    ).toDF("doc_id", "content")

    documents.select(
      col("doc_id"),
      col("content"),
      when(col("content").contains("fox"),"Animal Related")
        .when(col("content").contains("Lorem"),"Placeholder Text")
        .when(col("content").contains("Spark"),"Tech Related")
        .otherwise("not a valid content")
        .alias("content_category")
    ).show(false)

    /*
    Question: How would you add a new column task_duration which is "Short" if the difference
    between end_date and start_date is less than 7 days, "Medium" if it is between 7 and 14 days, and
    "Long" otherwise?
     */

    val tasks = List(
      (1, "2024-07-01", "2024-07-10"),
      (2, "2024-08-01", "2024-08-15"),
      (3, "2024-09-01", "2024-09-05")
    ).toDF("task_id", "start_date", "end_date")


//    tasks.select(
//      col("task_id"),
//      col("start_date"),
//      col("end_date"),
//      when(date_format(to_date(col("end_date")),"yyyy-MM-dd")-date_format(to_date(col("start_date")),"yyyy-MM-dd")<7,"Short")
//        .when(date_format(to_date(col("end_date")),"yyyy-MM-dd")-date_format(to_date(col("start_date")),"yyyy-MM-dd").between(7,14),"Medium")
//        .otherwise("Long")
//        .alias("task_duration")
//    ).show(false)

    tasks.select(
      col("task_id"),
      col("start_date"),
      col("end_date"),
      when(
        datediff(to_date(col("end_date")), to_date(col("start_date"))) < 7,
        "Short"
      ).when(
          datediff(to_date(col("end_date")), to_date(col("start_date"))).between(7, 14),
          "Medium"
        ).otherwise("Long")
        .alias("task_duration")
    ).show(false)


    val students = List(
      (1,"Alice",92,"Math"),
      (2,"Bob",85,"Math"),
      (3,"Carol",77,"Science"),
      (4,"Dave",65,"Science"),
      (5,"Eve",50,"Math"),
      (6,"Frank",82,"Science")
      ).toDF("student_id","name","score","subject")

    /*
     Create a new column grade based on the score:
 'A' if score >= 90
 'B' if 80 <= score < 90
 'C' if 70 <= score < 80
 'D' if 60 <= score < 70
 'F' if score < 60

   Calculate the average score per subject.
 Find the maximum and minimum score per subject.
 Count the number of students in each grade category per subject.


     */

  val count=  students.select(
      col("student_id"),
      col("name"),
      col("score"),
      col("subject"),
      when(col("score") > 90,"A")
        .when(col("score")<=90 && col("score")>80,'B')
        .when(col("score")<=80 && col("score")>70,"C")
        .when(col("score")<=70 && col("score")>60,"D")
        .when(col("score")<60,"F")
        .otherwise("Not a valid grade")
        .alias("Grade")
            ).groupBy("Grade").count()


    //Calculate the average score per subject.

    students.groupBy("subject")
      .agg(avg("score").alias("avg_score")).show(false)


// Find the maximum and minimum score per subject.

    students.groupBy("subject")
      .agg(max("score").alias("max_score"),min("score").alias("min_score")).show(false)






  }



}
//scala.io.StdIn.readInt()