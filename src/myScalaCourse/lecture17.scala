package myScalaCourse

object lecture17 {

  object RepeatInheritance {
  abstract class Base {
    val name = "Base"
  }
  trait SubClass1 extends Base {
    override val name = "Sub1"
  }
  trait SubClass2 extends Base {
    override val name = "Sub2"
  }
  class Sub extends SubClass1 with SubClass2
  }
  
  object EnumObj {
    object Level extends Enumeration {
      type Level = Value
      val Overflow, High, Medium, Low, Empty = Value
    }
    trait Flavor
    object Syrup extends Enumeration {
      case class _Val() extends Val with Flavor
      type Syrup = _Val
      val Chocolate, HotFudge, Butterscotch, Caramel = _Val()
    }
  }
  
  def main(args: Array[String]): Unit = {
//    import RepeatInheritance._
//    val s = new Sub
//    println(s.name)
    import EnumObj._
    println(Level.Medium)
    
  }

}