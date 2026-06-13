package com.spark.project

import org.apache.spark.SparkContext

object rddOperations {

  def main(args:Array[String]):Unit={

    val sc = new SparkContext("local[2]","rddOperations")
//    val arr = Array(1,2,3,3,4,4,5,5,6,7,8)
//    val input = sc.parallelize(arr)
//    val result=input.mean()
//    val resuld_dis=input.distinct()
//    val final_res=resuld_dis.collect
//
//    final_res.foreach(println)

    //println(result)

    val myList = List(1,2,3,4,5,6,7,8,33)
    val input = sc.parallelize(myList)
    val myList1 = List(6,7,8,9,10,11,12,13)
    val input1 = sc.parallelize(myList1)

    val unionRdd = input.union(input1).collect()
    val intersectRDD = input.intersection(input1).collect()
    val subRdd = input.subtract(input1).collect()
    val cartesianRdd = input.cartesian(input).collect()

   // cartesianRdd.foreach(println)

    val colors = List((1,"Red"),(2,"Blue"),(3,"Purple"),(4,"Green"))
    val colorRdd = sc.parallelize(colors)

    val fruits = List((1,"Apple"),(2,"BlueBerries"),(7,"Mangoes"),(4,"Grapes"))
    val furitRdd = sc.parallelize(fruits)

    val joinedRdd =colorRdd.fullOuterJoin(furitRdd)

    joinedRdd.collect.foreach(println)




    scala.io.StdIn.readInt()

  }


}
