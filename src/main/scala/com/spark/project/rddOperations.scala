package com.spark.project

import org.apache.spark.SparkContext

object rddOperations {

  def main(args:Array[String]):Unit={

    val sc = new SparkContext("local[2]","rddOperations")
    val arr = Array(1,2,3,3,4,4,5,5,6,7,8)
    val input = sc.parallelize(arr)
    val result=input.mean()
    val resuld_dis=input.distinct()
    val final_res=resuld_dis.collect

    final_res.foreach(println)

    //println(result)


    scala.io.StdIn.readInt()

  }


}
