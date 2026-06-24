package com.spark.project

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

    df.show(5,false)


  }

}
