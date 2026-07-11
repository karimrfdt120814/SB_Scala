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


  }



}
//scala.io.StdIn.readInt()