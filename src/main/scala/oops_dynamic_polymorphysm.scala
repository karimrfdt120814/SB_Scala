object oops_dynamic_polymorphysm {

  class A {
    def marry()={
      println("I want to Marry Priya")
    }

    def cal(a:Int)={
      a*10
    }


  }

  class B extends A() {
    override def marry()={
      println("I want to marry meera.")

    }

    override def cal(a:Int)={
      a*100
    }
  }

  def main(args:Array[String])={
    val obj = new B()
    println(obj.marry())
    println(obj.cal(20))
  }

}
