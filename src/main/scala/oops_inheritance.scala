object oops_inheritance {

  class A {
    val a =10
    def sum(a:Int,b:Int):Int={
      a+b
    }
  }

  class B extends A {

    def mul(a:Int,b:Int):Int={
      a*b
    }

  }

 class C extends B {

 }

  def main(args:Array[String]) {
    val in = new B()
//    println(in.a)
//    println(in.sum(10, 20))

    val c_in=new C()

    println(c_in.sum(2,3))
    println(c_in.mul(2,3))

  }



}
