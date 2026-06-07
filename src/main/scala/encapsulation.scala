object encapsulation {

  class A {

    var c=0
    private def sum(a:Int,b:Int):Int={
      c= a+b
      c
    }

    def getter()={
      sum(10,20)
      c
    }

  }

  class B extends A {

  }

  def main(args:Array[String])={

    val obj=new B()
   // obj.sum(1,2) // Error: symbol sum is inaccessible

    println(obj.getter())


  }

}
