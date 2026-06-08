package com.spark.project

import org.apache.spark.SparkContext


object SparkRdd {

  def main(args:Array[String]):Unit={

    val sc=new SparkContext("local[*]","Karimulla")



    val rdd1=sc.textFile("C:/Users/Asus/Desktop/file.txt")

    val rdd2=rdd1.flatMap(x=>x.split(" "))
    val rdd3=rdd2.map(x=>(x,1))
    val rdd4=rdd3.reduceByKey((x,y)=>x+y)


    val sorted=rdd4.sortBy(x=>x._2,false)

    sorted.take(10).foreach(println)

    scala.io.StdIn.readInt()

  }


}
