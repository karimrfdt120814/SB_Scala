package com.spark.project

import org.apache.spark.SparkContext

object groupByKey_Vs_reduceByKey {

  val sc = new SparkContext("local[*]","GroupByKey vs ReduceByKey")

  def main(args:Array[String]):Unit={

    val rdd = sc.parallelize(List(
      ("A", 10),
      ("B", 20),
      ("A", 30),
      ("B", 40),
      ("A", 50)
    ))

    //rdd.groupByKey().mapValues(x=>x.sum).collect.foreach(println)

    //rdd.reduceByKey(_+_).collect.foreach(println)

   // println(rdd.getNumPartitions)

    val rdd1 = sc.parallelize(1 to 100, 4)

    println("before repartition",rdd1.getNumPartitions)

  val rdd2 =rdd1.repartition(8)
    println("after repartition",rdd2.getNumPartitions)

    val rdd3 = rdd2.coalesce(1)
    println("after coalesce", rdd3.getNumPartitions)

    val glomData = rdd3.glom()
    glomData.collect().foreach(println)

    val rdd4=sc.parallelize(List(1,23,343,232,53,2323,545,2,22,2134,45,3,7,8,9))

    rdd4.take(4).foreach(println)
    rdd4.top(4).foreach(println)
    rdd4.takeOrdered(4).foreach(println)

    scala.io.StdIn.readInt()




  }

}
