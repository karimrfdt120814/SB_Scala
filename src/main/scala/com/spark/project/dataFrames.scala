package com.spark.project
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions
import org.apache.spark.sql.SparkSession


object dataFrames {

  def main(args:Array[String]):Unit={

    val spark=SparkSession.builder()
      .appName("spark-program")
      .master("local[*]")
      .getOrCreate()

    val df=spark.read
      .format("csv")
      .option("header","true")
      .option("path","C:\\Users\\Asus\\Downloads/details-2026-04-05.csv")
      .load()

//    df.select(
//      (col("id")+col("salary")).alias("addition")
//    ).show(false)

//    df.select(
//      (col("id")>10) and (col("salary")>200)
//    ).show(false)


//    df.select(
//      col("id"),
//      col("name"),
//      col("salary"),
//      col("city"),
//      when(col("salary")>500,"Rich").otherwise("Not Rich").alias("Status")
//    ).show(false)

    df.createOrReplaceTempView("myView")

    spark.sql(
      """
        |select id,name,salary,city,
        |case
        |when salary > 500 then "Rich"
        |else "Not Rich"
        |end status
        |from my view
        |""".stripMargin
    ).show(false)




  }

}
