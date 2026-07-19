package com.spark.project

import org.apache.spark.sql.functions
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions
import org.apache.spark.sql.SparkSession

object groupByProbs {

  def main(args:Array[String]):Unit= {
    val spark = SparkSession.builder().appName("whenAndOtherwise").master("local[*]").getOrCreate()

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
    import spark.implicits._

    val students = List(
      (1,"Alice",92,"Math"),
      (2,"Bob",85,"Math"),
      (3,"Carol",77,"Science"),
      (4,"Dave",65,"Science"),
      (5,"Eve",50,"Math"),
      (6,"Frank",82,"Science")
    ).toDF("student_id","name","score","subject")

      students.select(
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
    ).groupBy("Grade")


    //Calculate the average score per subject.

    students.groupBy("subject")
      .agg(avg("score").alias("avg_score")).show(false)


    // Find the maximum and minimum score per subject.

    students.groupBy("subject")
      .agg(max("score").alias("max_score"),min("score").alias("min_score")).show(false)

//Count the number of students in each grade category per subject

    val count=students.select(
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
    ).groupBy("Grade","subject").count()

    count.show(false)


    val products = Seq(
      (1, "Smartphone", 700, "Electronics"),
      (2, "TV", 1200, "Electronics"),
      (3, "Shoes", 150, "Apparel"),
      (4, "Socks", 25, "Apparel"),
      (5, "Laptop", 800, "Electronics"),
      (6, "Jacket", 200, "Apparel")
    ).toDF("product_id", "product_name", "price", "category")

    /*
    Create a new column price_category based on price:
o 'Expensive' if price > 500
o 'Moderate' if 200 <= price <= 500
o 'Cheap' if price < 200
 Filter products whose product_name starts with 'S'.
 Filter products whose product_name ends with 's'.
 Calculate the total price (sum), average price, maximum price, and minimum price for each
category.

     */

val price_category_DF=products.select(
  col("product_id"),
  col("product_name"),
  col("price"),
  col("category"),
  when(col("price")>500,"Expensive")
    .when(col("price")>=200 && col("price") <=500,"Moderate")
    .when(col("price")<200,"Cheap")
    .alias("price_category")
)
    price_category_DF.show(false)

    // product name starts with 'S'

    products.filter(col("product_name").startsWith("S"))
      .select(
      col("product_id"),
      col("product_name"),
      col("price"),
      col("category")
    ).show(false)

    //     Filter products whose product_name ends with 's'.

    products.filter(col("product_name").endsWith("s"))
      .select(
        col("product_id"),
        col("product_name"),
        col("price"),
        col("category")
      ).show(false)

//    Calculate the total price (sum), average price, maximum price, and minimum price for each category

    products.groupBy("category").agg(sum("price").alias("total_price"),
      avg("price").alias("average_price"),
      max("price").alias("maximum_price"),
      min("price").alias("minimum_price")).show(false)



/*
3. Employee Age and Salary Analysis
Problem:
You have a DataFrame employees with columns: employee_id, name, age, and salary.
 Create a new column age_group based on age:
o 'Young' if age < 30
o 'Mid' if 30 <= age <= 50
o 'Senior' if age > 50
 Create a new column salary_range based on salary:
o 'High' if salary > 100000
o 'Medium' if 50000 <= salary <= 100000
o 'Low' if salary < 50000
 Filter employees whose name starts with 'J'.
 Filter employees whose name ends with 'e'.
Calculate the total (sum), average (avg), maximum (max), and minimum (min) salary for each
age_group
 */

    val employees = Seq(
      (1, "John", 28, 60000),
      (2, "Jane", 32, 75000),
      (3, "Mike", 45, 120000),
      (4, "Alice", 55, 90000),
      (5, "Steve", 62, 110000),
      (6, "Claire", 40, 40000)
    ).toDF("employee_id", "name", "age", "salary")

    employees.select(
      col("employee_id"),
      col("name"),
      col("salary"),
      when(col("age")<30,"Young")
        .when(col("age")>=30 && col("age")<=50,"Mid")
        .when(col("age")>50,"Senior").alias("age_group"),
      when(col("salary") > 50000,"High")
        .when(col("salary").between(50000,100000),"Medium")
        .when(col("salary")<50000,"Low").alias("salary_range")
    ).show(false)


    println("Press Enter to stop the application...")
    scala.io.StdIn.readLine()

    spark.stop()

  }

}
