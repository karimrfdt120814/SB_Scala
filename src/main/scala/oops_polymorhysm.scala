object oops_polymorhysm {

  class A {

    def A():Unit={
      println("function with no parameters...")
    }

    def A(a:Int):Unit={
      println("function with one parameter...")
    }

    def A(a:Int,b:Int):Unit={
      println("function with two parameters...")
    }

    def A(a:Int,b:Int,c:Int):Unit={
      println("function with three parameters...")
    }
  }

  def main(args:Array[String]):Unit={
    val obj=new A()

    println(obj.A(10,20,30))
  }


}
